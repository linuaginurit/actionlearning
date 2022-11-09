package com.agungfAl.actionlearning.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

// import java.util.List;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.agungfAl.actionlearning.service.PenyerapanService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import com.agungfAl.actionlearning.entity.PenyerapanDanaDesa;
import com.agungfAl.actionlearning.repository.PenyerapanRepository;

@RestController
public class PenyerapanController {
  private final PenyerapanRepository repo;
  PenyerapanController(PenyerapanRepository repository){
    this.repo = repository;
  }
  @Autowired
  private PenyerapanService service;
  
  @Operation(summary = "Get All penyerapan")
  @ApiResponses(
    value = {
      @ApiResponse(responseCode = "200",description = "Found the Penyerapan"),
      @ApiResponse(responseCode = "404",description = "Penyerapan Not Found"),
      @ApiResponse(responseCode = "500",description = "Internal Server Error"),
    }
  )
  @GetMapping("/penyerapan")
  List<PenyerapanDanaDesa> getAll(){
    return repo.findAll();
    // return repo.findAll(PageRequest.of(0, 5, Sort.by("name").ascending()));
  } 
  @Operation(summary = "Adding Penyerapan")
  @PostMapping("/penyerapan")
  PenyerapanDanaDesa add(@RequestBody PenyerapanDanaDesa newSerap){
    return repo.save(newSerap);
  }
  @Operation(summary = "Find Penyerapan By id")
  @GetMapping("/penyerapan/{id}")
  PenyerapanDanaDesa getOne(@PathVariable Long id){
    return repo.findById(id).orElseThrow(()->new PenyerapanNotFoundException(id));
  }
  
  @Operation(summary = "Find Penyerapan By kode_output")
  @GetMapping("/penyerapan_output/{kdUraianOutput}")
  public List<PenyerapanDanaDesa> getPenyerapanDanaDesas(@PathVariable String kdUraianOutput){
      return repo.findByKdUraianOutput(kdUraianOutput);
  }  

  @Operation(summary = "Delete Penyerapan By id")
  @DeleteMapping("/penyerapan/{id}")
  void deleteSerap(@PathVariable Long id){
      repo.deleteById(id);
  }

  @Operation(summary = "Get penyerapan BLT")
  @GetMapping("/penyerapan_blt")
  List<PenyerapanDanaDesa> getBlt(){
    return repo.getBlt();
    // return repo.findAll(PageRequest.of(0, 5, Sort.by("name").ascending()));
  } 

  @Operation(summary = "Update Penyerapan")
  @PutMapping("/penyerapan/{id}")
  PenyerapanDanaDesa updateSerap(@RequestBody PenyerapanDanaDesa newSerap, @PathVariable Long id){
    return service.update(newSerap, id);
  }

  private static String UPLOAD_FOLDER = "/tmp/uploads/";
  @PostMapping(value = "/penyerapan/upload", consumes = "multipart/form-data")
    public String uploadSerapPic(@RequestParam("file") MultipartFile file) {
        try {
            byte[] bytes = file.getBytes();
            Path dir = Paths.get(UPLOAD_FOLDER);
            //jika directory belum ada maka akan dibuat
            if (!Files.exists(dir)) {
                Files.createDirectories(dir);
            }
            //set path untuk file yang akan diupload
            Path path = Paths.get(UPLOAD_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            return "File uploaded successfully!";
        } catch (IOException e) {
            e.printStackTrace();
            return "Gagal upload file!";
        }
    }

}
