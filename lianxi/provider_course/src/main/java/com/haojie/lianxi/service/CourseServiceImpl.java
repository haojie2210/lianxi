package com.haojie.lianxi.service;

import com.haojie.lianxi.dao.CategoryDao;
import com.haojie.lianxi.dao.CourseDao;
import com.haojie.lianxi.entity.Course;
import com.haojie.lianxi.entity.CourseCategory;
import com.haojie.lianxi.entity.VO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：单击开始
 * @description：
 * @date ：Created in 2019/11/24 20:03
 */
@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;
    @Autowired
    private CategoryDao categoryDao;
    @Override
    public Page<Course> list(VO vo) {
        Specification<Course> specification = new Specification<Course>() {

            @Override
            public Predicate toPredicate(Root<Course> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                ArrayList<Predicate> list = new ArrayList<>();
                if (vo.getCcid()!=null && !"".equals(vo.getCcid())){
                    Predicate p1 = cb.like(root.get("courseCategory").get("ccid"), "%" + vo.getCcid() + "%");
                    list.add(p1);
                }
                if (vo.getDateName()!=null && !"".equals(vo.getDateName())) {
                    if (vo.getStartDate() != null) {
                        Predicate p2 = cb.greaterThan(root.get("courseCategory").get(vo.getDateName()), vo.getStartDate());
                        list.add(p2);
                    }
                    if (vo.getEndDate() != null) {
                        Predicate p3 = cb.lessThan(root.get("courseCategory").get(vo.getDateName()), vo.getEndDate());
                        list.add(p3);
                    }
                }
                if (vo.getGtPrice() != null) {
                    Predicate p4 = cb.gt(root.get("price"), vo.getGtPrice());
                    list.add(p4);
                }
                if (vo.getLtPrice() != null) {
                    Predicate p5 = cb.lt(root.get("price"), vo.getLtPrice());
                    list.add(p5);
                }
                return cb.and(list.toArray(new Predicate[list.size()]));
            }
        };
        PageRequest request = PageRequest.of(vo.getPageNum()-1,vo.getPageSize());
        return courseDao.findAll(specification,request);
    }

    @Override
    public List<CourseCategory> categoryList() {
        return categoryDao.findAll();
    }

    @Override
    public boolean save(Course course) {
        Course course1 = courseDao.saveAndFlush(course);
        if (null==course1){
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(List<Course> course) {
        try {
            courseDao.deleteAll(course);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
