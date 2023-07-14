/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.service.impl;

import com.dht.pojo.Category;
import com.dht.repository.CategoriesRepository;
import com.dht.service.CategoriesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class CategoriesServiceImpl implements CategoriesService{
    @Autowired
    private CategoriesRepository cateRepo;

    @Override
    public List<Category> getCategory() {
        return this.cateRepo.getCategories();
    }
   
}
