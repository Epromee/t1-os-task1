package com.epromee.ost1.homework1;

import org.springframework.stereotype.Component;

@Component
public class FakeWorkload {

    void performFakeJob(long constantTimeMs, long stochasticTimeMs) {
        long sleepTime = (long)(constantTimeMs + Math.random() * stochasticTimeMs);
        
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
