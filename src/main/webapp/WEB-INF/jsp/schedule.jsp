<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html lang="en">
<head>
  <title>Wheel of Fate</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.1/css/bootstrap.css">
  <link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap4.min.css">
  <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
  <script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
  <script src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap4.min.js"></script>
</head>
<body>

<div class="container">
            
   <table id="schedule-table" class="table table-striped table-bordered" style="width:100%">
        <thead>
            <tr>
           		<th>Shift (Schedule)</th>
            </tr>
        </thead>
        <tbody>
          
          </table>
          
</div>
<script>
  
	 $.ajax({
	    type:"GET", 
	    url: "/schedules", 
	    success: function(data) {
	    	var data = JSON.stringify(data)
	            $("body").append(JSON.stringify(data));
	        }, 
	    error: function(jqXHR, textStatus, errorThrown) {
	            alert(jqXHR.status);
	        }
	});
	</script>
</body>
</html>