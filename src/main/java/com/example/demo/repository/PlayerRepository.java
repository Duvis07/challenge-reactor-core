package com.example.demo.repository;

import com.example.demo.Player;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface PlayerRepository extends ReactiveMongoRepository<Player, Integer>{

    Flux<Player> listar();
}
