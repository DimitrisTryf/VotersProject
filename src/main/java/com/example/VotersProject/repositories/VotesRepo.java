/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.VotersProject.repositories;


import com.example.VotersProject.models.Polluser;
import com.example.VotersProject.models.Pollvote;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dimit
 */
@Repository
public interface VotesRepo extends CrudRepository<Pollvote,Integer>{
    List<Pollvote> findBycandidateId(Polluser candidateId);
    
    Pollvote findByVoterId(Polluser voterId);
}