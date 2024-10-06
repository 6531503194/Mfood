package com.pj.pd.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pj.pd.Entity.User;

public interface UserRepository extends JpaRepository<User , Long>{
    User findByEmail(String email);

    User findByUsername(String username);
}
