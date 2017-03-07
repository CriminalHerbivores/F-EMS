package com.uni.fems.common;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.uni.fems.dto.Lctre_SearchVO;

public class ListExcelView extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		response.setHeader("Content-Disposition",
				"attachment;filename=\"Lctre_List.xls\";");

		HSSFSheet sheet = createFirstSheet(workbook); // 페이지 정보설정.
		createColumnLabel(sheet); // excel문서의 컬럼명 세팅.
		List<Lctre_SearchVO> lctre_SearchList = (List<Lctre_SearchVO>) model
				.get("lctre_SearchList");
		int rowNum = 1;
		for (Lctre_SearchVO rank : lctre_SearchList) {
			createProductListkRow(sheet, rank, rowNum++); // excel 문서의 행추가
		}
	}

	/**
	 * 엑셀 안의 페이지 만들기
	 * @param workbook
	 * @return
	 */
	private HSSFSheet createFirstSheet(HSSFWorkbook workbook) {
		HSSFSheet sheet = workbook.createSheet();// sheet생성
		workbook.setSheetName(0, "강의 정보"); // (sheet순번, sheet제목)
		// sheet.setColumnWidth(6, 256 * 50); // (컬럼번호, 크기) 1자/256
		// sheet.setColumnWidth(5, 256 * 15);
		return sheet;
	}

	/**
	 * 엑셀의 첫번째 줄 만들기
	 * @param sheet
	 */
	private void createColumnLabel(HSSFSheet sheet) {
		HSSFRow firstRow = sheet.createRow(0); // 시작행 설정
		HSSFCell cell = null;
		String[] colName = { "개설년도/학기", "개설학과전공", "교과목명", "강의번호", "이수구분",
				"이수학점", "학년", "선행과목", "교수이름", "담당교수전화", "교수 이메일 주소",
				"주간 강의 요일", "강의실", "중간고사", "기말고사", "개인과제", "팀별과제", "발표", "출석",
				"태도", "강의진행형태", "강의목표", "주교재", "부교재", "1주차", "2주차", "3주차",
				"4주차", "5주차", "6주차", "7주차", "8주차", "9주차", "10주차", "11주차",
				"12주차", "13주차", "14주차", "15주차" };
		for (int i = 0; i < colName.length; i++) {
			cell = firstRow.createCell(i); // 컬럼순번
			cell.setCellValue(colName[i]);// 컬럼명
		}

	}

	/**
	 * 엑셀의 2번쨰 줄부터 리스트 값 넣기
	 * @param sheet
	 * @param lctre_Search
	 * @param rowNum
	 */
	private void createProductListkRow(HSSFSheet sheet,
			Lctre_SearchVO lctre_Search, int rowNum) {
		HSSFRow row = sheet.createRow(rowNum); // 행추가 (행번호)
		HSSFCell cell = null;

		// String kindArr[] = { "0", "Heels", "Boots", "Sandals", "Slipers",
		// "Shcakers","Sale" };

		String[] value = {
				new SimpleDateFormat("yyyy년도").format(lctre_Search
						.getLc_Lctrbgn_Dt()) + lctre_Search.getLc_Term() + "학기",
				lctre_Search.getSit_Subjct(),
				lctre_Search.getLu_Lctre_Nm(),
				lctre_Search.getLc_Lctre_Code(),
				lctre_Search.getLu_Compl_Se(),
				lctre_Search.getLu_Pnt(),
				lctre_Search.getLu_Grade() + "",
				lctre_Search.getLu_Presubjct(),
				lctre_Search.getPr_Nm() + lctre_Search.getPr_Profsr_No(),
				lctre_Search.getPr_Profsr_Tlphon_No(),
				lctre_Search.getPr_Email(),
				lctre_Search.getLc_Wik_Lctre_Dayweek()
						+ lctre_Search.getLc_Lctre_Time(),
				lctre_Search.getLc_Lctrum_No(),
				lctre_Search.getLa_Midex() + "",
				lctre_Search.getLa_Fnex() + "",
				lctre_Search.getLa_Indvdl_Task() + "",
				lctre_Search.getLa_Team_Task() + "",
				lctre_Search.getLa_Presnatn() + "",
				lctre_Search.getLa_Atend() + "",
				lctre_Search.getLa_Attd() + "",
				lctre_Search.getLa_Lctre_Progrs_Form(),
				lctre_Search.getLa_Lctre_Goal(),
				lctre_Search.getLa_Main_Txtbook(),
				lctre_Search.getLa_Sub_Txtbook(), lctre_Search.getLa_Week1(),
				lctre_Search.getLa_Week2(), lctre_Search.getLa_Week3(),
				lctre_Search.getLa_Week4(), lctre_Search.getLa_Week5(),
				lctre_Search.getLa_Week6(), lctre_Search.getLa_Week7(),
				lctre_Search.getLa_Week8(), lctre_Search.getLa_Week9(),
				lctre_Search.getLa_Week10(), lctre_Search.getLa_Week11(),
				lctre_Search.getLa_Week12(), lctre_Search.getLa_Week13(),
				lctre_Search.getLa_Week14(), lctre_Search.getLa_Week15() };
		for (int i = 0; i < value.length; i++) {
			cell = row.createCell(i);// 셀삽입(컬럼순번)
			cell.setCellValue(value[i]);// 값할당(값)
		}
	}
}
