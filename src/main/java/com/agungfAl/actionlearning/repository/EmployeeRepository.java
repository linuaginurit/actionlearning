package com.agungfAl.actionlearning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.agungfAl.actionlearning.entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long>{
  //Get employee by name (custom method)
  public List<Employee> findByName(String name);
  //menggunakan namedquery yang ada di entity
  public List<Employee> findAdmin();
  //menggunakan @Query
  @Query("SELECT e FROM Employee e WHERE e.role = 'USER'")
  public List<Employee> findUser();
  //menggunakan @Query dengan native query
  @Query(value="SELECT * FROM employee WHERE role = 'USER' and is_active=true", nativeQuery = true)
  public List<Employee> findUserBiasa();

  // public List<Employee> findByNameAndRole(String name, String role);
  // public List<Employee> findByNameOrRole(String name, String role);
  // public List<Employee> findByNameLike(String name);
  // public List<Employee> findByNameContaining(String name);
  // public List<Employee> findByNameStartingWith(String name);
  // public List<Employee> findByNameEndingWith(String name);
  // public List<Employee> findByNameIgnoreCase(String name);
  // public List<Employee> findByNameNot(String name);
  // public List<Employee> findByNameNotLike(String name);
  // public List<Employee> findByNameNotContaining(String name);
  // public List<Employee> findByNameNotStartingWith(String name);
  // public List<Employee> findByNameNotEndingWith(String name);
  // public List<Employee> findByNameNotIgnoreCase(String name);
  // public List<Employee> findByIsActiveTrue();     
  // public List<Employee> findByIdGreaterThan(Long id);
  // public List<Employee> findByIdLessThan(Long id);  

}

