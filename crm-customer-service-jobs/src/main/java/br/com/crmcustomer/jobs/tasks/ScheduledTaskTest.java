package br.com.crmcustomer.jobs.tasks;

import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.inject.Named;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Log4j2
@Named
public class ScheduledTaskTest {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void testScheduleTask(){
        log.info(dateFormat.format(new Date()));
    }
}
