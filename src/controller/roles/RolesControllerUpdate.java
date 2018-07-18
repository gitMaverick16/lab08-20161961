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
public class RolesControllerUpdate extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		PersistenceManager pm = PMF.get().getPersistenceManager();

		Role role = pm.getObjectById(Role.class, Long.parseLong(req.getParameter("id")));
		pm.close();
		req.setAttribute("role", role);
		RequestDispatcher var = this.getServletContext().getRequestDispatcher("/WEB-INF/Views/Roles/update.jsp");

		var.forward(req, resp);

	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Role role = pm.getObjectById(Role.class, Long.parseLong(req.getParameter("id")));

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date created = null;
		try {
			created = sdf.parse(req.getParameter("created"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		role.setName(req.getParameter("name"));
		role.setCreated(created);
		role.setStatus(Boolean.parseBoolean(req.getParameter("status")));

		pm.close();
		req.setAttribute("role", role);
		resp.sendRedirect("/roles/view?id=" + req.getParameter("id"));
	}
}