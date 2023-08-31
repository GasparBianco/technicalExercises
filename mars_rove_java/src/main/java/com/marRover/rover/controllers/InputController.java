package com.marRover.rover.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InputController {

    @RequestMapping(value = "prueba")
    public String prueba(){
        return "hola mundo";
    }

}
