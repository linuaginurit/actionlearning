package com.agungfAl.actionlearning.entity;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;



@Entity
@NamedQuery(name = "Employee.findAdmin", query = "SELECT e FROM Employee e WHERE e.role = 'ADMIN'")
public class Employee {
  
  private @Id @GeneratedValue Long id;
    
  @NotBlank
  @Size(min = 3, max = 20)
  private String name;
  private String role;
  private boolean isActive;


  @Transient 
  Long atasan_id;
  @ManyToOne(fetch = FetchType.LAZY,optional = false)
  @JoinColumn (name = "atasan_id")
  private Employee atasan;

  @OneToMany(mappedBy = "atasan", fetch = FetchType.LAZY)
//   @JoinColumn(name = "atasan_id")
  private List<Employee> staff;

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
public Employee getAtasan() {
    return atasan;
}
// public List<Employee> getStaff() {
//     return staff;
// }
}
