package com.xuemiao.taosmybaits.sqlserver.dao;

import com.xuemiao.taosmybaits.sqlserver.domain.HistoryData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xxm
 * @date 2021/3/10 13:42
 */
public interface HistoryDataMapper {

    List<HistoryData> getData(@Param("projectId") Integer projectId,@Param("limit") Integer limit,@Param("offset") Integer offset);
}
