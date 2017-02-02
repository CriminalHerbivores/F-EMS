package com.uni.fems.view;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;
import com.uni.fems.dto.LctreVO;

/**
 * pdf 샘플 코드
 */
public class ListPdfView extends AbstractPdfView{
	
	private String fontPath="c:\\windows\\Fonts\\malgun.ttf";

	@Override
	protected void buildPdfDocument(Map<String, Object> model, 
			Document document, PdfWriter writer, 
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		
		List<LctreVO> lctreList=(List<LctreVO>)model.get("LctreList");
		 
		Table table = new Table(3, lctreList.size() + 1); //Table 선언(열개수, 행수)
		table.setPadding(5); //내부여백
		float[] columnWidths = new float[] {15f,20f,25f,20f,20f,30f,40f};
		table.setWidths(columnWidths);
		//글꼴설정.
		BaseFont bfKorean = BaseFont.createFont(fontPath, BaseFont.IDENTITY_H,
				BaseFont.EMBEDDED);
		
		Font font = new Font(bfKorean);
		Cell cell=new Cell(new Paragraph("번호",font));		
		cell.setHeader(true); //표헤더시작
		table.addCell(cell);
		cell=new Cell(new Paragraph("강의번호",font));
		table.addCell(cell);
		cell=new Cell(new Paragraph("강의코드",font));
		table.addCell(cell);
		table.endHeaders(); //표헤더 종료.
		
		for (LctreVO lctre : lctreList) {
			table.addCell(cell);
			cell=new Cell(new Paragraph(lctre.getLc_Lctrum_No(),font));			
			table.addCell(cell);
			cell=new Cell(new Paragraph(lctre.getLc_Lctre_Code(),font));			
			table.addCell(cell);
			
		}
		document.add(table);
		document.close();
	}
	
	@Autowired(required=false)
	public void setFontPath(String fontPath) {
		this.fontPath = fontPath;
	}
}

