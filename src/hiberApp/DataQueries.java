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
//    Projection
    public void showAllStudent(SessionFactory SESSION_FACTORY) {
        try (Session session = SESSION_FACTORY.openSession()) {
            String hql = "SELECT s " +
                    "FROM model1.Student s";
            Query query = session.createQuery(hql);
            List results = query.list();
            results.forEach(System.out::println);

        }
    }

//      select count(test_id), student_id from tests group by student_id;
    public void showGroupByTest(SessionFactory SESSION_FACTORY) {
        try (Session session = SESSION_FACTORY.openSession()) {
            Query query = session.createQuery("SELECT t.student.id , COUNT(t.id) " +
                    "FROM Test t " +
                    "GROUP BY t.student.id ",Tuple.class);
                List<Tuple> results = query.getResultList();
                for( var r : results){
                    System.out.println(r.get(0) + " " + r.get(1));
                }
            }
    }

//    Implicit
//    select p.fName , a.country from persons p , addresses a where p.address_id = a.address_id;
    public  void showImplicitJoinOnPersonsAddresses(SessionFactory SESSION_FACTORY){
        try(Session session = SESSION_FACTORY.openSession()){
            Query query = session.createQuery("SELECT p.fName , a.postalCode " +
                    "FROM Person p , Address a " +
                    "WHERE p.address = a.id ",Tuple.class);
            List<Tuple> results = query.getResultList();
            for( var r : results){
                System.out.println(r.get(0) + "  |  " + r.get(1));
            }
        }
    }

//    Explicit
//    select t.title , s.name from teachers t join subjects s on t.subject_id = s.subject_id;
    public void showExplicitJoinOnTeachersSubjects(SessionFactory SESSION_FACTORY) {
        try (Session session = SESSION_FACTORY.openSession()) {
            Query query = session.createQuery("SELECT t.title , s.name " +
                    "FROM Teacher t " +
                    "JOIN Subject s ON t.subject.id = s.id ", Tuple.class);
            List<Tuple> results = query.getResultList();
            for (var r : results) {
                System.out.println(r.get(0) + "  |  " + r.get(1));
            }
        }
    }
}
