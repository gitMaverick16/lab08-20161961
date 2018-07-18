package controller.kids;

import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.appengine.api.users.UserServiceFactory;

import controller.PMF;
import model.entity.Access;
import model.entity.Kids;
import model.entity.Resource;
import model.entity.User;

@SuppressWarnings("serial")
public class KidsControllerUpdate extends HttpServlet {
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

						Kids niños = pm.getObjectById(Kids.class, Long.parseLong(req.getParameter("id")));
						pm.close();
						req.setAttribute("niños", niños);
						RequestDispatcher var = this.getServletContext()
								.getRequestDispatcher("/WEB-INF/Views/Kids/update.jsp");
						var.forward(req, resp);
					}
				}
			}

		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Kids niños = pm.getObjectById(Kids.class, Long.parseLong(req.getParameter("id")));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date created = null, birth = null;
		try {
			created = sdf.parse(req.getParameter("created"));
			birth = sdf.parse(req.getParameter("birth"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		niños.setName(req.getParameter("name"));
		niños.setDNI(req.getParameter("DNI"));
		niños.setTutor(req.getParameter("tutor"));
		niños.setHobby(req.getParameter("hobby"));
		niños.setMadre(req.getParameter("madre"));
		niños.setPlace_birth(req.getParameter("place_birth"));
		niños.setCorreo(req.getParameter("correo"));
		niños.setPadre(req.getParameter("padre"));
		niños.setReligion(req.getParameter("religion"));
		niños.setGender(Boolean.parseBoolean(req.getParameter("gender")));
		niños.setCreated(created);
		niños.setBirth(birth);
		niños.setGrado(req.getParameter("grado"));

		pm.close();
		req.setAttribute("niños", niños);
		resp.sendRedirect("/kids/view?id=" + req.getParameter("id"));
	}
}