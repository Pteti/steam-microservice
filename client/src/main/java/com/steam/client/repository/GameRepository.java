package com.steam.client.repository;

import com.steam.client.model.Game;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends CrudRepository<Game,Long> {

    List<Game> findAll();
}
