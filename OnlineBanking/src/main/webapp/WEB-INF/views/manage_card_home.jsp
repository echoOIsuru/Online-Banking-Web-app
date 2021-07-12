
<%@page import="com.manage.model.MCustomer"%>
<%@page import="java.util.List"%>
<%@page import="com.manage.model.Customer"%>
<%@page import="java.util.List"%>


<%
@SuppressWarnings("unchecked")
List<Customer> customer = (List<Customer>) request.getAttribute("CustomerDetails");
%>
<%
for (Customer c : customer) {
%>


<jsp:include page="section/header.jsp"></jsp:include>
<link href="css/card.css" rel="stylesheet" />


<body id="page-top">
	<!-- Navigation-->
	<nav class="navbar navbar-expand-lg navbar-light fixed-top"
		id="mainNav">
		<div class="container">
		<a class="navbar-brand js-scroll-trigger" href="#">Hello, <span class="tab"> <%=c.getName()%></span></a>
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
				<div class="col align-self-center" style="margin-top: 50px">
					<div class="bg-text">

						<%
						@SuppressWarnings("unchecked")
						List<MCustomer> Mcustomer = (List<MCustomer>) request.getAttribute("mCustomerDetails");
						%>

						<%
						for (MCustomer a : Mcustomer) {
						%>

						<%
						String n = a.getmCardNumber();
						char n1 = n.charAt(12);
						char n2 = n.charAt(13);
						char n3 = n.charAt(14);
						char n4 = n.charAt(15);
						%>

						<div class="Checkout">
							<div class="Card">
								<div class="front">
									<div class="card-chip"></div>
									<div class="card-logo">
										Online<br />BANK
									</div>
									<div class="card-number">
										Card Number
										<div class="mono">
											XXXX XXXX XXXX
											<%=n1%><%=n2%><%=n3%><%=n4%></div>
									</div>
									<div class="card-holder">
										Card Holder
										<div class="mono"><%=a.getmName()%></div>
									</div>
									<div class="card-date">
										<label>Expires</label>
										<div class="mono">xx/20xx</div>
									</div>
								</div>
								<div class="back">
									<div class="card-strip"></div>
									<div class="card-logo-back">
										Online<br>BANK
									</div>
									<div class="card-code">
										<label>CCV</label>
										<div class="mono">XXX</div>
									</div>
								</div>
							</div>
						</div>
						<br>
						<br>
						<br>

						<form method="post" action="disableCard" class="text-center">
							<input type="hidden" name="customerid"
								value="<%=c.getCustomer_id()%>" /> <input type="hidden"
								name="number" value="<%=a.getmCardNumber()%>" /> <br>
							<h4>
								Customer ID :<%=a.getmID()%></h4>
							<h4>
								Card type:
								<%=a.getmCardType()%></h4>
							<br>

							<table class="gg">
								<tr>
									<td>You can disable your card using disable card option
										for card stolen or card loss situation.</td>
								</tr>

								<tr>
									<td align="left" style="color: white">Do you want to
										disable card? <input type="checkbox" id="chekpolicy"
										onclick="enablebutton()">
									</td>
								</tr>

								<tr>
									<td></td>
									<td></td>
									<td></td>
								</tr>


							</table>
							<br> <input class="btn btn-primary" type="submit"
								name="disable_card" value="Disable Card" id="submitbt" disabled>
						</form>

						<form action="home" method="post">
							<input type="hidden" name="customerid"
								value="<%=c.getCustomer_id()%>" /> <input type="submit"
								class="btn btn-light" name="back" value="Back to Home">

						</form>

					</div>
				</div>
			</div>
		</div>
	</section>

	<%
	}
	%>


	<%
	}
	%>
	<jsp:include page="section/footer.jsp"></jsp:include>