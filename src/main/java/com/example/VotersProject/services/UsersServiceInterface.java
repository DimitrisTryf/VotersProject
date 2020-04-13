/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.VotersProject.services;

import com.example.VotersProject.models.Pollrole;
import com.example.VotersProject.models.Polluser;
import java.util.List;

/**
 *
 * @author dimit
 */
public interface UsersServiceInterface {

    public Polluser getUserByUsername(String username);

    public void insertUser(Polluser user);

    public List<Polluser> findCandidatesNotThePresent(Integer userId);
    
    public Polluser getUserById(Integer id);
}
