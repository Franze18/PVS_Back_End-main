package com.pvsbackend.pvs.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pvsbackend.pvs.Model.NameRequest;

public interface NameRequestRepository extends JpaRepository<NameRequest, Long>{
    
}
