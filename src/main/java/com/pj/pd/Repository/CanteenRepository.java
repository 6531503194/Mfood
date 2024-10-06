package com.pj.pd.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pj.pd.Entity.Canteen;

@Repository
public interface CanteenRepository extends JpaRepository<Canteen , Integer> {
    
}
