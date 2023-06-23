/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lmd.repository;

import com.lmd.hibernatedemov1.HibernateUtils;
import com.lmd.pojo.Product;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author admin
 */
public class ProductRepository {
    public List<Product>  getProducts(Map<String, String> params){
        try(Session session = HibernateUtils.getFactory().openSession()){
            CriteriaBuilder b = session.getCriteriaBuilder();
            CriteriaQuery<Product> pre = b.createQuery(Product.class);
            Root root = pre.from(Product.class);
            pre.select(root);
            
            if(params != null){
                String kw = params.get("kw");
                if (kw != null && !kw.isEmpty()){
                    Predicate p1 = b.like(root.get("name"), String.format("%%%s%%", kw));
                    pre.where(p1);
                }

            }
            pre.orderBy(b.desc(root.get("id")));

            Query query = session.createQuery(pre);
            return query.getResultList();

        }    
    }
}
