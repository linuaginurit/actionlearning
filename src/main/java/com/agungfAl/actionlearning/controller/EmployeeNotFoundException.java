package com.agungfAl.actionlearning.controller;

public class EmployeeNotFoundException extends RuntimeException {
  EmployeeNotFoundException(Long id){
      super(String.format("Employee dengan id:%s tidak ditemukan",id));
  }
}

