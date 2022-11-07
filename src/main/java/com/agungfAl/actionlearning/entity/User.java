package com.agungfAl.actionlearning.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;


@Entity
public class User{
  @GeneratedValue @Id Long id;
  private String username;
  private String password;
  Date created_at;
  Date updated_at;
  Date last_login;

  @OneToOne
  @JoinColumn(name = "employee_id",referencedColumnName = "id", nullable = false)
  private Employee profile;

  public Employee getProfile() {
      return profile;
  }
  public void setProfile(Employee profile) {
      this.profile = profile;
  }
  public User() {
  }
  public User(String username, String password) {
      this.username = username;
      this.password = password;
  }

  @PrePersist
  public void onCreate() {
      this.created_at = new Date();
      this.updated_at = new Date();
  }

  @PreUpdate
  public void onUpdate() {
      this.updated_at = new Date();
  }

  public Long getId() {
      return id;
  }
  public void setId(Long id) {
      this.id = id;
  }
  public String getUsername() {
      return username;
  }
  public void setUsername(String username) {
      this.username = username;
  }
  public void setPassword(String password) {
      this.password = password;
  }
  public Date getCreated_at() {
      return created_at;
  }
  public void setCreated_at(Date created_at) {
      this.created_at = created_at;
  }
  public Date getUpdated_at() {
      return updated_at;
  }
  public void setUpdated_at(Date updated_at) {
      this.updated_at = updated_at;
  }
  public Date getLast_login() {
      return last_login;
  }
  public void setLast_login(Date last_login) {
      this.last_login = last_login;
  }

  
}
