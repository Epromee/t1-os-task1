package com.epromee.ost1.homework1;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeTrackerCrudRepo extends CrudRepository<TimeTrackerLogEntry, Long> {

    @Query(value = "SELECT SUM(t.timeMilliseconds) FROM TimeTrackerLogEntry t WHERE t.methodName = ?1")
    Long getTotalTime(String methodName);

    @Query(value = "SELECT SUM(t.timeMilliseconds) / COUNT(t.timeMilliseconds) FROM TimeTrackerLogEntry t WHERE t.methodName = ?1")
    Long getAverageTime(String methodName);

    @Query(value = "SELECT new com.epromee.ost1.homework1.MethodStat(t.methodName, SUM(t.timeMilliseconds), SUM(t.timeMilliseconds) / COUNT(t.timeMilliseconds)) FROM TimeTrackerLogEntry t GROUP BY t.methodName")
    List<MethodStat> getFullStats();

}
