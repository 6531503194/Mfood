package com.pj.pd.Entity;

import jakarta.persistence.*;
import java.util.List;


@Entity
@Table(name = "canteen")
public class Canteen {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "c_id")
    private int id;

    @Column(name = "c_name", nullable = false)
    private String name;

    @Column(name = "c_location", nullable = false)
    private String location;

    // @OneToMany(mappedBy = "canteen", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    // private List<Shop> shops;
    
    @OneToMany(mappedBy = "canteen", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Shop> shops;



    public Canteen() {}

    public long getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Shop> getShops() {
        return shops;
    }

    public void setShops(List<Shop> shops) {
        this.shops = shops;
    }
}
