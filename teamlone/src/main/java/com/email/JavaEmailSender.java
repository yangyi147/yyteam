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
	//����debug����
	pro.setProperty("mail.debug","true");
	//���ͷ�������Ҫ�����֤
	pro.setProperty("mail.smtp.auth","true");
	//�����ʼ�������������
	pro.setProperty("mail.host","smtp.qq.com");
	//�����ʼ�Э������
	pro.setProperty("mail.transport.protocol","smtp");
	
	/**SSL��֤��ע����Ѷ�����ǻ���SSL���ܵģ�������Ҫ�����ſ���ʹ��**/
	MailSSLSocketFactory mf;
	try {
		mf = new MailSSLSocketFactory();
	
     mf.setTrustAllHosts(true);
     pro.put("mail.smtp.ssl.enable", "true");
     pro.put("mail.smtp.ssl.socketFactory",mf);
     
     //�����Ự
     Session session = Session.getInstance(pro);
     
     //���͵���Ϣ�����ڹ۲���ģʽ������Ƶ�
     Message msg = new MimeMessage(session);
	msg.setSubject(e.getTitle());
	
     //ʹ��stringBuilder����ΪstringBuilder�����ٶȻ��string
	StringBuilder builder = new StringBuilder();
	builder.append("\n"+e.getContent());
	builder.append("\nʱ��"+new Date());
	msg.setText(builder.toString());
	msg.setFrom(new InternetAddress("1553920465@qq.com"));

	Transport transport = session.getTransport();
	transport.connect("smtp.qq.com", "1553920465@qq.com","jmaazijhodueicaa");
	//������Ϣ
	transport.sendMessage(msg, new Address[]{new InternetAddress(e.getEmail())});
	transport.close();
	} catch (Exception es) {
		es.printStackTrace();
	}
}


}
