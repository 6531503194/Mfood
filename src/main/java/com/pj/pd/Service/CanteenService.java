package com.pj.pd.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pj.pd.Entity.Canteen;
import com.pj.pd.Repository.CanteenRepository;

@Service
public class CanteenService {
    
    @Autowired
    private CanteenRepository C_repo;

    public List<Canteen> getAllCanteens(){
        return C_repo.findAll();
    }
}
