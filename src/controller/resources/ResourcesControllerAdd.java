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
public class ResourcesControllerAdd extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		doPost(req, resp);

	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		PersistenceManager pm = PMF.get().getPersistenceManager();

		String url = req.getParameter("url");
		String name = req.getParameter("name");
		boolean status = Boolean.parseBoolean(req.getParameter("status"));

		if (req.getParameter("url") != null && req.getParameter("status") != null && req.getParameter("name") != null) {
			Resource res;
			res = new Resource(url, name, status);
			try {
				pm.makePersistent(res);
			} finally {
				pm.close();
			}
			resp.sendRedirect("/resources");
		}
		RequestDispatcher var = getServletContext().getRequestDispatcher("/WEB-INF/Views/Resources/add.jsp");

		try {
			var.forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}