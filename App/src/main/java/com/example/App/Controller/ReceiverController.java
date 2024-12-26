package com.example.App.Controller;

import com.example.App.Model.Donor;
import com.example.App.Model.Receiver;
import com.example.App.Service.DonorService;
import com.example.App.Service.ReceiverService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/receiver")
public class ReceiverController {

    @Autowired
    private ReceiverService receiverService;
    @Autowired
    private DonorService donorService;
    
    

    @GetMapping("/register")
    public String showReceiverForm(Model model) {
        model.addAttribute("receiver", new Receiver());
        return "receiver_register";
    }
    @GetMapping("/form")
    public String showSearchForm(Model model) {
        model.addAttribute("receiver", new Receiver());
        return "receiver_search";
    }
    @PostMapping("/search")
    public String searchDonors(@RequestParam String bloodType, @RequestParam String location, Model model) {
        List<Donor> donors = donorService.searchDonors(bloodType, location);
        model.addAttribute("donors", donors);
        return "donor_list";
    }

    @PostMapping("/save")
    public String saveReceiver(@ModelAttribute Receiver receiver, Model model) {
    receiverService.createReceiver(receiver);
    model.addAttribute("message", "Receiver details submitted successfully.");
    return "success";
}

    @GetMapping("/list")
    public String listReceivers(Model model) {
        List<Receiver> receivers = receiverService.getAllReceivers();
        model.addAttribute("receivers", receivers);
        return "receiver_list";
    }

    @GetMapping("/edit/{id}")
    public String editReceiver(@PathVariable Long id, Model model) {
        Receiver receiver = receiverService.getReceiverById(id);
        model.addAttribute("receiver", receiver);
        return "receiver_register";
    }
    @PostMapping("/update/{id}")
    public String updateReceiver(@PathVariable Long id, @ModelAttribute Receiver receiver) {
        receiver.setId(id);
        receiverService.updateReceiver(receiver);
        return "redirect:/admin/adminlist"; 
    }

    @GetMapping("/delete/{id}")
    public String deleteReceiver(@PathVariable Long id) {
        receiverService.deleteReceiver(id);
        return "redirect:/admin/adminlist";
    }
}
