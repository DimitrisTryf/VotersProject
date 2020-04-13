/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.VotersProject.services;

import com.example.VotersProject.models.Pollrole;
import java.util.List;

/**
 *
 * @author dimit
 */
public interface RolesServiceInterface {
    
    public List<Pollrole> getAllRoles();
    
    public Pollrole getById(Integer id);
}
