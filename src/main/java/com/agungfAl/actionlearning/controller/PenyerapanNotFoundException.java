package com.agungfAl.actionlearning.controller;

public class PenyerapanNotFoundException extends RuntimeException {
  PenyerapanNotFoundException(Long id){
    super(String.format("Penyerapan dengan id:%s tidak ditemukan",id));
}

}
