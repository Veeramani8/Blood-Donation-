package com.example.App.Controller;

import com.example.App.Model.Admin;
import com.example.App.Service.AdminService;
import com.example.App.Service.DonorService;
import com.example.App.Service.ReceiverService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private DonorService donorService;
    @Autowired
    private ReceiverService receiverService;

    @GetMapping("/login")
    public String showLoginPage(Model model) {
        model.addAttribute("admin", new Admin());
        return "admin_login";
    }

    @PostMapping("/login")
    public String loginAdmin(@ModelAttribute Admin admin, Model model) {
        Admin authAdmin = adminService.authenticateAdmin(admin.getUsername(), admin.getPassword());
        if (authAdmin != null) {
            return "redirect:/admin/adminlist";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "admin_login";
        }
    }

    @GetMapping("/adminlist")
    public String showAdminDashboard(Model model) {
        model.addAttribute("donors", donorService.getAllDonors());
        model.addAttribute("receivers", receiverService.getAllReceivers());
        return "admin_board";
}
}
