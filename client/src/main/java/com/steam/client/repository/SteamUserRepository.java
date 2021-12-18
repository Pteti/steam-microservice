package com.steam.client.repository;

import com.steam.client.model.SteamUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SteamUserRepository extends JpaRepository<SteamUser, Long> {
    List<SteamUser> findByUserName(String userName);
}
