package com.williamspires.bumblewebapp.repositories;

import com.williamspires.bumblewebapp.models.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmerRepository extends JpaRepository<Farmer, String> {
}
