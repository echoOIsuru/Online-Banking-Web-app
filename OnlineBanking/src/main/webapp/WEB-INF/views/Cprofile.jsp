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

		<div class="container d-flex h-100 align-items-center"
			style="margin-top: 30px">
			<div class="container" style="margin-top: 30px">
				<div class="row">
					<div class="col-sm-4">

						<div class="bg-text">


							<h2>About Me</h2>

							<p>
								ID :
								<%=a.getCustomer_id()%></p>
							<br> <img src="assets/img/profile.png" class="img-thumbnail">
							<br> <br>

							<ul class="nav nav-pills flex-column">


								<li class="nav-item">

									<form action="home" method="post">
										<br> <input type="hidden" name="customerid"
											value="<%=a.getCustomer_id()%>" /> <input type="submit"
											class="btn btn-dark" name="update" value="Update">

									</form>

								</li>

								<li class="nav-item">

									<form class="text-center" action="home" method="post">
										<br> <input type="hidden" name="customerid"
											value="<%=a.getCustomer_id()%>" /> <input type="submit"
											name="delete" class="btn btn-dark" value="Delete My Profile">

									</form>

								</li>

							</ul>
						</div>
						<hr class="d-sm-none">

					</div>



					<div class="col-sm-8">
						<div class="bg-text">

							<h2 align="center">My Information</h2>
							<br>
							<h5 align="center">Basic Information</h5>
							<br>
							<p>
								Name :
								<%=a.getName()%></p>
							<p>
								ID :
								<%=a.getCustomer_id()%></p>
							<p>
								Mobile :
								<%=a.getMobile()%></p>
							<br>
							<h5 align="center">Other Information</h5>
							<br> <br>
							<p>
								Email :
								<%=a.getEmail()%></p>

							<p>
								Address :
								<%=a.getAddress()%></p>
							<p>
								NIC :
								<%=a.getNic()%></p>
							<p>
								Account type :
								<%=a.getAccount_type()%></p>
							<br>
							<form action="home" method="post">
								<input type="hidden" name="customerid"
									value="<%=a.getCustomer_id()%>" /> <input type="submit"
									class="text-white bg-dark" name="back" value="Back">

							</form>

						</div>
					</div>
				</div>
			</div>


		</div>


	</section>

	<%
	}
	%>
	<jsp:include page="section/footer.jsp"></jsp:include>

</body>
</html>