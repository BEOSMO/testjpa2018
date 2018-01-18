package servlet;

import domain.Person;
import jpa.GenTestDao;
import jpa.PersonDao;

import java.io.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.util.*;


@WebServlet(name = "PersonInfo", urlPatterns = { "/PersonInfo" })
public class PersonInfo extends HttpServlet {
	PersonDao daop;
	@Override
	public void init() throws ServletException {
		super.init();
		 daop = new PersonDao();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		for (Person p : daop.readAll()){
			out.println("Name : " + p.getName() +"<BR>");
			out.println("Prénom : " + p.getFirstName() +"<BR>");
			out.println("Mail : " + p.getMail() +"<BR>");

		}
		out.println("</body></html>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");

		EntityManager manager = factory.createEntityManager();

		GenTestDao genTestDAO = new GenTestDao(manager);

		EntityTransaction tx = manager.getTransaction();

		Person user = new Person(request.getParameter("name"),

				request.getParameter("firstName"),

				request.getParameter("email"));

		tx.begin();

		genTestDAO.create(user);

		tx.commit();

		response .setContentType("text/html");

		PrintWriter out = response .getWriter();

		out.println( "<html>\n<body>\n" +

               "<h1>Recapitulatif des informations</h1>\n" +

               "<ul>\n" +

               "<li>Nom: "

		+ request . getParameter ( "name" ) + "\n" +

               "<li>Prenom: "

		+ request . getParameter ( "firstName" ) + "\n" +

               " <li>Email: "

		+ request . getParameter ( "email" ) + "\n" +

               "</ul>\n" +

               "</body></html>" );

	}
	}
