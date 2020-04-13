/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.VotersProject.services;

import com.example.VotersProject.models.Pollrole;
import com.example.VotersProject.repositories.RolesRepo;
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
public class RolesServiceImp implements RolesServiceInterface {

    @Autowired
    RolesRepo rr;

    @Override
    public List<Pollrole> getAllRoles() {
        return (List<Pollrole>) rr.findAll();
    }

    @Override
    public Pollrole getById(Integer id) {
        Optional<Pollrole> role = rr.findById(id);

        if (role.isPresent()) {
            return role.get();
        } else {
            return null;
        }
    }

}
