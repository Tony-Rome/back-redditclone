package com.example.springredditclone.srpingredditclone.service;
import lombok.AllArgsConstructor;
import static org.apache.tomcat.jni.Lock.name;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tony
 */
@Service
@AllArgsConstructor
public class MailContentBuilder {
    
    private final TemplateEngine templateEngine;
    
    public String build(String message){
        Context context = new Context();
        context.setVariable("message", message);
        return templateEngine.process("mailTemplate",context);
    }
}
