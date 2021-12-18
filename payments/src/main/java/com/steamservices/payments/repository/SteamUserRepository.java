package com.steamservices.payments.repository;

import com.steamservices.payments.model.SteamUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SteamUserRepository extends JpaRepository<SteamUser, Long> {
}
