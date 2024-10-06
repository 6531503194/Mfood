package com.pj.pd.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pj.pd.Entity.Canteen;
import com.pj.pd.Entity.Shop;

@Repository
public interface ShopRepository extends JpaRepository<Shop , Integer>{

    List<Shop> findAllByCanteen(Canteen canteen);
    
}
