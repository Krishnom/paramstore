package com.krishnom.paramstore.controller;

import com.krishnom.paramstore.entities.Parameter;
import com.krishnom.paramstore.services.ParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {
    @Autowired
    private ParameterService parameterService;

    @GetMapping("/")
    public String root() {
        return "This is default response from  param store rest server";
    }

    @GetMapping("/params")
    public List<Parameter> getAllParameters() {
        return parameterService.getParameters();
    }

    @GetMapping("/params/{name}")
    public Parameter getParameter(@PathVariable String name) {
        return parameterService.getParameter(name);
    }

    @PostMapping(path = "/params", consumes = "application/json")
    public Parameter addParameter(@RequestBody Parameter parameter) throws Exception {
        return this.parameterService.addParameter(parameter);
    }

    @PutMapping(path = "/params", consumes = "application/json")
    public Parameter updateParameter(@RequestBody Parameter parameter) throws Exception {
        return this.parameterService.updateParameter(parameter);
    }
}
