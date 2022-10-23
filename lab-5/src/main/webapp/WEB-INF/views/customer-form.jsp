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
		</div>
		<!-- form data sending to save request mapping -->
		<form action="/lab-5/customer/save" method="post">
			<div class="form-group row">
				<div class="col-sm-10">
					<input type="hidden" name="id" id="id" value="${customer.id }" />
				</div>
			</div>
			<div class="form-group row">
				<div class="col-sm-7">
					<label for="firstname" class="col-sm-2 col-form-label">First Name: </label>
					<input type="text" name="firstname" id="firstname"
						value="${customer.firstName}">
				</div>
			</div>
			<div class="form-group row">
				<div class="col-sm-7">
					<label for="statilastnamecEmail" class="col-sm-2 col-form-label">Last Name: </label>
					<input type="text" name="lastname" id="lastname"
						value="${customer.lastName}">
				</div>
			</div>
			<div class="form-group row">
				<div class="col-sm-7">
					<label for="email" class="col-sm-2 col-form-label">Email: </label> <input
						type="text" name="email" id="email" value="${customer.email}">
				</div>
			</div>
			<div class="form-group row">
				<div class="col-sm-7">
					<label for="email" class="col-sm-2 col-form-label"></label> <input
						type="submit" value="Save" />
				</div>
			</div>
		</form>
		<a href="/lab-5/customer/list">Back to List</a>
	</div>
</body>
</html>