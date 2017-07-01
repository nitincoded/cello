package com.katkam.cello;

import org.hibernate.*;
import java.util.*;
import com.katkam.cello.entity.*;
import org.hibernate.criterion.Restrictions;
/**
 *
 * @author User
 */
public class EntryPoint {
    public static void main(String args[]) throws Exception {
//        haveAGo();
        takeAPeek();
        System.out.println("Done!");
    }
    
    private static void haveAGo() throws Exception {
        Session sess = com.katkam.cello.helpers.OrmHelper.getSessionInstance();
        
        Uom can = new Uom("CAN", "can");
        Uom bag = new Uom("BAG", "bag");
        Uom box = new Uom("BOX", "box");
        
        Transaction t = sess.beginTransaction();
//        sess.merge(can);
//        sess.merge(bag);
//        sess.merge(box);
//        sess.save(can); //Use merge - it can create and update

        Part spare = new Part("TOOLBOX", "Toolbox");
        spare.setUom((Uom) sess.createCriteria(Uom.class).add(Restrictions.eq("code", "BOX")).list().get(0));
//        sess.merge(spare);
        
        t.commit();        
    }
    
    private static void takeAPeek() throws Exception {
        Session sess = com.katkam.cello.helpers.OrmHelper.getSessionInstance();

//        List<Uom> lstUom = sess.createCriteria(Uom.class).list();
//        for (Uom iter : lstUom) {
//            System.out.println(iter.toString());
//        }

        List<Part> lstPart = sess.createCriteria(Part.class).list();
        for (Part iter : lstPart) {
            System.out.println(iter.toString());
        }
    }
}
