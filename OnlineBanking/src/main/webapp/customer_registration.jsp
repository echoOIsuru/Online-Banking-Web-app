
<jsp:include page="WEB-INF/views/section/header.jsp"></jsp:include>
<link href="css/regTable.css" rel="stylesheet" />

<header class="masthead">
	<div class="container d-flex h-100 align-items-center">
		<div class="mx-auto text-center" style="margin-top: 40px">
			<h1 class="mx-auto my-0 text-uppercase">City Bank</h1>
			<h2 class="text-white-50 mx-auto mt-2 mb-5">
				<br>Money transfer, made easy.
			</h2>
			<div class="container">
				<div class="row">
					<div class="col align-self-center" style="margin-top: 20px">
						<div class="bg-text">

							<form class="text-center" method="post"
								action="customer_registration" onsubmit="return checkPassword()">
								<h5>Register</h5>
								<table class="gg">
									<tr>
										<td align="left" style="color: white">Account Holder Name</td>
										<td>:</td>
										<td align="left"><input type="text" class="col-xs-4"
											name="name" style="width: 100%" placeholder="A.B Nimal"
											required></td>
									</tr>
									<tr>
										<td align="left" style="color: white">Mobile Number</td>
										<td>:</td>
										<td align="left"><input type="text" name="mobile"
											style="width: 100%" placeholder="0771234567"
											pattern="[0-9]{10}" required></td>
									</tr>
									<tr>
										<td align="left" style="color: white">Email</td>
										<td>:</td>
										<td align="left"><input type="email" name="email"
											style="width: 100%" placeholder="nimal12@gmail.com" required></td>
									</tr>
									<tr>
										<td align="left" style="color: white">Password</td>
										<td>:</td>
										<td align="left"><input type="password"
											name="loginPassword" id="pwd" style="width: 100%" required></td>
									</tr>
									<tr>
										<td align="left" style="color: white">Confirm Password</td>
										<td>:</td>
										<td align="left"><input type="password" name="cPassword"
											id="confirmpwd" style="width: 100%" required></td>
									</tr>
									<tr>
										<td align="left" style="color: white">Address</td>
										<td>:</td>
										<td align="left"><textarea name="address" rows="3"
												cols="25" style="width: 100%"
												placeholder="12/2, mal road, Kandy" required></textarea></td>
									</tr>
									<tr>
										<td align="left" style="color: white">Account Type</td>
										<td>:</td>
										<td align="left"><select name="aType" required>
												<option value="error">--select---</option>
												<option value="Current">Current account</option>
												<option value="Saving">Savings account</option>
												<option value="Fixed">Fixed deposit account</option>
										</select></td>

									</tr>
									<tr>
										<td align="left" style="color: white">Government Id</td>
										<td>:</td>
										<td align="left"><input type="text" name="govtIdNumber"
											style="width: 100%" placeholder="992121212V" required></td>
									</tr>
									<tr>
										<td align="left" style="color: white">Security Question</td>
										<td>:</td>
										<td align="left"><select name="securityQuestion" required>
												<option value="error">--select---</option>
												<option value="q1">What was your favorite sport</option>
												<option value="q2">Who was your role model</option>
												<option value="q3">What was your first cooked food</option>
										</select></td>
									</tr>
									<tr>
										<td align="left" style="color: white">Answer</td>
										<td>:</td>
										<td align="left"><input type="text" name="answer"
											style="width: 100%" placeholder="Enter your answer here"
											required></td>
									</tr>
									<tr>
										<td align="left" style="color: white">Accept Privacy
											Policy</td>
										<td>:</td>
										<td align="left"><input type="checkbox" id="chekpolicy"
											onclick="enablebutton()"></td>
									</tr>
									<tr>
										<td></td>
										<td></td>
										<td></td>
									</tr>
								</table>
								<br> <input class="btn btn-primary" type="submit"
									value="Generate Account" id="submitbt" disabled>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</header>


<jsp:include page="WEB-INF/views/section/footer.jsp"></jsp:include>


