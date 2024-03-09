package com.vinay.authoriser.Services;

import com.vinay.authoriser.Entities.WebSocketUserDetails;
import com.vinay.clients.database.DatabaseClient;
import com.vinay.clients.database.ResponsePayloads.UserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class WebSocketUserDetailsService implements UserDetailsService {

    @Autowired
    private DatabaseClient databaseClient;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserResponse userResponse = null;
        try {
            userResponse = databaseClient.getUser(username);
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        if (userResponse == null || userResponse.getUser() == null) {
            throw new UsernameNotFoundException("Username not Found");
        }
        return new WebSocketUserDetails(userResponse.getUser());
    }
}
