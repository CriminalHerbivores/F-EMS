package com.uni.fems.view;

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

import com.uni.fems.dto.LctreVO;

/**
 * 엑셀 샘플 코드
 */
public class ListExcelView extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		response.setHeader("Content-Disposition", "attachment;filename=\"LctreList.xls\";");

		HSSFSheet sheet = createFirstSheet(workbook); // 페이지 정보설정.
		createColumnLabel(sheet); // excel문서의 컬럼명 세팅.
		List<LctreVO> lctreList 
			= (List<LctreVO>) model.get("lctreList");
		int rowNum = 1;		
		for (LctreVO rank : lctreList) {
			createLctreListkRow(sheet, rank, rowNum++); // excel 문서의 행추가
		}
	}

	private HSSFSheet createFirstSheet(HSSFWorkbook workbook) {
		HSSFSheet sheet = workbook.createSheet();// sheet생성
		workbook.setSheetName(0, "강의 리스트"); // (sheet순번, sheet제목)
		sheet.setColumnWidth(6, 256 * 50); // (컬럼번호, 크기) 1자/256
		sheet.setColumnWidth(5, 256 * 15);
		return sheet;
	}

	private void createColumnLabel(HSSFSheet sheet) {
		HSSFRow firstRow = sheet.createRow(0); // 시작행 설정
		HSSFCell cell = null;
		//////////////////////////////////////////////////////////////////////
		String[] colName={"강의번호","강의코드"};
		for(int i=0;i<colName.length;i++){			
			cell = firstRow.createCell(i); // 컬럼순번
			cell.setCellValue(colName[i]);// 컬럼명
		}
		
	}

	private void createLctreListkRow(HSSFSheet sheet, LctreVO lctre,
			int rowNum) {
		HSSFRow row = sheet.createRow(rowNum); // 행추가 (행번호)
		HSSFCell cell = null;
		//////////////////////////////////////////////////////////////////////
		String[] value={""+ // 추가필요
				lctre.getLc_Lctre_No(),
				lctre.getLc_Lctre_Code()
				};
		for(int i=0;i<value.length;i++){
			cell = row.createCell(i);// 셀삽입(컬럼순번)
			cell.setCellValue(value[i]);// 값할당(값)
		}
	}
}

