package cn.itcast.quartz.job;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HelloJob implements Job {

    public HelloJob() {
        System.out.println("欢迎访问HelloJob");
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext)
            throws JobExecutionException {
        //从JobDetail对象中获取jobDataMap的数据
        JobDataMap dataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        String jobDataMessage = dataMap.getString("message");
        System.out.println("jobDataMessage:"+jobDataMessage);
        //从Trigger对象中获取jobDataMap的数据
        JobDataMap triggerDataMap = jobExecutionContext.getTrigger().getJobDataMap();
        String triggerDateMessage = triggerDataMap.getString("message");
        System.out.println("triggerDateMessage:"+triggerDateMessage);


        //输出当前时间
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dataString = sdf.format(date);
        System.out.println("正在进行数据库的备份工作，备份数据库的时间是:"+dataString);
    }
}
