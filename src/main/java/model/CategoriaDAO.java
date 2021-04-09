package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {

  public List<Categoria> doRetriveAll() {

    ArrayList<Categoria> categories = new ArrayList<>();
    Statement statement;
    ResultSet rs;
    Categoria category;

    try (Connection con = ConPool.getConnection()) {
      statement = con.createStatement();
      rs = statement.executeQuery("SELECT * FROM categoria");
      while (rs.next()) {
        category = new Categoria();
        category.setId(rs.getInt(1));
        category.setName(rs.getString(2));
        category.setDescription(rs.getString(3));
        categories.add(category);
      }
      return categories;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
