package com.agungfAl.actionlearning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agungfAl.actionlearning.entity.PenyerapanDanaDesa;

public interface PenyerapanRepository extends JpaRepository<PenyerapanDanaDesa,Long> {
  public List<PenyerapanDanaDesa> findByKdUraianOutput(String kdUraianOutput);
  public List<PenyerapanDanaDesa> getBlt();
}