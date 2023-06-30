/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.lmd.hibernatedemov1;


import com.lmd.pojo.Category;
import com.lmd.repository.ProductRepository;
import com.lmd.repository.StatsRepository;
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
        
        StatsRepository s = new StatsRepository();
        s.statsRevenue(null).forEach(o -> System.out.printf("%d - %s - %d\n", o[0], o[1], o[2]));
    }
}
