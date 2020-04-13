/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.VotersProject.repositories;

import com.example.VotersProject.models.Pollrole;
import com.example.VotersProject.models.Polluser;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dimit
 */
@Repository
public interface UsersRepo extends CrudRepository<Polluser,Integer>{
    
    Polluser findByULoginname(String uLoginname);
    
    @Query("SELECT u FROM Polluser u where u.uId<>?1 and u.uRoleId=?2")
    List<Polluser> findCandidatesNotThePresent(int userId, Pollrole role);
}
