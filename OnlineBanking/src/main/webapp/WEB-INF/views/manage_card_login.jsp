<%@page import="com.manage.model.MCustomer"%>
<%@page import="java.util.List"%>
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
<link href="css/tabletwo.css" rel="stylesheet" />


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
<br><br>

		<div class="container">
				<div class="row">
					<div class="col align-self-center">
				<div class="bg-text">
					<form class="text-center" method="post" action="mlog">
					
					
						<input type="hidden" name="customerid" value="<%=a.getCustomer_id()%>" /> 
						<table class="gg">
							<tr>
							<td align="left" style="color:white">Enter Card Number <br></td>
							<td><input type="text"  name="McardNumber"><br></td>
							</tr>
							<tr>
						   <td align="left" style="color:white">Enter Password <br></td><td>
						   <input type="password"  name="McardPassword"><br> </td> 
							
						</table>	
						<br><br>
						<input type="submit" name="Msubmit" value="Enter" class="btn btn-primary">
						<input type="submit" name="addcard" value="Add Card" class="btn btn-primary">
							
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

