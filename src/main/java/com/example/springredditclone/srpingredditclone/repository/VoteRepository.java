/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.springredditclone.srpingredditclone.repository;

import com.example.springredditclone.srpingredditclone.model.Post;
import com.example.springredditclone.srpingredditclone.model.User;
import com.example.springredditclone.srpingredditclone.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 *
 * @author tony
 */
@Repository
public interface VoteRepository extends JpaRepository<Vote, Long>{

    Optional<Vote> findTopByPostAndUserOrderByVoteIdDesc(Post post, User currentUser);
}
