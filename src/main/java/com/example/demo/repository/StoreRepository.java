package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Integer>{

}
