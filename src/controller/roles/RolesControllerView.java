package controller.roles;

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
public class RolesControllerView extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		PersistenceManager pm = PMF.get().getPersistenceManager();

		Role role = pm.getObjectById(Role.class, Long.parseLong(req.getParameter("id")));

		// pasar la lista al jsp
		req.setAttribute("role", role);

		// reenviar la solicitud al jsp
		RequestDispatcher var = getServletContext().getRequestDispatcher("/WEB-INF/Views/Roles/view.jsp");

		var.forward(req, resp);

	}

}