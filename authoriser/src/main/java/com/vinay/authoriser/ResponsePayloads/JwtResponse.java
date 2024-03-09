package com.vinay.authoriser.ResponsePayloads;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class JwtResponse {
    private String message;
    private int status;
    private String jwtToken;
}
