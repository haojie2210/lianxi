package com.haojie.lianxi.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author ：单击开始
 * @description：
 * @date ：Created in 2019/11/24 20:00
 */
@Data
public class VO {

    private String dateName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    private BigDecimal gtPrice;
    private BigDecimal ltPrice;
    private String ccid;

    private Integer pageNum;
    private Integer pageSize;

}
