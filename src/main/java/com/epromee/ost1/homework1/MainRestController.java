package com.epromee.ost1.homework1;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class MainRestController {

    private HelperService helper;
    private FakeWorkload fwl;

    public MainRestController(
        @Autowired HelperService helper,
        @Autowired FakeWorkload fwl
    ) {
        this.helper = helper;
        this.fwl = fwl;
    }
    
    /* 2 метода, время которых замеряем синхронно с @TrackTime. performFakeJob выдаёт время, за которое он собирается спать. */
    @GetMapping("/resource1")
    @TrackTime
    public String getResource1() {
        fwl.performFakeJob(100, 200);
        return "Resource 1";
    }
    
    @GetMapping("/resource2")
    @TrackTime
    public String getResource2() {
        fwl.performFakeJob(200, 400);
        return "Resource 2";
    }
    
    /* 2 метода, которые запускают асинхронные методы, и их время мы замеряем с @TrackAsyncTime */
    @GetMapping("/asyncResource1")
    public String getAsyncResource1() {
        helper.doHardcoreStuff1();
        return "Async resource 1";
    }

    @GetMapping("/asyncResource2")
    public String getAsyncResource2() {
        helper.doHardcoreStuff2();
        return "Async resource 2";
    }

}
