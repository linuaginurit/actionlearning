package com.agungfAl.actionlearning.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.agungfAl.actionlearning.entity.Employee;
import com.agungfAl.actionlearning.repository.EmployeeRepository;
import com.agungfAl.actionlearning.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@RestController
public class EmployeeController {
    private final EmployeeRepository repo;
    EmployeeController(EmployeeRepository repository){
        this.repo = repository;
    }
    @Autowired
    private EmployeeService service;

    @Operation(summary = "Get Semua employee dengan role user")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Found the employee"),
        @ApiResponse(responseCode = "404", description = "Employee not found"),
        @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @GetMapping("/employees_user")
    public List<Employee> findUser(){
        return service.findUser();
    }

    @Operation(summary = "Get Semua employee dengan role user yang aktif")
    @GetMapping("/employees_active_user")
    public List<Employee> findActiveUser(){
        return repo.findUserBiasa();
    }
    @GetMapping("/employees_admin")
    public List<Employee> getAdmin(){
        return repo.findAdmin();
    }

    @GetMapping("/employees_by_name/{name}")
    public List<Employee> getEmployeeByName(@PathVariable String name){
        return repo.findByName(name);
    }

    @GetMapping("/employees")
    Page<Employee> getAll(){
        return repo.findAll(
            PageRequest.of(0, 5, Sort.by("name").ascending())      
        );
    }
    @PostMapping("/employees")
    Employee add(@RequestBody Employee newEmp){
        return repo.save(newEmp);
    }
    @GetMapping("/employees/{id}")
    Employee getOne(@PathVariable Long id){
        return repo.findById(id).orElseThrow(()->new EmployeeNotFoundException(id));
    }

    @DeleteMapping("/employees/{id}")
    void deleteEmp(@PathVariable Long id){
        repo.deleteById(id);
    }

    

    @PutMapping("/employees/{id}")
    Employee updateEmp(@RequestBody Employee newEmp, @PathVariable Long id){
        return service.update(newEmp, id);
    }

    // private static String UPLOAD_FOLDER = "uploads/";
    private static String UPLOAD_FOLDER = "/tmp/uploads/";
    @PostMapping(value = "/employees/upload", consumes = "multipart/form-data")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
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

    @PostMapping(value = "/employees/uploads", consumes = "multipart/form-data")
    public String uploadFiles(@RequestParam("file") MultipartFile[] file) {
        try {
            for (MultipartFile f : file) {
                byte[] bytes = f.getBytes();
                Path dir = Paths.get(UPLOAD_FOLDER);
                //jika directory belum ada maka akan dibuat
                if (!Files.exists(dir)) {
                    Files.createDirectories(dir);
                }
                //set path untuk file yang akan diupload
                Path path = Paths.get(UPLOAD_FOLDER + f.getOriginalFilename());
                Files.write(path, bytes);
            }
            return "File uploaded successfully!";
        } catch (IOException e) {
            e.printStackTrace();
            return "Gagal upload file!";
        }
    }

    @RequestMapping("/employees/download")
    public Resource downloadFile(String fileName) throws IOException {
        //  Path path = Paths.get(UPLOAD_FOLDER + fileName);
         File file = new File(UPLOAD_FOLDER + fileName); 
         HttpHeaders header = new HttpHeaders();
         header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + file.getName());
         header.add("Cache-Control", "no-cache, no-store, must-revalidate");
        header.add("Pragma", "no-cache");
        header.add("Expires", "0");
        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(file.toPath()));
        return resource;
    }
}
