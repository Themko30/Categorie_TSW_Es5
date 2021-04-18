package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Utente;
import model.UtenteDAO;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    UtenteDAO utenteDAO = new UtenteDAO();
    Utente utente =
        utenteDAO.doRetrieveByUsernamePassword(
            request.getParameter("username"), request.getParameter("password"));
    request.getSession().setAttribute("utente", utente);
    response.sendRedirect(".");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }
}
