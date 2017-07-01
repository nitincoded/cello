package com.katkam.cello.helpers;

import com.katkam.cello.entity.*;
//import javax.persistence.*;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import java.util.Properties;

/**
 *
 * @author User
 */
public class OrmHelper {
    private static Session sessionInstance = null;
    
    public static Session getSessionInstance() {
        if (sessionInstance == null) {
            Properties prop = new Properties();
            //jdbc:mysql://localhost:3306/parttrack?serverTimezone=Asia/Dubai&user=root&password=pepsi
            prop.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/cello?serverTimezone=Asia/Dubai&user=root&password=password");
            prop.setProperty("dialect", "org.hibernate.dialect.MySQLDialect");
            prop.setProperty("hibernate.hbm2ddl.auto", "update"); //create //update

            SessionFactory sessFactory = new Configuration()
                    .addProperties(prop)
                    .addPackage("com.katkam.cello.entity")

                    .addAnnotatedClass(Uom.class)
                    .addAnnotatedClass(Part.class)

                    .buildSessionFactory();

            sessionInstance = sessFactory.openSession();
        }
        
        return sessionInstance;
    }
}
