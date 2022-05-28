package com.example.demo.service;

import com.example.demo.Player;
import com.example.demo.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository repository;

    public Flux<Player> list(){

        return (repository.findAll());
    }

}
