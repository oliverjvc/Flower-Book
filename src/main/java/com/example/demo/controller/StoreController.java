package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.security.CustomUserDetailService;
import com.example.demo.service.StoreService;

import model.Store;
import model.User;

@Controller
@RequestMapping("/admin/")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @PostMapping("/processStoreForm")
    public String processStoreForm(
            @RequestParam("storeName") String storeName,
            @RequestParam("storeLocation") String storeLocation,
            @RequestParam("websiteLink") String websiteLink,
            @RequestParam("additionalLink") String additionalLink) {

        // Create a Store object with the form data
        Store store = new Store();
        store.setName(storeName);
        store.setLocation(storeLocation);
        store.setLink(websiteLink);
        store.setPic(additionalLink);

        // Save the store information using the StoreService
        storeService.saveStore(store);

        // Redirect to a confirmation page or any other page as needed
        return "admin/storeConfirmation";
    }
    
	

}
