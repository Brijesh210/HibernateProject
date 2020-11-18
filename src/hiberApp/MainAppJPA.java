/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hiberApp;

import model1.Address;
import model1.Student;
import util.EMBuilder;

import java.rmi.StubNotFoundException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;


/*
 @author LabHiber
 */
public final class MainAppJPA {
    private final static EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("labPU");
    private Root<Student> root;

    public static void main(String[] args) {
//        showAllStudents();
//        showSelectionAddress();
//        showGroupBy();
        EMBuilder.closeFactory();

    }

    //    Projection
    public static void showAllStudents() {
        EntityManager em = EMBuilder.getEM();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery criteria = builder.createQuery(Student.class);
        Root<Student> root = criteria.from(Student.class);
        criteria.select(root);
        List<String> result = em.createQuery(criteria).getResultList();
        result.forEach(System.out::println);
        em.close();
    }

    //    Selection
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

    //  select count(test_id), student_id from tests group by student_id;

//    public static void showGroupBy() {
//        EntityManager em = EMBuilder.getEM();
//
//        CriteriaBuilder builder = em.getCriteriaBuilder();
//        CriteriaQuery criteria = builder.createQuery(Student.class);
//
//        Root<Student> root = criteria.from(Student.class);
//        criteria.groupBy(root.get(Student.id));
//        criteria.multiselect(root.get(Student.id), builder.count(Student.test.id));
//
//        List<String> result = em.createQuery(criteria).getResultList();
//        result.forEach(System.out::println);
//        em.close();
//    }

    public static void showExplictJoin() {
        EntityManager em = EMBuilder.getEM();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery criteria = builder.createQuery(Student.class);
        Root<Student> root = criteria.from(Student.class);
        criteria.select(root);
        List<String> result = em.createQuery(criteria).getResultList();
        result.forEach(System.out::println);
        em.close();
    }

    public static void showImplicitJoin() {
        EntityManager em = EMBuilder.getEM();
        CriteriaBuilder builder = em.getCriteriaBuilder();

        CriteriaQuery criteria = builder.createQuery(Student.class);
        Root<Student> root = criteria.from(Student.class);
        criteria.select(root);

        List<String> result = em.createQuery(criteria).getResultList();
        result.forEach(System.out::println);
        em.close();
    }



}
