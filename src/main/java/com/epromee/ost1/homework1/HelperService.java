package com.epromee.ost1.homework1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelperService {

    private FakeWorkload fwl;

    public HelperService(
        @Autowired FakeWorkload fwl
    ) {
        this.fwl = fwl;
    }

    @TrackAsyncTime
    public void doHardcoreStuff1() {
        fwl.performFakeJob(1000, 2000);
    }

    @TrackAsyncTime
    public void doHardcoreStuff2() {
        fwl.performFakeJob(2000, 4000);
    }
}
