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
public class ResourcesControllerUpdate extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		PersistenceManager pm = PMF.get().getPersistenceManager();

		Resource res = pm.getObjectById(Resource.class, Long.parseLong(req.getParameter("id")));
		pm.close();
		req.setAttribute("res", res);
		RequestDispatcher var = this.getServletContext().getRequestDispatcher("/WEB-INF/Views/Resources/update.jsp");

		var.forward(req, resp);

	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Resource res = pm.getObjectById(Resource.class, Long.parseLong(req.getParameter("id")));

		res.setName(req.getParameter("name"));
		res.setUrl(req.getParameter("url"));
		res.setStatus(Boolean.parseBoolean(req.getParameter("status")));

		pm.close();
		req.setAttribute("res", res);
		resp.sendRedirect("/resources/view?id=" + req.getParameter("id"));
	}
}