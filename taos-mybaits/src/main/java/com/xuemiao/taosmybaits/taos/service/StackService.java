package com.xuemiao.taosmybaits.taos.service;

import com.xuemiao.taosmybaits.taos.dao.StackMapper;
import com.xuemiao.taosmybaits.taos.domain.Stack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xxm
 * @date 2021/3/9 14:36
 */
@Service
public class StackService {

    @Autowired
    private StackMapper stackMapper;

    public List<Stack> getStacks(Long limit, Long offset){
        List<Stack> stacks = stackMapper.select(limit, offset);
        return stacks;
    }

}
