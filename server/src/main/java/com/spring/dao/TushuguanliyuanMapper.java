package com.spring.dao;

import com.spring.config.MapperBase;
import com.spring.entity.Tushuguanliyuan;
import org.springframework.stereotype.Repository;

@Repository
public interface TushuguanliyuanMapper extends MapperBase<Tushuguanliyuan> {
    Tushuguanliyuan login(Tushuguanliyuan tushuguanliyuan);
}
