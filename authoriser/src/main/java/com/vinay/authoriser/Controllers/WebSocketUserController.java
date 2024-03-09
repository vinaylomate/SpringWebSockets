package com.vinay.authoriser.Controllers;

import com.vinay.authoriser.Entities.WebSocketUserDetails;
import com.vinay.authoriser.RequestPayloads.JwtRequest;
import com.vinay.authoriser.ResponsePayloads.JwtResponse;
import com.vinay.authoriser.ResponsePayloads.WebSocketSessionResponse;
import com.vinay.authoriser.Services.WebSocketUserService;
import com.vinay.clients.database.RequestPayloads.UserRegistrationRequest;
import com.vinay.clients.database.ResponsePayloads.UserRegisterResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
public class WebSocketUserController {
    @Autowired
    private WebSocketUserService webSocketUserService;

    @PostMapping("/api/register/user")
    public UserRegisterResponse registerUser(@Valid @RequestBody UserRegistrationRequest user) {
        return webSocketUserService.registerUser(user);
    }

    @PostMapping("/api/jwt")
    public JwtResponse getJwt(@Valid @RequestBody JwtRequest jwtRequest) {
        return webSocketUserService.getJwtToken(jwtRequest.getUsername(), jwtRequest.getPassword());
    }

    @GetMapping("/api/websocket/session")
    public WebSocketSessionResponse getWebsocketSession(@AuthenticationPrincipal WebSocketUserDetails webSocketUserDetails) {
        return webSocketUserService.getWebSocketSession(webSocketUserDetails.getUsername());
    }
}
