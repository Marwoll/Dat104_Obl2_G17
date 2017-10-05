package no.hib.dat104.kontroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringEscapeUtils;

@WebServlet("/paameldingsskjema")
public class paameldingsskjema_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	int fornavnLengde;
	int etternavnLengde;
	int mobilLengde;
	int mobilNr;
	boolean gyldig;
	
	String errorFornavn;
	String errorEtternavn;
	String errorMobil;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesjon = request.getSession(false);

		if (sesjon == null) {
			response.sendRedirect("paameldingsskjema.jsp");
		} else {
			request.getRequestDispatcher("paameldingsbekreftelse").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		errorFornavn="";
		errorEtternavn="";
		errorMobil="";
		
		String fornavn = request.getParameter("fornavn");
		String etternavn = request.getParameter("etternavn");
		String mobil = request.getParameter("mobil");
		String kjonn = request.getParameter("kjonn");

		StringEscapeUtils.escapeHtml(fornavn);
		StringEscapeUtils.escapeHtml(etternavn);
		StringEscapeUtils.escapeHtml(mobil);

		fornavnLengde = fornavn.length();
		etternavnLengde = etternavn.length();
		mobilLengde = mobil.length();
	
		//Detta bør vær i Unit-testa
		if (fornavn.isEmpty() == true) {
			errorFornavn = "Kan ikke være tomt";
			gyldig = false;
			System.out.println("fornavn");
		} else if (fornavn.length() > 20 || fornavn.length() < 2) {
			errorFornavn = "Må være mellom 2 og 20 bokstaver i lengde";
			gyldig = false;
			System.out.println("fornavnlengde");
		
		} else if(etternavn.isEmpty() == true) {
			errorEtternavn = "Kan ikke være tomt";
			gyldig = false;
			System.out.println("etternavn");
		}else if(etternavn.isEmpty() == true) {
				errorEtternavn = "Kan ikke være tomt";
				gyldig = false;
				System.out.println("etternavn");
		} else if(mobil.isEmpty() == true) {
			errorMobil = "Kan ikke være tomt";
			gyldig = false;
		
		} else if (mobil.length() != 8) {
			errorMobil = "Må være 8 siffre";
			gyldig = false;
			System.out.println("mobilikkje8");
		} else {
			gyldig = true; 
		}
		
		if (gyldig==true) {
			HttpSession sesjon = request.getSession(false);
			if (sesjon != null) {
				sesjon.invalidate();
			}
			sesjon = request.getSession(true);
			sesjon.setMaxInactiveInterval(30);
			sesjon.setAttribute("fornavn", fornavn);
			sesjon.setAttribute("etternavn", etternavn);
			sesjon.setAttribute("mobil", mobil);
			sesjon.setAttribute("konn", kjonn);
			response.sendRedirect("paameldingsbekreftelse");
		} else{
			request.setAttribute("errorFornavn", errorFornavn);
			request.setAttribute("errorEtternavn", errorEtternavn);
			request.setAttribute("errorMobil", errorMobil);
			request.getRequestDispatcher("/paameldingsskjema.jsp").forward(request, response);
		}

	}



}
