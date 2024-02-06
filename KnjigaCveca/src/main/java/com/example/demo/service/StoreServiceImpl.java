package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.StoreRepository; // Import the actual repository

import model.Store;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreRepository storeRepository; 

    @Override
    public void saveStore(Store store) {
        storeRepository.save(store);
    }

    @Override
    public Store getStoreById(Long storeId) {
        return null;
    }

    @Override
    public List<Store> getAllStores() {
        return storeRepository.findAll();
    }

    @Override
    public void updateStore(Store store) {
    }

    @Override
    public void deleteStore(Long storeId) {
    }

}
