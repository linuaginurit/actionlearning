package com.agungfAl.actionlearning.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@NamedQuery(name = "PenyerapanDanaDesa.getBlt", query = "SELECT e FROM PenyerapanDanaDesa e  WHERE e.kdUraianOutput = '530001'")
public class PenyerapanDanaDesa {
  private @Id @GeneratedValue Long id;
  @NotBlank @Size(min =10, max=10)
  private String kdDesa;
  private String kdUraianOutput;
  private String volume;
  private String satuanOutput;
  private String realisasi;
  private String persentase;
  private String createdDate;
  private String status;
  private String tahun;
  private String keterangan;


  


  public PenyerapanDanaDesa() {
  }

  

  public PenyerapanDanaDesa(String kdDesa, String kdUraianOutput, String volume, String satuanOutput,
      String realisasi, String persentase, String createdDate, String status, String tahun, String keterangan) {
    this.kdDesa = kdDesa;
    this.kdUraianOutput = kdUraianOutput;
    this.volume = volume;
    this.satuanOutput = satuanOutput;
    this.realisasi = realisasi;
    this.persentase = persentase;
    this.createdDate = createdDate;
    this.status = status;
    this.tahun = tahun;
    this.keterangan = keterangan;
  }



  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getkdDesa() {
    return kdDesa;
  }
  public void setkdDesa(String kdDesa) {
    this.kdDesa = kdDesa;
  }
  public String getkdUraianOutput() {
    return kdUraianOutput;
  }
  public void setkdUraianOutput(String kdUraianOutput) {
    this.kdUraianOutput = kdUraianOutput;
  }
  public String getVolume() {
    return volume;
  }
  public void setVolume(String volume) {
    this.volume = volume;
  }
  public String getsatuanOutput() {
    return satuanOutput;
  }
  public void setsatuanOutput(String satuanOutput) {
    this.satuanOutput = satuanOutput;
  }
  public String getRealisasi() {
    return realisasi;
  }
  public void setRealisasi(String realisasi) {
    this.realisasi = realisasi;
  }
  public String getPersentase() {
    return persentase;
  }
  public void setPersentase(String persentase) {
    this.persentase = persentase;
  }
  public String getcreatedDate() {
    return createdDate;
  }
  public void setcreatedDate(String createdDate) {
    this.createdDate = createdDate;
  }
  public String getStatus() {
    return status;
  }
  public void setStatus(String status) {
    this.status = status;
  }
  public String getTahun() {
    return tahun;
  }
  public void setTahun(String tahun) {
    this.tahun = tahun;
  }
  public String getKeterangan() {
    return keterangan;
  }
  public void setKeterangan(String keterangan) {
    this.keterangan = keterangan;
  }


  
}
