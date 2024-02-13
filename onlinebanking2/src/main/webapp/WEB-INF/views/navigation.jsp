<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<!-- Navbar -->
<div class="w3-top">
  <div class="w3-bar w3-theme w3-top w3-left-align w3-large">
    <a class="w3-bar-item w3-button w3-right w3-hide-large w3-hover-white w3-large w3-theme-l1" href="javascript:void(0)" onclick="w3_open()"><i class="fa fa-bars"></i></a>
    <a href="#" class="w3-bar-item w3-button w3-theme-l1">Logo</a>
    <a href="/index" class="w3-bar-item w3-button w3-hide-small w3-hover-white">Home</a>
    <a href="/index" class="w3-bar-item w3-button w3-hide-small w3-hover-white">About</a>
    <a href="/index" class="w3-bar-item w3-button w3-hide-small w3-hover-white">News</a>
    <a href="/index" class="w3-bar-item w3-button w3-hide-small w3-hover-white">Contact</a>
    <a href="/index" class="w3-bar-item w3-button w3-hide-small w3-hide-medium w3-hover-white">Clients</a>
    <a href="/index" class="w3-bar-item w3-button w3-hide-small w3-hide-medium w3-hover-white">Partners</a>
    <security:authorize access="isAuthenticated()">
      <div class="w3-bar-item w3-button w3-hide-small w3-hide-medium w3-hover-white">Welcome ${pageContext.request.userPrincipal.name}</div>
  	</security:authorize>
  </div>
</div>

<!-- Sidebar -->
<nav class="w3-sidebar w3-bar-block w3-collapse w3-large w3-theme-l5 w3-animate-left" id="mySidebar">
  <a href="javascript:void(0)" onclick="w3_close()" class="w3-right w3-xlarge w3-padding-large w3-hover-black w3-hide-large" title="Close Menu">
    <i class="fa fa-remove"></i>
  </a>
  <h4 class="w3-bar-item"><b>Menu</b></h4>
  <security:authorize access="!isAuthenticated()">
    <a class="w3-bar-item w3-button w3-hover-black" href="/login">Login</a>
  	<a class="w3-bar-item w3-button w3-hover-black" href="/register">Register</a>  
  </security:authorize>
  <security:authorize access="hasAuthority('ADMIN')">
  	<a class="w3-bar-item w3-button w3-hover-black" href="/changeAuthority">(Broken)Change Authority</a>
	<a class="w3-bar-item w3-button w3-hover-black" href="/t/viewTransactions">View Transactions</a>
	<a class="w3-bar-item w3-button w3-hover-black" href="/b/createBranch">Create Branch</a>
	
  </security:authorize>
  
  <security:authorize access="isAuthenticated()">
      <a class="w3-bar-item w3-button w3-hover-black" href="/createAccount">Create Bank Account</a>
      <a class="w3-bar-item w3-button w3-hover-black" href="/deposit">Deposit Money</a>
      <a class="w3-bar-item w3-button w3-hover-black" href="/withdraw">Withdraw Money</a>
      <a class="w3-bar-item w3-button w3-hover-black" href="/t/transfer">Transfer Money</a>
      <a class="w3-bar-item w3-button w3-hover-black" href="/login?logout">Logout</a>
      
      <br>
      <security:authorize access="hasAuthority('ADMIN')">
      <h4 class="w3-bar-item"><b>Tests</b></h4>
      <a class="w3-bar-item w3-button w3-hover-black" href="/viewAllAccounts/normal">View Accounts (website)</a>
      <a class="w3-bar-item w3-button w3-hover-black" href="/viewAllAccounts/pdf">View Accounts (PDF)</a>    
      <a class="w3-bar-item w3-button w3-hover-black" href="/viewAllAccounts/excel">View Accounts (EXCEL)</a>
      <a class="w3-bar-item w3-button w3-hover-black" href="/viewAllAccounts/csv">View Accounts (CSV)</a>
      </security:authorize>
      
      <br><br><br>
      <h4 class="w3-bar-item"><b>Need a Loan?</b></h4>
      <a class="w3-bar-item w3-button w3-hover-black" href="/customer">Loan Login Form</a>
      <a class="w3-bar-item w3-button w3-hover-black" href="/loan">Request Loan</a>
  </security:authorize>
  
  
</nav>

<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

