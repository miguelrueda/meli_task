package com.example.melitask.controller;

import com.example.melitask.dto.SecretRequest;
import com.example.melitask.dto.SecretResponse;
import com.example.melitask.dto.SplitSecretRequest;
import com.example.melitask.service.MeliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class MeliController {

    @Autowired
    private MeliService meliService;

    @GetMapping("/")
    public ResponseEntity getServiceName(){
        ResponseEntity responseEntity = new ResponseEntity(HttpStatus.OK);
        return responseEntity;
    }

    @PostMapping("/topsecret")
    public SecretResponse getSecretResponse(@RequestBody SecretRequest request) {
        return meliService.processRequest(request);
    }

    @RequestMapping(value = "/topsecret_split/{satellite_name}", method = RequestMethod.GET)
    public SecretResponse getSecretResponse(@RequestBody SplitSecretRequest request,
                                            @PathVariable("satellite_name") String satelliteName) {
        return meliService.processSplitRequest(request, satelliteName);
    }

    @RequestMapping(value = "/topsecret_split/{satellite_name}", method = RequestMethod.POST)
    public SecretResponse postSecretResponse(@RequestBody SplitSecretRequest request,
                                            @PathVariable("satellite_name") String satelliteName) {
        return meliService.processSplitRequest(request, satelliteName);
    }
}
