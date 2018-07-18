package controller.homeworks;

import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.*;

import com.google.appengine.api.users.UserServiceFactory;

import controller.PMF;
import model.entity.Access;
import model.entity.Homework;
import model.entity.Resource;
import model.entity.Role;
import model.entity.User;

import javax.servlet.*;
import javax.jdo.PersistenceManager;

@SuppressWarnings("serial")
public class HomeworksControllerAdd extends HttpServlet {
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
							+ uSearch.get(0).getIdRole() + "&& 	IdUrl==" + rSearch.get(0).getId() + "&& status==true";
					List<Access> aSearch = (List<Access>) pm.newQuery(query3).execute();
					// verificando acceso registrado
					if (aSearch.isEmpty()) {
						RequestDispatcher var = getServletContext()
								.getRequestDispatcher("/WEB-INF/Views/Errors/deny4.jsp");
						var.forward(req, resp);
					} else {
						doPost(req, resp);
					}
				}

			}
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		PersistenceManager pm = PMF.get().getPersistenceManager();
		String alumno = req.getParameter("alumno");
		String tema = req.getParameter("tema");
		String curso = req.getParameter("curso");
		String profesor =req.getParameter("profesor");
		
		if (req.getParameter("alumno") != null && req.getParameter("tema") != null && req.getParameter("curso") != null
				&& req.getParameter("profesor") != null) {
			Homework p;
			try {
				p = new Homework(alumno, tema, curso, profesor);
				try {
					pm.makePersistent(p);
				} finally {
					pm.close();
				}
				System.out.println(p.toString());
				resp.sendRedirect("/homeworks");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		RequestDispatcher var = getServletContext().getRequestDispatcher("/WEB-INF/Views/Homeworks/add.jsp");
		try {
			var.forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}