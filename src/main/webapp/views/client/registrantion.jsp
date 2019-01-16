<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="container">
		<div class="account">
			<h2 class="account-in">Account</h2>
				<form:form modelAttribute="user" action="register" method="post">
				<div>
					<form:label path="name">Username: </form:label>
					<form:input path="name" name="name" id="name" />
				</div> 	
				<div> 	
					<form:label path="email">Email: </form:label>
					<form:input path="email" name="email" id="email" />
				</div>
				<div> 	
					<form:label path="phone">Phone: </form:label>
					<form:input path="phone" name="phone" id="phone" /> 
				</div>
				<div> 
					<form:label path="password">Password: </form:label>
					<form:password path="password" name="password" id="password" />
				</div>					
					<button type="submit">Register</button>
				</form:form>
		</div>
	</div>
