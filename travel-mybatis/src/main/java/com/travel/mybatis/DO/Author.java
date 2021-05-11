package com.travel.mybatis.DO;


import java.io.Serializable;

public class Author implements Serializable {

  protected String id;
  protected String username;
  protected String password;
  protected String email;
  protected String bio;

  public Author() {

  }

  public void setId(String id) {
    this.id = id;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setBio(String bio) {
    this.bio = bio;
  }

  public String getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public String getEmail() {
    return email;
  }

  public String getBio() {
    return bio;
  }



  @Override
  public String toString() {
    return "Author : " + id + " : " + username + " : " + email;
  }
}
