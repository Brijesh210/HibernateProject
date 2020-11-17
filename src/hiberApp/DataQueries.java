/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hiberApp;

import model1.*;

import java.util.Arrays;
import java.util.List;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.w3c.dom.ls.LSOutput;

/* 
 @author Brijesh
 */
public final class DataQueries {

//    Queries (each query in JPQL and Criteria API version):
//
//    Query with simple projection and simple selection
//    Query with implicite join
//    Query with explicite join
//    Query with aggregation and grouping


    public void showAddressWhereCity(SessionFactory SESSION_FACTORY) {
        try (Session session = SESSION_FACTORY.openSession()) {
            String hql = "FROM model1.Address WHERE city=?1";
            Query query = session.createQuery(hql);
            query.setParameter(1,"gliwice");
            List results = query.list();
            results.forEach(System.out::println);
        }
    }

    public void showAllStudent(SessionFactory SESSION_FACTORY){
        try (Session session = SESSION_FACTORY.openSession()){
            String hql = "SELECT s FROM model1.Student s";
            Query query = session.createQuery(hql);
            List results = query.list();
            results.forEach(System.out::println);

        }
    }
}
