package com.pj.pd.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "shop")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "s_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "c_id", nullable = false)
    private Canteen canteen;

    @Column(name = "owner_id", nullable = false)
    private Integer ownerId;

    @Column(name = "s_name", nullable = false)
    private String name;

    @Column(name = "s_description")
    private String description;


    public Shop() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Canteen getCanteen() {
        return canteen;
    }

    public void setCanteen(Canteen canteen) {
        this.canteen = canteen;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
