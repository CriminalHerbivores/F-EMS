<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
    <title>Customizing templates</title>
    <meta charset="utf-8">
    
    
    
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


    
</body>
