package com.hr.springbootjpa2.dao.impl;

import com.hr.springbootjpa2.dao.StudentInfoRepository;
import com.hr.springbootjpa2.entity.StudentInfo2;
import com.hr.springbootjpa2.service.StudentInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@SpringBootTest
public class StudentInfoRepositoryImplTest {

    @Autowired
    private StudentInfoRepository studentInfoRepository;
    @Autowired
    private StudentInfoService studentInfoService;

    @PersistenceContext
    private EntityManager em;


    //操作service层
    @Test
    public void testFindStuByName1(){
        List<StudentInfo2> stuList=  studentInfoService.findStuByName("%精神%","%二%");
        for (StudentInfo2 studentInfo : stuList) {
            System.out.println(studentInfo);
        }
    }
    //操作service层
    @Test
    public void testFindStuByNameAndAge1(){
        StudentInfo2 stu = new StudentInfo2();
        stu.setName("%精神%");
        stu.setAge(17);
        List<StudentInfo2> stuList=  studentInfoService.findStuByNameAndAge(stu);
        for (StudentInfo2 studentInfo : stuList) {
            System.out.println(studentInfo);
        }
    }
    //直接操作dao层
    @Test
    public void testFindStuByName(){
        List<StudentInfo2> stuList = studentInfoRepository.findStuByName("%精神%", "%二%");
        for (StudentInfo2 studentInfo : stuList) {
            System.out.println(studentInfo);
        }
    }
    //直接操作dao层
    @Test
    public void testFindStuByNameAndAge(){
        StudentInfo2 stu = new StudentInfo2();
        stu.setName("%精神%");
        stu.setAge(17);

        List<StudentInfo2> stuList = studentInfoRepository.findStuByNameAndAge(stu);
        for (StudentInfo2 studentInfo : stuList) {
            System.out.println(studentInfo);
        }
    }
    //直接操作dao层
    @Test
    public void testFindStuBySql(){
        //em.createQuery("hql语句");
        //em.createNativeQuery("sql语句")

        //em.createQuery("delete from StudentInfo stu where stu.id=1").executeUpdate();
        List<StudentInfo2> stuList =  em.createQuery("from StudentInfo2").getResultList();
        for (StudentInfo2 studentInfo : stuList) {
            System.out.println(studentInfo);
        }
    }

}
