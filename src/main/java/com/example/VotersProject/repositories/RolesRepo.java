/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.VotersProject.repositories;


import com.example.VotersProject.models.Pollrole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dimit
 */
@Repository
public interface RolesRepo extends CrudRepository<Pollrole,Integer>{
    
}