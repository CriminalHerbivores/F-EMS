<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.uni.fems.dto.Lctre_SearchVO"%>

<%--
 * <pre>
 * 관심강의 혹은 수강신청완료한 강의들을 시간표로 보여주는 JSP
 * </pre>
 * [[개정이력(Modification Information)]]
 * 수정일        수정자       수정내용
 * --------     --------    ----------------------
 * 2017.01.24      KJH        최초작성
 * 2017.02.15      KJH        추가작성
 * Copyright (c) 2017 by DDIT All right reserved
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script src="https://code.jquery.com/jquery.min.js"></script>

<script type="text/javascript">
$(document).ready(function () {
	var data = "${st_No}";
	var dataList = {'in_Stdnt_No':data};
	
		$.ajax({
			contentType:'application/json',
			dataType:'json',
			url:'initData',
			type:'post',
			data:JSON.stringify(dataList),
			success:function(result){
				$.each(result,function(i){
					setData(result[i]);
				});
				
			}
			
		})
})
</script>

<script>	
		var timeTbValues=[];

	function setData(result){
	$.each(result,function(i) {
		
			var lc_Wik_Lctre_Dayweek = result.lc_Wik_Lctre_Dayweek;
			var lc_Lctre_Time = result.lc_Lctre_Time;
			var lc_Lctrum_No = result.lc_Lctrum_No;
			var lu_Lctre_Nm = result.lu_Lctre_Nm;
			var bd_Nm = result.bd_Nm;
			var pr_Nm = result.pr_Nm;
			var lc_Lctre_No =result.lc_Lctre_No;
			var lc_Lctre_Code = result.lc_Lctre_Code;
			var lc_Split = result.lc_Split;
			
			allData= {"lc_Wik_Lctre_Dayweek": lc_Wik_Lctre_Dayweek, "lc_Lctre_Time": lc_Lctre_Time, 
					"lc_Lctrum_No": lc_Lctrum_No, "lu_Lctre_Nm": lu_Lctre_Nm, 
					"bd_Nm": bd_Nm, "pr_Nm": pr_Nm, "lc_Lctre_No": lc_Lctre_No, 
					"lc_Lctre_Code": lc_Lctre_Code, "lc_Split": lc_Split}
		 var allData = new Array();
		 
		
		timeTbValues.push(allData); 	/* $(this).val() */
		// 요일 처리
		var str= lc_Wik_Lctre_Dayweek;
		var arr = str.split("/");
		var arr1 = arr[0];
		var arr2 = arr[1];
		
		var period1=lc_Lctre_Time.split("/")[0].split(",")[0]+"-"+lc_Lctre_Time.split("/")[0].split(",")[1]
		var period2=lc_Lctre_Time.split("/")[1].split(",")[0]+"-"+lc_Lctre_Time.split("/")[1].split(",")[1]
		
		// 강의실 처리
		var roomNm=lc_Lctrum_No.split("-")[1];
		
		var bdNm=bd_Nm.slice(0,1).concat("",bd_Nm.split(" ")[1].slice(0,1)).concat("-",roomNm);
		
		//---------------------------------------
		var rst1 = "["+lc_Lctre_Code+"-"+lc_Split+"] "+lu_Lctre_Nm+"<br>"+arr1+"( "+period1+" 교시)<br>"+bdNm+pr_Nm+"<br>";
		var rst2 = "["+lc_Lctre_Code+"-"+lc_Split+"] "+lu_Lctre_Nm+"<br>"+arr2+"( "+period2+" 교시)<br>"+bdNm+pr_Nm+"<br>";

		
if(period1.split("-")[0]=="1"||period1.split("-")[1]=="1"){
	if(arr1=="월"){
		$("td:eq(0)").html(rst1);
	}else if(arr1=="화"){
		$("td:eq(1)").html(rst1);
	}else if(arr1=="수"){
		$("td:eq(2)").html(rst1);
	}else if(arr1=="목"){
		$("td:eq(3)").html(rst1);
	}else if(arr1=="금"){
		$("td:eq(4)").html(rst1);
	}	
}
if(period1.split("-")[0]=="2"||period1.split("-")[1]=="2"){
	if(arr1=="월"){
		$("td:eq(5)").html(rst1);
	}else if(arr1=="화"){
		$("td:eq(6)").html(rst1);
	}else if(arr1=="수"){
		$("td:eq(7)").html(rst1);
	}else if(arr1=="목"){
		$("td:eq(8)").html(rst1);
	}else if(arr1=="금"){
		$("td:eq(9)").html(rst1);
	}	
}
if(period1.split("-")[0]=="3"||period1.split("-")[1]=="3"){
	if(arr1=="월"){
		$("td:eq(10)").html(rst1);
	}else if(arr1=="화"){
		$("td:eq(11)").html(rst1);
	}else if(arr1=="수"){
		$("td:eq(12)").html(rst1);
	}else if(arr1=="목"){
		$("td:eq(13)").html(rst1);
	}else if(arr1=="금"){
		$("td:eq(14").html(rst1);
	}	
}
if(period1.split("-")[0]=="4"||period1.split("-")[1]=="4"){
	if(arr1=="월"){
		$("td:eq(15)").html(rst1);
	}else if(arr1=="화"){
		$("td:eq(16)").html(rst1);
	}else if(arr1=="수"){
		$("td:eq(17)").html(rst1);
	}else if(arr1=="목"){
		$("td:eq(18)").html(rst1);
	}else if(arr1=="금"){
		$("td:eq(19)").html(rst1);
	}	
}
if(period1.split("-")[0]=="5"||period1.split("-")[1]=="5"){
	if(arr1=="월"){
		$("td:eq(20)").html(rst1);
	}else if(arr1=="화"){
		$("td:eq(21)").html(rst1);
	}else if(arr1=="수"){
		$("td:eq(22)").html(rst1);
	}else if(arr1=="목"){
		$("td:eq(23)").html(rst1);
	}else if(arr1=="금"){
		$("td:eq(24)").html(rst1);
	}	
}
if(period1.split("-")[0]=="56"||period1.split("-")[1]=="6"){
	if(arr1=="월"){
		$("td:eq(25)").html(rst1);
	}else if(arr1=="화"){
		$("td:eq(26)").html(rst1);
	}else if(arr1=="수"){
		$("td:eq(27)").html(rst1);
	}else if(arr1=="목"){
		$("td:eq(28)").html(rst1);
	}else if(arr1=="금"){
		$("td:eq(29)").html(rst1);
	}	
}
if(period1.split("-")[0]=="7"||period1.split("-")[1]=="7"){
	if(arr1=="월"){
		$("td:eq(30)").html(rst1);
	}else if(arr1=="화"){
		$("td:eq(31)").html(rst1);
	}else if(arr1=="수"){
		$("td:eq(32)").html(rst1);
	}else if(arr1=="목"){
		$("td:eq(33)").html(rst1);
	}else if(arr1=="금"){
		$("td:eq(34)").html(rst1);
	}	
}
if(period1.split("-")[0]=="8"||period1.split("-")[1]=="8"){
	if(arr1=="월"){
		$("td:eq(35)").html(rst1);
	}else if(arr1=="화"){
		$("td:eq(36)").html(rst1);
	}else if(arr1=="수"){
		$("td:eq(37)").html(rst1);
	}else if(arr1=="목"){
		$("td:eq(38)").html(rst1);
	}else if(arr1=="금"){
		$("td:eq(39)").html(rst1);
	}	
}
if(period1.split("-")[0]=="9"||period1.split("-")[1]=="9"){
	if(arr1=="월"){
		$("td:eq(40)").html(rst1);
	}else if(arr1=="화"){
		$("td:eq(41)").html(rst1);
	}else if(arr1=="수"){
		$("td:eq(42)").html(rst1);
	}else if(arr1=="목"){
		$("td:eq(43)").html(rst1);
	}else if(arr1=="금"){
		$("td:eq(44)").html(rst1);
	}	
}
if(period1.split("-")[0]=="10"||period1.split("-")[1]=="10"){
	if(arr1=="월"){
		$("td:eq(45)").html(rst1);
	}else if(arr1=="화"){
		$("td:eq(46)").html(rst1);
	}else if(arr1=="수"){
		$("td:eq(47)").html(rst1);
	}else if(arr1=="목"){
		$("td:eq(48)").html(rst1);
	}else if(arr1=="금"){
		$("td:eq(49)").html(rst1);
	}	
}
if(period1.split("-")[0]=="11"||period1.split("-")[1]=="11"){
	if(arr1=="월"){
		$("td:eq(50)").html(rst1);
	}else if(arr1=="화"){
		$("td:eq(51)").html(rst1);
	}else if(arr1=="수"){
		$("td:eq(52)").html(rst1);
	}else if(arr1=="목"){
		$("td:eq(53)").html(rst1);
	}else if(arr1=="금"){
		$("td:eq(54)").html(rst1);
	}	
}
if(period1.split("-")[0]=="12"||period1.split("-")[1]=="12"){
	if(arr1=="월"){
		$("td:eq(55)").html(rst1);
	}else if(arr1=="화"){
		$("td:eq(56)").html(rst1);
	}else if(arr1=="수"){
		$("td:eq(57)").html(rst1);
	}else if(arr1=="목"){
		$("td:eq(58)").html(rst1);
	}else if(arr1=="금"){
		$("td:eq(59)").html(rst1);
	}	
}
if(period1.split("-")[0]=="13"||period1.split("-")[1]=="13"){
	if(arr1=="월"){
		$("td:eq(60)").html(rst1);
	}else if(arr1=="화"){
		$("td:eq(61)").html(rst1);
	}else if(arr1=="수"){
		$("td:eq(62)").html(rst1);
	}else if(arr1=="목"){
		$("td:eq(63)").html(rst1);
	}else if(arr1=="금"){
		$("td:eq(64)").html(rst1);
	}	
}
//------------------------------------------------------------
if(period2.split("-")[0]=="1"||period2.split("-")[1]=="1"){
	if(arr2=="월"){
		$("td:eq(0)").html(rst2);
	}else if(arr2=="화"){
		$("td:eq(1)").html(rst2);
	}else if(arr2=="수"){
		$("td:eq(2)").html(rst2);
	}else if(arr2=="목"){
		$("td:eq(3)").html(rst2);
	}else if(arr2=="금"){
		$("td:eq(4)").html(rst2);
	}	
}
if(period2.split("-")[0]=="2"||period2.split("-")[1]=="2"){
	if(arr2=="월"){
		$("td:eq(5)").html(rst2);
	}else if(arr2=="화"){
		$("td:eq(6)").html(rst2);
	}else if(arr2=="수"){
		$("td:eq(7)").html(rst2);
	}else if(arr2=="목"){
		$("td:eq(8)").html(rst2);
	}else if(arr2=="금"){
		$("td:eq(9)").html(rst2);
	}	
}
if(period2.split("-")[0]=="3"||period2.split("-")[1]=="3"){
	if(arr2=="월"){
		$("td:eq(10)").html(rst2);
	}else if(arr2=="화"){
		$("td:eq(11)").html(rst2);
	}else if(arr2=="수"){
		$("td:eq(12)").html(rst2);
	}else if(arr2=="목"){
		$("td:eq(13)").html(rst2);
	}else if(arr2=="금"){
		$("td:eq(14").html(rst2);
	}	
}
if(period2.split("-")[0]=="4"||period2.split("-")[1]=="4"){
	if(arr2=="월"){
		$("td:eq(15)").html(rst2);
	}else if(arr2=="화"){
		$("td:eq(16)").html(rst2);
	}else if(arr2=="수"){
		$("td:eq(17)").html(rst2);
	}else if(arr2=="목"){
		$("td:eq(18)").html(rst2);
	}else if(arr2=="금"){
		$("td:eq(19)").html(rst2);
	}	
}
if(period2.split("-")[0]=="5"||period2.split("-")[1]=="5"){
	if(arr2=="월"){
		$("td:eq(20)").html(rst2);
	}else if(arr2=="화"){
		$("td:eq(21)").html(rst2);
	}else if(arr2=="수"){
		$("td:eq(22)").html(rst2);
	}else if(arr2=="목"){
		$("td:eq(23)").html(rst2);
	}else if(arr2=="금"){
		$("td:eq(24)").html(rst2);
	}	
}
if(period2.split("-")[0]=="6"||period2.split("-")[1]=="6"){
	if(arr2=="월"){
		$("td:eq(25)").html(rst2);
	}else if(arr2=="화"){
		$("td:eq(26)").html(rst2);
	}else if(arr2=="수"){
		$("td:eq(27)").html(rst2);
	}else if(arr2=="목"){
		$("td:eq(28)").html(rst2);
	}else if(arr2=="금"){
		$("td:eq(29)").html(rst2);
	}	
}
if(period2.split("-")[0]=="7"||period2.split("-")[1]=="7"){
	if(arr2=="월"){
		$("td:eq(30)").html(rst2);
	}else if(arr2=="화"){
		$("td:eq(31)").html(rst2);
	}else if(arr2=="수"){
		$("td:eq(32)").html(rst2);
	}else if(arr2=="목"){
		$("td:eq(33)").html(rst2);
	}else if(arr2=="금"){
		$("td:eq(34)").html(rst2);
	}	
}
if(period2.split("-")[0]=="8"||period2.split("-")[1]=="8"){
	if(arr2=="월"){
		$("td:eq(35)").html(rst2);
	}else if(arr2=="화"){
		$("td:eq(36)").html(rst2);
	}else if(arr2=="수"){
		$("td:eq(37)").html(rst2);
	}else if(arr2=="목"){
		$("td:eq(38)").html(rst2);
	}else if(arr2=="금"){
		$("td:eq(39)").html(rst2);
	}	
}
if(period2.split("-")[0]=="9"||period2.split("-")[1]=="9"){
	if(arr2=="월"){
		$("td:eq(40)").html(rst2);
	}else if(arr2=="화"){
		$("td:eq(41)").html(rst2);
	}else if(arr2=="수"){
		$("td:eq(42)").html(rst2);
	}else if(arr2=="목"){
		$("td:eq(43)").html(rst2);
	}else if(arr2=="금"){
		$("td:eq(44)").html(rst2);
	}	
}
if(period2.split("-")[0]=="10"||period2.split("-")[1]=="10"){
	if(arr2=="월"){
		$("td:eq(45)").html(rst2);
	}else if(arr2=="화"){
		$("td:eq(46)").html(rst2);
	}else if(arr2=="수"){
		$("td:eq(47)").html(rst2);
	}else if(arr2=="목"){
		$("td:eq(48)").html(rst2);
	}else if(arr2=="금"){
		$("td:eq(49)").html(rst2);
	}	
}
if(period2.split("-")[0]=="11"||period2.split("-")[1]=="11"){
	if(arr2=="월"){
		$("td:eq(50)").html(rst2);
	}else if(arr2=="화"){
		$("td:eq(51)").html(rst2);
	}else if(arr2=="수"){
		$("td:eq(52)").html(rst2);
	}else if(arr2=="목"){
		$("td:eq(53)").html(rst2);
	}else if(arr2=="금"){
		$("td:eq(54)").html(rst2);
	}	
}
if(period2.split("-")[0]=="12"||period2.split("-")[1]=="12"){
	if(arr2=="월"){
		$("td:eq(55)").html(rst2);
	}else if(arr2=="화"){
		$("td:eq(56)").html(rst2);
	}else if(arr2=="수"){
		$("td:eq(57)").html(rst2);
	}else if(arr2=="목"){
		$("td:eq(58)").html(rst2);
	}else if(arr2=="금"){
		$("td:eq(59)").html(rst2);
	}	
}
if(period2.split("-")[0]=="13"||period2.split("-")[1]=="13"){
	if(arr2=="월"){
		$("td:eq(60)").html(rst2);
	}else if(arr2=="화"){
		$("td:eq(61)").html(rst2);
	}else if(arr2=="수"){
		$("td:eq(62)").html(rst2);
	}else if(arr2=="목"){
		$("td:eq(63)").html(rst2);
	}else if(arr2=="금"){
		$("td:eq(64)").html(rst2);
	}	
}
	
})
	}
</script>

</head>
<body>
<form id="formm" name="formm">
<div class="margin-auto">
	
	<h1>시간표 (${loginUser}&nbsp;&nbsp;<%-- ${lctre_SearchVO.st_Nm} --%>)</h1>
	<table class="def-table-full tb-border">
		<tr>
			<th>시간</th>
			<th>월</th>
			<th>화</th>
			<th>수</th>
			<th>목</th>
			<th>금</th>
		</tr>
		<tr>
			<th>1교시</th>
			<td rowspan="2"></td>
			<td rowspan="2"></td>
			<td rowspan="2"></td>
			<td rowspan="2"></td>
			<td rowspan="2"></td>
		</tr>
		<tr>
			<th>09:00</th>
		</tr>
		<tr>
			<th>2교시</th>
			<td rowspan="2"></td>
			<td rowspan="2"></td>
			<td rowspan="2"></td>
			<td rowspan="2"></td>
			<td rowspan="2"></td>
		</tr>
		<tr>
			<th>10:00</th>
		</tr>
		<tr>
			<th>3교시</th>
			<td rowspan="2"></td>
			<td rowspan="2"></td>
			<td rowspan="2"></td>
			<td rowspan="2"></td>
			<td rowspan="2"></td>
		</tr>
		<tr>
			<th>11:00</th>
		</tr>
		<tr>
		<th>4교시</th>
		<td rowspan="2"></td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>	
		<td rowspan="2"></td>
	</tr>
	<tr>
	<th>12:00</th>
	</tr>
	<tr>
		<th>5교시</th>
		<td rowspan="2"></td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>	
		<td rowspan="2"></td>
	</tr>
	<tr>
	<th>13:00</th>
	</tr>
	<tr>
		<th>6교시</th>
		<td rowspan="2"></td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>	
		<td rowspan="2"></td>
	</tr>
	<tr>
	<th>14:00</th>
	</tr>
	<tr>
		<th>7교시</th>
		<td rowspan="2"></td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>	
		<td rowspan="2"></td>
	</tr>
	<tr>
	<th>15:00</th>
	</tr>
	<tr>
		<th>8교시</th>
		<td rowspan="2"></td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>	
		<td rowspan="2"></td>
	</tr>
	<tr>
	<th>16:00</th>
	</tr>
	<tr>
		<th>9교시</th>
		<td rowspan="2"></td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>	
		<td rowspan="2"></td>
	</tr>
	<tr>
	<th>17:00</th>
	</tr>
	<tr>
		<th>10교시</th>
		<td rowspan="2"></td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>	
		<td rowspan="2"></td>
	</tr>
	<tr>
	<th>18:00</th>
	</tr>
	<tr>
		<th>11교시</th>
		<td rowspan="2"></td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>	
		<td rowspan="2"></td>
	</tr>
	<tr>
	<th>19:00</th>
	</tr>
	<tr>
		<th>12교시</th>
		<td rowspan="2"></td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>	
		<td rowspan="2"></td>
	</tr>
	<tr>
	<th>20:00</th>
	</tr>
	<tr>
		<th>13교시</th>
		<td rowspan="2"></td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>	
		<td rowspan="2"></td>
	</tr>
	<tr>
	<th>21:00</th>
	</tr>
	</table>
</div>
</form>
</body>
</html>