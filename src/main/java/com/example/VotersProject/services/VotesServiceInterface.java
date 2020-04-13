/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.VotersProject.services;

import com.example.VotersProject.models.Polluser;
import com.example.VotersProject.models.Pollvote;
import java.util.List;

/**
 *
 * @author dimit
 */
public interface VotesServiceInterface {
    
    public void insertVote(Pollvote vote);
    
    public List<Pollvote> findMyVotes(Polluser user);
    
    public Pollvote findByVoterId(Polluser user);
}
