package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Prodotto;
import model.ProdottoDAO;

@WebServlet("/index.html")
public class HomeServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    ProdottoDAO prodottoDAO = new ProdottoDAO();
    List<Prodotto> prodotti = prodottoDAO.doRetriveAll();

    request.setAttribute("prodotti", prodotti);

    String add = "/WEB-INF/index.jsp";
    RequestDispatcher dispatcher = request.getRequestDispatcher(add);
    dispatcher.forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }
}
