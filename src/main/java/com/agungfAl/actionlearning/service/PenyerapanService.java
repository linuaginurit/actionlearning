package com.agungfAl.actionlearning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agungfAl.actionlearning.entity.PenyerapanDanaDesa;
import com.agungfAl.actionlearning.repository.PenyerapanRepository;

@Service
public class PenyerapanService {
  @Autowired
  private PenyerapanRepository repo;
  public PenyerapanDanaDesa update(PenyerapanDanaDesa newSerap, Long id){
    return repo.findById(id).map(
      serap -> {
         serap.setVolume(newSerap.getVolume());
         serap.setkdUraianOutput(newSerap.getkdUraianOutput());
         serap.setsatuanOutput(newSerap.getsatuanOutput());
         return repo.save(serap);}
        ).orElseGet(()->{
        newSerap.setId(id);
        return repo.save(newSerap);
        });}
}
