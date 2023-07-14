/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.repository.impl;

import com.dht.pojo.Category;
import com.dht.repository.CategoriesRepository;
import java.util.List;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

/**
 *
 * @author admin
 */
@Repository
@Transactional
public class CategoriesRepositoryImpl implements CategoriesRepository{
    @Autowired
    private LocalSessionFactoryBean factory;
    
    @Override
    public List<Category> getCategories() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM Category");
        
        return q.getResultList();
    }
    
}
