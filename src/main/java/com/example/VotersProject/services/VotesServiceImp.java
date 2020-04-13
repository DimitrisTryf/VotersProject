/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.VotersProject.services;

import com.example.VotersProject.models.Polluser;
import com.example.VotersProject.models.Pollvote;
import com.example.VotersProject.repositories.VotesRepo;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dimit
 */
@Service
@Transactional
public class VotesServiceImp implements VotesServiceInterface {

    @Autowired
    VotesRepo vr;

    @Override
    public void insertVote(Pollvote vote) {
        vr.save(vote);
    }

    @Override
    public List<Pollvote> findMyVotes(Polluser user) {
        return vr.findBycandidateId(user);
    }

    @Override
    public Pollvote findByVoterId(Polluser user) {
        return vr.findByVoterId(user);
    }

}
