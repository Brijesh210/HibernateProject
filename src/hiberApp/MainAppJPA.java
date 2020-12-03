/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hiberApp;

import model1.*;
import util.EMBuilder;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Tuple;
import javax.persistence.criteria.*;
import java.util.List;

/*
 @author Brijesh
 @version 1.1

 */
public final class MainAppJPA {
    private final static EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("labPU");
    private Root<Student> root;

    public static void main(String[] args) {
//        showAllStudents();
//        showSelectionAddress();
//        showGroupBy();
//        showImplicitJoin();
//        showExplicitJoin();
        EMBuilder.closeFactory();

    }

//    Projection
    public static void showAllStudents() {
        EntityManager em = EMBuilder.getEM();

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery criteria = builder.createQuery(Student.class);
        Root<Student> root = criteria.from(Student.class);
        criteria.select(root);

        List<Student> result = em.createQuery(criteria).getResultList();
        result.forEach(System.out::println);
        em.close();
    }

//  Selection
    public static void showSelectionAddress() {
        EntityManager em = EMBuilder.getEM();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cityByName = cb.createQuery(Address.class);
        Root<Address> root = cityByName.from(Address.class);
        cityByName.where(cb.like(root.get("city"), "G%"));
        List<Address> result = em.createQuery(cityByName).getResultList();
        result.forEach(System.out::println);
        em.close();
    }

//  Group BY
//  select count(test_id), student_id from tests group by student_id;
public static void showGroupBy() {
    EntityManager em = EMBuilder.getEM();

    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery q = cb.createTupleQuery();
    Root<Test> c = q.from(Test.class);
    q.multiselect(cb.count(c.get("id")), c.get("student"))
            .groupBy(c.get("student"));
    List<Tuple> resultList = em.createQuery(q).getResultList();
    resultList.forEach(t -> {
        System.out.println(t.get(0) + " " + t.get(1));
    });
    em.close();
}


//  Explicit
    public static void showExplicitJoin() {
        EntityManager em = EMBuilder.getEM();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery query = builder.createTupleQuery();
        Root<Student> root = query.from(Teacher.class);
        Join<Teacher, Subject> joinOn = root.join("subject");
        query.multiselect(root.get("title"), joinOn.get("name"));
        List<Tuple> result = em.createQuery(query).getResultList();
        result.forEach(t -> {
            System.out.println(t.get(0) + " " + t.get(1));
        });
        em.close();
    }

//  Implicit
    public static void showImplicitJoin() {
        EntityManager em = EMBuilder.getEM();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery query = cb.createTupleQuery();
        Root<Student> root = query.from(Person.class);
        query.multiselect(
                root.get("fName"),
                root.get("address").get("city"));
        query.where(cb.like(root.get("address").get("country"), "poland"));
        List<Tuple> result = em.createQuery(query).getResultList();
        result.forEach(t -> {
            System.out.println(t.get(0) + " " + t.get(1));
        });
        em.close();
    }

}
