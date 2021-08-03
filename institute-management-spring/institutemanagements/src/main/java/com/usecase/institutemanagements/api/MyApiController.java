package com.usecase.institutemanagements.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;
import java.util.Collection;
import java.util.Optional;

import com.usecase.institutemanagements.entity.Admin;
import com.usecase.institutemanagements.entity.Prof;
import com.usecase.institutemanagements.entity.Student;
import com.usecase.institutemanagements.service.AdminManager;
import com.usecase.institutemanagements.service.ProfManager;
import com.usecase.institutemanagements.service.StudentManager;

@Api(value="MyAPIController",description = "API Service that manages the Institution")
@RestController
@RequestMapping("api")
public class MyApiController extends BaseController {
    Logger logger = LoggerFactory.getLogger(MyApiController.class);

    @Autowired
    private ProfManager pService;
    @Autowired
    private StudentManager stuService;
    @Autowired
    private AdminManager aService;

    @GetMapping(value = "/admin",produces = MediaType.APPLICATION_JSON_VALUE)    
    public ResponseEntity<List<Admin>> getalladmin(@RequestBody Admin adminReq){
        return new ResponseEntity<List<Admin>>(aService.fetchAll(),HttpStatus.OK);
    }

    @GetMapping(value = "/admin/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<Admin>> getadminbyid(@PathVariable int id){
        return new ResponseEntity<Optional<Admin>>(aService.fetchById(id),HttpStatus.OK);
    }

    @GetMapping(value = "/prof",produces = MediaType.APPLICATION_JSON_VALUE)    
    public ResponseEntity<List<Prof>> getallprof(@RequestBody Prof profReq){
        return new ResponseEntity<List<Prof>>(pService.fetchAll(),HttpStatus.OK);
    }

    @GetMapping(value = "/prof/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<Prof>> getprofbyid(@PathVariable int id){
        return new ResponseEntity<Optional<Prof>>(pService.fetchById(id),HttpStatus.OK);
    }

    @GetMapping(value = "/student/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<Student>> getstubyid(@PathVariable int id){
        return new ResponseEntity<Optional<Student>>(stuService.fetchById(id),HttpStatus.OK);
    }

    @GetMapping(value = "/student",produces = MediaType.APPLICATION_JSON_VALUE)    
    public ResponseEntity<List<Student>> getallstud(@RequestBody Student stuReq){
        return new ResponseEntity<List<Student>>(stuService.fetchAll(),HttpStatus.OK);
    }

    @PostMapping(value = "/admin",produces = MediaType.APPLICATION_JSON_VALUE)    
    public ResponseEntity<List<Admin>> saveAdmin(@RequestBody Admin adminReq){
        aService.save(adminReq);
        System.out.println("====" + adminReq.getId());
        return new ResponseEntity<List<Admin>>(aService.fetchAll(),HttpStatus.OK);
    }

    @PutMapping(value = "/admin",produces = MediaType.APPLICATION_JSON_VALUE)    
    public ResponseEntity<List<Admin>> putAdmin(@RequestBody Admin adminReq){
        aService.save(adminReq);
        System.out.println("====" + adminReq.getId());
        return new ResponseEntity<List<Admin>>(aService.fetchAll(),HttpStatus.OK);
    }

    @PostMapping(value = "/prof",produces = MediaType.APPLICATION_JSON_VALUE)    
    public ResponseEntity<List<Prof>> saveProf(@RequestBody Prof profReq){
        pService.save(profReq);
        System.out.println("====" + profReq.getId());
        return new ResponseEntity<List<Prof>>(pService.fetchAll(),HttpStatus.OK);
    }

    @PutMapping(value = "/prof",produces = MediaType.APPLICATION_JSON_VALUE)    
    public ResponseEntity<List<Prof>> putProf(@RequestBody Prof profReq){
        pService.save(profReq);
        System.out.println("====" + profReq.getId());
        return new ResponseEntity<List<Prof>>(pService.fetchAll(),HttpStatus.OK);
    }

    @PostMapping(value = "/student",produces = MediaType.APPLICATION_JSON_VALUE)    
    public ResponseEntity<List<Student>> putStudent(@RequestBody Student stuReq){
        stuService.save(stuReq);
        System.out.println("====" + stuReq.getId());
        return new ResponseEntity<List<Student>>(stuService.fetchAll(),HttpStatus.OK);
    }

    @PutMapping(value = "/student",produces = MediaType.APPLICATION_JSON_VALUE)    
    public ResponseEntity<List<Student>> saveStudent(@RequestBody Student stuReq){
        stuService.save(stuReq);
        System.out.println("====" + stuReq.getId());
        return new ResponseEntity<List<Student>>(stuService.fetchAll(),HttpStatus.OK);
    }

    @DeleteMapping(value = "/prof/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteProf (@PathVariable int id){
    pService.delete(id);
    }

    @DeleteMapping(value = "/student/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteStudent (@PathVariable int id){
    stuService.delete(id);
    }

}

