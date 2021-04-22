package com.hr.springbootjpa2.service;

import com.hr.springbootjpa2.entity.StudentInfo2;
import com.hr.springbootjpa2.entity.StudentInfo2;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentInfoService{
    public void saveAll(List<StudentInfo2> stuList);
    public List<StudentInfo2> findStu(StudentInfo2 stu);
    public List<StudentInfo2> findStuByName(String name, String name2);//dao层自定义的方法
    public List<StudentInfo2> findStuByNameAndAge(StudentInfo2 stu);//dao层自定义的方法
}
