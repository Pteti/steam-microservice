package com.steam.client.service;

import com.steam.client.model.SteamUser;
import com.steam.client.repository.SteamUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SteamUserService {

    @Autowired
    SteamUserRepository userRepository;

    public List<SteamUser> getAllUsers() {
        return userRepository.findAll();
    }

    public void logIn(String userName) {
        SteamUser temp = userRepository.findByUserName(userName).get(0);
        temp.isLoggedIn = true;
        userRepository.save(temp);
    }

    public boolean isLoggedIn(String userName) {
        return userRepository.findByUserName(userName).get(0).isLoggedIn;
    }

    public boolean isUserExists(String userName) {
        return userRepository.findByUserName(userName).size() > 0;
    }
}
