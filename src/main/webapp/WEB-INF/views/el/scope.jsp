<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Servlet/JSP 내장 객체와 범위(Scope)</title>
</head>
<body>
	<h1> Servlet/JSP 내장 객체와 범위(Scope)</h1>
    <pre>
    	Servlet/JSP 에는 기본적으로 내장되어있는 4가지 객체가 존재
    	
    	4종류의 객체는 각각 영향을 미칠 수 있는 범위가 다르다
    	
    </pre>
    
    <ul>
	    <li>
	    	<%
	    		pageContext.setAttribute("pageMsg", "페이지 범위입니다.");
	    	
	    		pageContext.setAttribute("str", "page scope");
    		%>
    		
    		page scope pageMsg : ${pageMsg}
    		
	    </li>
	    <li> request scope message : ${message} </li>
	    <li> session scope sessionValue : ${sessionValue} </li>
	    <li> application scope appValue : ${appValue} </li>
    </ul>
    
    <h1> 내장 객체 우선순위 확인 : ${str} </h1>
    page 의 str 값 : ${pageScope.str}
    request 의 str 값 : ${requestScope.str}
    session 의 str 값 : ${sessionScope.str}
    application 의 str 값 : ${applicationScope.str}
</body>
</html>