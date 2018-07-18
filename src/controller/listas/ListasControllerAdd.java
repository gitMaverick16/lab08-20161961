package controller.listas;

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
import model.entity.Listas;
import model.entity.Kids;

@SuppressWarnings("serial")
public class ListasControllerAdd extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		PersistenceManager pm = PMF.get().getPersistenceManager();

		String query = "select from " + Kids.class.getName();

		List<Kids> niños = (List<Kids>) pm.newQuery(query).execute();

		// pasar la lista al jsp
		req.setAttribute("niños", niños);
		RequestDispatcher var = this.getServletContext().getRequestDispatcher("/WEB-INF/Views/Listas/add.jsp");
		var.forward(req, resp);

	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		PersistenceManager pm = PMF.get().getPersistenceManager();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		boolean presente = Boolean.parseBoolean(req.getParameter("presente"));
		Long IdKids = Long.parseLong(req.getParameter("IdKids"));
		String tutor = req.getParameter("tutor");

		if (req.getParameter("dia") != null && req.getParameter("tutor") != null
				&& req.getParameter("IdKids") != null
				&& req.getParameter("presente") !=null) {
			Listas u;
			try {
				Date dia = null;
				dia = sdf.parse(req.getParameter("dia"));
				u = new Listas(dia, tutor, IdKids, presente);
				try {
					pm.makePersistent(u);
				} finally {
					pm.close();
				}
				resp.sendRedirect("/listas");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		RequestDispatcher var = getServletContext().getRequestDispatcher("/WEB-INF/Views/Listas/add.jsp");
		try {
			var.forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}