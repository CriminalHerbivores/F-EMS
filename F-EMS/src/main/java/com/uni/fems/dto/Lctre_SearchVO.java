package com.uni.fems.dto;

import java.sql.Timestamp;

public class Lctre_SearchVO {
	
	// 건물 BUILDING
	private String bd_No;   // 건물 번호
	private String bd_Nm;   // 건물명
	private String bd_useyn;   // 건물 사용유무
	
	// 강의실 LCTRUM
	private String lr_Lctrum_No;   // 강의실 번호
	private String lr_Bd_No;   // 건물 번호
	private int lr_Floor;   // 층수
	private int lr_Roomno;   // 호실
	private int lr_Accept_Nmpr;   // 수용인원
	private String lr_useyn;   // 건물 사용유무
	
	// 강의 LCTRE
	private int lc_Lctre_No;   // 강의번호
	private String lc_Profsr_No;   // 교수번호
	private String lc_Lctre_Code;   // 강의코드
	private Timestamp lc_Lctrbgn_Dt;   // 강의개강일
	private int lc_Lctre_Nmpr;   // 강의 인원
	private String lc_Wik_Lctre_Dayweek;   // 주간 강의 요일
	private String lc_Lctre_Time;   // 강의 시간
	private String lc_Pnt;   // 학점
	private String lc_Grade;   // 학년
	private String lc_Lctrum_No;   // 강의실 번호
	private String lc_Open_At;   // 개설여부
	private String lc_Lctre_Org;   // 강의 원본
	private String lc_Lctre_Evl_Score;   // 강의 평가 점수
	private String lc_Split;   // 분반
	
	// 강의계획서 LCTRE_ACTPLN
	private int la_Lctre_No;   // 강의번호
	private String la_Main_Txtbook;   // 주교재
	private String la_Sub_Txtbook;   // 부교재
	private String la_Lctre_Goal;   // 강의목표
	private String la_Lctre_Progrs_Form;   // 강의진행형태
	private String la_Midex;   // 중간고사
	private String la_Fnex;   // 기말고사
	private String la_Indvdl_Task;   // 개인과제
	private String la_Team_Task;   // 팀별과제
	private String la_Presnatn;   // 발표
	private String la_Atend;   // 출석
	private String la_Attd;   // 태도
	
	// 강의고유번호 LCTRE_UNQ_NO
	private String Lu_Lctre_Code;   // 강의 코드
	private String Lu_Lctre_Nm;   // 강의명
	private String Lu_Pnt;   // 학점
	private String Lu_Compl_Se;   // 이수구분
	private String Lu_Presubjct;   // 선수과목
	
	// 관심목록 INTRST_LIST
	private String in_Stdnt_No;   // 학생번호
	private int in_Lctre_No;   // 강의번호
	
	// 교수 PROFSR
	private String pr_Profsr_No;   // 교수 번호
	private String pr_Pw;   // 비밀번호
	private String pr_Nm;   // 이름
	private String pr_Eng_Nm;   // 영문 이름
	private String pr_Ihidnum;   // 주민번호
	private String pr_Moblphon_No;   // 핸드폰 번호
	private String pr_House_Tlphon_No;   // 집 전화번호
	private String pr_Profsr_Tlphon_No;   // 교수 전화번호
	private String pr_Post_No;   // 우편 번호
	private String pr_Adres1;   // 주소1
	private String pr_Adres2;   // 주소2
	private String pr_Email;   // 이메일
	
	// 교수학과배정 PROFSR_SUBJCT_ASNM
	private String psa_Code;   // 교수학과배정코드
	private String psa_Subjct_Code;   // 학과코드
	private String psa_Profsr_No;   // 교수번호
	private Timestamp psa_Dt;   // 배정일
	
	// 학과정보테이블 SUBJCT_INFO_TABLE
	private String sit_Subjct_Code;   // 학과 코드
	private String sit_Faculty;   // 학부
	private String sit_Subjct;   // 학과
	private int sit_Tut;   // 등록금 금액
	private String sit_useyn;   // 학과 사용유무
	
	// 학부 FACULTY
	private String fc_Faculty_Code;   // 학부코드
	private String fc_Coleg_Code;   // 단과대학코드
	private String fc_Faculty_Nm;   // 학부명
	private String fc_useyn;   // 학부 사용유무
	
	// 단과대학 COLEGE
	private String coleg_Code;   // 단과대학코드
	private String coleg_Nm;   // 단과대학명
	private String coleg_useyn;   // 단과대학 사용유무
	public String getBd_No() {
		return bd_No;
	}
	public void setBd_No(String bd_No) {
		this.bd_No = bd_No;
	}
	public String getBd_Nm() {
		return bd_Nm;
	}
	public void setBd_Nm(String bd_Nm) {
		this.bd_Nm = bd_Nm;
	}
	public String getBd_useyn() {
		return bd_useyn;
	}
	public void setBd_useyn(String bd_useyn) {
		this.bd_useyn = bd_useyn;
	}
	public String getLr_Lctrum_No() {
		return lr_Lctrum_No;
	}
	public void setLr_Lctrum_No(String lr_Lctrum_No) {
		this.lr_Lctrum_No = lr_Lctrum_No;
	}
	public String getLr_Bd_No() {
		return lr_Bd_No;
	}
	public void setLr_Bd_No(String lr_Bd_No) {
		this.lr_Bd_No = lr_Bd_No;
	}
	public int getLr_Floor() {
		return lr_Floor;
	}
	public void setLr_Floor(int lr_Floor) {
		this.lr_Floor = lr_Floor;
	}
	public int getLr_Roomno() {
		return lr_Roomno;
	}
	public void setLr_Roomno(int lr_Roomno) {
		this.lr_Roomno = lr_Roomno;
	}
	public int getLr_Accept_Nmpr() {
		return lr_Accept_Nmpr;
	}
	public void setLr_Accept_Nmpr(int lr_Accept_Nmpr) {
		this.lr_Accept_Nmpr = lr_Accept_Nmpr;
	}
	public String getLr_useyn() {
		return lr_useyn;
	}
	public void setLr_useyn(String lr_useyn) {
		this.lr_useyn = lr_useyn;
	}
	public int getLc_Lctre_No() {
		return lc_Lctre_No;
	}
	public void setLc_Lctre_No(int lc_Lctre_No) {
		this.lc_Lctre_No = lc_Lctre_No;
	}
	public String getLc_Profsr_No() {
		return lc_Profsr_No;
	}
	public void setLc_Profsr_No(String lc_Profsr_No) {
		this.lc_Profsr_No = lc_Profsr_No;
	}
	public String getLc_Lctre_Code() {
		return lc_Lctre_Code;
	}
	public void setLc_Lctre_Code(String lc_Lctre_Code) {
		this.lc_Lctre_Code = lc_Lctre_Code;
	}
	public Timestamp getLc_Lctrbgn_Dt() {
		return lc_Lctrbgn_Dt;
	}
	public void setLc_Lctrbgn_Dt(Timestamp lc_Lctrbgn_Dt) {
		this.lc_Lctrbgn_Dt = lc_Lctrbgn_Dt;
	}
	public int getLc_Lctre_Nmpr() {
		return lc_Lctre_Nmpr;
	}
	public void setLc_Lctre_Nmpr(int lc_Lctre_Nmpr) {
		this.lc_Lctre_Nmpr = lc_Lctre_Nmpr;
	}
	public String getLc_Wik_Lctre_Dayweek() {
		return lc_Wik_Lctre_Dayweek;
	}
	public void setLc_Wik_Lctre_Dayweek(String lc_Wik_Lctre_Dayweek) {
		this.lc_Wik_Lctre_Dayweek = lc_Wik_Lctre_Dayweek;
	}
	public String getLc_Lctre_Time() {
		return lc_Lctre_Time;
	}
	public void setLc_Lctre_Time(String lc_Lctre_Time) {
		this.lc_Lctre_Time = lc_Lctre_Time;
	}
	public String getLc_Pnt() {
		return lc_Pnt;
	}
	public void setLc_Pnt(String lc_Pnt) {
		this.lc_Pnt = lc_Pnt;
	}
	public String getLc_Grade() {
		return lc_Grade;
	}
	public void setLc_Grade(String lc_Grade) {
		this.lc_Grade = lc_Grade;
	}
	public String getLc_Lctrum_No() {
		return lc_Lctrum_No;
	}
	public void setLc_Lctrum_No(String lc_Lctrum_No) {
		this.lc_Lctrum_No = lc_Lctrum_No;
	}
	public String getLc_Open_At() {
		return lc_Open_At;
	}
	public void setLc_Open_At(String lc_Open_At) {
		this.lc_Open_At = lc_Open_At;
	}
	public String getLc_Lctre_Org() {
		return lc_Lctre_Org;
	}
	public void setLc_Lctre_Org(String lc_Lctre_Org) {
		this.lc_Lctre_Org = lc_Lctre_Org;
	}
	public String getLc_Lctre_Evl_Score() {
		return lc_Lctre_Evl_Score;
	}
	public void setLc_Lctre_Evl_Score(String lc_Lctre_Evl_Score) {
		this.lc_Lctre_Evl_Score = lc_Lctre_Evl_Score;
	}
	public String getLc_Split() {
		return lc_Split;
	}
	public void setLc_Split(String lc_Split) {
		this.lc_Split = lc_Split;
	}
	public int getLa_Lctre_No() {
		return la_Lctre_No;
	}
	public void setLa_Lctre_No(int la_Lctre_No) {
		this.la_Lctre_No = la_Lctre_No;
	}
	public String getLa_Main_Txtbook() {
		return la_Main_Txtbook;
	}
	public void setLa_Main_Txtbook(String la_Main_Txtbook) {
		this.la_Main_Txtbook = la_Main_Txtbook;
	}
	public String getLa_Sub_Txtbook() {
		return la_Sub_Txtbook;
	}
	public void setLa_Sub_Txtbook(String la_Sub_Txtbook) {
		this.la_Sub_Txtbook = la_Sub_Txtbook;
	}
	public String getLa_Lctre_Goal() {
		return la_Lctre_Goal;
	}
	public void setLa_Lctre_Goal(String la_Lctre_Goal) {
		this.la_Lctre_Goal = la_Lctre_Goal;
	}
	public String getLa_Lctre_Progrs_Form() {
		return la_Lctre_Progrs_Form;
	}
	public void setLa_Lctre_Progrs_Form(String la_Lctre_Progrs_Form) {
		this.la_Lctre_Progrs_Form = la_Lctre_Progrs_Form;
	}
	public String getLa_Midex() {
		return la_Midex;
	}
	public void setLa_Midex(String la_Midex) {
		this.la_Midex = la_Midex;
	}
	public String getLa_Fnex() {
		return la_Fnex;
	}
	public void setLa_Fnex(String la_Fnex) {
		this.la_Fnex = la_Fnex;
	}
	public String getLa_Indvdl_Task() {
		return la_Indvdl_Task;
	}
	public void setLa_Indvdl_Task(String la_Indvdl_Task) {
		this.la_Indvdl_Task = la_Indvdl_Task;
	}
	public String getLa_Team_Task() {
		return la_Team_Task;
	}
	public void setLa_Team_Task(String la_Team_Task) {
		this.la_Team_Task = la_Team_Task;
	}
	public String getLa_Presnatn() {
		return la_Presnatn;
	}
	public void setLa_Presnatn(String la_Presnatn) {
		this.la_Presnatn = la_Presnatn;
	}
	public String getLa_Atend() {
		return la_Atend;
	}
	public void setLa_Atend(String la_Atend) {
		this.la_Atend = la_Atend;
	}
	public String getLa_Attd() {
		return la_Attd;
	}
	public void setLa_Attd(String la_Attd) {
		this.la_Attd = la_Attd;
	}
	public String getLu_Lctre_Code() {
		return Lu_Lctre_Code;
	}
	public void setLu_Lctre_Code(String lu_Lctre_Code) {
		Lu_Lctre_Code = lu_Lctre_Code;
	}
	public String getLu_Lctre_Nm() {
		return Lu_Lctre_Nm;
	}
	public void setLu_Lctre_Nm(String lu_Lctre_Nm) {
		Lu_Lctre_Nm = lu_Lctre_Nm;
	}
	public String getLu_Pnt() {
		return Lu_Pnt;
	}
	public void setLu_Pnt(String lu_Pnt) {
		Lu_Pnt = lu_Pnt;
	}
	public String getLu_Compl_Se() {
		return Lu_Compl_Se;
	}
	public void setLu_Compl_Se(String lu_Compl_Se) {
		Lu_Compl_Se = lu_Compl_Se;
	}
	public String getLu_Presubjct() {
		return Lu_Presubjct;
	}
	public void setLu_Presubjct(String lu_Presubjct) {
		Lu_Presubjct = lu_Presubjct;
	}
	public String getIn_Stdnt_No() {
		return in_Stdnt_No;
	}
	public void setIn_Stdnt_No(String in_Stdnt_No) {
		this.in_Stdnt_No = in_Stdnt_No;
	}
	public int getIn_Lctre_No() {
		return in_Lctre_No;
	}
	public void setIn_Lctre_No(int in_Lctre_No) {
		this.in_Lctre_No = in_Lctre_No;
	}
	public String getPr_Profsr_No() {
		return pr_Profsr_No;
	}
	public void setPr_Profsr_No(String pr_Profsr_No) {
		this.pr_Profsr_No = pr_Profsr_No;
	}
	public String getPr_Pw() {
		return pr_Pw;
	}
	public void setPr_Pw(String pr_Pw) {
		this.pr_Pw = pr_Pw;
	}
	public String getPr_Nm() {
		return pr_Nm;
	}
	public void setPr_Nm(String pr_Nm) {
		this.pr_Nm = pr_Nm;
	}
	public String getPr_Eng_Nm() {
		return pr_Eng_Nm;
	}
	public void setPr_Eng_Nm(String pr_Eng_Nm) {
		this.pr_Eng_Nm = pr_Eng_Nm;
	}
	public String getPr_Ihidnum() {
		return pr_Ihidnum;
	}
	public void setPr_Ihidnum(String pr_Ihidnum) {
		this.pr_Ihidnum = pr_Ihidnum;
	}
	public String getPr_Moblphon_No() {
		return pr_Moblphon_No;
	}
	public void setPr_Moblphon_No(String pr_Moblphon_No) {
		this.pr_Moblphon_No = pr_Moblphon_No;
	}
	public String getPr_House_Tlphon_No() {
		return pr_House_Tlphon_No;
	}
	public void setPr_House_Tlphon_No(String pr_House_Tlphon_No) {
		this.pr_House_Tlphon_No = pr_House_Tlphon_No;
	}
	public String getPr_Profsr_Tlphon_No() {
		return pr_Profsr_Tlphon_No;
	}
	public void setPr_Profsr_Tlphon_No(String pr_Profsr_Tlphon_No) {
		this.pr_Profsr_Tlphon_No = pr_Profsr_Tlphon_No;
	}
	public String getPr_Post_No() {
		return pr_Post_No;
	}
	public void setPr_Post_No(String pr_Post_No) {
		this.pr_Post_No = pr_Post_No;
	}
	public String getPr_Adres1() {
		return pr_Adres1;
	}
	public void setPr_Adres1(String pr_Adres1) {
		this.pr_Adres1 = pr_Adres1;
	}
	public String getPr_Adres2() {
		return pr_Adres2;
	}
	public void setPr_Adres2(String pr_Adres2) {
		this.pr_Adres2 = pr_Adres2;
	}
	public String getPr_Email() {
		return pr_Email;
	}
	public void setPr_Email(String pr_Email) {
		this.pr_Email = pr_Email;
	}
	public String getPsa_Code() {
		return psa_Code;
	}
	public void setPsa_Code(String psa_Code) {
		this.psa_Code = psa_Code;
	}
	public String getPsa_Subjct_Code() {
		return psa_Subjct_Code;
	}
	public void setPsa_Subjct_Code(String psa_Subjct_Code) {
		this.psa_Subjct_Code = psa_Subjct_Code;
	}
	public String getPsa_Profsr_No() {
		return psa_Profsr_No;
	}
	public void setPsa_Profsr_No(String psa_Profsr_No) {
		this.psa_Profsr_No = psa_Profsr_No;
	}
	public Timestamp getPsa_Dt() {
		return psa_Dt;
	}
	public void setPsa_Dt(Timestamp psa_Dt) {
		this.psa_Dt = psa_Dt;
	}
	public String getSit_Subjct_Code() {
		return sit_Subjct_Code;
	}
	public void setSit_Subjct_Code(String sit_Subjct_Code) {
		this.sit_Subjct_Code = sit_Subjct_Code;
	}
	public String getSit_Faculty() {
		return sit_Faculty;
	}
	public void setSit_Faculty(String sit_Faculty) {
		this.sit_Faculty = sit_Faculty;
	}
	public String getSit_Subjct() {
		return sit_Subjct;
	}
	public void setSit_Subjct(String sit_Subjct) {
		this.sit_Subjct = sit_Subjct;
	}
	public int getSit_Tut() {
		return sit_Tut;
	}
	public void setSit_Tut(int sit_Tut) {
		this.sit_Tut = sit_Tut;
	}
	public String getSit_useyn() {
		return sit_useyn;
	}
	public void setSit_useyn(String sit_useyn) {
		this.sit_useyn = sit_useyn;
	}
	public String getFc_Faculty_Code() {
		return fc_Faculty_Code;
	}
	public void setFc_Faculty_Code(String fc_Faculty_Code) {
		this.fc_Faculty_Code = fc_Faculty_Code;
	}
	public String getFc_Coleg_Code() {
		return fc_Coleg_Code;
	}
	public void setFc_Coleg_Code(String fc_Coleg_Code) {
		this.fc_Coleg_Code = fc_Coleg_Code;
	}
	public String getFc_Faculty_Nm() {
		return fc_Faculty_Nm;
	}
	public void setFc_Faculty_Nm(String fc_Faculty_Nm) {
		this.fc_Faculty_Nm = fc_Faculty_Nm;
	}
	public String getFc_useyn() {
		return fc_useyn;
	}
	public void setFc_useyn(String fc_useyn) {
		this.fc_useyn = fc_useyn;
	}
	public String getColeg_Code() {
		return coleg_Code;
	}
	public void setColeg_Code(String coleg_Code) {
		this.coleg_Code = coleg_Code;
	}
	public String getColeg_Nm() {
		return coleg_Nm;
	}
	public void setColeg_Nm(String coleg_Nm) {
		this.coleg_Nm = coleg_Nm;
	}
	public String getColeg_useyn() {
		return coleg_useyn;
	}
	public void setColeg_useyn(String coleg_useyn) {
		this.coleg_useyn = coleg_useyn;
	}
	@Override
	public String toString() {
		return "Lctre_SearchVO [bd_No=" + bd_No + ", bd_Nm=" + bd_Nm
				+ ", bd_useyn=" + bd_useyn + ", lr_Lctrum_No=" + lr_Lctrum_No
				+ ", lr_Bd_No=" + lr_Bd_No + ", lr_Floor=" + lr_Floor
				+ ", lr_Roomno=" + lr_Roomno + ", lr_Accept_Nmpr="
				+ lr_Accept_Nmpr + ", lr_useyn=" + lr_useyn + ", lc_Lctre_No="
				+ lc_Lctre_No + ", lc_Profsr_No=" + lc_Profsr_No
				+ ", lc_Lctre_Code=" + lc_Lctre_Code + ", lc_Lctrbgn_Dt="
				+ lc_Lctrbgn_Dt + ", lc_Lctre_Nmpr=" + lc_Lctre_Nmpr
				+ ", lc_Wik_Lctre_Dayweek=" + lc_Wik_Lctre_Dayweek
				+ ", lc_Lctre_Time=" + lc_Lctre_Time + ", lc_Pnt=" + lc_Pnt
				+ ", lc_Grade=" + lc_Grade + ", lc_Lctrum_No=" + lc_Lctrum_No
				+ ", lc_Open_At=" + lc_Open_At + ", lc_Lctre_Org="
				+ lc_Lctre_Org + ", lc_Lctre_Evl_Score=" + lc_Lctre_Evl_Score
				+ ", lc_Split=" + lc_Split + ", la_Lctre_No=" + la_Lctre_No
				+ ", la_Main_Txtbook=" + la_Main_Txtbook + ", la_Sub_Txtbook="
				+ la_Sub_Txtbook + ", la_Lctre_Goal=" + la_Lctre_Goal
				+ ", la_Lctre_Progrs_Form=" + la_Lctre_Progrs_Form
				+ ", la_Midex=" + la_Midex + ", la_Fnex=" + la_Fnex
				+ ", la_Indvdl_Task=" + la_Indvdl_Task + ", la_Team_Task="
				+ la_Team_Task + ", la_Presnatn=" + la_Presnatn + ", la_Atend="
				+ la_Atend + ", la_Attd=" + la_Attd + ", Lu_Lctre_Code="
				+ Lu_Lctre_Code + ", Lu_Lctre_Nm=" + Lu_Lctre_Nm + ", Lu_Pnt="
				+ Lu_Pnt + ", Lu_Compl_Se=" + Lu_Compl_Se + ", Lu_Presubjct="
				+ Lu_Presubjct + ", in_Stdnt_No=" + in_Stdnt_No
				+ ", in_Lctre_No=" + in_Lctre_No + ", pr_Profsr_No="
				+ pr_Profsr_No + ", pr_Pw=" + pr_Pw + ", pr_Nm=" + pr_Nm
				+ ", pr_Eng_Nm=" + pr_Eng_Nm + ", pr_Ihidnum=" + pr_Ihidnum
				+ ", pr_Moblphon_No=" + pr_Moblphon_No
				+ ", pr_House_Tlphon_No=" + pr_House_Tlphon_No
				+ ", pr_Profsr_Tlphon_No=" + pr_Profsr_Tlphon_No
				+ ", pr_Post_No=" + pr_Post_No + ", pr_Adres1=" + pr_Adres1
				+ ", pr_Adres2=" + pr_Adres2 + ", pr_Email=" + pr_Email
				+ ", psa_Code=" + psa_Code + ", psa_Subjct_Code="
				+ psa_Subjct_Code + ", psa_Profsr_No=" + psa_Profsr_No
				+ ", psa_Dt=" + psa_Dt + ", sit_Subjct_Code=" + sit_Subjct_Code
				+ ", sit_Faculty=" + sit_Faculty + ", sit_Subjct=" + sit_Subjct
				+ ", sit_Tut=" + sit_Tut + ", sit_useyn=" + sit_useyn
				+ ", fc_Faculty_Code=" + fc_Faculty_Code + ", fc_Coleg_Code="
				+ fc_Coleg_Code + ", fc_Faculty_Nm=" + fc_Faculty_Nm
				+ ", fc_useyn=" + fc_useyn + ", coleg_Code=" + coleg_Code
				+ ", coleg_Nm=" + coleg_Nm + ", coleg_useyn=" + coleg_useyn
				+ "]";
	}
	
}
