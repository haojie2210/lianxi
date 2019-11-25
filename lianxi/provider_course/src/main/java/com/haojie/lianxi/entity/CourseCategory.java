package com.haojie.lianxi.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;

/**
 * @author ：单击开始
 * @description：
 * @date ：Created in 2019/11/24 19:53
 */
@Getter
@Setter
@Entity
public class CourseCategory implements Serializable {
    private static final long serialVersionUID = 272562425971425185L;

    @Id
    private String ccid;
    private String cname;
    private String createId;
    private String updateId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column()
    private Date createDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updateDate;
    private Integer delStatus;
}
