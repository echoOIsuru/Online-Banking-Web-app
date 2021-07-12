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
		<div class="container">
			<div class="row">
				<div class="col align-self-center" style="margin-top: 120px">
					<div class="bg-text">
						<form action="delete" method="post" class="text-center">
							<br>

							<p><%=a.getName()%>
								<br>
								<br>Do you want to delete your account?
							</p>

							<br> <input type="hidden" name="customerid"
								value="<%=a.getCustomer_id()%>" /> <input type="submit"
								name="delete" class="btn btn-dark" value="Confirm">

						</form>
						<form action="home" method="post" class="text-center">
							<br> <input type="hidden" name="customerid"
								value="<%=a.getCustomer_id()%>" /> <input type="submit"
								name="back" class="btn btn-light" value="Back to Menu">


						</form>

					</div>
				</div>
			</div>
		</div>





	</section>

	<%
	}
	%>
	<jsp:include page="section/footer.jsp"></jsp:include>