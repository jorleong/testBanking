<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<title>Online Banking</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-black.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
html,body,h1,h2,h3,h4,h5,h6 {font-family: "Roboto", sans-serif;}
.w3-sidebar {
  z-index: 3;
  width: 250px;
  top: 43px;
  bottom: 0;
  height: inherit;
}
.footer{
	position: fixed;
   left: 0;
   bottom: 0;
   width: 100%;
   background-color: red;
   color: white;
   text-align: center;
}
</style>
<body>

<!-- input page stuff here -->
<jsp:include page="navigation.jsp"></jsp:include>

<!-- Main content: shift it to the right by 250 pixels when the sidebar is visible -->
<div class="w3-main" style="margin-left:250px">

  <div class="w3-row w3-padding-64">
    <div class="w3-twothird w3-container">
      <h2 class="w3-text-teal">Welcome to Synergistic Banking</h2>
      	<table>
		<form:form action="login" method="post" modelAttribute="user">
			<table>
				<tr>
					<td>Username: <form:input path="username"/>
					<form:errors path="username" cssClass="error"/></td>
				</tr>
				<tr><td>Password: <form:input path="password"/></td>
					<td><form:errors path="password" cssClass="error"/></td>
				</tr>
				
				<tr><td colspan="2"><input type="submit" value="login"> </td></tr>
			</table>
			<form:errors path="*" cssClass="error"/>
		
		</form:form>
	</table>
	<p>${error} </p>
	<br><br><br><br><br>
      
    </div>
    <div class="w3-row w3-padding-64">
    <div class="w3-twothird w3-container">
      <h2 class="w3-text-teal">Don't have an account?</h2>
      <a href="/register">Register here</a>
      
    </div>
    <div class="w3-third w3-container">
<!--       <p class="w3-border w3-padding-large w3-padding-32 w3-center">AD</p> -->
<!--       <p class="w3-border w3-padding-large w3-padding-64 w3-center">AD</p> -->
    </div>
  </div>
	
  <div class="footer">
  	  <jsp:include page="footer.jsp"></jsp:include>
  </div>

<!-- END MAIN -->
</div>

<script>
// Get the Sidebar
var mySidebar = document.getElementById("mySidebar");

// Get the DIV with overlay effect
var overlayBg = document.getElementById("myOverlay");

// Toggle between showing and hiding the sidebar, and add overlay effect
function w3_open() {
    if (mySidebar.style.display === 'block') {
        mySidebar.style.display = 'none';
        overlayBg.style.display = "none";
    } else {
        mySidebar.style.display = 'block';
        overlayBg.style.display = "block";
    }
}

// Close the sidebar with the close button
function w3_close() {
    mySidebar.style.display = "none";
    overlayBg.style.display = "none";
}
</script>

</body>
</html>
