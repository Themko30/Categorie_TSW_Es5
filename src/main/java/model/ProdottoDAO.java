package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProdottoDAO {

  public List<Prodotto> doRetriveAll() {

    ArrayList<Prodotto> prodotti = new ArrayList<>();
    Statement statement;
    ResultSet rs;
    Prodotto prodotto;

    try (Connection con = ConPool.getConnection()) {
      statement = con.createStatement();
      rs = statement.executeQuery("SELECT * FROM prodotto");
      while (rs.next()) {
        prodotto = new Prodotto();
        prodotto.setId(rs.getInt(1));
        prodotto.setName(rs.getString(2));
        prodotto.setDescription(rs.getString(3));
        prodotto.setPrice(rs.getDouble(4));
        prodotti.add(prodotto);
      }
      return prodotti;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public List<Prodotto> doRetriveByCategoria(int idcategoria) {

    ArrayList<Prodotto> prodotti = new ArrayList<>();
    PreparedStatement statement1;
    Statement statement2;
    ResultSet rs1, rs2;
    Prodotto prodotto;
    ArrayList<Integer> idcat_res = new ArrayList<>();

    try (Connection con = ConPool.getConnection()) {
      statement1 =
          con.prepareStatement("SELECT idprodotto FROM prodottocategoria WHERE idcategoria=?");
      statement1.setInt(1, idcategoria);
      rs1 = statement1.executeQuery();
      while (rs1.next()) {
        idcat_res.add(rs1.getInt(1));
      }
      for (int i = 0; idcat_res.size() > i; i++) {
        String query =
            "SELECT id, nome, descrizione, prezzo FROM prodotto WHERE id=" + idcat_res.get(i) + ";";
        statement2 = con.createStatement();
        rs2 = statement2.executeQuery(query);
        prodotto = new Prodotto();
        prodotto.setId(rs2.getInt(1));
        prodotto.setName(rs2.getString(2));
        prodotto.setDescription(rs2.getString(3));
        prodotto.setPrice(rs2.getDouble(4));
        prodotti.add(prodotto);
      }
      return prodotti;

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
