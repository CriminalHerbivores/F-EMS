package com.uni.fems.common;

import java.util.Calendar;
import java.util.HashMap;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.annotation.Resource;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;

import com.uni.fems.dto.request.MessageRequest;
import com.uni.fems.sms.Coolsms;

/**
 * <pre>
 * 공용 기능을 모아둔 메서드
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
/**
 * @author rlawl
 *
 */
public class Supporter {
	
	/**
	 * <pre>
	 * 이메일을 전송
	 * 
	 * 컨트롤러 단 혹은 사용하려는 곳에서 
	 * @Autowired
	 * private MailSender mailSender;
	 * 선언 한 후 주입 필요
	 * 
	 * IndexController 참고
	 * </pre>
	 * <pre>
	 * @param msgCom
	 * @return
	 * </pre>
	 */
	public void sendMail(MailSender mailSender,MessageRequest msg){
		JavaMailSender jmailSender = (JavaMailSender) mailSender;
		MimeMessage message = jmailSender.createMimeMessage();
		try{
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "utf-8");
			messageHelper.setSubject(msg.getTitle());
			String htmlContent = msg.getContent();
			messageHelper.setText(htmlContent,true);
			messageHelper.setFrom(msg.getMng_Email(),msg.getMng_Univ_Nm());
			messageHelper.setTo(new InternetAddress(msg.getEmail(),"utf-8"));
			
			if(msg.getFilePath()!=null && msg.getFilePath()!=""){
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
	/**
	 * <pre>
	 * 반환받은 배열의 
	 * 0번째는 현재년도
	 * 1번째는 현재월
	 * 2번째는 현재일
	 * 3번쨰는 현재학기
	 * </pre>
	 * <pre>
	 * @return
	 * </pre>
	 */
	public int[] getDay(){
		Calendar c = Calendar.getInstance();
		int[] uDay = new int[4];
		uDay[0] = c.get(Calendar.YEAR);
		uDay[1] = c.get(Calendar.MONTH);
		uDay[2] = c.get(Calendar.DATE);
		
		// 1~6월은 1학기
		// 7~12월은 2학기
		if(uDay[1]<7){
			uDay[3] = 1;
		}else{
			uDay[3] = 2;
		}
		return uDay;
	}
	
	
	/**
	 * <pre>
	 * 전송할 문자의 내용화 받는 발신자의 번호를 입력받아 문자 메시지를 전송해준다.
	 * </pre>
	 * <pre>
	 * @param message
	 * @param hp
	 * </pre>
	 */
	public void smsSend(String message, String hp){
    	
    	String api_key = "NCS5880CE7517EC8";
        String api_secret = "C9684A6058C858F7BCF422DC8FB64C75";
        Coolsms coolsms = new Coolsms(api_key, api_secret);
    
        HashMap<String, String> set = new HashMap<String, String>();
        set.put("to", hp); // 수신번호
        set.put("from", "01074571287"); // 발신번호 
        set.put("text", message); // 문자내용
        set.put("type", "sms"); // 문자 타입

        JSONObject result = coolsms.send(set); // 보내기
        
    }
}
