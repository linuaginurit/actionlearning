package com.agungfAl.actionlearning.entity;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;



@Entity
public class Employee {
  
  private @Id @GeneratedValue Long id;
    
  @NotBlank
  @Size(min = 3, max = 20)
  private String name;
  private String role;
  private boolean isActive;

  @ManyToOne
  @JoinColumn (name = "atasan_id")
  private Employee atasan;

//   @OneToMany
//   @JoinColumn(mappedBy="atasan")
//   private List<Employee> staff;

  public Employee() {
  }
  public Employee(String name, String role) {
      this.name = name;
      this.role = role;
  }



  @Override
  public boolean equals(Object obj) {
      if(this == obj)
          return true;
      if(!(obj instanceof Employee))
          return false;
      Employee e = (Employee) obj;
      return Objects.equals(this.id,e.id);
  }

  @Override
  public String toString() {
      // TODO Auto-generated method stub
      return super.toString();
  }
 
  public Long getId() {
      return id;
  }
  public String getName() {
      return name;
  }
  public String getRole() {
      return role;
  }
  public void setId(Long id) {
      this.id = id;
  }
  public void setName(String name) {
      this.name = name;
  }
  public void setRole(String role) {
      this.role = role;
  }
  public boolean isActive() {
      return isActive;
  }
  public void setActive(boolean isActive) {
      this.isActive = isActive;
  }
}
