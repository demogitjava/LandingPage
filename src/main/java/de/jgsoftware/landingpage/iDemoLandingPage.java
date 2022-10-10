package de.jgsoftware.landingpage;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZonedDateTime;
//import org.springframework.cloud.config.server.EnableConfigServer;


@SpringBootApplication
//@EnableConfigServer
public interface iDemoLandingPage
{

    public static String st_timezones = "Europe/Berlin";
    static void main(String[] args)
    {
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of(st_timezones));
        //ZonedDateTime now = ZonedDateTime.now();

        // 1. ZonedDateTime to TimeStamp
        Timestamp timestamp = Timestamp.valueOf(now.toLocalDateTime());

        // 2. ZonedDateTime to TimeStamp , no different
        Timestamp timestamp2 = Timestamp.from(now.toInstant());

        System.out.println(now);
        System.out.println(timestamp);
        System.out.println(timestamp2);

        SpringApplication.run(DemoLandingPageApplication.class, args);
    }
}
