package com.ihason.learn.springbatch.xxljob.mapper.bill;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ihason.learn.springbatch.xxljob.mapper.bill.dataobject.BillDO;
import org.apache.ibatis.annotations.Mapper;

@DS("master")
@Mapper
public interface BillMapper extends BaseMapper<BillDO> {
}
