<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<script type="text/javascript">
function resultLctre(lc_Wik_Lctre_Dayweek,lc_Lctre_Time,lc_Lctrum_No,lu_Lctre_Nm) {	// ,bd_Nm,pr_Nm  왜 건물명,교수명을 못불러오는가?
	   
// 요일 처리
var str=lc_Wik_Lctre_Dayweek;
var arr = str.split("/");
var arr1 = arr[0];
var arr2 = arr[1];
//alert(arr1);
//alert(arr2);

// 교시 처리
// var aa=lc_Lctre_Time.split("/")[0];
// var bb=lc_Lctre_Time.split("/")[1];
// var cc=aa.split(",")[0];
// var dd=bb.split(",")[0];
// var ee=aa.split(",")[1];
// var ff=bb.split(",")[1];
// alert(cc+ee+"-"+dd+ff);


var period1=lc_Lctre_Time.split("/")[0].split(",")[0]+"-"+lc_Lctre_Time.split("/")[0].split(",")[1]
var period2=lc_Lctre_Time.split("/")[1].split(",")[0]+"-"+lc_Lctre_Time.split("/")[1].split(",")[1]
alert(period1+"   "+period2);

// 강의실 처리
var roomNm=lc_Lctrum_No.split("-")[1];
//alert(roomNm)
var bd_Nmm="공과대학 2호관";
//alert(bd_Nm); 
		
//var bdNm1=bd_Nmm.slice(0,1);
//var bdNm2=bd_Nmm.split(" ")[1].slice(0,1);
var bdNm=bd_Nmm.slice(0,1).concat("",bd_Nmm.split(" ")[1].slice(0,1)).concat("-",roomNm);
//---------------------------------------
var rst1 = lu_Lctre_Nm+"<br>"+"pr_Nm 와야함"+"<br>"+arr1+"( "+period1+" 교시)<br>"+bdNm;
var rst2 = lu_Lctre_Nm+"<br>"+"pr_Nm 와야함"+"<br>"+arr2+"( "+period2+" 교시)<br>"+bdNm;

alert("rst1 : "+rst1);

/* var thArray = new Array();
var contentArray = new Array();

$('th').each(function(index) {
  thArray[index] =    $(this).html();
})


$('tr').each(function(indexParent) {
  contentArray['row'+indexParent] = new Array();
    $(this).children().each(function(indexChild) {
      contentArray['row'+indexParent]['col'+indexChild] = $(this).html();
    });
}); */

if(period1.split("-")[0]=="1"||period1.split("-")[1]=="1"){
	if(arr1=="월"){
		$("td:eq(1)").html(rst1);
	}else if(arr1=="화"){
		$("td:eq(2)").html(rst1);
	}else if(arr1=="수"){
		$("td:eq(3)").html(rst1);
	}else if(arr1=="목"){
		$("td:eq(4)").html(rst1);
	}else if(arr1=="금"){
		$("td:eq(5)").html(rst1);
	}	
}
if(period1.split("-")[0]=="2"||period1.split("-")[1]=="2"){
	if(arr1=="월"){
		$("td:eq(8)").html(rst1);
	}else if(arr1=="화"){
		$("td:eq(9)").html(rst1);
	}else if(arr1=="수"){
		$("td:eq(10)").html(rst1);
	}else if(arr1=="목"){
		$("td:eq(11)").html(rst1);
	}else if(arr1=="금"){
		$("td:eq(12)").html(rst1);
	}	
}
if(period1.split("-")[0]=="3"||period1.split("-")[1]=="3"){
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
if(period1.split("-")[0]=="4"||period1.split("-")[1]=="4"){
	if(arr1=="월"){
		$("td:eq(22)").html(rst1);
	}else if(arr1=="화"){
		$("td:eq(23)").html(rst1);
	}else if(arr1=="수"){
		$("td:eq(24)").html(rst1);
	}else if(arr1=="목"){
		$("td:eq(25)").html(rst1);
	}else if(arr1=="금"){
		$("td:eq(26)").html(rst1);
	}	
}
if(period1.split("-")[0]=="5"||period1.split("-")[1]=="5"){
	if(arr1=="월"){
		$("td:eq(29)").html(rst1);
	}else if(arr1=="화"){
		$("td:eq(30)").html(rst1);
	}else if(arr1=="수"){
		$("td:eq(31)").html(rst1);
	}else if(arr1=="목"){
		$("td:eq(32)").html(rst1);
	}else if(arr1=="금"){
		$("td:eq(33)").html(rst1);
	}	
}
if(period1.split("-")[0]=="5"||period1.split("-")[1]=="6"){
	if(arr1=="월"){
		$("td:eq(36)").html(rst1);
	}else if(arr1=="화"){
		$("td:eq(37)").html(rst1);
	}else if(arr1=="수"){
		$("td:eq(38)").html(rst1);
	}else if(arr1=="목"){
		$("td:eq(39)").html(rst1);
	}else if(arr1=="금"){
		$("td:eq(40)").html(rst1);
	}	
}
if(period1.split("-")[0]=="5"||period1.split("-")[1]=="7"){
	if(arr1=="월"){
		$("td:eq(47)").html(rst1);
	}else if(arr1=="화"){
		$("td:eq(48)").html(rst1);
	}else if(arr1=="수"){
		$("td:eq(49)").html(rst1);
	}else if(arr1=="목"){
		$("td:eq(50)").html(rst1);
	}else if(arr1=="금"){
		$("td:eq(51)").html(rst1);
	}	
}
if(period1.split("-")[0]=="5"||period1.split("-")[1]=="8"){
	if(arr1=="월"){
		$("td:eq(64)").html(rst1);
	}else if(arr1=="화"){
		$("td:eq(65)").html(rst1);
	}else if(arr1=="수"){
		$("td:eq(66)").html(rst1);
	}else if(arr1=="목"){
		$("td:eq(67)").html(rst1);
	}else if(arr1=="금"){
		$("td:eq(68)").html(rst1);
	}	
}
if(period1.split("-")[0]=="5"||period1.split("-")[1]=="9"){
	if(arr1=="월"){
		$("td:eq(71)").html(rst1);
	}else if(arr1=="화"){
		$("td:eq(72)").html(rst1);
	}else if(arr1=="수"){
		$("td:eq(73)").html(rst1);
	}else if(arr1=="목"){
		$("td:eq(74)").html(rst1);
	}else if(arr1=="금"){
		$("td:eq(75)").html(rst1);
	}	
}
if(period1.split("-")[0]=="5"||period1.split("-")[1]=="10"){
	if(arr1=="월"){
		$("td:eq(78)").html(rst1);
	}else if(arr1=="화"){
		$("td:eq(79)").html(rst1);
	}else if(arr1=="수"){
		$("td:eq(80)").html(rst1);
	}else if(arr1=="목"){
		$("td:eq(81)").html(rst1);
	}else if(arr1=="금"){
		$("td:eq(82)").html(rst1);
	}	
}



/* var aaa="올ㅋㅋㅋㅋ"
$("td:eq(0)").text("0번인듯");
$("td:eq(2)").css("background", "yellow");
$("td:eq(5)").text(aaa);
$("td:eq(4)").text("4번인가"); */


//--------------------------------------


//document.getElementById("demo1").innerHTML = lu_Lctre_Nm+"<br>"+"pr_Nm 와야함"+"<br>"+arr1+"( "+period1+" 교시)<br>"+bdNm;
//document.getElementById("demo2").innerHTML = lu_Lctre_Nm+"<br>"+"pr_Nm 와야함"+"<br>"+arr2+"( "+period2+" 교시)<br>"+bdNm;


// document.formm.getElementById("demo1").innerHTML = arr1;
// document.formm.getElementById("demo2").innerHTML = arr2;


}


	
</script>

</head>
<body>
<form id="formm" name="formm">
	<c:forEach items="${lctre_SearchVO}" var="timeTb">
	
	
	${timeTb.lu_Lctre_Nm}
	<input type="button" value="${timeTb.lc_Lctre_No}" onclick="return resultLctre('${timeTb.lc_Wik_Lctre_Dayweek}','${timeTb.lc_Lctre_Time}','${timeTb.lc_Lctrum_No}','${timeTb.lu_Lctre_Nm}')" ><br/>
	<%-- ,'${timeTb.bd_Nm}','${timeTb.pr_Nm}' --%>
	
	</c:forEach>
	
	<h1>시간표 (${loginUser}&nbsp;&nbsp;<%-- ${lctre_SearchVO.st_Nm} --%>)</h1>
	<table class="def-table-full tb-border table-hover">
		<tr>
			<th>시간</th>
			<th>월</th>
			<th>화</th>
			<th>수</th>
			<th>목</th>
			<th>금</th>
		</tr>
		<tr>
			<td>1교시</td>
			<td rowspan="2"><p id="demo1"></p></td>
			<td rowspan="2"><p id="demo2"></p></td>
			<td rowspan="2"></td>
			<td rowspan="2"></td>
			<td rowspan="2"></td>
		</tr>
		<tr>
			<td>09:00</td>
		</tr>
		<tr>
			<td>2교시</td>
			<td rowspan="2"></td>
			<td rowspan="2"></td>
			<td rowspan="2"></td>
			<td rowspan="2"></td>
			<td rowspan="2"></td>
		</tr>
		<tr>
			<td>10:00</td>
		</tr>
		<tr>
			<td>3교시</td>
			<td rowspan="2"></td>
			<td rowspan="2"></td>
			<td rowspan="2"></td>
			<td rowspan="2"></td>
			<td rowspan="2"></td>
		</tr>
		<tr>
			<td>11:00</td>
		</tr>
		<tr>
		<td>4교시</td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>	
		<td rowspan="2"></td>
	</tr>
	<tr>
	<td>12:00</td>
	</tr>
	<tr>
		<td>5교시</td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>	
		<td rowspan="2"></td>
	</tr>
	<tr>
	<td>13:00</td>
	</tr>
	<tr>
		<td>6교시</td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>	
		<td rowspan="2"></td>
	</tr>
	<tr>
	<td>14:00</td>
	</tr>
	<tr>
		<td>7교시</td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>	
		<td rowspan="2"></td>
	</tr>
	<tr>
	<td>15:00</td>
	</tr>
	<tr>
		<td>8교시</td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>	
		<td rowspan="2"></td>
	</tr>
	<tr>
	<td>16:00</td>
	</tr>
	<tr>
		<td>9교시</td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>	
		<td rowspan="2"></td>
	</tr>
	<tr>
	<td>17:00</td>
	</tr>
	<tr>
		<td>10교시</td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>	
		<td rowspan="2"></td>
	</tr>
	<tr>
	<td>18:00</td>
	</tr>
	<tr>
		<td>11교시</td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>	
		<td rowspan="2"></td>
	</tr>
	<tr>
	<td>19:00</td>
	</tr>
	<tr>
		<td>12교시</td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>	
		<td rowspan="2"></td>
	</tr>
	<tr>
	<td>20:00</td>
	</tr>
	<tr>
		<td>13교시</td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>
		<td rowspan="2"></td>	
		<td rowspan="2"></td>
	</tr>
	<tr>
	<td>21:00</td>
	</tr>
	</table>

</form>
</body>
</html>