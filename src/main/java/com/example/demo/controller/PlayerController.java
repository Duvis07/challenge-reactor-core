package com.example.demo.controller;

import com.example.demo.Player;
import com.example.demo.service.PlayerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/player")
public class PlayerController {

    private static final Logger log = LoggerFactory.getLogger(PlayerController.class);

    @Autowired
    private PlayerService service;

    @GetMapping("/listPersons")
    public Flux<Player> listar(){

        return service.list().buffer(100).flatMap(x -> Flux.fromStream(x.parallelStream()));
    }
}
