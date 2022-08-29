package com.mybatis.plus.example.travelmybatisplus.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author ddshuai
 * date 2022-08-29 16:17
 **/
@Data
@TableName("t_fl_items")
public class Items {
    private String itemId;
    private String itemCode;
    private String itemName;
    private Integer itemIndex;
    private Integer itemState;
    private String itemType;
    private Date created;
    private String creater;
}
