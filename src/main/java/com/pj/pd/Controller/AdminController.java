package com.pj.pd.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pj.pd.Entity.Canteen;
import com.pj.pd.Entity.Shop;
import com.pj.pd.Repository.ShopRepository;
import com.pj.pd.Service.CanteenService;
import com.pj.pd.Service.ShopService;

@Controller
public class AdminController {

    @Autowired 
    CanteenService canteenService;

    @Autowired
    ShopService shopService;

    @Autowired
    ShopRepository S_repo;
    
    @GetMapping("/admin")
    public String Building(Model model) {
        List<Canteen> canteens = canteenService.getAllCanteens();
        List<Shop> shops = S_repo.findAll();
        model.addAttribute("canteens", canteens);
        model.addAttribute("shops", shops);
        return "admin-home";
    }

    @GetMapping("/create-canteen")
    public String getCanteens(Model model) {
        model.addAttribute("canteen", new Canteen());
        return "canteen-list";
    }
}
