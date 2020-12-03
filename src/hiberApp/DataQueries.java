package hiberApp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import javax.persistence.Tuple;
import java.util.List;

/**
 @author Brijesh
 */
public final class DataQueries {

//  Selection
    public void showAddressWhereCity(SessionFactory SESSION_FACTORY) {
        try (Session session = SESSION_FACTORY.openSession()) {
            String hql = "FROM model1.Address " +
                    "WHERE city=?1";
            Query query = session.createQuery(hql);
            query.setParameter(1, "gliwice");
            List results = query.list();
            results.forEach(System.out::println);
        }
    }
//  Projection
    public void showAllStudent(SessionFactory SESSION_FACTORY) {
        try (Session session = SESSION_FACTORY.openSession()) {
            String hql = "SELECT s " +
                    "FROM model1.Student s";
            Query query = session.createQuery(hql);
            List results = query.list();
            results.forEach(System.out::println);

        }
    }

//  Group By
    public void showGroupByTest(SessionFactory SESSION_FACTORY) {
        try (Session session = SESSION_FACTORY.openSession()) {
//            Query query = session.createQuery("select count(t.id) ,t.student.id"  +
//                    " from Test t group by t.student.id", Tuple.class);
            Query query = session.createQuery("select s.tests.size, s.id "  +
                    " from Student s group by s.id", Tuple.class);

            List<Tuple> results = query.getResultList();
                for( var r : results){
                    System.out.println(r.get(0) + " " + r.get(1));
                }
            }
    }


//    Implicit
    public  void showImplicitJoinOnPersonsAddresses(SessionFactory SESSION_FACTORY){
        try(Session session = SESSION_FACTORY.openSession()){
                Query query = session.createQuery("SELECT p.fName , p.address.postalCode " +
                    "FROM Person p " +
                    "WHERE p.address.country like 'Germany'",Tuple.class);
            List<Tuple> results = query.getResultList();
            for( var r : results){
                System.out.println(r.get(0) + "  |  " + r.get(1));
            }
        }
    }

//    Explicit  (One to Many)
    public void showExplicitJoinOnTeachersSubjects(SessionFactory SESSION_FACTORY) {
        try (Session session = SESSION_FACTORY.openSession()) {
            Query query = session.createQuery("SELECT t.title , t.subject.name " +
                    "FROM Teacher t ", Tuple.class);
            List<Tuple> results = query.getResultList();
            for (var r : results) {
                System.out.println(r.get(0) + "  |  " + r.get(1));
            }
        }
    }
}
