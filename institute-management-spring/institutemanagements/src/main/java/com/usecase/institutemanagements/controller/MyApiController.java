package com.usecase.institutemanagements.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;
import java.util.Optional;


import com.usecase.institutemanagements.entity.Admin;
import com.usecase.institutemanagements.entity.Prof;
import com.usecase.institutemanagements.entity.Student;
import com.usecase.institutemanagements.model.ErrorCust;
import com.usecase.institutemanagements.service.AdminManager;
import com.usecase.institutemanagements.service.ProfManager;
import com.usecase.institutemanagements.service.StudentManager;

@Api(value="MyAPIController",description = "API Service that manages the Institution")
@RestController
@CrossOrigin(origins = "*", maxAge = 3000)
@RequestMapping("api")
public class MyApiController extends BaseController {
    Logger logger = LoggerFactory.getLogger(MyApiController.class);

    @Autowired
    private ProfManager pService;
    @Autowired
    private StudentManager stuService;
    @Autowired
    private AdminManager aService;

    @ApiOperation(value="Get all admin", response = Iterable.class, tags = "getalladmin")
    @ApiResponses(value={ 
        @ApiResponse(code = 200, message = "Success|OK"),
        @ApiResponse(code = 401, message = "authorized!"), 
        @ApiResponse(code = 403, message = "forbidden!!!"),
        @ApiResponse(code = 404, message = "not found!!!") })
    @GetMapping(value = "/admin/all",produces = MediaType.APPLICATION_JSON_VALUE)    
    public ResponseEntity<List<Admin>> getalladmin(@RequestBody Admin adminReq)throws ErrorCust{
        try{ 
            return new ResponseEntity<List<Admin>>(aService.fetchAll(),HttpStatus.OK);
        }catch(ErrorCust ec){
        throw ec;
        }
    }

    @ApiOperation(value="Get admin by id", response = Iterable.class, tags = "getadminbyid")
    @ApiResponses(value={ 
        @ApiResponse(code = 200, message = "Success|OK"),
        @ApiResponse(code = 401, message = "authorized!"), 
        @ApiResponse(code = 403, message = "forbidden!!!"),
        @ApiResponse(code = 404, message = "not found!!!") })
    @GetMapping(value = "/admin/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<Admin>> getadminbyid(@PathVariable int id) throws ErrorCust{
        try{
            return new ResponseEntity<Optional<Admin>>(aService.fetchById(id),HttpStatus.OK);
        }catch(ErrorCust ec){
            throw ec;
        }
    }

    @ApiOperation(value="Get all professors", response = Iterable.class, tags = "getallprof")
    @ApiResponses(value={ 
        @ApiResponse(code = 200, message = "RSC-Success|OK"),
        @ApiResponse(code = 401, message = "RSC-not authorized!"), 
        @ApiResponse(code = 403, message = "RSC-forbidden!!!"),
        @ApiResponse(code = 404, message = "RSC-not found!!!") })

    @GetMapping(value = "/prof/all",produces = MediaType.APPLICATION_JSON_VALUE)    
    public ResponseEntity<List<Prof>> getallprof(@RequestBody Prof profReq) throws ErrorCust{
        try{
            return new ResponseEntity<List<Prof>>(pService.fetchAll(),HttpStatus.OK);
        }catch(ErrorCust ec){
            throw ec;
        }
    }

    @ApiOperation(value="Get Professor by id", response = Iterable.class, tags = "getprofbyid")
    @ApiResponses(value={ 
        @ApiResponse(code = 200, message = "Success|OK"),
        @ApiResponse(code = 401, message = "authorized!"), 
        @ApiResponse(code = 403, message = "forbidden!!!"),
        @ApiResponse(code = 404, message = "not found!!!") })
    @GetMapping(value = "/prof/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<Prof>> getprofbyid(@PathVariable int id) throws ErrorCust{
        try{
            return new ResponseEntity<Optional<Prof>>(pService.fetchById(id),HttpStatus.OK);
        }catch(ErrorCust ec){
            throw ec;
        }
    }

    @ApiOperation(value="Get student by id", response = Iterable.class, tags = "getstubyid")
    @ApiResponses(value={ 
        @ApiResponse(code = 200, message = "RSC-Success|OK"),
        @ApiResponse(code = 401, message = "RSC-not authorized!"), 
        @ApiResponse(code = 403, message = "RSC-forbidden!!!"),
        @ApiResponse(code = 404, message = "RSC-not found!!!") })

    @GetMapping(value = "/student/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<Student>> getstubyid(@PathVariable int id) throws ErrorCust{
        try{
            return new ResponseEntity<Optional<Student>>(stuService.fetchById(id),HttpStatus.OK);
        }catch(ErrorCust ec){
            throw ec;
        }
    }

    @ApiOperation(value="Get all Students", response = Iterable.class, tags = "getallstud")
    @ApiResponses(value={ 
        @ApiResponse(code = 200, message = "Success|OK"),
        @ApiResponse(code = 401, message = "authorized!"), 
        @ApiResponse(code = 403, message = "forbidden!!!"),
        @ApiResponse(code = 404, message = "not found!!!") })
    @GetMapping(value = "/student/all",produces = MediaType.APPLICATION_JSON_VALUE)    
    public ResponseEntity<List<Student>> getallstud(@RequestBody Student stuReq) throws ErrorCust{
        try{
            return new ResponseEntity<List<Student>>(stuService.fetchAll(),HttpStatus.OK);
        }catch(ErrorCust ec){
            throw ec;
        }
    }

    @ApiOperation(value="Post Admin", response = Iterable.class, tags = "saveAdmin")
    @ApiResponses(value={ 
        @ApiResponse(code = 200, message = "Success|OK"),
        @ApiResponse(code = 401, message = "authorized!"), 
        @ApiResponse(code = 403, message = "forbidden!!!"),
        @ApiResponse(code = 404, message = "not found!!!") })
    @PostMapping(value = "/admin",produces = MediaType.APPLICATION_JSON_VALUE)    
    public ResponseEntity<List<Admin>> saveAdmin(@RequestBody Admin adminReq) throws ErrorCust{
        try{
            aService.save(adminReq);
            System.out.println("====" + adminReq.getId());
            return new ResponseEntity<List<Admin>>(aService.fetchAll(),HttpStatus.OK);
        }catch(ErrorCust ec){
            throw ec;
        }
    }

    @ApiOperation(value="Put Admin", response = Iterable.class, tags = "putAdmin")
    @ApiResponses(value={ 
        @ApiResponse(code = 200, message = "Success|OK"),
        @ApiResponse(code = 401, message = "authorized!"), 
        @ApiResponse(code = 403, message = "forbidden!!!"),
        @ApiResponse(code = 404, message = "not found!!!") })
    @PutMapping(value = "/admin",produces = MediaType.APPLICATION_JSON_VALUE)    
    public ResponseEntity<List<Admin>> putAdmin(@RequestBody Admin adminReq)throws ErrorCust{
        try{    
            aService.save(adminReq);
            System.out.println("====" + adminReq.getId());
            return new ResponseEntity<List<Admin>>(aService.fetchAll(),HttpStatus.OK);
        }catch(ErrorCust ec){
            throw ec;
        }
    }

    @ApiOperation(value="Post Prof", response = Iterable.class, tags = "saveProf")
    @ApiResponses(value={ 
        @ApiResponse(code = 200, message = "Success|OK"),
        @ApiResponse(code = 401, message = "authorized!"), 
        @ApiResponse(code = 403, message = "forbidden!!!"),
        @ApiResponse(code = 404, message = "not found!!!") })

    @PostMapping(value = "/prof",produces = MediaType.APPLICATION_JSON_VALUE)    
    public ResponseEntity<List<Prof>> saveProf(@RequestBody Prof profReq)throws ErrorCust{
        try{
            pService.save(profReq);
            System.out.println("====" + profReq.getId());
            return new ResponseEntity<List<Prof>>(pService.fetchAll(),HttpStatus.OK);
        }catch(ErrorCust ec){
            throw ec;
        }
    }

    @ApiOperation(value="Put Professor", response = Iterable.class, tags = "putProf")
    @ApiResponses(value={ 
        @ApiResponse(code = 200, message = "Success|OK"),
        @ApiResponse(code = 401, message = "authorized!"), 
        @ApiResponse(code = 403, message = "forbidden!!!"),
        @ApiResponse(code = 404, message = "not found!!!") })
    @PutMapping(value = "/prof",produces = MediaType.APPLICATION_JSON_VALUE)    
    public ResponseEntity<List<Prof>> putProf(@RequestBody Prof profReq) throws ErrorCust{
        try{
            pService.save(profReq);
            System.out.println("====" + profReq.getId());
            return new ResponseEntity<List<Prof>>(pService.fetchAll(),HttpStatus.OK);
        }catch(ErrorCust ec){
            throw ec;
        }
    }

    @ApiOperation(value="Post Student", response = Iterable.class, tags = "saveStudent")
    @ApiResponses(value={ 
        @ApiResponse(code = 200, message = "Success|OK"),
        @ApiResponse(code = 401, message = "authorized!"), 
        @ApiResponse(code = 403, message = "forbidden!!!"),
        @ApiResponse(code = 404, message = "not found!!!") })
    @PostMapping(value = "/student",produces = MediaType.APPLICATION_JSON_VALUE)    
    public ResponseEntity<List<Student>> saveStudent(@RequestBody Student stuReq) throws ErrorCust{
        try{
            stuService.save(stuReq);
            System.out.println("====" + stuReq.getId());
            return new ResponseEntity<List<Student>>(stuService.fetchAll(),HttpStatus.OK);
        }catch(ErrorCust ec){
            throw ec;
        }
    }

    @ApiOperation(value="Put Student", response = Iterable.class, tags = "putStudent")
    @ApiResponses(value={ 
        @ApiResponse(code = 200, message = "Success|OK"),
        @ApiResponse(code = 401, message = "authorized!"), 
        @ApiResponse(code = 403, message = "forbidden!!!"),
        @ApiResponse(code = 404, message = "not found!!!") })
    @PutMapping(value = "/student",produces = MediaType.APPLICATION_JSON_VALUE)    
    public ResponseEntity<List<Student>> putStudent(@RequestBody Student stuReq)throws ErrorCust{
        try{ 
            stuService.save(stuReq);
            System.out.println("====" + stuReq.getId());
            return new ResponseEntity<List<Student>>(stuService.fetchAll(),HttpStatus.OK);
        }catch(ErrorCust ec){
            throw ec;
        }
    }

    @ApiOperation(value="Delete Professor", response = Iterable.class, tags = "deleteProf ")
    @ApiResponses(value={ 
        @ApiResponse(code = 200, message = "Success|OK"),
        @ApiResponse(code = 401, message = "authorized!"), 
        @ApiResponse(code = 403, message = "forbidden!!!"),
        @ApiResponse(code = 404, message = "not found!!!") })
    @DeleteMapping(value = "/prof/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteProf (@PathVariable int id) throws ErrorCust{
        try{
            pService.delete(id);
        }catch(ErrorCust ec){
            throw ec;
        }
    }

    @ApiOperation(value="Delete Student", response = Iterable.class, tags = "deleteStudent")
    @ApiResponses(value={ 
        @ApiResponse(code = 200, message = "Success|OK"),
        @ApiResponse(code = 401, message = "authorized!"), 
        @ApiResponse(code = 403, message = "forbidden!!!"),
        @ApiResponse(code = 404, message = "not found!!!") })
    @DeleteMapping(value = "/student/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteStudent (@PathVariable int id) throws ErrorCust{
        try{
            stuService.delete(id);
        }catch(ErrorCust ec){
            throw ec;
        }
    }

}

