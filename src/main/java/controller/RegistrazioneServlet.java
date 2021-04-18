package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Utente;
import model.UtenteDAO;

@WebServlet(name = "RegistrazioneServlet", value = "/RegistrazioneServlet")
public class RegistrazioneServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    UtenteDAO utenteDAO = new UtenteDAO();
    Utente u1, utente = new Utente();
    utente.setUsername(request.getParameter("username"));
    utente.setPasswordhash(request.getParameter("psw1"));
    utente.setEmail(request.getParameter("email"));
    utenteDAO.doSave(utente);
    request.getSession().setAttribute("utente", utente);
    u1 = utenteDAO.doRetrieveByUsernamePassword(utente.getUsername(), utente.getPasswordhash());
    request.setAttribute("utente", u1);
    String add = "/InsertRes.jsp";
    RequestDispatcher dispatcher = request.getRequestDispatcher(add);
    dispatcher.forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }
}
