package com.pj.pd.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pj.pd.Entity.Canteen;
import com.pj.pd.Entity.Shop;
import com.pj.pd.Repository.ShopRepository;

@Service
public class ShopService {
    
    @Autowired
    private ShopRepository S_repo;

    public List<Shop> getAllShopInCanteen(Canteen canteen){
        List<Shop> shops = S_repo.findAllByCanteen(canteen);
        return shops;
    }

    public void deleteById(Integer id) {

        S_repo.deleteById(id);
    }



    
}
