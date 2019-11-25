package com.haojie.lianxi.dao;

import com.haojie.lianxi.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CourseDao extends
        JpaSpecificationExecutor<Course>, JpaRepository<Course,String> {
}
