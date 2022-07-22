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
						<h2 class="form-title">Edit User</h2>
					
						<form method="post" action="edit" class="register-form"
							id="register-form" onsubmit='return validate(this)'>
							<input type="hidden" name="partyId" id="partyId" value="<%=request.getAttribute("partyId") %>" />
							
							<div class="form-group"> &nbsp; &nbsp; &nbsp; <strong >First Name</strong>
								<label for="name"><i
								    class="zmdi zmdi-account material-icons-name"
									></i></label> <input
									type="text" name="firstName" id="firstName" value="<%=request.getAttribute("firstName") %>" />
							</div>
							<div class="form-group">&nbsp; &nbsp; &nbsp; <strong>Last Name</strong>
								<label for="name"><i
									class="zmdi zmdi-account material-icons-name"></i></label> <input
									type="text" name="lastName" id="lastName" value="<%=request.getAttribute("lastName") %>" />
							</div>
							<div class="form-group">&nbsp; &nbsp; &nbsp; <strong>Email</strong>
								<label for="email"><i class="zmdi zmdi-email"></i></label> <input
									type="email" name="email" id="email" value="<%=request.getAttribute("email") %>" readonly/>
							</div>
							<div class="form-group">&nbsp; &nbsp; &nbsp; <strong>Address</strong>
								<label for="address"><i class="zmdi zmdi-city"></i></label>
								<input type="text" name="address" id="address"
									value="<%=request.getAttribute("address") %>"/>
							</div>
							<div class="form-group">&nbsp; &nbsp; &nbsp; <strong>City</strong>
								<label for="city"><i class="zmdi zmdi-city"></i></label>
								<input type="text" name="city" id="city"
									value="<%=request.getAttribute("city") %>" />
							</div>
							
							<div class="form-group">&nbsp; &nbsp; &nbsp; <strong>Zip Code</strong>
								<label for="zip"><i class="zmdi zmdi-code"></i></label>
								<input type="text" name="zip" id="zip"
									value="<%=request.getAttribute("zip") %>" />
							</div>
							<div class="form-group">&nbsp; &nbsp; &nbsp; <strong>State</strong>
								<label for="state"><i class="zmdi zmdi-city"></i></label>
								<input type="text" name="state" id="state"
									value="<%=request.getAttribute("state") %> " />
							</div>
							<div class="form-group">&nbsp; &nbsp; &nbsp; <strong>Country</strong>
								<label for="country"><i class="zmdi zmdi-city"></i></label>
								<input type="text" name="country" id="country"
									value="<%=request.getAttribute("country") %>"/>
							</div>
							<div class="form-group">&nbsp; &nbsp; &nbsp; <strong>Phone</strong>
								<label for="phone"><i class="zmdi zmdi-phone"></i></label>
								<input type="text" name="phone" id="phone"
									value="<%=request.getAttribute("phone") %>" />
							</div>
						
							<div class="form-group form-button">
								<input type="submit" name="signup" id="signup"
									class="form-submit" value="Edit" />
							</div>
							</form>
					
					</div>
					<div class="signup-image">
						<figure>
							<img src="images/JayeshIllustration.jpg" alt="sing up image">
						</figure>
						<a href="usersInfo.jsp" class="signup-image-link">Cancel</a>
					</div>
				</div>
			</div>
		</section>


	</div>
	
	<!-- JS <script src="vendor/jquery/jquery.min.js"></script> -->
	<script src="https://code.jquery.com/jquery-latest.min.js"></script>
	
	<script src="js/main.js"></script>
	 
	<script type="text/javascript">
		function validate(frm)
		{
			var name=frm.firstName.value.trim();
			if(name.length==0)
			{
				frm.firstName.focus();
				return false;
			}
			var lastName=frm.lastName.value.trim();
			if(lastName.length==0)
			{
				frm.lastName.focus();
				return false;
			}
			var name=frm.firstName.value.trim();
			if(name.length==0)
			{
				frm.firstName.focus();
				return false;
			}
			var email=frm.email.value.trim();
			if(email.length==0)
			{
				frm.email.focus();
				return false;
			}
			var password=frm.pass.value.trim();
			if(password.length==0)
			{
				frm.pass.focus();
				return false;
			}
			var re_pass=frm.re_pass.value.trim();
			if(re_pass.length==0)
			{
				frm.re_pass.focus();
				return false;
			}
			var address=frm.address.value.trim();
			if(address.length==0)
			{
				frm.address.focus();
				return false;
			}
			var city=frm.city.value.trim();
			if(city.length==0)
			{
				frm.city.focus();
				return false;
			}
			var zip=frm.zip.value.trim();
			if(zip.length==0)
			{
				frm.zip.focus();
				return false;
			}		
			var state=frm.state.value.trim();
			if(state.length==0)
			{
				frm.state.focus();
				return false;
			}
			var country=frm.country.value.trim();
			if(country.length==0)
			{
				frm.country.focus();
				return false;
			}
			var phone=frm.phone.value.trim();
			if(phone.length==0)
			{
				frm.phone.focus();
				return false;
			}
			return true;
		}
	
	 
	</script>

</body>
</html>