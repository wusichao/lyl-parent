package org.lyl.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


/**
 * @author juny.ye
 */
@Component
public class SimpleTask {
	@Scheduled(cron = "*/1 * * * * ?")
	public void test(){
		System.out.println("定时任务,每秒执行一次");
	}

}
