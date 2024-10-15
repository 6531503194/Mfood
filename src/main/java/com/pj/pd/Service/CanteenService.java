package com.pj.pd.Service;

import java.util.List;
import java.util.Optional;
import java.util.NoSuchElementException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pj.pd.Entity.Canteen;
import com.pj.pd.Entity.Shop;
import com.pj.pd.Repository.CanteenRepository;
import com.pj.pd.Repository.ShopRepository;

@Service
public class CanteenService {
    
    @Autowired
    private CanteenRepository C_repo;

    @Autowired
    private ShopService S_service;

    @Autowired
    private ShopRepository S_repo;

    public List<Canteen> getAllCanteens(){
        return C_repo.findAll();
    }
    

    public void saveCanteen(Canteen canteen) {
        C_repo.save(canteen);
    }

    public void deleteCanteenById(int id) {
        System.out.println("============== before find by id =================");
        
        try {
            Canteen c = C_repo.findById(id).orElse(null);
            System.out.println("============= Canteen name " + c.getName() + "=========");
            
            // List<Shop> shops = S_service.getAllShopInCanteen(c);
            // System.out.println("============= Shop name " + shops.get(0).getName() + "=========");
            
            // // Delete shops and the canteen
            // S_service.deleteShopsInCanteen(c);
            C_repo.deleteById(id);
            
            System.out.println("============== After delete canteen =================");
    
        } catch (NoSuchElementException e) {
            System.out.println("Canteen with id " + id + " not found. Cannot delete.");
        }catch(NullPointerException e){
            System.out.println("canteen is not found in the database.");
        }
    }

    
}
