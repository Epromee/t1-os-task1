package com.epromee.ost1.homework1;


public class MethodStat {

    private String methodName;
    private Long totalTime;
    private Long averageTime;

    public MethodStat(String methodName, Long totalTime, Long averageTime) {
        this.methodName = methodName;
        this.totalTime = totalTime;
        this.averageTime = averageTime;
    }
    
    public String getMethodName() {
        return methodName;
    }
    
    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Long getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Long totalTime) {
        this.totalTime = totalTime;
    }

    public Long getAverageTime() {
        return averageTime;
    }

    public void setAverageTime(Long averageTime) {
        this.averageTime = averageTime;
    }
}
