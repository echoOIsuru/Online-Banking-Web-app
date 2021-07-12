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





<section class="signup-section" id="signup" >
	<form style="margin-top:35px" method="post" action="update" onsubmit="return checkPassword()">

		<div class="container d-flex h-100 align-items-center">
			<div class="container" style="margin-top: 30px">
				<div class="row">
					
					<div class="col-sm-6">

						<div class="bg-text">

							<input type="hidden" name="customerid"
								value="<%=a.getCustomer_id()%>" />
							<h5 align="center">Update</h5>
							<table class="gg">
								<tr>
									<td style="color:white">Account Holder ID</td>
									<td>:</td>
									<td style="color:white"><%=a.getCustomer_id()%></td>
								</tr>
								<tr>
									<td style="color:white">Account Holder Name</td>
									<td>:</td>
									<td><input type="text" name="name"
										value="<%=a.getName()%>"></td>
								</tr>
								<tr>
									<td style="color:white">Mobile Number</td>
									<td>:</td>
									<td><input type="text" name="mobile"
										value="<%=a.getMobile()%>"></td>
								</tr>
								<tr>
									<td style="color:white">Email</td>
									<td>:</td>
									<td><input type="email" name="email"
										value="<%=a.getEmail()%>"></td>
								</tr>
								<tr>
									<td style="color:white">Address</td>
									<td>:</td>
									<td><input type="text" name="address"
										value="<%=a.getAddress()%>"></td>
								</tr>
							</table>
							<br> <input type="submit" class="btn btn-primary"
								value="Change my data" name="updateData">

						</div>
						<hr class="d-sm-none">
					</div>
					<div class="col-sm-6">
						<div class="bg-text">
							<table>
								<tr>
									<td style="color:white">Update my password</td>
									<td>:</td>
									<td><input type="checkbox" id="checkUpdatePass"
										onclick="updatePassword()"></td>
								</tr>
								<tr>
									<td style="color:white">Enter password</td>
									<td>:</td>
									<td><input type="password" name="oldPassword" id="gg"
										disabled required></td>
								</tr>
								<tr>
									<td style="color:white">Enter new password</td>
									<td>:</td>
									<td><input type="password" name="loginPassword" id="pwd"
										disabled required></td>
								</tr>
								<tr>
									<td style="color:white">Re-enter password</td>
									<td>:</td>
									<td><input type="password" name="cPassword"
										id="confirmpwd" disabled required></td>
								</tr>
								<tr>
									<td></td>
									<td></td>
									<td></td>
								</tr>
							</table>
						</div>
					</div>



				</div>
			</div>
		</div>
	</form>
</section>


<%
}
%>

<jsp:include page="section/footer.jsp"></jsp:include>
