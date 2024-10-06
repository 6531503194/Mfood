package com.pj.pd.Entity;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "canteen")
public class Canteen {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "c_id")
    private Integer id;

    @Column(name = "c_name", nullable = false)
    private String name;

    @Column(name = "c_location", nullable = false)
    private String location;

    @OneToMany(mappedBy = "canteen", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Shop> shops;


    public Canteen() {}

    public Integer getId() {
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

    public Set<Shop> getShops() {
        return shops;
    }

    public void setShops(Set<Shop> shops) {
        this.shops = shops;
    }
}
