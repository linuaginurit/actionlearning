package com.agungfAl.actionlearning.repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.agungfAl.actionlearning.entity.PenyerapanDanaDesa;

@Configuration
public class LoadDatabase {
  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
//   @Bean
//   CommandLineRunner initDatabase(PenyerapanRepository repo){
//     return args -> {
//       log.info("isi data"+repo.save(new PenyerapanDanaDesa("08080808808","5300001","2","UNIT", null, null, null, null, null, null)));
//       log.info("isi data"+repo.save(new PenyerapanDanaDesa("123123123","5300001","2","UNIT", null, null, null, null, null, null)));
//     };
//   }
}
