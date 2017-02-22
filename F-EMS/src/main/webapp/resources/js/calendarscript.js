/* Kurien / Kurien's Blog / http://blog.kurien.co.kr */
/* 주석만 제거하지 않는다면, 어떤 용도로 사용하셔도 좋습니다. */

function kCalendar(id, date) {
	var kCalendar = document.getElementById(id);
	
	if( typeof( date ) !== 'undefined' ) {
		date = date.split('-');
		date[1] = date[1] - 1;
		date = new Date(date[0], date[1], date[2]);
	} else {
		var date = new Date();
	}
	var currentYear = date.getFullYear();
	//년도를 구함
	
	var currentMonth = date.getMonth() + 1;
	//연을 구함. 월은 0부터 시작하므로 +1, 12월은 11을 출력
	
	var currentDate = date.getDate();
	//오늘 일자.
	
	date.setDate(1);
	var currentDay = date.getDay();
	//이번달 1일의 요일은 출력. 0은 일요일 6은 토요일
	
	var dateString = new Array('sun', 'mon', 'tue', 'wed', 'thu', 'fri', 'sat');
	var lastDate = new Array(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);
	if( (currentYear % 4 === 0 && currentYear % 100 !== 0) || currentYear % 400 === 0 )
		lastDate[1] = 29;
	//각 달의 마지막 일을 계산, 윤년의 경우 년도가 4의 배수이고 100의 배수가 아닐 때 혹은 400의 배수일 때 2월달이 29일 임.
	
	var currentLastDate = lastDate[currentMonth-1];
	var week = Math.ceil( ( currentDay + currentLastDate ) / 7 );
	//총 몇 주인지 구함.
	
	if(currentMonth != 1)
		var prevDate = currentYear + '-' + ( currentMonth - 1 ) + '-' + currentDate;
	else
		var prevDate = ( currentYear - 1 ) + '-' + 12 + '-' + currentDate;
	//만약 이번달이 1월이라면 1년 전 12월로 출력.
	
	if(currentMonth != 12) 
		var nextDate = currentYear + '-' + ( currentMonth + 1 ) + '-' + currentDate;
	else
		var nextDate = ( currentYear + 1 ) + '-' + 1 + '-' + currentDate;
	//만약 이번달이 12월이라면 1년 후 1월로 출력.

	
	if( currentMonth < 10 )
		var currentMonth = '0' + currentMonth;
	if( currentMonth >=10)
		var currentMonth = ''+ currentMonth;
	//10월 이하라면 앞에 0을 붙여준다.
	
	var calendar = '';
	calendar += '<div id="header">';
	calendar += '			<span><a href="#" class="button left" onclick="kCalendar(\'' +  id + '\', \'' + prevDate + '\')"><</a></span>';
	calendar += '			<span id="date">' + currentYear + '년 ' + currentMonth + '월</span>';
	calendar += '			<span><a href="#" class="button right" onclick="kCalendar(\'' + id + '\', \'' + nextDate + '\')">></a></span>';
	calendar += '		</div>';
	calendar += '		<table border="0" cellspacing="0" cellpadding="0">';
	calendar += '			<caption>' + currentYear + '년 ' + currentMonth + '월 달력</caption>';
	calendar += '			<thead>';
	calendar += '				<tr>';
	calendar += '				  <th class="sun" scope="row">일</th>';
	calendar += '				  <th class="mon" scope="row">월</th>';
	calendar += '				  <th class="tue" scope="row">화</th>';
	calendar += '				  <th class="wed" scope="row">수</th>';
	calendar += '				  <th class="thu" scope="row">목</th>';
	calendar += '				  <th class="fri" scope="row">금</th>';
	calendar += '				  <th class="sat" scope="row">토</th>';
	calendar += '				</tr>';
	calendar += '			</thead>';
	calendar += '			<tbody>';
	
	var dateNum = 1 - currentDay;
	
	for(var i = 0; i < week; i++) {
		calendar += '			<tr>';
		for(var j = 0; j < 7; j++, dateNum++) {
			if( dateNum < 1 || dateNum > currentLastDate ) {
				calendar += '				<td class="' + dateString[j] + '"> </td>';
				continue;
			}
			calendar += '				<td class="' + dateString[j] + '">' + dateNum + '</td>';
		}
		calendar += '			</tr>';
	}
	
	calendar += '			</tbody>';
	calendar += '		</table>';
	
	
/*	
	function dateToYYYYMMDD(date){
	    function pad(num) {
	        num = num + '';
	        return num.length < 2 ? '0' + num : num;
	    }
	    return date.getFullYear() + '-' + pad(date.getMonth()+1) + '-' + pad(date.getDate());
	}

	*/
	var cdate = new Date();
	var cyear = cdate.getFullYear();
	var cmonth = '<strong>';
		cmonth += currentMonth;
		cmonth += '</strong>';
	var yearmonth = '<p>'+currentYear+'년 '+currentMonth+'월 </p>';
	
	if(currentYear==cyear){
	var data={'currentMonth':currentMonth};
    $.ajax({
        url:'currentDate',
        contentType:'application/json',
        dataType:'json',
        data:JSON.stringify(data),
        type:'post',
        success : function(data){
        	$('div #monthdata').empty();
           	$('div #year1').empty();
           	$('div #month1').empty();
            $('div #monthdata').empty();
            $('div #yearmonth').empty();
            
        var form = '';
        for(var i=0;i<data.length;i++){
       

        	
       form +=  data[i].sd_Bgndt;
       form +=  '&nbsp; ~ &nbsp;';
       form +=  data[i].sd_Enddt;
       form += ': &nbsp;'+ data[i].sd_Schdul_Sumry; 
       form += '<br>';
        
        
      } 
        $('div #year1').html(currentYear);
        $('div #month1').html(cmonth);
        $('div #monthdata').html(form);
        $('div #yearmonth').html(yearmonth);
        
       
      },
      error:function(request,status,error){
      alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);}

    	
     });
	}else{
    	$('div #monthdata').empty();
       	$('div #year1').empty();
       	$('div #month1').empty();
        $('div #yearmonth').empty();
		$('div #monthdata').empty();
		
	    $('div #year1').html(currentYear);
        $('div #month1').html(cmonth);
        $('div #yearmonth').html(yearmonth);
		
	}
	
	
	
	kCalendar.innerHTML = calendar;
	
	
}