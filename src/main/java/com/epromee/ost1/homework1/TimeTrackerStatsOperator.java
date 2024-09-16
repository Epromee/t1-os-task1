package com.epromee.ost1.homework1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class TimeTrackerStatsOperator {

    @Autowired
    private TimeTrackerCrudRepo ttCrudRepo;
    
    @Async
    public void sendStats(String methodName, long measuredTimeMs) {
        ttCrudRepo.save(new TimeTrackerLogEntry(methodName, measuredTimeMs));
    }

    public Long getTotalTime(String methodName) {
        return ttCrudRepo.getTotalTime(methodName);
    }

    public Long getAverageTime(String methodName) {
        return ttCrudRepo.getAverageTime(methodName);
    }

    public List<MethodStat> getFullStats() {
        return ttCrudRepo.getFullStats();
    }
}
