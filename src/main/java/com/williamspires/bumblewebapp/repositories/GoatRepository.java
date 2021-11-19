package com.williamspires.bumblewebapp.repositories;

import com.williamspires.bumblewebapp.models.Goats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoatRepository extends JpaRepository<Goats, Integer> {

    List<Goats> findGoatsByOwnerId(String ownerId);
}
