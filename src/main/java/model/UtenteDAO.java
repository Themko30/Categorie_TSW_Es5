package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UtenteDAO {

  public void doSave(Utente utente) {
    try (Connection con = ConPool.getConnection()) {
      PreparedStatement stmt =
          con.prepareStatement(
              "INSERT INTO utente (username, passwordhash, email) VALUES (?,?,?)",
              Statement.RETURN_GENERATED_KEYS);
      stmt.setString(1, utente.getUsername());
      stmt.setString(2, utente.getPasswordhash());
      stmt.setString(3, utente.getEmail());
      if (stmt.executeUpdate() != 1) {
        throw new RuntimeException("INSERT error.");
      }
      ResultSet rs = stmt.getGeneratedKeys();
      rs.next();
      int id = rs.getInt(1);
      utente.setId(id);

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public Utente doRetrieveByUsernamePassword(String username, String password) {
    try (Connection con = ConPool.getConnection()) {
      PreparedStatement stmt =
          con.prepareStatement("SELECT * FROM utente WHERE username=? AND passwordhash=SHA1(?)");
      stmt.setString(1, username);
      stmt.setString(2, password);
      ResultSet rs = stmt.executeQuery();
      if (rs.next()) {
        Utente u = new Utente();
        u.setId(rs.getInt(1));
        u.setUsername(rs.getString(2));
        u.setPasswordhash(rs.getString(3));
        u.setEmail(rs.getString(4));
        u.setAdmin(rs.getBoolean(5));
        return u;
      }
      return null;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
