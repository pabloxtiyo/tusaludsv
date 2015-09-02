$(document).ready(function()
{
	
	$("#btnButtomUs").click(function(){
		
		if($("#Owner").val() != ""){
			location.href="/tmtigo/TaskManagerByOwner/TaskUpdate?owner="+$("#Owner").val();
		}
		else{
			
			if (document.getElementById("erro")) {
				document.getElementById("erro").remove();
			}
			else{
				$("#idmesagge")
				.append("<span id ='erro' class='has-error'>No ha digitado el usuario.</span>");
			}
		}
	});
	
	
	 $('#expdf').click(function () {
	        
	    	var keyParams = new Array();
	    	keyParams.push("type");
	    	keyParams.push("tskOwner");
	    	var valueKeyParams = new Array();
	    	valueKeyParams.push("PDF");
	    	valueKeyParams.push($("#Owner").val());
	    	windowsOpen("/TaskManagerByOwner/Download","tmtigo",keyParams,valueKeyParams);
	    });  
	    
	 $('#exxls').click(function () {
	        
	    	var keyParams = new Array();
	    	keyParams.push("type");
	    	keyParams.push("tskOwner");
	    	var valueKeyParams = new Array();
	    	valueKeyParams.push("XLSX");
	    	valueKeyParams.push($("#Owner").val());
	    	
	    	windowsOpen("/TaskManagerByOwner/Download","tmtigo",keyParams,valueKeyParams);
	    });
	
	
	$('#updateModal').on('hide.bs.modal', function (e) 
	{
		$("#Task_id").text("Task ID: <>");
		$("#Task_des").text("Task Description: <>");
		$("#id").val("");
		$("#task_percent").val("0");
		$("#task_sts").val("1");
	});
		
	
	$(".updateTm").click(function(){
		
		$("#Task_id").text("Task ID: "+$(this).data("id"));
		$("#Task_des").text("Task Description: "+$(this).data("name"));
		$("#id").val($(this).data("id"));
		$("#task_percent").val($(this).data("progress"));
		
		var st = $(this).data("status");
		
		$("#task_sts option").filter(function() 
		{
		    return $(this).text() == st;
		}).attr('selected', true);
		
		$("#updateModal").modal('show');
		
	});
	
	$("#saveChanges").click(function(){
		
		//alert($("#id").val()+", "+$("#task_sts").val()+", "+$("#task_percent").val());
		
		var id =$("#id").val();
		var state = $("#task_sts").val();
		var percent = $("#task_percent").val();
		
		$.ajax({
		 	    type: "POST",
		 		url: "/tmtigo/TaskManagerByOwner/updateTsk",	
		 		data : ({taskId:id,state:state,progress:percent}),
		 	    success: function(data)
		 	    	{
		 	    		if(data == "ok")
		 	    			{
		 	    				window.location.href = "/tmtigo/TaskManagerByOwner/TaskUpdate?owner="+$("#Owner").val()+"&success=true";
		 	    			}
		 	    		else
		 	    			{
		 	    				console.log(data);
		 	    				window.location.href = "/tmtigo/TaskManagerByOwner/TaskUpdate?owner="+$("#Owner").val()+"&error=true";
		 	    			}
					},
						
				error: function(e)
					{
						$("#error").show();
					}
		 	    });	
		
	});
	
});


function windowsOpen(actionUrl,host,keyParams,valueParams) {
	
	var urlPath;
	if(host != "")
	{
		urlPath = "/"+ host + actionUrl;
	}
	else
	{
		urlPath = actionUrl;
	}
	
	var mapForm = document.createElement("form");
	mapForm.target = "Map";
	mapForm.method = "POST"; // or "post" if appropriate
	mapForm.action = urlPath;

	if (keyParams && valueParams && (keyParams.length == valueParams.length)){
        for (var i = 0; i < keyParams.length; i++){
        var mapInput = document.createElement("input");
            mapInput.type = "hidden";
            mapInput.name = keyParams[i];
            mapInput.value = valueParams[i];
            mapForm.appendChild(mapInput);

        }
        document.body.appendChild(mapForm);
    }
	
	mapForm.submit();
}
