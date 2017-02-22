package com.uni.fems.controller.common;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.annotation.Resource;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;

import com.uni.fems.dto.request.MessageRequest;

/**
 * <pre>
 * 메일을 보내기 위한 메소드를 작성해둔 클래스
 * </pre>
 * @author JAR
 * @since 2017. 2. 22.
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일                          수정자               수정내용
 * --------     --------    ----------------------
 * 2017. 2. 22.      JAR       최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
@Controller
public class SendMail {
	@Resource(name = "mailSender")
	private MailSender mailSender;
	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	/**
	 * <pre>
	 * 이메일을 전송
	 * </pre>
	 * <pre>
	 * @param msgCom
	 * @return
	 * </pre>
	 */
	public void sendMail(MessageRequest msg){
		JavaMailSender jmailSender = (JavaMailSender) mailSender;
		
		MimeMessage message = jmailSender.createMimeMessage();
		try{
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "utf-8");
			messageHelper.setSubject(msg.getTitle());
			String htmlContent = msg.getContent();
			messageHelper.setText(htmlContent,true);
			messageHelper.setFrom(msg.getMng_Email(),msg.getMng_Univ_Nm());
			messageHelper.setTo(new InternetAddress(msg.getEmail(),"utf-8"));
			
			if(!msg.getFilePath().isEmpty()){
			DataSource dataSource = new FileDataSource(msg.getFilePath());
			messageHelper.addAttachment(
					MimeUtility.encodeText(msg.getFilePath(),"utf-8","B"),dataSource);
			}
		}catch(Throwable e){
			e.printStackTrace();
		}
		try{
			jmailSender.send(message);
		}catch(MailException e){
			e.printStackTrace();
		}
	}
	
}
