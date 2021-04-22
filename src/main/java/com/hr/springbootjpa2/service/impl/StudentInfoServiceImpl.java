package com.hr.springbootjpa2.service.impl;

import com.hr.springbootjpa2.dao.StudentInfoRepository;
import com.hr.springbootjpa2.entity.StudentInfo2;
import com.hr.springbootjpa2.service.StudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class StudentInfoServiceImpl implements StudentInfoService {

    @Autowired
    private StudentInfoRepository studentInfoRepository;

    //springboot整合的事务管理
    @Transactional
    public void saveAll(List<StudentInfo2> stuList){
        List<StudentInfo2> studentInfos = studentInfoRepository.saveAll(stuList);
        for (StudentInfo2 stu:studentInfos) {
            System.out.println(stu);
        }

    }

    public List<StudentInfo2> findStu(StudentInfo2 stu){
        Example<StudentInfo2> stuEx = Example.of(stu);
        return studentInfoRepository.findAll(stuEx);
    }

    //dao层自定义的方法
    @Override
    public List<StudentInfo2> findStuByName(String name, String name2) {
        return studentInfoRepository.findStuByName(name,name2);
    }
    //dao层自定义的方法
    @Override
    public List<StudentInfo2> findStuByNameAndAge(StudentInfo2 stu) {
        return studentInfoRepository.findStuByNameAndAge(stu);
    }
}
