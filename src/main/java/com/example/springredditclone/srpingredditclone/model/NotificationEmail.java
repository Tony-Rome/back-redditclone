/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.springredditclone.srpingredditclone.model;

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
public class NotificationEmail {
    
    private String subject;
    private String recipient;
    private String body;
    
}
