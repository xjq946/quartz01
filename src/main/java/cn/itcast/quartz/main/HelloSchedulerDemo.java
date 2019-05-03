package cn.itcast.quartz.main;

import cn.itcast.quartz.job.HelloJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class HelloSchedulerDemo {

    public static void main(String[] args) throws SchedulerException {
        //1:调度器（Scheduler）
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        //2:任务实例（JobDetail）
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
                .withIdentity("job1", "group1")
                .usingJobData("message","打印日志")
                .build();
        //3:触发器（Trigger）
        SimpleTrigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "group1")
                .startNow()//马上启动触发器
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().repeatSecondlyForever(5))
                .usingJobData("message","simple触发器")
                .build();
        scheduler.scheduleJob(jobDetail,trigger);

        //启动
        scheduler.start();
    }
}
