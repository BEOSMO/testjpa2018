package servlet;

import domain.Home;
import domain.Person;
import jpa.GenTestDao;
import jpa.HomeDao;

import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "HomeInfo", urlPatterns = { "/HomeInfo" })
public class HomeInfo extends HttpServlet {

    HomeDao daoh;
    @Override
    public void init() throws ServletException {
        super.init();
        daoh = new HomeDao();
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		for (Home h : daoh.readAll()){
			out.println("Nombre de chambres : " + h.getRooms() +"<BR>");
			out.println("Surface en m² : " + h.getSurface() +"<BR>");
		}
		out.println("</body></html>");
	}

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");

        EntityManager manager = factory.createEntityManager();

        GenTestDao genTestDAO = new GenTestDao(manager);

        EntityTransaction tx = manager.getTransaction();

        Home home = new Home(request.getParameter("rooms"),

                request.getParameter("surface"));

        tx.begin();

        genTestDAO.create(home);

        tx.commit();

        response .setContentType("text/html");

        PrintWriter out = response .getWriter();

        out.println( "<html>\n<body>\n" +

                "<h1>Recapitulatif des informations</h1>\n" +

                "<ul>\n" +

                "<li>Nombre de chambre(s): "

                + request . getParameter ( "rooms" ) + "\n" +

                "<li>Surface: "

                + request . getParameter ( "surface" ) + "\n" +

                "</ul>\n" +

                "</body></html>" );

    }
}



