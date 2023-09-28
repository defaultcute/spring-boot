package com.example.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class Controller {

    List<Model> modelList = new ArrayList<>(); //just in memory

    @GetMapping("/hello")
    public ResponseEntity<List<Model>> getHello(){
        //Optional<model> optionaluse = new Optional<>;

        List<Integer> intList = new ArrayList<>();
        intList.add(2);
        intList.add(4);
        List <Integer> c = intList.stream().filter(x -> x%2 ==0).collect(Collectors.toList());
        Stream.Builder<String> builder
                = Stream.builder();
        intList.stream().forEach(p -> System.out.print(p));
        System.out.print(c);
        Stream<String> stream = builder.add("a")
                .add("b")
                .add("c")
                .build();
        Iterator<String> it =  stream.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
       return new ResponseEntity<>(modelList,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addMember(@RequestBody Model model){
        modelList.add(model);
        //List<String> list  = model.getName(
       // model.setName(name);
        return ResponseEntity.ok("ok");
    }

    @DeleteMapping("/delete/{name}") //from uri  //localhost:8080/delete/alpha
    public void deleteModel(@PathVariable String name){

        Optional<Model> modelOptional = modelList.stream().filter(m ->m.getName().equals(name)).findFirst();
        modelOptional.ifPresent(model -> modelList.remove(model));

        System.out.println("removed:"+ name);
    }

    @PutMapping("/put")
    public ResponseEntity<String> putInfo(@RequestParam String name, String rollNo){ //localhost:8080/put?name=alpha&rollNo=1
        Model model = new Model();
        model.setName(name);
        model.setRollNo(rollNo);
        modelList.add(model);
        return ResponseEntity.ok("added roll no");
    }
}
