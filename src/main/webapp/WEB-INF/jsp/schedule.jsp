<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE>
<html lang="en" xmlns:th="http://www.springframework.org/schema/mvc">
<head>
  <title>Wheel of Fate</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.1/css/bootstrap.css">
  <link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap4.min.css">
  <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
  <script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
  <script src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap4.min.js"></script>
  
	<spring:url value="/resources/js/schedule.js" var="scheduleJs" />
	<script type="text/javascript" src="${scheduleJs}"></script>
</head>
<body>

<div class="container">
		<div class="row">
		<div class="col-md-12">
			<div class="panel panel-default">
			<div class="panel-body"><h4 align="center">Click Schedule to Generate the Schedule And Shuffle to generate new random data </h4></div>
			<div  align="center">
				<button type="button" class="btn btn-primary btn-lg" id ="schedule">Schedule </button>
				<button type="button" class="btn btn-success btn-lg" id = "shuffle" >Shuffle</button>
			</div>
			</div>
		</div>
		</div>
		 <div class="clearfix hidden-xs hidden-sm"> </div>
		  <div class="clearfix hidden-xs hidden-sm"> </div>
		  
		  
   <table id="scheduleTable" class="table table-striped table-bordered" style="width:100%">
        <thead>
            <tr>
                <th>Shift</th>
                <th>Id</th>
                <th>Number of Days worked</th>
                <th>Name</th>
                
            </tr>
        </thead>
        <tfoot>
            <tr>
                <th>Shift</th>
                <th>Id</th>
                <th>Number of Days Worked</th>
                <th>Name</th>
            </tr>
        </tfoot>
    </table>
          
</div>
<script>

	
	</script>
</body>
</html>