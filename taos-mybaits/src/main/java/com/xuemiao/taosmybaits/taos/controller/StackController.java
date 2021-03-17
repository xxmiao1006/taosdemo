package com.xuemiao.taosmybaits.taos.controller;

import com.xuemiao.taosmybaits.taos.domain.Stack;
import com.xuemiao.taosmybaits.taos.service.StackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xxm
 * @date 2021/3/9 14:39
 */
@RestController
@RequestMapping("/stack")
public class StackController {

    @Autowired
    private StackService stackService;

    /**
     * Pagination Queryn
     *
     * @param limit
     * @param offset
     * @return
     */
    @GetMapping("/{limit}/{offset}")
    public List<Stack> queryStack(@PathVariable Long limit, @PathVariable Long offset) {
        return stackService.getStacks(limit, offset);
    }



}
