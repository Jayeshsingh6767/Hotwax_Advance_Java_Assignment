<%@page import="java.io.PrintWriter"%>
<%@ page import="com.customer.registration.model.*" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Admin Dashboard</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<style>
body {
    color: #566787;
    background: #f5f5f5;
    font-family: 'Varela Round', sans-serif;
    font-size: 13px;
}
.table-responsive {
    margin: 30px 0;
}
.table-wrapper {
    min-width: 1000px;
    background: #fff;
    padding: 20px 25px;
    border-radius: 3px;
    box-shadow: 0 1px 1px rgba(0,0,0,.05);
}
.table-title {
    padding-bottom: 15px;
    background: #299be4;
    color: #fff;
    padding: 16px 30px;
    margin: -20px -25px 10px;
    border-radius: 3px 3px 0 0;
}
.table-title h2 {
    margin: 5px 0 0;
    font-size: 24px;
}
.table-title .btn {
    color: #566787;
    float: right;
    font-size: 13px;
    background: #fff;
    border: none;
    min-width: 50px;
    border-radius: 2px;
    border: none;
    outline: none !important;
    margin-left: 10px;
}
.table-title .btn:hover, .table-title .btn:focus {
    color: #566787;
    background: #f2f2f2;
}
.table-title .btn i {
    float: left;
    font-size: 21px;
    margin-right: 5px;
}
.table-title .btn span {
    float: left;
    margin-top: 2px;
}
table.table tr th, table.table tr td {
    border-color: #e9e9e9;
    padding: 12px 15px;
    vertical-align: middle;
}
table.table tr th:first-child {
    width: 60px;
}
table.table tr th:last-child {
    width: 100px;
}
table.table-striped tbody tr:nth-of-type(odd) {
    background-color: #fcfcfc;
}
table.table-striped.table-hover tbody tr:hover {
    background: #f5f5f5;
}
table.table th i {
    font-size: 13px;
    margin: 0 5px;
    cursor: pointer;
}	
table.table td:last-child i {
    opacity: 0.9;
    font-size: 22px;
    margin: 0 5px;
}
table.table td a {
    font-weight: bold;
    color: #566787;
    display: inline-block;
    text-decoration: none;
}
table.table td a:hover {
    color: #2196F3;
}
table.table td a.settings {
    color: #2196F3;
}
table.table td a.delete {
    color: #F44336;
}
table.table td i {
    font-size: 19px;
}
table.table .avatar {
    border-radius: 50%;
    vertical-align: middle;
    margin-right: 10px;
}
.status {
    font-size: 30px;
    margin: 2px 2px 0 0;
    display: inline-block;
    vertical-align: middle;
    line-height: 10px;
}
.text-success {
    color: #10c469;
}
.text-info {
    color: #62c9e8;
}
.text-warning {
    color: #FFC107;
}
.text-danger {
    color: #ff5b5b;
}
.pagination {
    float: right;
    margin: 0 0 5px;
}
.pagination li a {
    border: none;
    font-size: 13px;
    min-width: 30px;
    min-height: 30px;
    color: #999;
    margin: 0 2px;
    line-height: 30px;
    border-radius: 2px !important;
    text-align: center;
    padding: 0 6px;
}
.pagination li a:hover {
    color: #666;
}	
.pagination li.active a, .pagination li.active a.page-link {
    background: #03A9F4;
}
.pagination li.active a:hover {        
    background: #0397d6;
}
.pagination li.disabled i {
    color: #ccc;
}
.pagination li i {
    font-size: 16px;
    padding-top: 6px
}
.hint-text {
    float: left;
    margin-top: 10px;
    font-size: 13px;
}
</style>
<script>
$(document).ready(function(){
	$('[data-toggle="tooltip"]').tooltip();
});
</script>
</head>
<body>
<div class="container-xl">
    <div class="table-responsive">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-5">
                        <h2>User <b>Management</b></h2>
                    </div>
                    <div class="col-sm-7">
                        <a href="logout" class="btn btn-secondary"><i class="material-icons">&#xE879;</i> <span>Logout</span></a>
                        <a href="usersInfo.jsp" class="btn btn-secondary"><i class="material-icons">&#xE8E8;</i> <span><%=session.getAttribute("Name") %></span></a>						
                    </div>
                </div>
            </div>
            <table class="table table-striped table-hover">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Name</th>						
                        <th>Address</th>
                        <th>City</th>
                        <th>Zip Code</th>
                        <th>State</th>
                        <th>Country</th>
                        <th>Phone</th>
                        
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                
                <%
                
                 
                UserDAO userDAO = new UserDAO();
                Set<UserDTO> set = userDAO.getAllUsers();
                int count=1;
                //PrintWriter out=response.getWriter();
                for(UserDTO u: set)
                {
                	out.print("<tr>");
                	out.print("<td>"+count+"</td>");
                	out.print("<td>"+u.getFirstName()+" "+u.getLastName()+"</td>");
                	out.print("<td>"+u.getAddress()+"</td>");                       
                	out.print("<td>"+u.getCity()+"</td>");
                	out.print("<td>"+u.getZip()+"</td>");
                	out.print("<td>"+u.getState()+"</td>");
                	out.print("<td>"+u.getCountry()+"</td>");
                    out.print("<td>"+u.getPhone()+"</td>");
           			out.print("<td>");
           			out.print("<a href='editUserForm?id="+u.getPartyid()+"' class='settings' title='Settings' data-toggle='tooltip'><i class='material-icons'>&#xE8B8;</i></a>");
           			out.print("<a href='delete?id="+u.getPartyid()+"' class='delete' title='Delete' data-toggle='tooltip'><i class='material-icons'>&#xE5C9;</i></a>");
           			out.print(" </td>");
           			out.print("</tr>");																									
                		count++;
                }
                
                
                out.flush();
                %>
                
                  
                  
                </tbody>
            </table>
            <div class="clearfix">
                <div class="hint-text"></div>
                <ul class="pagination">
                    <li class="page-item disabled"><a href="#">Previous</a></li>
                    <li class="page-item"><a href="#" class="page-link">1</a></li>
                    <li class="page-item"><a href="#" class="page-link">2</a></li>
                    <li class="page-item active"><a href="#" class="page-link">3</a></li>
                    <li class="page-item"><a href="#" class="page-link">4</a></li>
                    <li class="page-item"><a href="#" class="page-link">5</a></li>
                    <li class="page-item"><a href="#" class="page-link">Next</a></li>
                </ul>
            </div>
        </div>
    </div>
</div>     

<script src="https://code.jquery.com/jquery-latest.min.js"></script>

	<script src="js/main.js"></script>
	
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.33.1/sweetalert2.css">
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.33.1/sweetalert2.js"></script>

	 
	<script type="text/javascript">
	<%
	String status= (String)request.getAttribute("status");
	if(status!=null && status.equals("success"))
	{
		out.print("swal('Welcome','Hello Admin','success');");
		out.flush();
	}else if(status!=null && status.equals("edit"))
	{
		out.print("swal('Edited','user edited successfully','success');");
		out.flush();	
	}
	else if(status!=null && status.equals("delete"))
	{
		out.print("swal('Deleted','user deleted successfully','error');");
		out.flush();	
	}
	%>
			
	
	</script>

</body>
</html>