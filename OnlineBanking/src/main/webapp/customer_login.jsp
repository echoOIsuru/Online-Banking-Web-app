
<jsp:include page="WEB-INF/views/section/header.jsp"></jsp:include>

<header class="masthead">
	<div class="container d-flex h-100 align-items-center">
		<div class="mx-auto text-center">
			<h1 class="mx-auto my-0 text-uppercase">City Bank Online Banking</h1>
			<h2 class="text-white-50 mx-auto mt-2 mb-5">
				<br>Money transfer, made easy.
			</h2>
			<div class="container">
				<div class="row">
					<div class="col align-self-center">
						<div class="bg-text">
							<form method="post" action="log">
								<br>
								<table class="gg">
									<tr>
										<td align="left"><p style="color: white">
												<br>Enter Email <span style="color: white"
													class="tablg">:</span>
											</p> <br></td>
										<td><input type="text" name="email"
											class="form-control input-lg"><br></td>
									</tr>
									<tr>
										<td align="left"><p style="color: white">
												<br>Enter Password :
											</p></td>
										<td><input type="password" name="password"
											class="form-control input-lg"></td>
									</tr>
								</table>
								<br> <input type="submit" name="Msubmit" value="Enter"
									class="btn btn-primary">
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</header>

<jsp:include page="WEB-INF/views/section/footer.jsp"></jsp:include>

