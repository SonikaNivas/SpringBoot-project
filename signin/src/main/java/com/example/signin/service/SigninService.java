package com.example.signin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.signin.model.Signin;
import com.example.signin.repository.SigninRepo;

@Service
public class SigninService {
    @Autowired
    private final SigninRepo signinrepo;

    public SigninService(SigninRepo signinrepo) {
        this.signinrepo = signinrepo;
    }

    public  Signin createSignin (Signin signin){
        return signinrepo.save(signin);

    }
    public List<Signin> getAllSignin(){
        return signinrepo.findAll();
    
    }
    public Signin getSigninId(int signinId){
        return signinrepo.findById(signinId).orElse(null);

    }
    public List<Signin> sortTheRecords(String clientName)
    {
        return signinrepo.findAll(Sort.by(Sort.Direction.DESC,clientName));
    }
    public Signin update(int id, Signin signin) {
        Signin pros = signinrepo.findById(id).orElse(null);
        if (pros != null) {
            pros.setNo(signin.getNo());
            pros.setEmailaddress(signin.getEmailaddress());
            pros.setPassword(signin.getPassword());
            return signinrepo.save(pros);
        }
        return signin;
    }
    public void delete(int signinId) {
        signinrepo.deleteById(signinId);

    }
    public List<Signin> getPaginationSignin(int offset, int size) {
        return signinrepo.findAll(PageRequest.of(offset, size)).getContent();
    }

    public List<Signin> getSortedPaginationSignin(int offset, int size, String field) {
        return signinrepo.findAll(PageRequest.of(offset, size, Sort.by(field))).getContent();
    }
}
