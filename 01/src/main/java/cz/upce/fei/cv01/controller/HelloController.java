package cz.upce.fei.cv01.controller;

import cz.upce.fei.cv01.entity.Student;
import org.springframework.web.bind.annotation.*;

// RestController vs Controller
/*
* RestController se používá pro REST rozhraní, které vrací Json, Xml
* Controller většinou vrací nějaké view*/
// YAML vs JSON vs XML
/*
* YAML - je dobře čitelný pro člověka, nepoužívá žádné párové tagy, závorky, pouze mezery, dvojtečky a pomlčky
* JSON - Klíč a hodnota, používají se závorky
* XML - obsahuje tagy, zdlouhavé*/
@RestController
//@RequestMapping("api/v1")
public class HelloController {

    @GetMapping("")
    public String helloWorld() {
        return "Hello world from Spring Boot application.";
    }

    @GetMapping("/{name}")
    public String helloName(@PathVariable String name){
        return "Hello " + name;
    }

    @GetMapping("/")
    public String getAge(@RequestParam(defaultValue = "null") Integer age){
        return  "Your age is " + age;
    }

    @PostMapping("/")
    public String getInfoAboutStudent(@RequestBody Student student){
        return "Ahoj: " + student.toString();
    }
}
