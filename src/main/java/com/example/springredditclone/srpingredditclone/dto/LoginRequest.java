package com.example.springredditclone.srpingredditclone.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author tony
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    
    private String username;
    private String password;
}
