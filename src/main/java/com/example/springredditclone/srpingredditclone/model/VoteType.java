/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.springredditclone.srpingredditclone.model;


import com.example.springredditclone.srpingredditclone.exceptions.SpringRedditException;

import java.util.Arrays;

public enum VoteType {
   UPVOTE(1), DOWNVOTE(-1),
   ;

   private int direction;

    VoteType(int direction){
    }
    
    public static VoteType lookup(Integer direction){
        return Arrays.stream(VoteType.values())
                .filter(value -> value.getDirection().equals(direction))
                .findAny()
                .orElseThrow(() -> new SpringRedditException("Voto no encontrado"));
    }

    public Integer getDirection(){
        return direction;
    }
}
