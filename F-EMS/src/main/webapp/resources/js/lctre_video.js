function detailLctre_Video(lv_Bbs_No,table_Nm,tpage){
	var url = "detailLctre_Video_Stdnt?lv_Bbs_No="+lv_Bbs_No+"&table_Nm="+table_Nm+"&tpage="+tpage;
	  window.open( url, "_blank_1",
	"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=1000, height=1000, top=300, left=300, ");
}

function getTimeRemaining(endtime) {
  var t = -Date.parse(endtime) +Date.parse(new Date());
  var seconds = Math.floor((t / 1000) % 60);
  var minutes = Math.floor((t / 1000 / 60));
  return {
    'total': t,
    'minutes': minutes,
    'seconds': seconds
  };
}

function initializeClock(id, endtime) {
  var clock = document.getElementById(id);
  var minutesSpan = clock.querySelector('.minutes');
  var secondsSpan = clock.querySelector('.seconds');

  function updateClock() {
    var t = getTimeRemaining(endtime);
	    minutesSpan.innerHTML = ('0' + t.minutes).slice(-2);
	    secondsSpan.innerHTML = ('0' + t.seconds).slice(-2);
  	}
	updateClock();
	var timeinterval = setInterval(updateClock, 1000);
}

	