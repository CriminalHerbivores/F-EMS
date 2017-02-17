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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<style>
.scheBox2 {
    border: 1px solid #cfcfcf;
    padding: 5px 10px 5px 5px;
}
table{
width:100%;
border-spacing: 0px;
border-collapse: separate;
}

.scheBox2 .t_all .all_month {
    color: #666161;
    font-weight: bold;
    line-height: 45px;
    text-align: center;
    padding-top: 5px;
    background: #eee;
    border-bottom: 1px dashed #b7b7b7;
}



.scheBox2 .t_all .all_month {
    width:20%;
   font-size: 12px;
}

.scheBox2 .t_all .all_month strong {
    color: #000;
    font-size: 50px;
    font-family: Helvetica, sans-serif;
}

.scheBox2 .t_all .all_zoom {
    border-bottom: 1px dashed #b7b7b7;
    font-size: 12px;
    
}

.scheBox2 .t_all .all_zoom p {
    margin: 17px 10px 0px 14px;
    padding-left: 6px;
    padding-bottom: 4px;
    border-bottom: 1px solid #cfcfcf;
    font-weight: bold;
}


.scheBox2 .t_all .all_zoom .content {
    margin: 20px 10px 23px 24px;
    padding: 0px;
    list-style: none;
    line-height: 16px;
}


</style>    
    
    
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

<div class="scheBox2">
	<table class="t_all">
		<tr>
			<th class="all_month">
				2017년<br>
				<strong>01</strong>월
			</th>
			<td class="all_zoom">
				<p>2017년 1월
				 <button class="def-btn btn-search btn-color" value="조회">+추가</button>
				</p>
			<div class="content">
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
			 <input type="button" class="def-btn btn-md btn-color" value="등록">
			</div>
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
			<div class="content">
				<select name="선택" class="combobox-sm custom-form-control">
					<option value="">02</option>
				</select>월
				<select name="선택" class="combobox-sm custom-form-control">
					<option value="">01</option><option value="">02</option><option value="">03</option><option value="">04</option><option value="">05</option><option value="">06</option><option value="">07</option><option value="">08</option><option value="">09</option><option value="">10</option><option value="">11</option><option value="">12</option><option value="">13</option><option value="">14</option><option value="">15</option><option value="">16</option><option value="">17</option><option value="">18</option><option value="">19</option><option value="">20</option><option value="">21</option><option value="">22</option><option value="">23</option><option value="">24</option><option value="">25</option><option value="">26</option><option value="">27</option><option value="">28</option>
				</select>&nbsp; ∼
				<select name="선택" class="combobox-sm custom-form-control">
					<option value="">02</option><option value="">03</option><option value="">04</option><option value="">05</option><option value="">06</option><option value="">07</option><option value="">08</option><option value="">09</option><option value="">10</option><option value="">11</option><option value="">12</option>
				</select>월
				<select name="선택" class="combobox-sm custom-form-control">
					<option value="">01</option><option value="">02</option><option value="">03</option><option value="">04</option><option value="">05</option><option value="">06</option><option value="">07</option><option value="">08</option><option value="">09</option><option value="">10</option><option value="">11</option><option value="">12</option><option value="">13</option><option value="">14</option><option value="">15</option><option value="">16</option><option value="">17</option><option value="">18</option><option value="">19</option><option value="">20</option><option value="">21</option><option value="">22</option><option value="">23</option><option value="">24</option><option value="">25</option><option value="">26</option><option value="">27</option><option value="">28</option>
				</select>&nbsp;:
			 <input type="text" class="def-input-text-lg custom-form-control" value=""><br />
			</div>
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
			<div class="content">
				<select name="선택" class="combobox-sm custom-form-control">
					<option value="">03</option>
				</select>월
				<select name="선택" class="combobox-sm custom-form-control">
					<option value="">01</option><option value="">02</option><option value="">03</option><option value="">04</option><option value="">05</option><option value="">06</option><option value="">07</option><option value="">08</option><option value="">09</option><option value="">10</option><option value="">11</option><option value="">12</option><option value="">13</option><option value="">14</option><option value="">15</option><option value="">16</option><option value="">17</option><option value="">18</option><option value="">19</option><option value="">20</option><option value="">21</option><option value="">22</option><option value="">23</option><option value="">24</option><option value="">25</option><option value="">26</option><option value="">27</option><option value="">28</option><option value="">29</option><option value="">30</option><option value="">31</option>
				</select>&nbsp; ∼
				<select name="선택" class="combobox-sm custom-form-control">
					<option value="">03</option><option value="">04</option><option value="">05</option><option value="">06</option><option value="">07</option><option value="">08</option><option value="">09</option><option value="">10</option><option value="">11</option><option value="">12</option>
				</select>월
				<select name="선택" class="combobox-sm custom-form-control">
					<option value="">01</option><option value="">02</option><option value="">03</option><option value="">04</option><option value="">05</option><option value="">06</option><option value="">07</option><option value="">08</option><option value="">09</option><option value="">10</option><option value="">11</option><option value="">12</option><option value="">13</option><option value="">14</option><option value="">15</option><option value="">16</option><option value="">17</option><option value="">18</option><option value="">19</option><option value="">20</option><option value="">21</option><option value="">22</option><option value="">23</option><option value="">24</option><option value="">25</option><option value="">26</option><option value="">27</option><option value="">28</option><option value="">29</option><option value="">30</option><option value="">31</option>
				</select>&nbsp;:
			 <input type="text" class="def-input-text-lg custom-form-control" value=""><br />
			</div>
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
			<div class="content">
				<select name="선택" class="combobox-sm custom-form-control">
					<option value="">04</option>
				</select>월
				<select name="선택" class="combobox-sm custom-form-control">
					<option value="">01</option><option value="">02</option><option value="">03</option><option value="">04</option><option value="">05</option><option value="">06</option><option value="">07</option><option value="">08</option><option value="">09</option><option value="">10</option><option value="">11</option><option value="">12</option><option value="">13</option><option value="">14</option><option value="">15</option><option value="">16</option><option value="">17</option><option value="">18</option><option value="">19</option><option value="">20</option><option value="">21</option><option value="">22</option><option value="">23</option><option value="">24</option><option value="">25</option><option value="">26</option><option value="">27</option><option value="">28</option><option value="">29</option><option value="">30</option>
				</select>&nbsp; ∼
				<select name="선택" class="combobox-sm custom-form-control">
					<option value="">04</option><option value="">05</option><option value="">06</option><option value="">07</option><option value="">08</option><option value="">09</option><option value="">10</option><option value="">11</option><option value="">12</option>
				</select>월
				<select name="선택" class="combobox-sm custom-form-control">
					<option value="">01</option><option value="">02</option><option value="">03</option><option value="">04</option><option value="">05</option><option value="">06</option><option value="">07</option><option value="">08</option><option value="">09</option><option value="">10</option><option value="">11</option><option value="">12</option><option value="">13</option><option value="">14</option><option value="">15</option><option value="">16</option><option value="">17</option><option value="">18</option><option value="">19</option><option value="">20</option><option value="">21</option><option value="">22</option><option value="">23</option><option value="">24</option><option value="">25</option><option value="">26</option><option value="">27</option><option value="">28</option><option value="">29</option><option value="">30</option>
				</select>&nbsp;:
			 <input type="text" class="def-input-text-lg custom-form-control" value=""><br />
			</div>
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
			<div class="content">
				<select name="선택" class="combobox-sm custom-form-control">
					<option value="">05</option>
				</select>월
				<select name="선택" class="combobox-sm custom-form-control">
					<option value="">01</option><option value="">02</option><option value="">03</option><option value="">04</option><option value="">05</option><option value="">06</option><option value="">07</option><option value="">08</option><option value="">09</option><option value="">10</option><option value="">11</option><option value="">12</option><option value="">13</option><option value="">14</option><option value="">15</option><option value="">16</option><option value="">17</option><option value="">18</option><option value="">19</option><option value="">20</option><option value="">21</option><option value="">22</option><option value="">23</option><option value="">24</option><option value="">25</option><option value="">26</option><option value="">27</option><option value="">28</option><option value="">29</option><option value="">30</option><option value="">31</option>
				</select>&nbsp; ∼
				<select name="선택" class="combobox-sm custom-form-control">
					<option value="">05</option><option value="">06</option><option value="">07</option><option value="">08</option><option value="">09</option><option value="">10</option><option value="">11</option><option value="">12</option>
				</select>월
				<select name="선택" class="combobox-sm custom-form-control">
					<option value="">01</option><option value="">02</option><option value="">03</option><option value="">04</option><option value="">05</option><option value="">06</option><option value="">07</option><option value="">08</option><option value="">09</option><option value="">10</option><option value="">11</option><option value="">12</option><option value="">13</option><option value="">14</option><option value="">15</option><option value="">16</option><option value="">17</option><option value="">18</option><option value="">19</option><option value="">20</option><option value="">21</option><option value="">22</option><option value="">23</option><option value="">24</option><option value="">25</option><option value="">26</option><option value="">27</option><option value="">28</option><option value="">29</option><option value="">30</option><option value="">31</option>
				</select>&nbsp;:
			 <input type="text" class="def-input-text-lg custom-form-control" value=""><br />
			</div>
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
			<div class="content">
				<select name="선택" class="combobox-sm custom-form-control">
					<option value="">06</option>
				</select>월
				<select name="선택" class="combobox-sm custom-form-control">
					<option value="">01</option><option value="">02</option><option value="">03</option><option value="">04</option><option value="">05</option><option value="">06</option><option value="">07</option><option value="">08</option><option value="">09</option><option value="">10</option><option value="">11</option><option value="">12</option><option value="">13</option><option value="">14</option><option value="">15</option><option value="">16</option><option value="">17</option><option value="">18</option><option value="">19</option><option value="">20</option><option value="">21</option><option value="">22</option><option value="">23</option><option value="">24</option><option value="">25</option><option value="">26</option><option value="">27</option><option value="">28</option><option value="">29</option><option value="">30</option>
				</select>&nbsp; ∼
				<select name="선택" class="combobox-sm custom-form-control">
					<option value="">06</option><option value="">07</option><option value="">08</option><option value="">09</option><option value="">10</option><option value="">11</option><option value="">12</option>
				</select>월
				<select name="선택" class="combobox-sm custom-form-control">
					<option value="">01</option><option value="">02</option><option value="">03</option><option value="">04</option><option value="">05</option><option value="">06</option><option value="">07</option><option value="">08</option><option value="">09</option><option value="">10</option><option value="">11</option><option value="">12</option><option value="">13</option><option value="">14</option><option value="">15</option><option value="">16</option><option value="">17</option><option value="">18</option><option value="">19</option><option value="">20</option><option value="">21</option><option value="">22</option><option value="">23</option><option value="">24</option><option value="">25</option><option value="">26</option><option value="">27</option><option value="">28</option><option value="">29</option><option value="">30</option>
				</select>&nbsp;:
			 <input type="text" class="def-input-text-lg custom-form-control" value=""><br />
			</div>
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
			<div class="content">
				<select name="선택" class="combobox-sm custom-form-control">
					<option value="">07</option>
				</select>월
				<select name="선택" class="combobox-sm custom-form-control">
					<option value="">01</option><option value="">02</option><option value="">03</option><option value="">04</option><option value="">05</option><option value="">06</option><option value="">07</option><option value="">08</option><option value="">09</option><option value="">10</option><option value="">11</option><option value="">12</option><option value="">13</option><option value="">14</option><option value="">15</option><option value="">16</option><option value="">17</option><option value="">18</option><option value="">19</option><option value="">20</option><option value="">21</option><option value="">22</option><option value="">23</option><option value="">24</option><option value="">25</option><option value="">26</option><option value="">27</option><option value="">28</option><option value="">29</option><option value="">30</option><option value="">31</option>
				</select>&nbsp; ∼
				<select name="선택" class="combobox-sm custom-form-control">
					<option value="">07</option><option value="">08</option><option value="">09</option><option value="">10</option><option value="">11</option><option value="">12</option>
				</select>월
				<select name="선택" class="combobox-sm custom-form-control">
					<option value="">01</option><option value="">02</option><option value="">03</option><option value="">04</option><option value="">05</option><option value="">06</option><option value="">07</option><option value="">08</option><option value="">09</option><option value="">10</option><option value="">11</option><option value="">12</option><option value="">13</option><option value="">14</option><option value="">15</option><option value="">16</option><option value="">17</option><option value="">18</option><option value="">19</option><option value="">20</option><option value="">21</option><option value="">22</option><option value="">23</option><option value="">24</option><option value="">25</option><option value="">26</option><option value="">27</option><option value="">28</option><option value="">29</option><option value="">30</option><option value="">31</option>
				</select>&nbsp;:
			 <input type="text" class="def-input-text-lg custom-form-control" value=""><br />
			</div>
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
			<div class="content">
				<select name="선택" class="combobox-sm custom-form-control">
					<option value="">08</option>
				</select>월
				<select name="선택" class="combobox-sm custom-form-control">
					<option value="">01</option><option value="">02</option><option value="">03</option><option value="">04</option><option value="">05</option><option value="">06</option><option value="">07</option><option value="">08</option><option value="">09</option><option value="">10</option><option value="">11</option><option value="">12</option><option value="">13</option><option value="">14</option><option value="">15</option><option value="">16</option><option value="">17</option><option value="">18</option><option value="">19</option><option value="">20</option><option value="">21</option><option value="">22</option><option value="">23</option><option value="">24</option><option value="">25</option><option value="">26</option><option value="">27</option><option value="">28</option><option value="">29</option><option value="">30</option><option value="">31</option>
				</select>&nbsp; ∼
				<select name="선택" class="combobox-sm custom-form-control">
					<option value="">08</option><option value="">09</option><option value="">10</option><option value="">11</option><option value="">12</option>
				</select>월
				<select name="선택" class="combobox-sm custom-form-control">
					<option value="">01</option><option value="">02</option><option value="">03</option><option value="">04</option><option value="">05</option><option value="">06</option><option value="">07</option><option value="">08</option><option value="">09</option><option value="">10</option><option value="">11</option><option value="">12</option><option value="">13</option><option value="">14</option><option value="">15</option><option value="">16</option><option value="">17</option><option value="">18</option><option value="">19</option><option value="">20</option><option value="">21</option><option value="">22</option><option value="">23</option><option value="">24</option><option value="">25</option><option value="">26</option><option value="">27</option><option value="">28</option><option value="">29</option><option value="">30</option><option value="">31</option>
				</select>&nbsp;:
			 <input type="text" class="def-input-text-lg custom-form-control" value=""><br />
			</div>
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
			<div class="content">
				<select name="선택" class="combobox-sm custom-form-control">
					<option value="">09</option>
				</select>월
				<select name="선택" class="combobox-sm custom-form-control">
					<option value="">01</option><option value="">02</option><option value="">03</option><option value="">04</option><option value="">05</option><option value="">06</option><option value="">07</option><option value="">08</option><option value="">09</option><option value="">10</option><option value="">11</option><option value="">12</option><option value="">13</option><option value="">14</option><option value="">15</option><option value="">16</option><option value="">17</option><option value="">18</option><option value="">19</option><option value="">20</option><option value="">21</option><option value="">22</option><option value="">23</option><option value="">24</option><option value="">25</option><option value="">26</option><option value="">27</option><option value="">28</option><option value="">29</option><option value="">30</option>
				</select>&nbsp; ∼
				<select name="선택" class="combobox-sm custom-form-control">
					<option value="">09</option><option value="">10</option><option value="">11</option><option value="">12</option>
				</select>월
				<select name="선택" class="combobox-sm custom-form-control">
					<option value="">01</option><option value="">02</option><option value="">03</option><option value="">04</option><option value="">05</option><option value="">06</option><option value="">07</option><option value="">08</option><option value="">09</option><option value="">10</option><option value="">11</option><option value="">12</option><option value="">13</option><option value="">14</option><option value="">15</option><option value="">16</option><option value="">17</option><option value="">18</option><option value="">19</option><option value="">20</option><option value="">21</option><option value="">22</option><option value="">23</option><option value="">24</option><option value="">25</option><option value="">26</option><option value="">27</option><option value="">28</option><option value="">29</option><option value="">30</option>
				</select>&nbsp;:
			 <input type="text" class="def-input-text-lg custom-form-control" value=""><br />
			</div>
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
			<div class="content">
				<select name="선택" class="combobox-sm custom-form-control">
					<option value="">10</option>
				</select>월
				<select name="선택" class="combobox-sm custom-form-control">
					<option value="">01</option><option value="">02</option><option value="">03</option><option value="">04</option><option value="">05</option><option value="">06</option><option value="">07</option><option value="">08</option><option value="">09</option><option value="">10</option><option value="">11</option><option value="">12</option><option value="">13</option><option value="">14</option><option value="">15</option><option value="">16</option><option value="">17</option><option value="">18</option><option value="">19</option><option value="">20</option><option value="">21</option><option value="">22</option><option value="">23</option><option value="">24</option><option value="">25</option><option value="">26</option><option value="">27</option><option value="">28</option><option value="">29</option><option value="">30</option><option value="">31</option>
				</select>&nbsp; ∼
				<select name="선택" class="combobox-sm custom-form-control">
				<option value="">10</option><option value="">11</option><option value="">12</option>
				</select>월
				<select name="선택" class="combobox-sm custom-form-control">
					<option value="">01</option><option value="">02</option><option value="">03</option><option value="">04</option><option value="">05</option><option value="">06</option><option value="">07</option><option value="">08</option><option value="">09</option><option value="">10</option><option value="">11</option><option value="">12</option><option value="">13</option><option value="">14</option><option value="">15</option><option value="">16</option><option value="">17</option><option value="">18</option><option value="">19</option><option value="">20</option><option value="">21</option><option value="">22</option><option value="">23</option><option value="">24</option><option value="">25</option><option value="">26</option><option value="">27</option><option value="">28</option><option value="">29</option><option value="">30</option><option value="">31</option>
				</select>&nbsp;:
			 <input type="text" class="def-input-text-lg custom-form-control" value=""><br />
			</div>
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
			<div class="content">
				<select name="선택" class="combobox-sm custom-form-control">
					<option value="">11</option>
				</select>월
				<select name="선택" class="combobox-sm custom-form-control">
					<option value="">01</option><option value="">02</option><option value="">03</option><option value="">04</option><option value="">05</option><option value="">06</option><option value="">07</option><option value="">08</option><option value="">09</option><option value="">10</option><option value="">11</option><option value="">12</option><option value="">13</option><option value="">14</option><option value="">15</option><option value="">16</option><option value="">17</option><option value="">18</option><option value="">19</option><option value="">20</option><option value="">21</option><option value="">22</option><option value="">23</option><option value="">24</option><option value="">25</option><option value="">26</option><option value="">27</option><option value="">28</option><option value="">29</option><option value="">30</option>
				</select>&nbsp; ∼
				<select name="선택" class="combobox-sm custom-form-control">
					<option value="">11</option><option value="">12</option>
				</select>월
				<select name="선택" class="combobox-sm custom-form-control">
					<option value="">01</option><option value="">02</option><option value="">03</option><option value="">04</option><option value="">05</option><option value="">06</option><option value="">07</option><option value="">08</option><option value="">09</option><option value="">10</option><option value="">11</option><option value="">12</option><option value="">13</option><option value="">14</option><option value="">15</option><option value="">16</option><option value="">17</option><option value="">18</option><option value="">19</option><option value="">20</option><option value="">21</option><option value="">22</option><option value="">23</option><option value="">24</option><option value="">25</option><option value="">26</option><option value="">27</option><option value="">28</option><option value="">29</option><option value="">30</option>
				</select>&nbsp;:
			 <input type="text" class="def-input-text-lg custom-form-control" value=""><br />
			</div>
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
			<div class="content">
				<select name="선택" class="combobox-sm custom-form-control">
					<option value="">12</option>
				</select>월
				<select name="선택" class="combobox-sm custom-form-control">
					<option value="">01</option><option value="">02</option><option value="">03</option><option value="">04</option><option value="">05</option><option value="">06</option><option value="">07</option><option value="">08</option><option value="">09</option><option value="">10</option><option value="">11</option><option value="">12</option><option value="">13</option><option value="">14</option><option value="">15</option><option value="">16</option><option value="">17</option><option value="">18</option><option value="">19</option><option value="">20</option><option value="">21</option><option value="">22</option><option value="">23</option><option value="">24</option><option value="">25</option><option value="">26</option><option value="">27</option><option value="">28</option><option value="">29</option><option value="">30</option><option value="">31</option>
				</select>&nbsp; ∼
				<select name="선택" class="combobox-sm custom-form-control">
					<option value="">12</option>
				</select>월
				<select name="선택" class="combobox-sm custom-form-control">
					<option value="">01</option><option value="">02</option><option value="">03</option><option value="">04</option><option value="">05</option><option value="">06</option><option value="">07</option><option value="">08</option><option value="">09</option><option value="">10</option><option value="">11</option><option value="">12</option><option value="">13</option><option value="">14</option><option value="">15</option><option value="">16</option><option value="">17</option><option value="">18</option><option value="">19</option><option value="">20</option><option value="">21</option><option value="">22</option><option value="">23</option><option value="">24</option><option value="">25</option><option value="">26</option><option value="">27</option><option value="">28</option><option value="">29</option><option value="">30</option><option value="">31</option>
				</select>&nbsp;:
			 <input type="text" class="def-input-text-lg custom-form-control" value=""><br />
			</div>
			</td>
		</tr>
		
		
	

		
	</table>	
</div>


    
</body>

</html>