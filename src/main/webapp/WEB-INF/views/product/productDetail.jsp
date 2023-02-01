<%@page import="com.iu.home.product.ProductDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Product Detail Page</h1>
	<% 
		ProductDTO productDTO = (ProductDTO)request.getAttribute("ProductNum");
	%>
	
	<%= productDTO.getProductNum()%>
	<%= productDTO.getProductName()%>
	<%= productDTO.getProductDetail()%>
	<%= productDTO.getProductJumsu()%>
	
</body>
</html>