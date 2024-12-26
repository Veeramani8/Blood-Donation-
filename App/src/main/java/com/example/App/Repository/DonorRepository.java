package com.example.App.Repository;

import com.example.App.Model.Donor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DonorRepository extends JpaRepository<Donor, Long> {
    List<Donor> findByBloodTypeAndLocation(String bloodType, String location);
}
