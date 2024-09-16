package com.epromee.ost1.homework1;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;

@Entity
@Table(
    name = "time_tracker_log_tbl",
    indexes = {
        @Index(name = "tt_method_name_idx",  columnList="methodName", unique = false)
    }
)
public class TimeTrackerLogEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String methodName;

    @Column(nullable = false)
    private Long timeMilliseconds;

    public TimeTrackerLogEntry(String methodName, Long timeMilliseconds) {
        this.methodName = methodName;
        this.timeMilliseconds = timeMilliseconds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Long getTimeMilliseconds() {
        return timeMilliseconds;
    }

    public void setTimeMilliseconds(Long timeMilliseconds) {
        this.timeMilliseconds = timeMilliseconds;
    }
    
}
