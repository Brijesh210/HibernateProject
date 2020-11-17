/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hiberApp;

import model1.Student;
import util.EMBuilder;
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

    public static void main(String[] args) {
        showAllStudents();
        EMBuilder.closeFactory();

    }

    public static void showAllStudents() {
        EntityManager em = EMBuilder.getEM();

        List<Student> result = em.createQuery("select e from model1.Student e").getResultList();
        result.forEach(System.out::println);
        System.out.println("=======================");

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery criteria = builder.createQuery(Student.class);
        Root<Student> root = criteria.from(Student.class);
        criteria.select(root);
        result = em.createQuery(criteria).getResultList();
        result.forEach(System.out::println);

        builder = em.getCriteriaBuilder();
        criteria = builder.createQuery(String.class);
        root = criteria.from(Student.class);

        List<String> names = em.createQuery(criteria).getResultList();
        names.forEach(System.out::println);
        em.close();
    }
//        List<Employee> result = em.createQuery("select e from Employee e").getResultList();
//        result.forEach(System.out::println);
//        System.out.println("=======================");
//        CriteriaBuilder builder = em.getCriteriaBuilder();
//        CriteriaQuery criteria = builder.createQuery(Employee.class);
//        Root<Employee> root = criteria.from(Employee.class);
//        criteria.select(root);
//        result = em.createQuery(criteria).getResultList();
//        result.forEach(System.out::println);
//
//        builder = em.getCriteriaBuilder();
//        criteria = builder.createQuery(String.class);
//        root = criteria.from(Employee.class);
//        criteria.select(root.get(Employee_.NAME));
//        List<String> names = em.createQuery(criteria).getResultList();
//        names.forEach(System.out::println);
//    }

}
