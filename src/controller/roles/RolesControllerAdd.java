package controller.roles;

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
public class RolesControllerAdd extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		doPost(req, resp);

	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		PersistenceManager pm = PMF.get().getPersistenceManager();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		String name = req.getParameter("name");
		boolean status = Boolean.parseBoolean(req.getParameter("status"));

		if (req.getParameter("name") != null && req.getParameter("created") != null
				&& req.getParameter("status") != null) {
			Role r;
			try {
				Date created = null;
				created = sdf.parse(req.getParameter("created"));
				r = new Role(name, created, status);
				try {
					pm.makePersistent(r);
				} finally {
					pm.close();
				}
				resp.sendRedirect("/roles");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		RequestDispatcher var = getServletContext().getRequestDispatcher("/WEB-INF/Views/Roles/add.jsp");
		try {
			var.forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}