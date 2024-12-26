package com.example.App.Service;

import com.example.App.Model.Admin;
import com.example.App.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public Admin authenticateAdmin(String username, String password) {
        return adminRepository.findByUsernameAndPassword(username, password);
    }
}
