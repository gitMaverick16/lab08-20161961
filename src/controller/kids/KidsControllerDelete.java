package controller.kids;

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
import model.entity.Kids;
import model.entity.Resource;
import model.entity.User;

@SuppressWarnings("serial")
public class KidsControllerDelete extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		com.google.appengine.api.users.User uGoogle = UserServiceFactory.getUserService().getCurrentUser();
		// verificando login presente
		if (uGoogle == null) {
			RequestDispatcher var = getServletContext().getRequestDispatcher("/WEB-INF/Views/Errors/deny1.jsp");
			var.forward(req, resp);
		} else {
			// PMF para consultas
			PersistenceManager pm = PMF.get().getPersistenceManager();
			// buscando usuario registrado activo con el email
			String query1 = "select from " + User.class.getName() + " where email=='" + uGoogle.getEmail() + "'"
					+ "&& status==true";
			List<User> uSearch = (List<User>) pm.newQuery(query1).execute();
			// verificando usuario registrado
			if (uSearch.isEmpty()) {
				RequestDispatcher var = getServletContext().getRequestDispatcher("/WEB-INF/Views/Errors/deny2.jsp");
				var.forward(req, resp);
			} else {
				System.out.println(req.getServletPath());
				// buscando recurso registrado activo de acuerdo a la url
				String query2 = "select from " + Resource.class.getName() + " where url=='" + req.getServletPath() + "'"
						+ "&& status==true";

				List<Resource> rSearch = (List<Resource>) pm.newQuery(query2).execute();
				// verificando recurso registrado
				if (rSearch.isEmpty()) {
					RequestDispatcher var = getServletContext().getRequestDispatcher("/WEB-INF/Views/Errors/deny3.jsp");
					var.forward(req, resp);
				} else {
					// buscando acceso registrado para rol y recurso
					String query3 = "select from " + Access.class.getName() + " where IdRole=="
							+ uSearch.get(0).getIdRole() + "&& IdUrl==" + rSearch.get(0).getId() + "&& status==true";
					List<Access> aSearch = (List<Access>) pm.newQuery(query3).execute();
					// verificando acceso registrado
					if (aSearch.isEmpty()) {
						RequestDispatcher var = getServletContext()
								.getRequestDispatcher("/WEB-INF/Views/Errors/deny4.jsp");
						var.forward(req, resp);
					} else {
						String id = req.getParameter("id");
						Kids p = pm.getObjectById(Kids.class, Long.parseLong(id));
						pm.deletePersistent(p);
						resp.sendRedirect("/kids");
					}
				}
			}

		}
	}
}