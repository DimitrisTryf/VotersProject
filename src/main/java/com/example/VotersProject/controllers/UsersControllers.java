/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.VotersProject.controllers;

import com.example.VotersProject.dtos.LoginUserDto;
import com.example.VotersProject.dtos.NewUserDto;
import com.example.VotersProject.models.Pollrole;
import com.example.VotersProject.models.Polluser;
import com.example.VotersProject.models.Pollvote;
import com.example.VotersProject.services.RolesServiceInterface;
import com.example.VotersProject.services.UsersServiceInterface;
import com.example.VotersProject.services.VotesServiceInterface;
import com.example.VotersProject.validators.LoginUserValidator;
import com.example.VotersProject.validators.NewUserDtoValidator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author dimit
 */
@Controller
public class UsersControllers {

    @Autowired
    RolesServiceInterface rsi;
    @Autowired
    UsersServiceInterface usi;
    @Autowired
    VotesServiceInterface vsi;
    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping(value = "/")
    public String def() {
        return "index";
    }

    @Autowired
    NewUserDtoValidator val;

    @InitBinder("newUser")
    public void setupBinder(WebDataBinder binder) {
        binder.addValidators(val);
    }

     @Autowired
    LoginUserValidator logval;

    @InitBinder("LoginUserDto")// Εδω θα βαλεις το object που θες να κανεις validate
    public void setupBinder1(WebDataBinder binder) {
        binder.addValidators(logval);
    }

    @GetMapping(value = "/registerForm")
    public String registerForm(ModelMap mm) {
        NewUserDto newUser = new NewUserDto();
        mm.addAttribute("roles", rsi.getAllRoles());
        mm.addAttribute("newUser", newUser);
        return "addUser";
    }

    @PostMapping(value = "/addUser")
    public String addUser(@Valid @ModelAttribute(name = "newUser") NewUserDto newUser,
            BindingResult br,
            ModelMap mm) {
        if (br.hasErrors()) {
            mm.addAttribute("roles", rsi.getAllRoles());
            return "addUser";
        }

        Polluser temp = new Polluser();
        Pollrole role = rsi.getById(newUser.getRole());
        if (role != null) {
            temp.setURoleId(role);
        } else {
            return "error";
        }
        temp.setUName(newUser.getName());
        temp.setUSurname(newUser.getSurname());
        temp.setULoginname(newUser.getUsername());
        temp.setUPassword(passwordEncoder.encode(newUser.getPassword1()));
        temp.setUCountry(newUser.getCountry());
        usi.insertUser(temp);

        return "index";
    }

    @GetMapping(value = "/loginForm")
    public String loginForm(ModelMap mm) {
        mm.addAttribute("LoginUserDto", new LoginUserDto());
        return "login";
    }

    @PostMapping(value = "/login")
    public String login(@Valid @ModelAttribute(name = "LoginUserDto") LoginUserDto user,
            BindingResult br,
            HttpSession session,
            ModelMap mm) {
        if (br.hasErrors()) {
            return "login";
        }
        Polluser current = usi.getUserByUsername(user.getLousername());
        mm.addAttribute("candidatesList", usi.findCandidatesNotThePresent(current.getUId()));
        session.setAttribute("user", current);
        
        mm.addAttribute("voted", vsi.findByVoterId(current) != null);
        
        return "voteForm";

    }

    @PostMapping(value = "/vote")
    public String insertVote(@RequestParam(name = "candidate") Integer id,
            @RequestParam(name = "rating") Integer star,
            HttpSession session) {
        Polluser voter = (Polluser) session.getAttribute("user");
        Polluser candidate = usi.getUserById(id);
        Pollvote vote = new Pollvote();
        Date date = new Date();
        vote.setDatetime(date);
        vote.setRating(star);
        vote.setCandidateId(candidate);
        vote.setVoterId(voter);

        vsi.insertVote(vote);

        return "index";
    }

    @GetMapping(value = "/showVotes")
    public String showMyVotes(ModelMap mm, HttpSession session) {
        Polluser user = (Polluser) session.getAttribute("user");
        List<Pollvote> lp = vsi.findMyVotes(user);
        if (lp.isEmpty()) {
            return "index";
        }
        mm.addAttribute("myVotes", lp);
        System.out.println("");
        return "myVotes";
    }

    @ResponseBody
    @PostMapping(value = "/checkUsername/{username}")
    public boolean checkUsername(@PathVariable(name = "username") String username) {
        Polluser user = usi.getUserByUsername(username);

        return (user != null);
    }

//    @ResponseBody
//    @GetMapping(value = "/checkIfVoted")
//    public boolean checkIfVoted(HttpSession session) {
//        
//    }
    
}
