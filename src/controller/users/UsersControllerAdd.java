package controller.users;

import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.UserServiceFactory;

import controller.PMF;
import model.entity.Access;
import model.entity.Resource;
import model.entity.Role;
import model.entity.User;

@SuppressWarnings("serial")
public class UsersControllerAdd extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		PersistenceManager pm = PMF.get().getPersistenceManager();

		String query = "select from " + Role.class.getName();

		List<Role> roles = (List<Role>) pm.newQuery(query).execute();

		// pasar la lista al jsp
		req.setAttribute("roles", roles);
		RequestDispatcher var = this.getServletContext().getRequestDispatcher("/WEB-INF/Views/Users/add.jsp");
		var.forward(req, resp);

	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		PersistenceManager pm = PMF.get().getPersistenceManager();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String email = req.getParameter("email");
		boolean gender = Boolean.parseBoolean(req.getParameter("gender"));
		boolean status = Boolean.parseBoolean(req.getParameter("status"));
		Long IdRole = Long.parseLong(req.getParameter("IdRole"));

		if (req.getParameter("email") != null && req.getParameter("created") != null
				&& req.getParameter("status") != null && req.getParameter("gender") != null
				&& req.getParameter("birth") != null && req.getParameter("IdRole") != null) {
			User u;
			try {
				Date created = null, birth = null;
				created = sdf.parse(req.getParameter("created"));
				birth = sdf.parse(req.getParameter("birth"));
				u = new User(email, birth, created, gender, IdRole, status);
				try {
					pm.makePersistent(u);
				} finally {
					pm.close();
				}
				resp.sendRedirect("/users");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		RequestDispatcher var = getServletContext().getRequestDispatcher("/WEB-INF/Views/Users/add.jsp");
		try {
			var.forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}