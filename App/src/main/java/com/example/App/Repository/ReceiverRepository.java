package com.example.App.Repository;

import com.example.App.Model.Donor;
import com.example.App.Model.Receiver;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceiverRepository extends JpaRepository<Receiver, Long> {
	 List<Donor> findByBloodTypeAndLocation(String bloodType, String location );
}