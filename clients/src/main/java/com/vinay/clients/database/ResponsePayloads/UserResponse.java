package com.vinay.clients.database.ResponsePayloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
public class UserResponse {
    private String message;
    private int status;
    private User user;
}
