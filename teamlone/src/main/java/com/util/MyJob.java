package com.util;


import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MyJob implements Job{


	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
       try{
		JobDataMap map=jobExecutionContext.getJobDetail().getJobDataMap();
       String email=map.getString("email");
       String content=map.getString("content");
       String title=map.getString("title");
       final Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
       // �ʼ������Э��
       props.put("mail.transport.protocol", "smtp");
       // ������
       props.put("mail.user", "nanjingpaoyuan@163.com");
       // ���ӵ��ʼ�������
       props.put("mail.host", "smtp.163.com");
       // ����SMTP����ʱ��Ҫ�ṩ������
       props.put("mail.password", "huangjie");
    // ������Ȩ��Ϣ�����ڽ���SMTP���������֤
		Authenticator authenticator=new Authenticator(){
			  @Override
	            protected PasswordAuthentication getPasswordAuthentication() {
	                // �û���������
	                String userName = props.getProperty("mail.user");
	                String password = props.getProperty("mail.password");
	                return new PasswordAuthentication(userName, password);
	            }
		};
		  // ʹ�û������Ժ���Ȩ��Ϣ�������ʼ��Ự
       Session mailSession = Session.getInstance(props, authenticator);
       // �����ʼ���Ϣ
       MimeMessage message = new MimeMessage(mailSession);
       // ���÷�����
       InternetAddress form = new InternetAddress(
               props.getProperty("mail.user"));
       message.setFrom(form);

       // �����ռ���
       InternetAddress to = new InternetAddress(email);
       message.setRecipient(RecipientType.TO, to);
       // �����ʼ�����
       message.setSubject(title);
       // �����ʼ���������
       message.setContent(content,"text/html;charset=UTF-8");
       // �����ʼ�
       Transport.send(message);
       }catch(Exception e){
    	   e.printStackTrace();
       }
    }
}
