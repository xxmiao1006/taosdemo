package com.xuemiao.taosmybaits.sqlserver.controller;

import com.xuemiao.taosmybaits.sqlserver.domain.HistoryData;
import com.xuemiao.taosmybaits.sqlserver.service.HistoryDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xxm
 * @date 2021/3/10 13:53
 */
@RestController
@RequestMapping("/historyData")
public class HistoryDataController {

    @Autowired
    private HistoryDataService historyDataService;


    @GetMapping("/{projectId}/{limit}/{offset}")
    public List<HistoryData> getData(@PathVariable("projectId") Integer projectId,@PathVariable("limit") Integer limit,@PathVariable("offset") Integer offset){
        return historyDataService.getData(projectId,limit,offset);
    }

}
