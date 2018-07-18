package controller.kids;

import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.*;

import com.google.appengine.api.users.UserServiceFactory;

import controller.PMF;
import model.entity.Access;
import model.entity.Kids;
import model.entity.Resource;
import model.entity.Role;
import model.entity.User;
import model.entity.Listas;

import javax.servlet.*;
import javax.jdo.PersistenceManager;

@SuppressWarnings("serial")
public class KidsControllerAdd extends HttpServlet {
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
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String name = req.getParameter("name");
		String tutor = req.getParameter("tutor");
		String DNI = req.getParameter("DNI");
		String place_birth = req.getParameter("place_birth");
		String correo = req.getParameter("correo");
		String padre = req.getParameter("padre");
		String madre = req.getParameter("madre");
		String religion = req.getParameter("religion");
		String hobby = req.getParameter("hobby");
		String grado = req.getParameter("grado");
		

		boolean gender = Boolean.parseBoolean(req.getParameter("gender"));

		if (req.getParameter("name") != null && req.getParameter("tutor") != null && req.getParameter("DNI") != null
				&& req.getParameter("place_birth") != null && req.getParameter("correo") != null
				&& req.getParameter("padre") != null && req.getParameter("madre") != null
				&& req.getParameter("religion") != null && req.getParameter("hobby") != null
				&& req.getParameter("gender") != null && req.getParameter("birth") != null
				&& req.getParameter("created") != null && req.getParameter("grado") != null) {
			Kids p;
			Listas l;

			try {
				Date created = null, birth = null;
				created = sdf.parse(req.getParameter("created"));
				birth = sdf.parse(req.getParameter("birth"));
				p = new Kids(name, tutor, DNI, created, gender, place_birth, birth, correo, padre,
						madre, religion, hobby, grado);
				try {
					pm.makePersistent(p);
				} finally {
					pm.close();
				}
				System.out.println(p.toString());
				resp.sendRedirect("/kids");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		RequestDispatcher var = getServletContext().getRequestDispatcher("/WEB-INF/Views/Kids/add.jsp");
		try {
			var.forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}