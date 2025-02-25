package com.bootcamp.demo.demo_sb_customer.config;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleConfig {

  @Scheduled(cron = "0 40 17 * * MON")
  public void testCronJob() {
    System.out.println("Test Cron Job");
  }

 // @Scheduled(fixedDelay = 4000) // wait 9000 ms
 // public void sayHello() throws Exception {
 //   System.out.println(System.currentTimeMillis());
 //   Thread.sleep(5000);
 //   System.out.println("Hello World");

// }


 // @Scheduled(fixedDelay = 2000) // wait 2000 ms
 // public void sayGoodbye() {
 //   System.out.println("Goodbye");
  
  //  }

 //   @Scheduled(fixedRate = 4000) // 5000 ms
 //   public void sayGoodbye() throws Exception {
 //     System.out.println(System.currentTimeMillis());
 //     Thread.sleep(5000);
 //     System.out.println("ABCD");
    
 //     }
 
}
