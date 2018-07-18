package controller.access;

import java.io.IOException;
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
public class AccessControllerUpdate extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		PersistenceManager pm = PMF.get().getPersistenceManager();

		Access access = pm.getObjectById(Access.class, Long.parseLong(req.getParameter("id")));
		req.setAttribute("access", access);
		String query11 = "select from " + Role.class.getName();
		String query21 = "select from " + Resource.class.getName();
		List<Role> roles = (List<Role>) pm.newQuery(query11).execute();
		List<Resource> resources = (List<Resource>) pm.newQuery(query21).execute();

		// pasar la lista al jsp
		req.setAttribute("roles", roles);
		req.setAttribute("resources", resources);
		pm.close();

		RequestDispatcher var = this.getServletContext().getRequestDispatcher("/WEB-INF/Views/Access/update.jsp");

		var.forward(req, resp);

	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Access access = pm.getObjectById(Access.class, Long.parseLong(req.getParameter("id")));
		access.setIdRole(Long.parseLong(req.getParameter("IdRole")));
		access.setIdUrl(Long.parseLong(req.getParameter("IdUrl")));
		access.setStatus(Boolean.parseBoolean(req.getParameter("status")));

		pm.close();
		req.setAttribute("access", access);
		resp.sendRedirect("/access/view?id=" + req.getParameter("id"));
	}
}