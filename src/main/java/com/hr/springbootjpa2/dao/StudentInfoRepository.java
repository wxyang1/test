package com.hr.springbootjpa2.dao;


import com.hr.springbootjpa2.entity.StudentInfo2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentInfoRepository extends JpaRepository<StudentInfo2,Integer> {

    //自定义hql语句findStuByName
    @Query("from StudentInfo2 stu where stu.name like ?1")
    public List<StudentInfo2> findStuByName(String name, String name2);

    //自定义hql语句
    @Query(value = "select * from student_info2 where name like :#{#stu.name} and age= :#{#stu.age}",nativeQuery = true)
    public List<StudentInfo2> findStuByNameAndAge(@Param("stu") StudentInfo2 stu);
}
