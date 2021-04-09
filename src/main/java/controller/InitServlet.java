package controller;

import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import model.Categoria;
import model.CategoriaDAO;

@WebServlet(name = "MyInit", urlPatterns = "/MyInit", loadOnStartup = 0)
public class InitServlet extends HttpServlet {

  @Override
  public void init(ServletConfig config) throws ServletException {
    super.init(config);
    CategoriaDAO categoriaDAO = new CategoriaDAO();
    List<Categoria> categorie = categoriaDAO.doRetriveAll();
    getServletContext().setAttribute("categorie", categorie);
  }
}
