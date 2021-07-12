<%@page import="com.manage.model.Customer"%>
<%@page import="java.util.List"%>


<%
@SuppressWarnings("unchecked")
List<Customer> customer = (List<Customer>) request.getAttribute("CustomerDetails");
%>
<%
for (Customer a : customer) {
%>

<jsp:include page="section/header.jsp"></jsp:include>

<link href="css/table.css" rel="stylesheet" />
<link href="css/card.css" rel="stylesheet" />

<body id="page-top">
	<!-- Navigation-->
	<nav class="navbar navbar-expand-lg navbar-light fixed-top"
		id="mainNav">
		<div class="container">
		<a class="navbar-brand js-scroll-trigger" href="#">Hello, <span class="tab"> <%=a.getName()%></span></a>
			<button class="navbar-toggler navbar-toggler-right" type="button"
				data-toggle="collapse" data-target="#navbarResponsive"
				aria-controls="navbarResponsive" aria-expanded="false"
				aria-label="Toggle navigation">
				MENU <i class="fas fa-bars"></i>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">


				<ul class="navbar-nav ml-auto">

					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="#">About</a></li>
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="#">Home</a></li>

					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="#">Customer List</a></li>
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="#">Contact</a></li>
				</ul>
			</div>
		</div>
	</nav>



<section class="signup-section" id="signup">
	<div class="container">
		<div class="row">
			<div class="col align-self-center" style="margin-top: 5px">
				<div class="bg-text">

					<div class="Checkout">
						<div class="Card">
							<div class="front">
								<div class="card-chip"></div>
								<div class="card-logo">
									Online<br />BANK
								</div>
								<div class="card-number">
									Card Number
									<div class="mono">0000 0000 0000 0000</div>
								</div>
								<div class="card-holder">
									Card Holder
									<div class="mono">Nimal</div>
								</div>
								<div class="card-date">
									<label>Expires</label>
									<div class="mono">12/2020</div>
								</div>
							</div>
							<div class="back">
								<div class="card-strip"></div>
								<div class="card-logo-back">
									Online<br>BANK
								</div>
								<div class="card-code">
									<label>CCV</label>
									<div class="mono">123</div>
								</div>
							</div>
						</div>
					</div>
					<br> <br> <br>
					<form class="text-center" method="post" action="addCard"
						onsubmit="return checkPassword()">

						<input type="hidden" name="customerid"
							value="<%=a.getCustomer_id()%>" />


						<h4 align="center">Add card</h4>
						<br>
						<table class="gg">
							<tr>
								<td align="left" style="color: white">Card type</td>
								<td style="color: white">:</td>
								<td><select name="ctype" style="width: 100%" required>
										<option value="error">---Select---</option>
										<option value="debit">debit card</option>
										<option value="credit">credit card</option>
								</select></td>

							</tr>

							<tr>
								<td align="left" style="color: white">Card Number</td>
								<td style="color: white">:</td>
								<td align="left" style="color: white"><input type="text"
									class="col-xs-4" name="number" style="width: 100%" id="number"
									 pattern="[0-9]{16}" placeholder="0000000000000000" required></td>
							</tr>
							<tr>
								<td align="left" style="color: white">Card Holder Name</td>
								<td style="color: white">:</td>
								<td align="left"><input type="text" name="cname"
									style="width: 100%" id="holder" placeholder="Nimal" required></td>
							</tr>

							<tr>

								<td align="left" style="color: white">Expires year</td>
								<td style="color: white">:</td>
								<td><select name="year" id="year" style="width: 100%"
									required>
										<option value="error">---Select---</option>
										<option value="2021">2021</option>
										<option value="2022">2022</option>
										<option value="2023">2023</option>
										<option value="2024">2024</option>
										<option value="2025">2025</option>
										<option value="2026">2026</option>
										<option value="2027">2027</option>
										<option value="2028">2028</option>
								</select></td>
							</tr>

							<tr>

								<td align="left" style="color: white">Expires Month</td>
								<td style="color: white">:</td>
								<td><select name="month" id="month" style="width: 100%"
									required>
										<option value="error">---Select---</option>
										<option value="1">1</option>
										<option value="2">2</option>
										<option value="3">3</option>
										<option value="4">4</option>
										<option value="5">5</option>
										<option value="6">6</option>
										<option value="7">7</option>
										<option value="8">8</option>
										<option value="9">9</option>
										<option value="10">10</option>
										<option value="11">11</option>
										<option value="12">12</option>
								</select></td>
							</tr>




							<tr>
								<td align="left" style="color: white">Password</td>
								<td style="color: white">:</td>
								<td align="left"><input type="password"
									name="loginPassword" id="pwd" style="width: 100%" required></td>
							</tr>
							<tr>
								<td align="left" style="color: white">Confirm Password</td>
								<td style="color: white">:</td>
								<td align="left"><input type="password" name="cPassword"
									id="confirmpwd" style="width: 100%" required></td>
							</tr>
							<tr>
								<td align="left" style="color: white">CCV</td>
								<td style="color: white">:</td>
								<td align="left"><input type="text" name="ccv" id="ccv"
									style="width: 100%" pattern="[0-9]{3}" placeholder="123" required></td>
							</tr>

							<tr>
								<td></td>
								<td></td>
								<td></td>
							</tr>
						</table>
						<br> <input class="btn btn-primary" type="submit"
							value="Add Card" id="submitbt">
					</form>

					<script
						src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js'></script>
					<script src="js/card.js"></script>


				</div>
			</div>
		</div>
	</div>
</section>
<%
}
%>
<jsp:include page="section/footer.jsp"></jsp:include>
