package com.agungfAl.actionlearning.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SiteController {
  @GetMapping("/")
  String site(){
      return "API ver. 0.1";
  }

}
