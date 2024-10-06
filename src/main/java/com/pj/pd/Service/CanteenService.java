package com.pj.pd.Service;

import java.util.List;
import java.util.Optional;

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

    public void saveCanteen(Canteen canteen) {
        C_repo.save(canteen);
    }

    public void deleteCanteenById(Integer id) {
        System.out.println("============== before find by id =================");

        Optional<Canteen> c = C_repo.findById(id);
        if(c != null){
            C_repo.deleteById(id);
        }
        System.out.println("============== After find by id =================");
    }
}
