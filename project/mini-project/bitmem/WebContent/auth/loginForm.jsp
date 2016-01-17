<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="login" align="center">
	<a id="image" href="http://bitjobedu.co.kr"> <img
		src="../images/main.png" title="Bit Camp Membership"
		alt="Bit Camp Membership" />
	</a>
	<form action="main" method="post">
		<table style="margin-top: 20px; padding-bottom: 30px;">
			<tr>
				<td><label for="id" id="lable_id" style="display: none;">id</label>
					<input type="text" id="id" name="id" maxlength="41" title="아이디"
					accesskey="L" placeholder="id" /></td>
				<td rowspan="2">
					<button type="submit" style="height: 100px; margin: 3px;">LOGIN</button>
				</td>
			</tr>
			<tr>
				<td><label for="password" id="lable_password"
					style="display: none;">password </label> <input type="password"
					id="password" name="password" maxlength="16" title="비밀번호"
					placeholder="password" /></td>

			</tr>
		</table>
	</form>
</div>