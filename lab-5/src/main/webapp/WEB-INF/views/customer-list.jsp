<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GL-CRM</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
	<div class="card">
		<div class="card-body">
			<p class="card-text">CUSTOMER RELATIONSHIP MANAGEMENT</p>
			<hr>
			<a href="/lab-5/customer/add" class="btn btn-primary">Add
				Customer</a>
		</div>


		<table class="table">
			<thead class="thead-dark">
				<tr>
					<!-- 					<th scope="col">S.No</th> -->
					<th scope="col">FirstName</th>
					<th scope="col">LastName</th>
					<th scope="col">EmailId</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${customers}" var="customerData">
					<tr>
						<%-- 						<td scope="row"><c:out value="${customerData.id}" /></td> --%>
						<td scope="row"><c:out value="${customerData.firstName}" /></td>
						<td scope="row"><c:out value="${customerData.lastName}" /></td>
						<td scope="row"><c:out value="${customerData.email}" /></td>
						<td scope="row"><a
							href="/lab-5/customer/update?customerId=${customerData.id}">Update
								|</a> <a href="/lab-5/customer/delete?customerId=${customerData.id}"
							onclick="return confirm('Are you sure?')">Delete</a></td>
					</tr>

				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>