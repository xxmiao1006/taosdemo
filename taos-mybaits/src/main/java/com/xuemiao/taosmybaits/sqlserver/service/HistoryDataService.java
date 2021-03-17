package com.xuemiao.taosmybaits.sqlserver.service;

import com.xuemiao.taosmybaits.sqlserver.dao.HistoryDataMapper;
import com.xuemiao.taosmybaits.sqlserver.domain.HistoryData;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xxm
 * @date 2021/3/10 13:51
 */
@Service
public class HistoryDataService {

    @Autowired
    private HistoryDataMapper historyDataMapper;

    public List<HistoryData> getData(Integer projectId,Integer limit,Integer offset){
        List<HistoryData> data = historyDataMapper.getData(projectId, limit, offset);
        return data;
    };

}
