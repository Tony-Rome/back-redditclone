/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.springredditclone.srpingredditclone.repository;

import com.example.springredditclone.srpingredditclone.model.Post;
import com.example.springredditclone.srpingredditclone.model.Subreddit;
import com.example.springredditclone.srpingredditclone.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author tony
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Long>{
    List<Post> findAllBySubreddit(Subreddit subreddit);
    List<Post> findByUser(User user);
}
