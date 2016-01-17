<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form id="msform" name="msform" action="<%=request.getContextPath()%>/member/add" method="post">
	<fieldset>
		<h1 class="fs-title">CREATE YOUR ACCOUNT</h1>
		<input type="text" name="name" placeholder="Name" />
		<input type="text" name="id" placeholder="ID ( 6 ~ 12 )" />
		<input type="password" name="pass" placeholder="Password ( 4 ~ 8 )" />
		<input type="password" name="cpass" placeholder="Confirm Password" />
		<input type="text" name="birth" placeholder="Birth Date ( YYYY-MM-DD )" />
		<input type="text" name="email" placeholder="Email" />
		<input type="text" name="phone" placeholder="Phone ( Contain '-' )" />
		<div id="gender">
			Gender &nbsp;&nbsp;&nbsp;
			<input type="radio" name="gender" value="M" checked/>
			<font>
				Man&nbsp;
			</font> 
			<input type="radio" name="gender" value="F"/>
			<font>
				Femail&nbsp;
			</font>
		</div>
		<input type="button" class="submit action-button"
			   value="Submit" onclick="addAccountInspector();" />
		<input type="Reset" name="Reset" class="reset action-button" value="Reset" />
	</fieldset>
</form>
