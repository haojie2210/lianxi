package com.haojie.lianxi.service;

import com.haojie.lianxi.entity.Course;
import com.haojie.lianxi.entity.CourseCategory;
import com.haojie.lianxi.entity.VO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CourseService {
    Page<Course> list(VO vo);

    List<CourseCategory> categoryList();

    boolean save(Course course);

    boolean delete(List<Course> course);
}
