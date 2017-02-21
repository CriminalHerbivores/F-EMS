package UserSubjctVO;

import java.sql.Timestamp;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

/**
 * <pre>
 * 교수학과배정,교수,학생,직원,학과,학부,단과대학 테이블의 컬럼을 변수로 하는 VO클래스
 * </pre>
 * 
 * @author KJH
 * @since 2017. 02. 21
 * @version 1.0
 * @see javax.servlet.http.HttpServlet <pre>
 * [[개정이력(Modification Information)]]
 * 수정일        수정자           수정내용
 * --------     --------    ----------------------
 * 2017.02.21      KJH            최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */

@Alias("userSubjct")
@Data
public class UserSubjctVO {

	private static final long serialVersionUID = 1L;

	// ColegeVO 단과대학
	private String coleg_Code; // 단과대학코드
	private String coleg_Nm; // 단과대학명
	private String coleg_Useyn; // 단과대학 사용유무

	// FacultyVO 학부
	private String fc_Faculty_Code; // 학부코드
	private String fc_Coleg_Code; // 단과대학코드
	private String fc_Faculty_Nm; // 학부명
	private String fc_Useyn; // 학부 사용유무

	// Subjct_Info_TableVO 학과
	private String sit_Subjct_Code; // 학과 코드
	private String sit_Faculty; // 학부
	private String sit_Subjct; // 학과명
	private int sit_Tut; // 등록금 금액
	private String sit_Subjct_Tlphon_No; // 학과 전화 번호
	private String sit_Useyn; // 학과 사용유무

	// StdntVO 학생
	private String st_Stdnt_No; // 학생 번호
	private String st_Subjct_Code; // 학과 코드
	private String st_Pw; // 비밀번호
	private String st_Nm; // 이름
	private String st_Eng_Nm; // 영문 이름
	private String st_Ihidnum; // 주민번호
	private String st_Moblphon_No; // 핸드폰 번호
	private String st_House_Tlphon_No; // 집 전화 번호
	private String st_Entsch_Dt; // 입학 일자
	private String st_Prtctor_Nm; // 보호자 이름
	private String st_Family_Relate; // 가족 관계
	private String st_Post_No; // 우편 번호
	private String st_Adres1; // 주소1
	private String st_Adres2; // 주소2
	private String st_Cnslt_At; // 상담 여부
	private String st_Email; // 이메일
	private String st_Brhs_At; // 기숙사 여부
	private String st_Profsr_No; // 교수 번호
	private String st_Grdtn_Dt; // 졸업 일자

	// SklstfVO 직원
	private String stf_Sklstf_No; // 직원 번호
	private String stf_Subject_Code; // 학과 번호
	private String stf_Nm; // 이름
	private String stf_Eng_Nm; // 영문 이름
	private String stf_Ihidnum; // 주민 번호
	private String stf_Moblphon_No; // 핸드폰 번호
	private String stf_House_Tlphon_No; // 집 전화 번호
	private String stf_Sklstf_Tlphon_No; // 직원 전화번호
	private String stf_Pw; // 비밀번호
	private String stf_Post_No; // 우편번호
	private String stf_Adres1; // 주소1
	private String stf_Adres2; // 주소2
	private String stf_Email; // 이메일
	private String stf_Useyn; // 직원 사용여부

	// ProfsrVO 교수
	private String pr_Profsr_No; // 교수 번호
	private String pr_Pw; // 비밀번호
	private String pr_Nm; // 이름
	private String pr_Eng_Nm; // 영문 이름
	private String pr_Ihidnum; // 주민번호
	private String pr_Moblphon_No; // 핸드폰 번호
	private String pr_House_Tlphon_No; // 집 전화번호
	private String pr_Profsr_Tlphon_No; // 교수 전화번호
	private String pr_Post_No; // 우편 번호
	private String pr_Adres1; // 주소1
	private String pr_Adres2; // 주소2
	private String pr_Email; // 이메일

	// Profsr_Subjct_AsnmVO 교수학과배정
	private String psa_Code; // 교수학과배정코드
	private String psa_Subjct_Code; // 학과코드
	private String psa_Profsr_No; // 교수번호
	private Timestamp psa_Dt; // 배정일

}
