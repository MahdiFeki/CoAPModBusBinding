<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib  uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title> Heizung </title>
</head>
<body>
 	<div>
 		<f:form modelAttribute="ModbusForm" method="post" action="getTD">
 			<table>
 				<tr>
 					<td>IP Address:</td>
 					<td><f:input path="addressIP"/></td>
 					<td><f:errors path="addressIP"> </f:errors></td>
 					<td><input type ="submit" value="OK"></td>
 				</tr>
 			</table>
 		</f:form>	
 	</div>
 	
 	
 	<div>
 	 	<f:form modelAttribute="ModbusForm" method="post" action="getValue">
 		<table>
 			<tr>
 				<td> Ressource Name: </td>
 				<td><f:input path="ressource"/></td>
 				<td><f:errors path="ressource"> </f:errors></td>
 		 		<td><input type ="submit" value="OK"></td>
 	
 			</tr>	
 		</table>
 		</f:form>
 	</div>
 	<div>
 	
 		<table>
 			<tr>
 				<td> Value: </td>
 				<td>${ModbusForm.value}</td>
 			</tr>
 		</table>
 	</div>
 	
</body>
</html>