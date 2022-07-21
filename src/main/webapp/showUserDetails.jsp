<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Sign Up Form by Colorlib</title>

<!-- Font Icon -->
<link rel="stylesheet"
	href="fonts/material-icon/css/material-design-iconic-font.min.css">

<!-- Main css -->
<link rel="stylesheet" href="css/style.css">
</head>
<body>


	<div class="main">

		<!-- Sign up form -->
		<section class="signup">
			<div class="container">
				<div class="signup-content">
					<div class="signup-form">
						<h2 class="form-title">User Info</h2>
					
							<div class="form-group"> &nbsp; &nbsp; &nbsp; <strong >First Name</strong>
								<label for="name"><i
								    class="zmdi zmdi-account material-icons-name"
									></i></label> <input
									type="text" name="firstName" id="firstName" value="<%=request.getAttribute("firstName") %>" readonly />
							</div>
							<div class="form-group">&nbsp; &nbsp; &nbsp; <strong>Last Name</strong>
								<label for="name"><i
									class="zmdi zmdi-account material-icons-name"></i></label> <input
									type="text" name="lastName" id="lastName" value="<%=request.getAttribute("lastName") %>" readonly/>
							</div>
							<div class="form-group">&nbsp; &nbsp; &nbsp; <strong>Email</strong>
								<label for="email"><i class="zmdi zmdi-email"></i></label> <input
									type="email" name="email" id="email" value="<%=request.getAttribute("email") %>"readonly/>
							</div>
							<div class="form-group">&nbsp; &nbsp; &nbsp; <strong>Address</strong>
								<label for="address"><i class="zmdi zmdi-city"></i></label>
								<input type="text" name="address" id="address"
									value="<%=request.getAttribute("address") %>"readonly/>
							</div>
							<div class="form-group">&nbsp; &nbsp; &nbsp; <strong>City</strong>
								<label for="city"><i class="zmdi zmdi-city"></i></label>
								<input type="text" name="city" id="city"
									value="<%=request.getAttribute("city") %>" readonly/>
							</div>
							
							<div class="form-group">&nbsp; &nbsp; &nbsp; <strong>Zip Code</strong>
								<label for="zip"><i class="zmdi zmdi-code"></i></label>
								<input type="text" name="zip" id="zip"
									value="<%=request.getAttribute("zip") %>" readonly/>
							</div>
							<div class="form-group">&nbsp; &nbsp; &nbsp; <strong>State</strong>
								<label for="state"><i class="zmdi zmdi-city"></i></label>
								<input type="text" name="state" id="state"
									value="<%=request.getAttribute("state") %> " readonly/>
							</div>
							<div class="form-group">&nbsp; &nbsp; &nbsp; <strong>Country</strong>
								<label for="country"><i class="zmdi zmdi-city"></i></label>
								<input type="text" name="country" id="country"
									value="<%=request.getAttribute("country") %>"readonly />
							</div>
							<div class="form-group">&nbsp; &nbsp; &nbsp; <strong>Phone</strong>
								<label for="phone"><i class="zmdi zmdi-phone"></i></label>
								<input type="text" name="phone" id="phone"
									value="<%=request.getAttribute("phone") %>" readonly/>
							</div>
						
					
					</div>
					<div class="signup-image">
						<figure>
							<img src="images/signup-image.jpg" alt="sing up image">
						</figure>
						<a href="search.jsp" class="signup-image-link">Search Another user</a>
					</div>
				</div>
			</div>
		</section>


	</div>
	
	<!-- JS <script src="vendor/jquery/jquery.min.js"></script> -->
	<script src="https://code.jquery.com/jquery-latest.min.js"></script>

	<script src="js/main.js"></script>

</body>
</html>