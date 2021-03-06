package com.udemy.backendninja.repository;

import com.udemy.backendninja.entity.User;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Serializable>{
    
    public abstract User findByUsername(String username);
    
}
