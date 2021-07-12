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
						href="#footer">Contact</a></li>
				</ul>
			</div>
		</div>
	</nav>



<section class="signup-section" id="signup">
	<br> <br>

	<form method="post" action="home">

		<input type="hidden" name="customerid" value="<%=a.getCustomer_id()%>" />

		<div class="container">
			<div class="row">
				<div class="col-md-4 mb-3 mb-md-0">
					<div class="card py-4 h-70">
						<div class="card-body text-center">
							<h4>
							<img src="assets/img/pay.jpg" width="120" height="120"> <a href="#">
							<br><br>
								<button class="buttongg2">Online Payments</button>
							</a>
							</h4>
							<hr class="my-4" />
							<div class="small text-black-50">Pay bills and Re-charge Online</div>
						</div>
					</div>
				</div>
				<div class="col-md-4 mb-3 mb-md-0">
					<div class="card py-4 h-70">
						<div class="card-body text-center">
							<h4>
							<img src="assets/img/money-transfer.jpg" width="120" height="120"> <a href="#">
							<br><br>	
								<button class="buttongg2">Money transfer</button>
							</a>
							</h4>
							<hr class="my-4" />
							<div class="small text-black-50">
								<a href="#!">Transfer Funds Online</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-4 mb-3 mb-md-0">
					<div class="card py-4 h-70">
						<div class="card-body text-center">
						<h4>
							<img src="assets/img/viewTrans.png" width="120" height="120"> <a href="">
							<br><br>	
								<button class="buttongg2">View transaction</button>
							</a>
						</h4>	
							<hr class="my-4" />
							<div class="small text-black-50">
								<a href="#!">View History and Transaction</a>
							</div>
						</div>
					</div>
				</div>
			</div>
			<br> <br> <br>
			<div class="row">
				<div class="col-md-4 mb-3 mb-md-0">
					<div class="card py-4 h-70">
						<div class="card-body text-center">
							<img src="assets/img/manageCard.png" width="120" height="120">
							<br><br>
							<!--pass request -->
							<h4>
								<input  class="buttongg2" type="submit" name="ManageCard"
									value="Manage Card">
							</h4>
							<hr class="my-4" />
							<div class="small text-black-50">Add and Disable Credit Cards and Debit Cards</div>
						</div>
					</div>
				</div>
				<div class="col-md-4 mb-3 mb-md-0">
					<div class="card py-4 h-70">
						<div class="card-body text-center">
							<img src="assets/img/profile.png" width="120" height="120">
							<br><br>
							<!--pass request -->
							<h4>
								<input  class="buttongg1" type="submit" name="ProfileSubmit"
									value="PROFILE">
							</h4>

							<hr class="my-4" />
							<div class="small text-black-50">
								<a href="#!">Check User Profile</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-4 mb-3 mb-md-0">
					<div class="card py-4 h-70">
						<div class="card-body text-center">
						<h4>
							<img src="assets/img/hotline.png" width="120" height="120"> <a href="#">
							<br><br>	
								<button class="buttongg2">Bank Accounts</button>
								
							</a>
						</h4>	
							<hr class="my-4" />
							<div class="small text-black-50">
								<a href="#!">Create New Bank Accounts</a>
							</div>
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
