package controller.resources;

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
import model.entity.User;

@SuppressWarnings("serial")
public class ResourcesControllerIndex extends HttpServlet {
	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		PersistenceManager pm = PMF.get().getPersistenceManager();

		String query = "select from " + Resource.class.getName();

		List<Resource> resources = (List<Resource>) pm.newQuery(query).execute();

		// pasar la lista al jsp
		req.setAttribute("resources", resources);

		// reenviar la solicitud al jsp
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Views/Resources/index.jsp");

		dispatcher.forward(req, resp);

	}
}