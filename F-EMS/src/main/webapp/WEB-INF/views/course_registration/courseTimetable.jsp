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
<script src="https://code.jquery.com/jquery.min.js"></script>

<script type="text/javascript">
$(document).ready(function () {	// ,bd_Nm,pr_Nm  왜 건물명,교수명을 못불러오는가?
	   var a = $("input[name='timetable']").val();
	   var b = $("input[name='lc_Wik_Lctre_Dayweek']").val();
	   console.log(b);
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
//alert(period1+"   "+period2);

// 강의실 처리
var roomNm=lc_Lctrum_No.split("-")[1];
//alert(roomNm)
//var bd_Nmm="공과대학 2호관";
//alert(bd_Nm); 
		
//var bdNm1=bd_Nmm.slice(0,1);
//var bdNm2=bd_Nmm.split(" ")[1].slice(0,1);
var bdNm=bd_Nm.slice(0,1).concat("",bd_Nm.split(" ")[1].slice(0,1)).concat("-",roomNm);
//---------------------------------------
var rst1 = "["+lc_Lctre_Code+"-"+lc_Split+"] "+lu_Lctre_Nm+"<br>"+arr1+"( "+period1+" 교시)<br>"+bdNm+pr_Nm+"<br>";
var rst2 = "["+lc_Lctre_Code+"-"+lc_Split+"] "+lu_Lctre_Nm+"<br>"+arr2+"( "+period2+" 교시)<br>"+bdNm+pr_Nm+"<br>";

//alert("rst1 : "+rst1);
//alert("rst2 : "+rst2);


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



/* var aaa="올ㅋㅋㅋㅋ"
$("td:eq(0)").text("0번인듯");
$("td:eq(2)").css("background", "yellow");
$("td:eq(5)").text(aaa);
$("td:eq(4)").text("4번인가");  */
//$("td:eq(0)").text("0번인듯");	$("td:eq(1)").text("1번인듯");	$("td:eq(2)").text("2번인듯");	$("td:eq(3)").text("3번인듯");	$("td:eq(4)").text("4번인듯");	$("td:eq(5)").text("5번인듯");	$("td:eq(6)").text("6번인듯");	$("td:eq(7)").text("7번인듯");	$("td:eq(8)").text("8번인듯");	$("td:eq(9)").text("9번인듯");	$("td:eq(10)").text("10번인듯");	$("td:eq(11)").text("11번인듯");	$("td:eq(12)").text("12번인듯");	$("td:eq(13)").text("13번인듯");	$("td:eq(14)").text("14번인듯");	$("td:eq(15)").text("15번인듯");	$("td:eq(16)").text("16번인듯");	$("td:eq(17)").text("17번인듯");	$("td:eq(18)").text("18번인듯");	$("td:eq(19)").text("19번인듯");	$("td:eq(20)").text("20번인듯");	$("td:eq(21)").text("21번인듯");	$("td:eq(22)").text("22번인듯");	$("td:eq(23)").text("23번인듯");	$("td:eq(24)").text("24번인듯");	$("td:eq(25)").text("25번인듯");	$("td:eq(26)").text("26번인듯");	$("td:eq(27)").text("27번인듯");	$("td:eq(28)").text("28번인듯");	$("td:eq(29)").text("29번인듯");	$("td:eq(30)").text("30번인듯");	$("td:eq(31)").text("31번인듯");	$("td:eq(32)").text("32번인듯");	$("td:eq(33)").text("33번인듯");	$("td:eq(34)").text("34번인듯");	$("td:eq(35)").text("35번인듯");	$("td:eq(36)").text("36번인듯");	$("td:eq(37)").text("37번인듯");	$("td:eq(38)").text("38번인듯");	$("td:eq(39)").text("39번인듯");	$("td:eq(40)").text("40번인듯");	$("td:eq(41)").text("41번인듯");	$("td:eq(42)").text("42번인듯");	$("td:eq(43)").text("43번인듯");	$("td:eq(44)").text("44번인듯");	$("td:eq(45)").text("45번인듯");	$("td:eq(46)").text("46번인듯");	$("td:eq(47)").text("47번인듯");	$("td:eq(48)").text("48번인듯");	$("td:eq(49)").text("49번인듯");	$("td:eq(50)").text("50번인듯");	$("td:eq(51)").text("51번인듯");	$("td:eq(52)").text("52번인듯");	$("td:eq(53)").text("53번인듯");	$("td:eq(54)").text("54번인듯");	$("td:eq(55)").text("55번인듯");	$("td:eq(56)").text("56번인듯");	$("td:eq(57)").text("57번인듯");	$("td:eq(58)").text("58번인듯");	$("td:eq(59)").text("59번인듯");	$("td:eq(60)").text("60번인듯");	$("td:eq(61)").text("61번인듯");	$("td:eq(62)").text("62번인듯");	$("td:eq(63)").text("63번인듯");	$("td:eq(64)").text("64번인듯");	$("td:eq(65)").text("65번인듯");

//--------------------------------------


//document.getElementById("demo1").innerHTML = lu_Lctre_Nm+"<br>"+pr_Nm+"<br>"+arr1+"( "+period1+" 교시)<br>"+bdNm;
//document.getElementById("demo2").innerHTML = lu_Lctre_Nm+"<br>"+pr_Nm+"<br>"+arr2+"( "+period2+" 교시)<br>"+bdNm;


// document.formm.getElementById("demo1").innerHTML = arr1;
// document.formm.getElementById("demo2").innerHTML = arr2;


});


	
</script>

</head>
<body>
<form id="formm" name="formm">
	<c:forEach items="${lctre_SearchVO}" var="timeTb">
	
	<%-- <div style="margin:auto">[${timeTb.lc_Lctre_No}]&nbsp;&nbsp;
	${timeTb.lu_Lctre_Nm}&nbsp;&nbsp;
	<input type="button" value="${timeTb.lc_Lctre_No}" onclick="return resultLctre('${timeTb.lc_Wik_Lctre_Dayweek}','${timeTb.lc_Lctre_Time}','${timeTb.lc_Lctrum_No}','${timeTb.lu_Lctre_Nm}','${timeTb.bd_Nm}','${timeTb.pr_Nm}','${timeTb.lc_Lctre_No}','${timeTb.lc_Lctre_Code}','${timeTb.lc_Split}')" ><br/>
	,'${timeTb.bd_Nm}','${timeTb.pr_Nm}'
	</div> --%>
	
	<input type="hidden" name="timetable" value="'${timeTb.lc_Wik_Lctre_Dayweek}','${timeTb.lc_Lctre_Time}','${timeTb.lc_Lctrum_No}','${timeTb.lu_Lctre_Nm}','${timeTb.bd_Nm}','${timeTb.pr_Nm}','${timeTb.lc_Lctre_No}','${timeTb.lc_Lctre_Code}','${timeTb.lc_Split}'" ><br/>
	<input type="hidden" name="lc_Wik_Lctre_Dayweek" value="${timeTb.lc_Wik_Lctre_Dayweek}"><br/>
	
	
	</c:forEach>
	
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

</form>
</body>
</html>