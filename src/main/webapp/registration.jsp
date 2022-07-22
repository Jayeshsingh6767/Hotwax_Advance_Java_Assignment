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

		<!-- Sign up form -->
		<section class="signup">
			<div class="container">
				<div class="signup-content">
					<div class="signup-form">
						<h2 class="form-title">Sign up</h2>
					
						<form method="post" action="registration" class="register-form"
							id="register-form" onsubmit='return validate(this)'>
							<div class="form-group">
								<label for="name"><i
									class="zmdi zmdi-account material-icons-name"></i></label> <input
									type="text" name="firstName" id="firstName" placeholder="Your First Name" />
							</div>
							<div class="form-group">
								<label for="name"><i
									class="zmdi zmdi-account material-icons-name"></i></label> <input
									type="text" name="lastName" id="lastName" placeholder="Your Last Name" />
							</div>
							<div class="form-group">
								<label for="email"><i class="zmdi zmdi-email"></i></label> <input
									type="email" name="email" id="email" placeholder="Your Email" />
							</div>
							<div class="form-group">
								<label for="pass"><i class="zmdi zmdi-lock"></i></label> <input
									type="password" name="pass" id="pass" placeholder="Password" />
							</div>
							<div class="form-group">
								<label for="re-pass"><i class="zmdi zmdi-lock-outline"></i></label>
								<input type="password" name="re_pass" id="re_pass"
									placeholder="Repeat your password" />
							</div>
							<div class="form-group">
								<label for="address"><i class="zmdi zmdi-city"></i></label>
								<input type="text" name="address" id="address"
									placeholder="Address" />
							</div>
							<div class="form-group">
								<label for="city"><i class="zmdi zmdi-city"></i></label>
								<input type="text" name="city" id="city"
									placeholder="City" />
							</div>
							
							<div class="form-group">
								<label for="zip"><i class="zmdi zmdi-code"></i></label>
								<input type="text" name="zip" id="zip"
									placeholder="Zip code" />
							</div>
							<div class="form-group">
								<label for="state"><i class="zmdi zmdi-city"></i></label>
								<input type="text" name="state" id="state"
									placeholder="State" />
							</div>
							<div class="form-group">
								<label for="country"><i class="zmdi zmdi-city"></i></label>
								<input type="text" name="country" id="country"
									placeholder="Country" />
							</div>
							<div class="form-group">
								<label for="phone"><i class="zmdi zmdi-phone"></i></label>
								<input type="text" name="phone" id="phone"
									placeholder="Contact no" />
							</div>
							<div class="form-group">
								<input type="checkbox" name="agree-term" id="agree-term"
									class="agree-term" /> <label for="agree-term"
									class="label-agree-term"><span><span></span></span>I
									agree all statements in <a href="#" class="term-service">Terms
										of service</a></label>
							</div>
							<div class="form-group form-button">
								<input type="submit" name="signup" id="signup"
									class="form-submit" value="Register" />
							</div>
						</form>
					</div>
					<div class="signup-image">
						<figure>
							<img src="images/registration.gif" id="registationImage" alt="sing up image">
						</figure>
						<a href="login.jsp" class="signup-image-link">I am already
							member</a>
					</div>
				</div>
			</div>
		</section>


	</div>
	
	<!-- JS <script src="vendor/jquery/jquery.min.js"></script> -->
	<script src="https://code.jquery.com/jquery-latest.min.js"></script>

	<script src="js/main.js"></script>
	
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.33.1/sweetalert2.css">
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.33.1/sweetalert2.js"></script>

	 
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
			//var imgs=document.getElementById("regisrationImage").src="images/loading.gif";
			
			
			return true;
		}
	 var status=document.getElementById("status").value;
	 
	 if(status=="success")
	 {
		  swal("Congrats","Account Created Successfully","success");
	 }else if(status=="failed")
	 {
		  swal("Sorry","Account not Created ","error");
	 }else if(status=="emailExists")
	 {
		  swal("Invalid","Email exists","error");
	 }
	 
	</script>

</body>
</html>