package model;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utente {
  private int id;
  private String username;
  private String passwordhash;
  private String email;
  private Boolean admin;

  public Utente(int id, String username, String passwordhash, String email, Boolean admin) {
    this.id = id;
    this.username = username;
    this.passwordhash = passwordhash;
    this.email = email;
    this.admin = admin;
  }

  public Utente() {}

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPasswordhash() {
    return passwordhash;
  }

  public void setPasswordhash(String password) {
    try {
      MessageDigest digest = MessageDigest.getInstance("SHA-1");
      digest.reset();
      digest.update(password.getBytes(StandardCharsets.UTF_8));
      this.passwordhash = String.format("%040x", new BigInteger(1, digest.digest()));
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException(e);
    }
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Boolean getAdmin() {
    return admin;
  }

  public void setAdmin(Boolean admin) {
    this.admin = admin;
  }
}
