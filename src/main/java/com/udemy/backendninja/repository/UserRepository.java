package com.udemy.backendninja.repository;

import com.udemy.backendninja.entity.User;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Serializable>{
    
    public abstract User findByUserName(String username);
    
}
