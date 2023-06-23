/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.lmd.hibernatedemov1;


import com.lmd.pojo.Category;
import com.lmd.repository.ProductRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author admin
 */
public class HibernateDemoV1 {

    public static void main(String[] args) {
        
        Map<String, String> params = new HashMap<>();
        params.put("kw", "Galaxy");
        
        ProductRepository pr = new ProductRepository();
        
        pr.getProducts(params).forEach(q -> {
            System.out.printf("%d - %s\n", q.getId(), q.getName());
        });
    }
}
