package com.udemy.backendninja.repository;

import com.udemy.backendninja.entity.Log;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("logRepository")
public interface LogRepository extends JpaRepository<Log, Serializable>{
    
}
