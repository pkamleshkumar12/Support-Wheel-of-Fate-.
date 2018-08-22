function getScheduleData(url){ 
	
	 var table = $('#scheduleTable').DataTable();
	 table.clear().draw();
 $.ajax({
	    type:"GET", 
	    url: "/"+url, 
	    success: function(data) {
	    	Object.keys(data).forEach(function(key){
	    			var shiftArray = [key];
	    				var shiftData = data[key];
	    				Object.keys(shiftData).forEach(function(key){
	    					var valuePerShift = shiftData[key];
	    					shiftArray.push(valuePerShift);
	    				});
	    				table.row.add(shiftArray).draw( false );
	    				 
	    			});
	        }, 
	    error: function(jqXHR, textStatus, errorThrown) {
	            alert(jqXHR.status);
	        }
	});
}
 $(document).ready(function() {
	    $('#scheduleTable').DataTable();
	    
	    $( "#schedule" ).click(function() {
	    	getScheduleData("schedules");
	    });
	    
	    $( "#shuffle" ).click(function() {
	    	getScheduleData("shuffle");
	    });
	   
	} );