package com.itmuch.cloud.study.order.controller;

import com.itmuch.cloud.study.common.base.Result;
import com.itmuch.cloud.study.common.base.Results;
import com.itmuch.cloud.study.order.service.DistributedLockByCurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("curator")
public class DistributeLockController {
    @Autowired
    private DistributedLockByCurator distributedLockByCurator;

    private final static String PATH = "test";

    @GetMapping("/lock1")
    public Result<Boolean> getLock1() {
        Boolean flag;
        distributedLockByCurator.acquireDistributedLock(PATH);
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            flag = distributedLockByCurator.releaseDistributedLock(PATH);
        }
        flag = distributedLockByCurator.releaseDistributedLock(PATH);
        return Results.newSuccessResult(flag);
    }

    @GetMapping("/lock2")
    public Result<Boolean> getLock2() {
        Boolean flag;
        distributedLockByCurator.acquireDistributedLock(PATH);
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            flag = distributedLockByCurator.releaseDistributedLock(PATH);
        }
        flag = distributedLockByCurator.releaseDistributedLock(PATH);
        return Results.newSuccessResult(flag);
    }

    
}
