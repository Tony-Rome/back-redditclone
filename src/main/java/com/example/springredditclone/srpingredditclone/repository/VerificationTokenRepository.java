/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.springredditclone.srpingredditclone.repository;

import com.example.springredditclone.srpingredditclone.model.VerificationToken;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author tony
 */
@Repository
public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long>{
    
    Optional<VerificationToken> findByToken(String token);
}
