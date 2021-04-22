package com.hr.springbootjpa2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
//@Table(name="student")
@Data //get set 方法
@NoArgsConstructor //无参构造
@AllArgsConstructor//有参构造
public class StudentInfo2 implements Serializable {

    @Id
    //自动增长
    @GeneratedValue(strategy = GenerationType.AUTO)//会新建一个hibernate_sequence表，表中存放序列中
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //@Column(name = "stu_name",length = 50)
    private String name;
    private Integer age;
    private Date birthDay;

    //表中不需要此列
    @Transient
    private Double money;
}
