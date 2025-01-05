package com.smartCity.smartCity.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartCity.smartCity.Entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
}
