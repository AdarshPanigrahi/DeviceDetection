package com.example.DeviceDetection;

import jakarta.servlet.http.HttpServletRequest;
import nl.basjes.parse.useragent.UserAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class MainController {

   @Autowired
   private  UAnalyzer uAnalyzer1;

    @Autowired
    private  UAnalyzer2 uAnalyzer2;

    AtomicInteger count= new AtomicInteger();



//    @Autowired
//    public MainController(List<UserAgentAnalyzer>  userAgentAnalyzers){
    //      this.userAgentAnalyzers = userAgentAnalyzers;
    //       this.executorService = Executors.newFixedThreadPool(10);
//    }

//    @Autowired
//    public MainController(UAnalyzer uAnalyzer) {
//        this.uAnalyzer1=uAnalyzer;
//        this.uAnalyzer2=uAnalyzer;
//
//    }

    @GetMapping("/detectSingleDevice")
    public void deviceData1(HttpServletRequest request, @RequestHeader("userAgent") String userAgent) throws IOException {

        //     int index = (int) (Thread.currentThread().getId() % userAgentAnalyzers.size());
        //     UserAgentAnalyzer userAgentAnalyzer = userAgentAnalyzers.get(0);
        //      System.out.println(userAgentAnalyzers.size());

        if(count.getAndIncrement()%2==0){
            UserAgent agent = uAnalyzer1.analyze(userAgent);
            System.out.println("Device Type: "+ agent.getValue("DeviceClass"));
            System.out.println("Device Name: "+ agent.getValue("DeviceName"));
            System.out.println("Operating System Name: "+ agent.getValue("OperatingSystemName"));
            System.out.println("Agent Type: "+ agent.getValue("AgentClass"));
            System.out.println("Agent Name: "+ agent.getValue("AgentName"));

            System.out.println("\n\n");

        }
        else{
            UserAgent agent = uAnalyzer2.analyze(userAgent);
            System.out.println("Device Type: "+ agent.getValue("DeviceClass"));
            System.out.println("Device Name: "+ agent.getValue("DeviceName"));
            System.out.println("Operating System Name: "+ agent.getValue("OperatingSystemName"));
            System.out.println("Agent Type: "+ agent.getValue("AgentClass"));
            System.out.println("Agent Name: "+ agent.getValue("AgentName"));

            System.out.println("\n\n");
        }
        //       executorService.submit(() -> {

//        });

    }

}
