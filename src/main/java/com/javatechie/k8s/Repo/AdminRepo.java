package com.javatechie.k8s.Repo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.javatechie.k8s.Model.Admin;



public interface AdminRepo extends JpaRepository<Admin,Long>{
    
}
