$(document).ready(function(){
	//if($("#myTable").length==1) {$("#myTable").hide();}
	$.getJSON("../RestfulJSONWebService/rest/users/all", function(data){
		if(data.length>0) {$("#myTable").show();}
		$("#myTable").find("tr:gt(0)").remove();
		$.each(data, function(key, val){
			var rowCount=$("#myTable tr").length;
			$("#myTable tr:last").after("<tr><td>"+rowCount+"</td><td>"+val.name+"</td><td>"+val.age+"</td></tr>");
		});
		
	});
});

