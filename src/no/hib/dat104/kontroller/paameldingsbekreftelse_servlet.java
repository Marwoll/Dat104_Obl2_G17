package no.hib.dat104.kontroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/paameldingsbekreftelse")
public class paameldingsbekreftelse_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession sesjon = request.getSession(false);

		if (sesjon == null) {
			response.sendRedirect("paameldingsskjema");
		} else {
			String fornavn = (String) sesjon.getAttribute("fornavn");
			String etternavn = (String) sesjon.getAttribute("etternavn");
			String mobil = (String) sesjon.getAttribute("mobil");
			String kjonn = (String) sesjon.getAttribute("kjonn");
			
			request.setAttribute("fornavn", fornavn);
			request.setAttribute("etternavn", etternavn);
			request.setAttribute("mobil", mobil);
			request.setAttribute("kjonn", kjonn);
			request.getRequestDispatcher("/paameldingsbekreftelse.jsp").forward(request, response);
		}

	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
