/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class RegisterRequest {
    
    private String email;
    private String username;
    private String password;
    
}
