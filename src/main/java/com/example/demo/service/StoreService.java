package com.example.demo.service;

import java.util.List;

import model.Store;

public interface StoreService {
    void saveStore(Store store);
    // Add other store-related methods as needed

	Store getStoreById(Long storeId);

	List<Store> getAllStores();

	void updateStore(Store store);

	void deleteStore(Long storeId);
}
