package com.ihason.learn.springbatch.xxljob.mapper.bill.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 *
 * @author Hason
 */
@Getter
@Setter
@ToString
@TableName("bill")
public class BillDO {

    @TableId(value = "id", type = IdType.INPUT)
    private Long id;

    @TableField("`date`")
    private LocalDate date;

    private BigDecimal amount;

}
