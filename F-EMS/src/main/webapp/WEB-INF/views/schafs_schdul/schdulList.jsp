<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!--  [[개정이력(Modification Information)]]       -->
<!--  수정일               수정자            수정내용               -->
<!--  ==========   ======    ==============        -->
<!--  2017.02.13    송선호            최초작성               -->
<!--  Copyright (c) 2017 by DDIT All right reserved -->

<!DOCTYPE html>
<html>
<head>
    <title>Customizing templates</title>
    <meta charset="utf-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<script>
  
  $(function() {
    $("#sd_Bgnde, #sd_Enddt").datepicker();
  });

  
  
</script>
    

<script>
/* $(document).on('click','#monthbutton1',function(){
	var month1 = $("#content1").html();
	$('#contentplus1').append(month1);
});
 */
 
 function insertSchdul(){
	 var sd_Bgnde = $('#sd_Bgnde').val();
	 var sd_Enddt = $('#sd_Enddt').val();
	 var sd_Schdul_Nm = $('#sd_Schdul_Nm').val();
	 var sd_Schdul_Sumry = $('#sd_Schdul_Sumry').val();
	 var dataWrite ={ 'sd_Bgnde':sd_Bgnde, 'sd_Enddt':sd_Enddt,
			 'sd_Schdul_Nm':sd_Schdul_Nm,'sd_Schdul_Sumry':sd_Schdul_Sumry
	 };
	 $.ajax({
		 url : '<%=request.getContextPath()%>/schafs_schdul/insertSchdul',
		 contentType:'application/json; charset=utf-8',
		 data:JSON.stringify(dataWrite),
		 dateType:'text',
		 type:'post',
		 success: function(data){
			$('div #append1').append(data);
		 },
		 error: function(){
				alert('일정 등록 실패');
			}
	 });
 }

</script>


    
</head>
<body>
        <a class="offline-button" href="../index.html">Back</a>
    
    
        <div id="example">
            <div class="demo-section k-content">
                <div id="special-days">
                    <div id="calendar"></div>
                </div>
            </div>

             <script>
                $(document).ready(function() {
                    var today = new Date(),
                        events = [
                           +new Date(today.getFullYear(), today.getMonth(), 8),
                           +new Date(today.getFullYear(), today.getMonth(), 12),
                           +new Date(today.getFullYear(), today.getMonth(), 24),
                           +new Date(today.getFullYear(), today.getMonth() + 1, 6),
                           +new Date(today.getFullYear(), today.getMonth() + 1, 7),
                           +new Date(today.getFullYear(), today.getMonth() + 1, 25),
                           +new Date(today.getFullYear(), today.getMonth() + 1, 27),
                           +new Date(today.getFullYear(), today.getMonth() - 1, 3),
                           +new Date(today.getFullYear(), today.getMonth() - 1, 5),
                           +new Date(today.getFullYear(), today.getMonth() - 2, 22),
                           +new Date(today.getFullYear(), today.getMonth() - 2, 27)
                        ];

                    $("#calendar").kendoCalendar({
                        value: today,
                        dates: events,
                        weekNumber: true,
                        month: {
                            // template for dates in month view
                            content: '# if ($.inArray(+data.date, data.dates) != -1) { #' +
                                        '<div class="' +
                                           '# if (data.value < 10) { #' +
                                               "exhibition" +
                                           '# } else if ( data.value < 20 ) { #' +
                                               "party" +
                                           '# } else { #' +
                                               "cocktail" +
                                           '# } #' +
                                        '">#= data.value #</div>' +
                                     '# } else { #' +
                                     '#= data.value #' +
                                     '# } #',
                            weekNumber: '<a class="italic">#= data.weekNumber #</a>'
                        },
                        footer: false
                    });
                });
            </script>
            
        </div>


<form name="formm" method="post" action="schafs_schdul">
<table class="def-table-auto tb-border table-hover">
  <tr>
	<th>월</th>
	<th>시작날짜</th>
	<th>종료날짜</th>
	<th>일정명</th>
	<th style="width:500px;">일정요약</th>
	<td rowspan="2"><input type="button" class="def-btn btn-md btn-color" value="추가" onclick="insertSchdul();"></td>
  </tr>
  <tr>
	<td>
	<select name="selectmonth" class="combobox-sm custom-form-control">
					<option value="1월">01</option><option value="2월">02</option><option value="3월">03</option><option value="4월">04</option><option value="5월">05</option><option value="6월">06</option><option value="7월">07</option><option value="8월">08</option><option value="9월">09</option><option value="10월">10</option><option value="11월">11</option><option value="12월">12</option>
				</select>
	</td>
	<td>
	<input type="text" id="sd_Bgnde" name="sd_Bgnde" class="def-input-text-md custom-form-control">
	</td>
	<td>
	<input type="text" id="sd_Enddt" name="sd_Enddt" class="def-input-text-md custom-form-control">
	</td>
	<td>
	<input type="text" id="sd_Schdul_Nm" name="sd_Schdul_Nm" class="def-input-text-full custom-form-control">
	</td>
	<td>
	<input type="text" id="sd_Schdul_Sumry" name="sd_Schdul_Sumry" class="def-input-text-full custom-form-control">
	</td>
  </tr>
</table>
</form>
<!-- <p>일정추가:
월 &nbsp;
  시작일
  <input type="text" id="datepicker1" class="def-input-text-md custom-form-control">&nbsp; ~ &nbsp;
    종료일<input type="text" id="datepicker2" class="def-input-text-md custom-form-control">
  :
</p>
 -->

<div class="scheBox2">
	<table class="t_all">
		<tr>
			<th class="all_month">
				2017년<br>
				<strong>01</strong>월
			</th>
			<td class="all_zoom">
				<p>2017년 1월
				</p>
				<div id="append1"></div>
			</td>
		</tr>
		
		
		<tr>
			<th class="all_month">
				2017년<br>
				<strong>02</strong>월
			</th>
			<td class="all_zoom">
				<p>2017년 2월
				 <button class="def-btn btn-search btn-color" value="조회">+추가</button>
				</p>
				<div id="append2"></div>
			</td>
		</tr>
		<tr>
			<th class="all_month">
				2017년<br>
				<strong>03</strong>월
			</th>
			<td class="all_zoom">
				<p>2017년 3월
				 <button class="def-btn btn-search btn-color" value="조회">+추가</button>
				</p>
				<div id="append3"></div>
			</td>
		</tr>
		<tr>
			<th class="all_month">
				2017년<br>
				<strong>04</strong>월
			</th>
			<td class="all_zoom">
				<p>2017년 4월
				 <button class="def-btn btn-search btn-color" value="조회">+추가</button>
				</p>
				<div id="append4"></div>
			</td>
		</tr>
		<tr>
			<th class="all_month">
				2017년<br>
				<strong>05</strong>월
			</th>
			<td class="all_zoom">
				<p>2017년 5월
				 <button class="def-btn btn-search btn-color" value="조회">+추가</button>
				</p>
				<div id="append5"></div>
			</td>
		</tr>
		<tr>
			<th class="all_month">
				2017년<br>
				<strong>06</strong>월
			</th>
			<td class="all_zoom">
				<p>2017년 6월
				 <button class="def-btn btn-search btn-color" value="조회">+추가</button>
				</p>
				<div id="append6"></div>
			</td>
		</tr>
		<tr>
			<th class="all_month">
				2017년<br>
				<strong>07</strong>월
			</th>
			<td class="all_zoom">
				<p>2017년 7월
				 <button class="def-btn btn-search btn-color" value="조회">+추가</button>
				</p>
				<div id="append7"></div>
			</td>
		</tr>
		<tr>
			<th class="all_month">
				2017년<br>
				<strong>08</strong>월
			</th>
			<td class="all_zoom">
				<p>2017년 8월
				 <button class="def-btn btn-search btn-color" value="조회">+추가</button>
				</p>
				<div id="append8"></div>
			</td>
		</tr>
		<tr>
			<th class="all_month">
				2017년<br>
				<strong>09</strong>월
			</th>
			<td class="all_zoom">
				<p>2017년 9월
				 <button class="def-btn btn-search btn-color" value="조회">+추가</button>
				</p>
				<div id="append9"></div>
			</td>
		</tr>
		<tr>
			<th class="all_month">
				2017년<br>
				<strong>10</strong>월
			</th>
			<td class="all_zoom">
				<p>2017년 10월
				 <button class="def-btn btn-search btn-color" value="조회">+추가</button>
				</p>
				<div id="append10"></div>
			</td>
		</tr>
		<tr>
			<th class="all_month">
				2017년<br>
				<strong>11</strong>월
			</th>
			<td class="all_zoom">
				<p>2017년 11월
				 <button class="def-btn btn-search btn-color" value="조회">+추가</button>
				</p>
				<div id="append11"></div>
			</td>
		</tr>
		<tr>
			<th class="all_month">
				2017년<br>
				<strong>12</strong>월
			</th>
			<td class="all_zoom">
				<p>2017년 12월
				 <button class="def-btn btn-search btn-color" value="조회">+추가</button>
				</p>
				<div id="append12"></div>
			</td>
		</tr>
		
		
	



<!-- <tr>
			<th class="all_month">
				2017년<br>
				<strong>01</strong>월
			</th>
			<td class="all_zoom">
				<p>2017년 1월
				 <button id="monthbutton1" class="def-btn btn-search btn-color" value="조회">+추가</button>
				</p>
			<div id="content1" class="content">
				<select name="선택" class="combobox-sm custom-form-control">
					<option value="">01</option>
				</select>월
				<select name="선택" class="combobox-sm custom-form-control">
					<option value="">01</option><option value="">02</option><option value="">03</option><option value="">04</option><option value="">05</option><option value="">06</option><option value="">07</option><option value="">08</option><option value="">09</option><option value="">10</option><option value="">11</option><option value="">12</option><option value="">13</option><option value="">14</option><option value="">15</option><option value="">16</option><option value="">17</option><option value="">18</option><option value="">19</option><option value="">20</option><option value="">21</option><option value="">22</option><option value="">23</option><option value="">24</option><option value="">25</option><option value="">26</option><option value="">27</option><option value="">28</option><option value="">29</option><option value="">30</option><option value="">31</option>
				</select>&nbsp; ∼
				<select name="선택" class="combobox-sm custom-form-control">
					<option value="">01</option><option value="">02</option><option value="">03</option><option value="">04</option><option value="">05</option><option value="">06</option><option value="">07</option><option value="">08</option><option value="">09</option><option value="">10</option><option value="">11</option><option value="">12</option>
				</select>월
				<select name="선택" class="combobox-sm custom-form-control">
					<option value="">01</option><option value="">02</option><option value="">03</option><option value="">04</option><option value="">05</option><option value="">06</option><option value="">07</option><option value="">08</option><option value="">09</option><option value="">10</option><option value="">11</option><option value="">12</option><option value="">13</option><option value="">14</option><option value="">15</option><option value="">16</option><option value="">17</option><option value="">18</option><option value="">19</option><option value="">20</option><option value="">21</option><option value="">22</option><option value="">23</option><option value="">24</option><option value="">25</option><option value="">26</option><option value="">27</option><option value="">28</option><option value="">29</option><option value="">30</option><option value="">31</option>
				</select>&nbsp;:
			 <input type="text" class="def-input-text-lg custom-form-control" value="">
			 <button id="submit1" class="def-btn btn-search btn-color" value="등록">등록</button> <br>
			</div>
			<div id="contentplus1" class="content"></div>
			</td>
		</tr> -->

		
	</table>	
</div>


    
</body>

</html>
