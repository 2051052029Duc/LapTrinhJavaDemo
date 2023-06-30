/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lmd.repository;

import com.lmd.hibernatedemov1.HibernateUtils;
import com.lmd.pojo.Category;
import com.lmd.pojo.OrderDetail;
import com.lmd.pojo.Product;
import com.lmd.pojo.SaleOrder;
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
public class StatsRepository {
    public List<Object[]> countProductByCate(){
        try(Session session = HibernateUtils.getFactory().openSession()){
           CriteriaBuilder b = session.getCriteriaBuilder();
           CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
           Root rP = q.from(Product.class);            
           Root rC = q.from(Category.class);

           q.multiselect(rC.get("id"), rC.get("name"), b.count(rP.get("id")));
           
           q.where(b.equal(rP.get("categoryId"), rC.get("id")));
           q.groupBy(rC.get("id"));

           Query query = session.createQuery(q);
           return query.getResultList();

       }    
    }
    
    public List<Object[]> statsRevenue(Map<String, String> params){
        try(Session session = HibernateUtils.getFactory().openSession()){
           CriteriaBuilder b = session.getCriteriaBuilder();
           CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
//           Root rSaleOrder = q.from(SaleOrder.class);            
           Root rOrderDetail = q.from(OrderDetail.class);
           Root rProduct = q.from(Product.class);

           q.multiselect(rProduct.get("id"), rProduct.get("name"), b.sum(rOrderDetail.get("unitPrice"), rOrderDetail.get("num")));
           q.where(b.equal(rOrderDetail.get("productId"), rProduct.get("id")));
           q.groupBy(rProduct.get("id"));

           Query query = session.createQuery(q);
           return query.getResultList();

       }    
    }
}
