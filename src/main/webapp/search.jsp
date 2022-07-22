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
<input type="hidden" id="status" value="<%=request.getAttribute("status")%>">

	<div class="main">

		<!-- Sing in  Form -->
		<section class="sign-in">
			<div class="container">
				<div class="signin-content">
					<div class="signin-image">
						<figure>
							<img src="images/search.gif" alt="sing up image">
						</figure>
						<a href="login.jsp" class="signup-image-link">Home</a>
					</div>

					<div class="signin-form">
						<h2 class="form-title">Search</h2>
						<form method="get" action="search" class="register-form"
							id="login-form">
							<div class="form-group">
								<label for="username"><i
									class="zmdi zmdi-account material-icons-name"></i></label> <input
									type="text" name="firstName" id="firstName"
									placeholder="First Name" />
							</div>
							<div class="form-group">
								<label for="username"><i class="zmdi zmdi-account material-icons-name"></i></label> <input
									type="text" name="lastName" id="lastName"
									placeholder="Last Name" />
							</div>
						
							<div class="form-group form-button">
								<input type="submit" name="signin" id="signin"
									class="form-submit" value="search" />
							</div>
						</form>
					
					</div>
				</div>
			</div>
		</section><link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.33.1/sweetalert2.css">
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.33.1/sweetalert2.js"></script>

	 
	<script type="text/javascript">
		
	 var status=document.getElementById("status").value;
	 
	 if(status=="failed")
	 {
		  swal("Wrong","invalid name ","error");
	 }
	 
	</script>

	</div>

	<!-- JS <script src="vendor/jquery/jquery.min.js"></script>-->
	<script src="https://code.jquery.com/jquery-latest.min.js"></script>
	
	<script src="js/main.js"></script>
	
</body>
<!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>