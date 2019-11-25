package com.haojie.lianxi.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author ：单击开始
 * @description：
 * @date ：Created in 2019/11/24 19:44
 */
@Data
@Table(name = "course")
@Entity
public class Course implements Serializable {
    private static final long serialVersionUID = -1290706583390900618L;

    @Id
    private String id;
    @Column
    private String name;
    @Column
    private String teacherName;
    @Column
    private Integer delStatus;
    @Column
    private BigDecimal price;
    @Column
    private String pic;

    @JoinColumn(name = "ccid",referencedColumnName = "ccid")
    @ManyToOne
    private CourseCategory courseCategory;
}
