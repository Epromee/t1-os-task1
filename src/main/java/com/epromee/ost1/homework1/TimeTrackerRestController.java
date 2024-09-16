package com.epromee.ost1.homework1;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class TimeTrackerRestController {

    @Autowired
    private TimeTrackerStatsOperator statsOperator;
    

    @GetMapping("/tt/total/")
    public Long getTotalTime(
        @RequestParam String methodName
    ) {
        return statsOperator.getTotalTime(methodName);
    }
    
    @GetMapping("/tt/average/")
    public Long getAverageTime(
        @RequestParam String methodName
    ) {
        return statsOperator.getAverageTime(methodName);
    }

    @GetMapping("/tt/full/")
    public List<MethodStat> getMethodName() {
        return statsOperator.getFullStats();
    }
    
}
