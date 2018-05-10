package com.email;
import java.security.GeneralSecurityException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.bean.Emailsend;
import com.sun.mail.util.MailSSLSocketFactory;

public class JavaEmailSender {
public static void sendEmail(Emailsend e) throws GeneralSecurityException, MessagingException {

	Properties pro = new Properties();
	//开启debug调试
	pro.setProperty("mail.debug","true");
	//发送服务器需要身份验证
	pro.setProperty("mail.smtp.auth","true");
	//设置邮件服务器主机名
	pro.setProperty("mail.host","smtp.qq.com");
	//发送邮件协议名称
	pro.setProperty("mail.transport.protocol","smtp");
	
	/**SSL认证，注意腾讯邮箱是基于SSL加密的，所有需要开启才可以使用**/
	MailSSLSocketFactory mf;
	try {
		mf = new MailSSLSocketFactory();
	
     mf.setTrustAllHosts(true);
     pro.put("mail.smtp.ssl.enable", "true");
     pro.put("mail.smtp.ssl.socketFactory",mf);
     
     //创建会话
     Session session = Session.getInstance(pro);
     
     //发送的消息，基于观察者模式进行设计的
     Message msg = new MimeMessage(session);
	msg.setSubject(e.getTitle());
	
     //使用stringBuilder，因为stringBuilder加载速度会比string
	StringBuilder builder = new StringBuilder();
	builder.append("\n"+e.getContent());
	builder.append("\n时间"+new Date());
	msg.setText(builder.toString());
	msg.setFrom(new InternetAddress("1553920465@qq.com"));

	Transport transport = session.getTransport();
	transport.connect("smtp.qq.com", "1553920465@qq.com","jmaazijhodueicaa");
	//发送消息
	transport.sendMessage(msg, new Address[]{new InternetAddress(e.getEmail())});
	transport.close();
	} catch (Exception es) {
		es.printStackTrace();
	}
}


}
