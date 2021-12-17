package com.steam.client.repository;

import com.steam.client.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GameRepository extends JpaRepository<Game,Long> {
}
