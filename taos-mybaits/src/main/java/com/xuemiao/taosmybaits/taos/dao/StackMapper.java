package com.xuemiao.taosmybaits.taos.dao;

import com.xuemiao.taosmybaits.taos.domain.Stack;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xxm
 * @date 2021/3/9 14:17
 */
public interface StackMapper {
    void dropDB();

    void createDB();

    void createSuperTable();

    void createTable(Stack stack);

    List<Stack> select(@Param("limit") Long limit, @Param("offset") Long offset);

    int insert(Stack weather);

    int count();

    List<String> getSubTables();

    List<Stack> avg();
}
