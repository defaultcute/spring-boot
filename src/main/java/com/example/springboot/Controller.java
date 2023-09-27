package com.example.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class Controller {

    List<Model> modelList = new ArrayList<>(); //just in memory

    @GetMapping("/hello")
    public ResponseEntity<List<Model>> getHello(){
        //Optional<model> optionaluse = new Optional<>;
       return new ResponseEntity<>(modelList,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addMember(@RequestBody Model model){
        modelList.add(model);
       // model.setName(name);
        return ResponseEntity.ok("ok");
    }
}
