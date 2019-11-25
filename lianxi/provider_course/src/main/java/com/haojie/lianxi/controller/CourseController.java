package com.haojie.lianxi.controller;

import com.haojie.lianxi.entity.Course;
import com.haojie.lianxi.entity.VO;
import com.haojie.lianxi.service.CourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：单击开始
 * @description：
 * @date ：Created in 2019/11/24 19:57
 */
@Api(tags = "课程的操作接口")
@RestController
@CrossOrigin
public class CourseController {

    @Autowired
    private CourseService courseService;

    @ApiOperation(value = "查询、联合查询")
    @ApiImplicitParam(paramType = "query",value = "模糊查询、分页",dataType = "String",name = "vo")
    @RequestMapping("list")
    public Object list(VO vo){

        return courseService.list(vo);
    }

    @ApiOperation(value = "课程分类的集合")
    @RequestMapping("categoryList")
    public Object categoryList(){
        return courseService.categoryList();
    }

    @RequestMapping("save")
    public Object save(Course course){
        return courseService.save(course);
    }

    @RequestMapping("delete")
    public Object delete(@RequestBody List<Course> course){
        return courseService.delete(course);
    }
}
