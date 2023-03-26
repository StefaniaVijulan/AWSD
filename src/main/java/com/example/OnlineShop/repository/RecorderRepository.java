package com.example.OnlineShop.repository;

import com.example.OnlineShop.model.Product;
import com.example.OnlineShop.model.Recorder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RecorderRepository extends JpaRepository<Recorder, Integer> {

}
