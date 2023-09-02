package com.marRover.rover.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class MapController {

    @RequestMapping(value = "mapGenerator")
    public String mapGenerator(){
        return "hola mundo";
    }

}
