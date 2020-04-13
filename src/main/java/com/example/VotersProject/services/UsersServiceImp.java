/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.VotersProject.services;

import com.example.VotersProject.models.Pollrole;
import com.example.VotersProject.models.Polluser;
import com.example.VotersProject.repositories.RolesRepo;
import com.example.VotersProject.repositories.UsersRepo;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dimit
 */
@Service
@Transactional
public class UsersServiceImp implements UsersServiceInterface {

    @Autowired
    UsersRepo ur;
    @Autowired
    RolesRepo rr;

    @Override
    public Polluser getUserByUsername(String username) {
        return ur.findByULoginname(username);
    }

    @Override
    public void insertUser(Polluser user) {
        ur.save(user);
    }

    @Override
    public List<Polluser> findCandidatesNotThePresent(Integer userId) {
        return ur.findCandidatesNotThePresent(userId,rr.findById(2).get());
    }

    @Override
    public Polluser getUserById(Integer id) {
        Optional<Polluser> user = ur.findById(id);
        if(user.isPresent()){
            return user.get();
        }
        return null;
    }

}
