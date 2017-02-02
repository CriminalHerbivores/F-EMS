package com.uni.fems.mail;

import java.sql.SQLException;

import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import com.uni.fems.dto.StdntVO;
import com.uni.fems.service.ProfsrService;
import com.uni.fems.service.SklstfService;
import com.uni.fems.service.StdntService;

public class SimpleRegistrationNotifier{	
	
	private StdntService studentSvc;
	private ProfsrService professorSvc;
	private SklstfService StaffSvc;
	
	private MailSender mailSender;
	
	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}
	public void setStudentSvc(StdntService studentSvc) {
		this.studentSvc = studentSvc;
	}
	public void setProfessorSvc(ProfsrService professorSvc) {
		this.professorSvc = professorSvc;
	}
	public void setStaffSvc(SklstfService staffSvc) {
		StaffSvc = staffSvc;
	}
	
	public void sendMail(MailRequest mailReq) {
		SimpleMailMessage message = new SimpleMailMessage();
		for(String userid:mailReq.getUserid()){
			StdntVO stdnt=null;
//			try {
//				stdnt = studentSvc.getStdnt(userid); //메소드 필요
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
			message.setSubject(mailReq.getTitle());
			message.setFrom("보내는사람메일주소"); //보내는 사람 메일 주소
			message.setText(mailReq.getMessage());
			message.setTo(stdnt.getSt_Email());
			try {
				mailSender.send(message);
			} catch (MailException ex) {
				ex.printStackTrace();
			}
		}
	}
}
