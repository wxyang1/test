package com.hr.springbootjpa2.service.impl;

import com.hr.springbootjpa2.dao.StudentInfoRepository;

import com.hr.springbootjpa2.entity.StudentInfo2;
import com.hr.springbootjpa2.service.StudentInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class StudentInfoServiceImplTest {

    @Autowired
    private StudentInfoService studentInfoService;

    @Test
    public void testSaveAll(){
        List<StudentInfo2> stuList = new ArrayList<>();

        Date date = new Date();

        stuList.add(new StudentInfo2(null,"精神小伙",18,date,null));
        stuList.add(new StudentInfo2(null,"精神小妹",17,date,null));
        stuList.add(new StudentInfo2(null,"二哈",15,date,null));

        studentInfoService.saveAll(stuList);
    }

    @Test
    public void testFindStu(){
        StudentInfo2 stu = new StudentInfo2();
        stu.setName("二哈");

        List<StudentInfo2> stuList = studentInfoService.findStu(stu);

        for(StudentInfo2 stu2:stuList){
            System.out.println(stu2);
        }

    }
}
