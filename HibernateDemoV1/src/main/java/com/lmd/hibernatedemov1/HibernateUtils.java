/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lmd.hibernatedemov1;

import com.lmd.pojo.Category;
import com.lmd.pojo.OrderDetail;
import com.lmd.pojo.ProdTag;
import com.lmd.pojo.Product;
import com.lmd.pojo.SaleOrder;
import com.lmd.pojo.Tag;
import com.lmd.pojo.User;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;




/**
 *
 * @author admin
 */
public class HibernateUtils {
    private static final SessionFactory factory;
    
    static{
        Configuration conf = new Configuration();
        Properties props = new Properties();
        props.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");        
        props.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        props.put(Environment.URL, "jdbc:mysql://localhost/saledb");
        props.put(Environment.USER, "root");        
        props.put(Environment.PASS, "Admin@123");
        props.put(Environment.SHOW_SQL, "true");
        
        
        conf.setProperties(props);
        
        conf.addAnnotatedClass(Category.class);        
        conf.addAnnotatedClass(Product.class);
        conf.addAnnotatedClass(Tag.class);
        
        conf.addAnnotatedClass(User.class);        
        conf.addAnnotatedClass(Tag.class);
        conf.addAnnotatedClass(ProdTag.class);
        conf.addAnnotatedClass(SaleOrder.class);
        conf.addAnnotatedClass(OrderDetail.class);

        
 
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
        
        factory = conf.buildSessionFactory(serviceRegistry);
        
    }

    /**
     * @return the factory
     */
    public static SessionFactory getFactory() {
        return factory;
    }
    
}
