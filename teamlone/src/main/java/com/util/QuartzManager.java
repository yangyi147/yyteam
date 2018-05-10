package com.util;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzManager {

	 private static SchedulerFactory schedulerFactory = new StdSchedulerFactory();  

	    /** 
	     * @Description: ���һ����ʱ���� 
	     *  
	     * @param jobName ������ 
	     * @param jobGroupName  �������� 
	     * @param triggerName �������� 
	     * @param triggerGroupName ���������� 
	     * @param jobClass  ���� 
	     * @param cron   ʱ�����ã��ο�quartz˵���ĵ�  
	     */  
	    @SuppressWarnings({ "unchecked", "rawtypes" })  
	    public static void addJob(String jobName, String jobGroupName, 
	            String triggerName, String triggerGroupName, JobDetail jobDetail, String cron) {  
	        try {  
	            Scheduler sched = schedulerFactory.getScheduler();  
	            // �������������飬����ִ����
	            //JobDetail jobDetail= JobBuilder.newJob(jobClass).withIdentity(jobName, jobGroupName).build();

	            // ������  
	            TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
	            // ��������,��������  
	            triggerBuilder.withIdentity(triggerName, triggerGroupName);
	            triggerBuilder.startNow();
	            // ������ʱ���趨  
	            triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(cron));
	            // ����Trigger����
	            CronTrigger trigger = (CronTrigger) triggerBuilder.build();

	            // ������������JobDetail��Trigger
	            sched.scheduleJob(jobDetail, trigger);  

	            // ����  
	            if (!sched.isShutdown()) {  
	                sched.start();  
	            }  
	        } catch (Exception e) {  
	            throw new RuntimeException(e);  
	        }  
	    }  

	    /** 
	     * @Description: �޸�һ������Ĵ���ʱ��
	     *  
	     * @param jobName 
	     * @param jobGroupName
	     * @param triggerName ��������
	     * @param triggerGroupName ���������� 
	     * @param cron   ʱ�����ã��ο�quartz˵���ĵ�   
	     */  
	    public static void modifyJobTime(String jobName, 
	            String jobGroupName, String triggerName, String triggerGroupName, String cron) {  
	        try {  
	            Scheduler sched = schedulerFactory.getScheduler();  
	            TriggerKey triggerKey = TriggerKey.triggerKey(triggerName, triggerGroupName);
	            CronTrigger trigger = (CronTrigger) sched.getTrigger(triggerKey);  
	            if (trigger == null) {  
	                return;  
	            }  

	            String oldTime = trigger.getCronExpression();  
	            if (!oldTime.equalsIgnoreCase(cron)) { 
	                /** ��ʽһ ������ rescheduleJob ��ʼ */
	                // ������  
	                TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
	                // ��������,��������  
	                triggerBuilder.withIdentity(triggerName, triggerGroupName);
	                triggerBuilder.startNow();
	                // ������ʱ���趨  
	                triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(cron));
	                // ����Trigger����
	                trigger = (CronTrigger) triggerBuilder.build();
	                // ��ʽһ ���޸�һ������Ĵ���ʱ��
	                sched.rescheduleJob(triggerKey, trigger);
	                /** ��ʽһ ������ rescheduleJob ���� */

	                /** ��ʽ������ɾ����Ȼ���ڴ���һ���µ�Job  */
	                //JobDetail jobDetail = sched.getJobDetail(JobKey.jobKey(jobName, jobGroupName));  
	                //Class<? extends Job> jobClass = jobDetail.getJobClass();  
	                //removeJob(jobName, jobGroupName, triggerName, triggerGroupName);  
	                //addJob(jobName, jobGroupName, triggerName, triggerGroupName, jobClass, cron); 
	                /** ��ʽ�� ����ɾ����Ȼ���ڴ���һ���µ�Job */
	            }  
	        } catch (Exception e) {  
	            throw new RuntimeException(e);  
	        }  
	    }  

	    /** 
	     * @Description: �Ƴ�һ������ 
	     *  
	     * @param jobName 
	     * @param jobGroupName 
	     * @param triggerName 
	     * @param triggerGroupName 
	     */  
	    public static void removeJob(String jobName, String jobGroupName,  
	            String triggerName, String triggerGroupName) {  
	        try {  
	            Scheduler sched = schedulerFactory.getScheduler();  

	            TriggerKey triggerKey = TriggerKey.triggerKey(triggerName, triggerGroupName);

	            sched.pauseTrigger(triggerKey);// ֹͣ������  
	            sched.unscheduleJob(triggerKey);// �Ƴ�������  
	            sched.deleteJob(JobKey.jobKey(jobName, jobGroupName));// ɾ������  
	        } catch (Exception e) {  
	            throw new RuntimeException(e);  
	        }  
	    }  

	    /** 
	     * @Description:�������ж�ʱ���� 
	     */  
	    public static void startJobs() {  
	        try {  
	            Scheduler sched = schedulerFactory.getScheduler();  
	            sched.start();  
	        } catch (Exception e) {  
	            throw new RuntimeException(e);  
	        }  
	    }  

	    /** 
	     * @Description:�ر����ж�ʱ���� 
	     */  
	    public static void shutdownJobs() {  
	        try {  
	            Scheduler sched = schedulerFactory.getScheduler();  
	            if (!sched.isShutdown()) {  
	                sched.shutdown();  
	            }  
	        } catch (Exception e) {  
	            throw new RuntimeException(e);  
	        }  
	    }  
}
