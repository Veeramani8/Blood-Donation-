package com.example.App.Controller;

import com.example.App.Model.Donor;
import com.example.App.Service.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/donor")
public class DonorController {

    @Autowired
    private DonorService donorService;

    @GetMapping("/form")
    public String showDonorForm(Model model) {
        model.addAttribute("donor", new Donor());
        return "donor_form";
    }

    @PostMapping("/save")
    public String saveDonor(@ModelAttribute Donor donor,Model model) {
        donorService.createDonor(donor);
        model.addAttribute("message", "Donor saved successfully!");
        return "success";
    }

    @GetMapping("/list")
    public String listDonors(Model model) {
        List<Donor> donors = donorService.getAllDonors();
        model.addAttribute("donors", donors);
        return "donor_list";
    }

    @GetMapping("/edit/{id}")
    public String editDonor(@PathVariable Long id, Model model) {
        Donor donor = donorService.getDonorById(id);
        model.addAttribute("donor", donor);
        return "donor_form";
    }
    @PostMapping("/update/{id}")
    public String updateDonor(@PathVariable Long id, @ModelAttribute Donor donor) {
        donorService.updateDonor(donor);
        donor.setId(id);
        return "redirect:/admin/adminlist";  // Redirect back to the admin list after update
    }

    @GetMapping("/delete/{id}")
    public String deleteDonor(@PathVariable Long id) {
        donorService.deleteDonor(id);
        return "redirect:/admin/adminlist";    }
}
