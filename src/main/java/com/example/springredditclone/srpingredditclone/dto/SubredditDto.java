package com.example.springredditclone.srpingredditclone.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class SubredditDto {
    //Los nombres atributos deben ser iguales a los modelos para crear subreddit
    private Long id;
    private String name;
    private String description;
    private Integer numberOfPosts;
}
