<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>

<!DOCTYPE html>
<html>
<head>
<title></title>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/accordion.css">
<style>
* {
	padding:0;
	margin:0;
}
    
body{
	font-size:9pt;
}	

    
.no-uline {
	text-decoration:none;
	text-decoration:none !important;
}


</style>


<script src="<%=request.getContextPath()%>/js/jquery-1.11.0.min.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery.easing.1.3.js"></script>
<script src="<%=request.getContextPath()%>/js/accordion.js"></script>
<script>
$(document).ready(function(){
	 $("#accordionMenu1").folderAccordionMenu();
     
     // 이벤트 등록
     $("#accordionMenu1").on("open",function(e){
     console.log("open", e.$target.find(".main-title a").text());
     })
     
     $("#accordionMenu1").on("close",function(e){
     console.log("close", e.$target.find(".main-title a").text());
     })
     
     $("#accordionMenu1").on("select",function(e){
     var oldText = "없음";
     if(e.$oldItem)
         oldText = e.$oldItem.text();
     console.log("select old = ", oldText+", new = "+e.$newItem.text());
     })  
     
     // step #07-02
     $("#accordionMenu1").selectFolderAccordionMenu(0,1);
 	
 })


/*//////////////////////////////////////// */
(function($){
    // step #07-01  
    // folderAccordionMenu 플러그인
    $.fn.folderAccordionMenu=function(){
        // 선택자에 해당하는 요소 개수 만큼 FolderAccordionMenu 객체 생성
        this.each(function(index){
            var $this = $(this);
            var menu = new FolderAccordionMenu($this);
            $this.data("folderAccorionMenu", menu);   
        });
        
        return this;
    }
    
    // step #07-02
    // n번째 메뉴 선택
    $.fn.selectFolderAccordionMenu=function(mainIndex, subIndex, animation){
        this.each(function(index){
            var accordionMenu = $(this).data("folderAccorionMenu");
            accordionMenu.selectMenu(mainIndex, subIndex, animation);
        });
        
        return this;
    }
    
})(jQuery);


// step #02-01
function FolderAccordionMenu(selector){
    this.$accordionMenu = null;
    this._$mainMenuItems = null;
    
    // step #03
    // 선택 서브 메뉴 아이템 
    this._$selectSubItem = null;
    
    
    this._init(selector);
    this._initSubMenuPanel();
    
    // step #02-03
    this._initEvent();

}

/* step #02-01
* 요소 초기화
*/
FolderAccordionMenu.prototype._init=function(selector){
    this.$accordionMenu = $(selector);
    this._$mainMenuItems = this.$accordionMenu.children("li");   
}
    
    /* step #02-03
    * 이벤트 초기화
    */
FolderAccordionMenu.prototype._initEvent=function(){
    var objThis = this;
    this._$mainMenuItems.children(".main-title").click(function(e){
        var $item = $(this).parent();
        objThis.toggleSubMenuPanel($item);
    })
    
    // step #03
    this._$mainMenuItems.find(".sub li").click(function(e){
        objThis._selectSubMenuItem($(this));
    })
}

/* step #02-01
*  서브 패널 초기화 - 초기 시작히 닫힌 상태로 만들기 
*/
FolderAccordionMenu.prototype._initSubMenuPanel=function(){  
    var objThis =  this;
    this._$mainMenuItems.each(function(index){
        var $item = $(this);
        var $subMenu = $item.find(".sub");
        
        // 서브가 없는 경우 
        if($subMenu.length==0){
            $item.attr("data-extension","empty");           
            objThis._setFolderState($item, "empty");
        
        }else {
            if($item.attr("data-extension")=="open"){                           
                objThis.openSubMenu($item, false);
                
            }else{
                objThis.closeSubMenu($item,false);
            }
        }
    })
}

/* step #02-01
* 폴더 상태 설정
*/  
FolderAccordionMenu.prototype._setFolderState=function($item,state){
    var $folder = $item.find(".main-title .folder");
    // 기존 클래스를 모두 제거
    $folder.removeClass();
    $folder.addClass("folder "+state);

}

/*
* step #02-02
* 서브 메뉴 패널 열기 
* animation 기본 값은 true
*/
FolderAccordionMenu.prototype.openSubMenu=function($item, animation){

    if($item != null){
        $item.attr("data-extension", "open");
        
        var $subMenu = $item.find(".sub");
        
        // step #02-04
        if(animation==false){
            $subMenu.css({
                marginTop:0
            });
        }else {
            $subMenu.stop().animate({
                    marginTop:0
                },300,"easeInCubic"
            );
        }
        
        this._setFolderState($item, "open");
        
        // step #05-01
        // open 이벤트 발생
        this._dispatchOpenCloseEvent($item, "open");
    }
}

/*
* step #02-02
* 서브 메뉴 패널 닫기
* animation 기본 값은 true
*/
FolderAccordionMenu.prototype.closeSubMenu=function($item, animation){
    if($item != null){
        $item.attr("data-extension", "close");
        
        var $subMenu = $item.find(".sub");
        
        // step #02-04
        var subMenuPanelHeight = -$subMenu.outerHeight(true);
        if(animation==false){
            $subMenu.css({
                marginTop:subMenuPanelHeight
            });
        }else {
            $subMenu.stop().animate({
                    marginTop:subMenuPanelHeight
                },300,"easeInCubic"
            );
        }
        
        this._setFolderState($item, "close");
        
        // step #05-01
        // close 이벤트 발생
        this._dispatchOpenCloseEvent($item, "close");
    }
}

/*
* step #02-03
* 서브메뉴 패널 열고 닫기 
*/
FolderAccordionMenu.prototype.toggleSubMenuPanel=function($item){
    var extension = $item.attr("data-extension");
    
    // 서브가 없는 경우 취소
    if(extension=="empty"){
        return;
    }

    if(extension=="open"){      
        this.closeSubMenu($item);
    }else{
        this.openSubMenu($item);
    }
}

/*
 * step #02-05
 * index 메뉴의 서브 메뉴 패널 닫기
 */
FolderAccordionMenu.prototype.closeSubMenuAt=function(index, animation){
    var $item = this._$mainMenuItems.eq(index);
    this.closeSubMenu($item, animation);
}

/*
 * step #02-05
 * index 메뉴의 서브 메뉴 패널 열기
 */
FolderAccordionMenu.prototype.openSubMenuAt=function(index, animation){
    var $item = this._$mainMenuItems.eq(index);
    this.openSubMenu($item, animation);
}

/*
 * step #03
 * 서브 메뉴 아이템 선택 
 */
FolderAccordionMenu.prototype._selectSubMenuItem=function($item){
    
    var $oldItem = this._$selectSubItem; 
        
    if(this._$selectSubItem != null){
        this._$selectSubItem.removeClass("select");
    }
    
    this._$selectSubItem = $item;
    this._$selectSubItem.addClass("select");
    
    // step #05-02
    // 선택 이벤트 발생
    this._dispatchSelectEvent($oldItem, this._$selectSubItem);
}

/* 
 * step #04
 * 메뉴 선택 기능 
 * @mainIndex : 메인 메뉴 아이템 index
 * @subIndex : 서브 메뉴 아이템 index
 * @animation : 애니메이션 실행 유무 
 */
FolderAccordionMenu.prototype.selectMenu=function(mainIndex,subIndex, animation){
    
    // 메인 메뉴 아이템 
    var $item = this._$mainMenuItems.eq(mainIndex);
    // 서브 메뉴 아이템
    var $subMenuItem = $item.find(".sub li").eq(subIndex);
    if($subMenuItem){
        // 서브 메뉴 패널 열기
        this.openSubMenu($item, animation);
        
        // 서브 메뉴 아이템 서택
        this._selectSubMenuItem($subMenuItem);
    }
}

// step #05-01
// open, close 이벤트 발생
FolderAccordionMenu.prototype._dispatchOpenCloseEvent=function($item, eventName){
    
    var event = jQuery.Event(eventName);
    event.$target=$item;
    
    this.$accordionMenu.trigger(event);
}

// step #05-02
// select 이벤트 발생
FolderAccordionMenu.prototype._dispatchSelectEvent=function($oldItem, $newItem){
    
    var event = jQuery.Event("select");
    event.$oldItem = $oldItem;
    event.$newItem = $newItem;
    
    this.$accordionMenu.trigger(event);
}




</script>

</head>
<body>

<!-- 상단바 시작 -->
	<nav class="navbar navbar-inverse" id="topnav">
		<div class="container-fluid" id="toptable">
			<div class="navbar-header" style="width: 100%;">
				<table id="topnav-table">
					<tr>
						<td><a href="#"><img src="<%=request.getContextPath()%>/images/logo.png" id="logo"></a></td>
						<td></td>
					</tr>
				</table>
				
				<!-- 로그인한 사용자 정보 받아오는건 추후에 쿼리로 받아오거나 해야함 -->
				
				<button class="def-btn float-r" onclick="logout_go">Logout</button>
			</div>
		</div>
	</nav>
<!-- 상단바 끝 -->

<!-- 상단메뉴 시작 -->

<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<!-- <div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		</div> -->
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav navbar-left">
			
			
			<!-- 권한 관련 추후에 설정 -->	
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">직원 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#" class="no-uline">직원메뉴1 </a></li>
						<li><a href="#" class="no-uline">메뉴2 </a></li>
					</ul></li>
				
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">교수 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">교수메뉴1 </a></li>
						<li><a href="#">메뉴2 </a></li>
					</ul></li>
				
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">학생 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">학생메뉴1 </a></li>
						<li><a href="#">메뉴2 </a></li>
					</ul></li>
				<!-- 여기까지 -->
									
					
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">학사 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">학사메뉴1 </a></li>
						<li><a href="#">메뉴2 </a></li>
					</ul></li>	
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">수강신청 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">수강신청메뉴1 </a></li>
						<li><a href="#">메뉴2 </a></li>
					</ul></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">강의 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">강의메뉴1 </a></li>
						<li><a href="#">메뉴2 </a></li>
					</ul></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">커뮤니티 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">커뮤니티메뉴1 </a></li>
						<li><a href="#">메뉴2 </a></li>
					</ul></li>
				
				
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">관리자 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">관리자메뉴1 </a></li>
						<li><a href="#">메뉴2 </a></li>
					</ul></li>
				
			</ul>

		</div>
	</div>
</nav>


<!-- 상단 메뉴 끝 -->	

<!-- 좌측메뉴 시작 -->
	<div class="container-fluid">
		<div class="row content">
			<div class="col-sm-2 sidenav">
				<!-- <p>1</p>
				<p class="main_menu">
				<a href="#">상위메뉴</a></p>
				
				<p class="sub_meun">
				<a href="#">하위메뉴</a>
				</p>
				<p>2</p> -->
				
			<!-- ////////////////// -->	
	<ul class="accordion-menu" id="accordionMenu1">
		<li data-extension="close">
			<div class="main-title"><span class="folder main_menu"> </span><a href="#" class="no-uline">직원</a></div>
			<ul class="sub sub_meun">
				<li style="margin-left:2em;"><a href="#" class="no-uline">직원메뉴1 </a></li>
				<li style="margin-left:2em;"><a href="#" class="no-uline">메뉴2 </a></li>
			</ul>
		</li>		
		
		<li>
			<div class="main-title"><span class="folder main_menu"> </span><a href="#" class="no-uline">교수</a> </div>
			<ul class="sub sub_meun">
				<li style="margin-left:2em;"><a href="#" class="no-uline">학생메뉴1 </a></li>
				<li style="margin-left:2em;"><a href="#" class="no-uline">메뉴2 </a></li>
			</ul>
		</li>
			
		<li>
			<div class="main-title"><span class="folder main_menu"> </span><a href="#" class="no-uline">학생</a> </div>
			<ul class="sub sub_meun">
				<li style="margin-left:2em;"><a href="#" class="no-uline">학생메뉴1 </a></li>
				<li style="margin-left:2em;"><a href="#" class="no-uline">메뉴2 </a></li>
			</ul>
		</li>
		
		<li>
			<div class="main-title"><span class="folder main_menu"> </span><a href="#" class="no-uline">학사</a> </div>
			<ul class="sub sub_meun">
				<li style="margin-left:2em;"><a href="#" class="no-uline">학사메뉴1 </a></li>
				<li style="margin-left:2em;"><a href="#" class="no-uline">메뉴2 </a></li>
			</ul>
		</li>
		
		<li>
			<div class="main-title"><span class="folder main_menu"> </span><a href="#" class="no-uline">수강신청</a> </div>
			<ul class="sub sub_meun">
				<li style="margin-left:2em;"><a href="#" class="no-uline">수강신청메뉴1 </a></li>
				<li style="margin-left:2em;"><a href="#" class="no-uline">메뉴2 </a></li>
			</ul>
		</li>
		
		<li>
			<div class="main-title"><span class="folder main_menu"> </span><a href="#" class="no-uline">강의</a> </div>
			<ul class="sub sub_meun">
				<li style="margin-left:2em;"><a href="#" class="no-uline">강의메뉴1 </a></li>
				<li style="margin-left:2em;"><a href="#" class="no-uline">메뉴2 </a></li>
			</ul>
		</li>
		
		<li>
			<div class="main-title"><span class="folder main_menu"> </span><a href="#" class="no-uline">커뮤니티</a> </div>
			<ul class="sub sub_meun">
				<li style="margin-left:2em;"><a href="#" class="no-uline">커뮤니티메뉴1 </a></li>
				<li style="margin-left:2em;"><a href="#" class="no-uline">메뉴2 </a></li>
			</ul>
		</li>
		
		<li>
			<div class="main-title"><span class="folder main_menu"> </span><a href="#" class="no-uline">관리자</a> </div>
			<ul class="sub sub_meun">
				<li style="margin-left:2em;"><a href="#" class="no-uline">관리자메뉴1 </a></li>
				<li style="margin-left:2em;"><a href="#" class="no-uline">메뉴2 </a></li>
			</ul>
		</li>
		
		
		
	</ul> 
	<!-- ////////////////// -->
				
				
				
				
			</div>
			
			<div class="col-sm-10 text-left">
			
<decorator:body />
			</div>
			
			
		</div>
	</div>
<!-- 좌측메뉴 끝 -->




<!-- Footer 시작 -->
	<footer class="footer">
		<p>Footer Text</p>
	</footer>
<!-- Footer 끝 -->


</body>
</html>
