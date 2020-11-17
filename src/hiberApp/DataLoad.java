/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hiberApp;

import java.time.LocalDate;
import java.util.Date;

import model1.*;

import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* 
 @author LabHiber
 */
public final class DataLoad {
    /**
     * Creates test data
     *
     * @param SESSION_FACTORY for connecting data source
     */

    static Logger log = LoggerFactory.getLogger(DataLoad.class);

    protected void createData(SessionFactory SESSION_FACTORY) {

        try (Session session = SESSION_FACTORY.openSession()) {

            Transaction tx = null;
            try {
                log.trace("insert person transaction begin");
                tx = session.beginTransaction();
                Person person1 = new Person("John", "Smith", "johnsnith@gmail.com");
                Address address4 = new Address("germany", "warsaw", "30-100", "waclowska");
                person1.setAddress(address4);
                session.save(person1);

                Person person2 = new Person("Tom", "Jones", "tomjones@gmail.com");
                Address address3 = new Address("germany", "gliwice", "44-100", "surat");
                person2.setAddress(address3);
                session.save(person2);
                tx.commit();
                log.trace("insert person transaction commit");
            } catch (Exception e) {
                if (tx != null) {
                    tx.rollback();
                    log.trace(e.toString());
                }
            }
            tx = session.beginTransaction();


            //----------students---------
            Student student1 = new Student("ismail", "atajanov ", "ismail@gmail.com");
            FieldOfStudy fieldOfStudy1 = new FieldOfStudy("Informatics", "S2");
            student1.setFieldOfStudys(fieldOfStudy1);
            Address address1 = new Address("poland", "gliwice", "44-100", "kujawska");
            Address address5 = new Address("germany", "gliwice", "44-100", "kujawska");

            student1.setAddress(address1);
            student1.setIndexNo("345293");
            student1.setSemester(5);
            session.save(student1);

            Student student2 = new Student("gafar", "azeez", "gafar@gmail.com");
            FieldOfStudy fieldOfStudy2 = new FieldOfStudy("Informatics", "S1");
            student2.setFieldOfStudys(fieldOfStudy2);
            Address address2 = new Address("poland", "katowice", "42-102", "Opolska");
            student2.setAddress(address2);
            student2.setIndexNo("342292");
            student2.setSemester(2);
            session.save(student2);

            //--------teachers-----------

            Teacher teacher1 = new Teacher("vish", "anaghan", "vishal@gmail.com");
            teacher1.setTitle("Proff");
            Subject subject1 = new Subject("ori");
            Subject subject2 = new Subject("avrs");
            teacher1.setSubject(subject1);
            teacher1.setAddress(student1.getAddress());
            session.save(teacher1);

            Teacher teacher2 = new Teacher("ashish", "sutariya", "ashish@gmail.com");
            teacher2.setTitle("Assistance");
            teacher2.setSubject(subject2);
            session.save(teacher2);

            Test test1 = new Test(LocalDate.parse("2020-09-20"), 3);
            Test test2 = new Test(LocalDate.parse("2020-09-21"), 5);
            Test test3 = new Test(LocalDate.parse("2020-09-22"), 4);

            HashSet<Test> setTest1 = new HashSet<>();
            HashSet<Test> setTest2 = new HashSet<>();
            HashSet<Test> setTest3 = new HashSet<>();

            setTest1.add(test3);
            setTest1.add(test2);
            setTest1.add(test1);
            setTest2.add(test2);
            setTest2.add(test3);
            setTest3.add(test1);

            student1.setTests(setTest1);
            student2.setTests(setTest3);

            subject1.setTests(setTest3);
            subject1.setTests(setTest2);
            subject2.setTests(setTest1);

            test1.setStudent(student2);
            test1.setSubject(subject2);

            test2.setStudent(student1);
            test2.setSubject(subject1);

            test3.setStudent(student2);
            test3.setSubject(subject2);

            session.save(test1);
            session.save(test2);
            session.save(test3);

            tx.commit();
        }
    }
}
