package com.haojie.lianxi.dao;

import com.haojie.lianxi.entity.CourseCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Locale;

public interface CategoryDao extends JpaRepository<CourseCategory,String> {
}
