var countdownTimeMax = 120;
var countdownTime = countdownTimeMax;
var countdownActive = true;

$(function(){
	
	var myDate = new Date();
	var month = myDate.getMonth() + 1;
	var prettyDate = myDate.getFullYear() + '-' + month + '-'
			+ myDate.getDate() + ' ' + addZero(myDate.getHours()) + ':'
			+ addZero(myDate.getMinutes()) + ':'+ addZero(myDate.getSeconds());
	var prettyDateInit = myDate.getFullYear() + '-' + month + '-'
	+ myDate.getDate() + ' ' + "00" + ':'
	+ "00" + ':'
	+ "00";

	
	$("#startDate").val(prettyDateInit);
	$("#EndDate").val(prettyDate);
	
	
	$("#btnButtomUp").click(function(){
		
		Ontable();
		
	});
	
	
	$("#timesRefresh").change(function () {
		var value = $(this).val();
		
		if (value == null || value == '') {
			return;
		}
		
		countdownTimeMax = parseInt(value);
		countdownTime = parseInt(value);
	});
    
    $('#expdf').click(function () {
        
    	var keyParams = new Array();
    	keyParams.push("type");
    	var valueKeyParams = new Array();
    	valueKeyParams.push("PDF");
    	windowsOpen("/TaskManager/Download","tmtigo",keyParams,valueKeyParams);
    });  
    
 $('#exxls').click(function () {
        
    	var keyParams = new Array();
    	keyParams.push("type");
    	keyParams.push("inDate");
    	keyParams.push("finDate");
    	keyParams.push("tskStatus");
    	keyParams.push("tskOwner");
    	keyParams.push("tskTeam");
    	keyParams.push("tskName");
    	var valueKeyParams = new Array();
    	valueKeyParams.push("XLSX");
    	valueKeyParams.push($("#startDate").val());
    	valueKeyParams.push($("#EndDate").val());
    	valueKeyParams.push($("#SelectTask").find(':selected').text());
    	valueKeyParams.push($("#OwnerTask").val());
    	valueKeyParams.push($("#RespTeam").val());
    	valueKeyParams.push($("#RespTeam1").val());
    	
    	windowsOpen("/TaskManager/Download","tmtigo",keyParams,valueKeyParams);
    });
    
});


var autoRefresh = function() {
	 var tm = new Date(countdownTime * 1000);

	    var minutes = tm.getUTCMinutes();
	    var seconds = tm.getUTCSeconds();
	    if (seconds < 10) {
	        seconds = "0" + seconds;
	    }
	$('#counter').html(minutes + ":" + seconds);
	
	 if (countdownTime >= 0) {
         countdownTime--;
     } else {
         countdownActive = false;
         Ontable();

         resetTimer();
     }
	
}

function resetTimer() {
    countdownActive = true;
    countdownTime = countdownTimeMax;
}

setInterval("autoRefresh()", 1000);

function drawingTable(callback){
	var idContentBodyTable = $("#taskManagerTable");
	idContentBodyTable.find('tr').remove().end();
	
	if (callback && typeof(callback) === "function") {  
        callback();  
    }
}


function Ontable(){
	
	var firstDate = $("#startDate").val();
	var endDate = $("#EndDate").val();
	var status = $("#SelectTask").find(':selected').text();
	var responsa = $("#OwnerTask").val();
	var equip = $("#RespTeam").val();
	var nametask = $("#RespTeam1").val();
	
	$.ajax({
 	    type: "POST",
 		url: "/tmtigo/TaskManager/UpdateRefresh",	
 		data:({
 			startDate:firstDate, 
 			EndDate:endDate,
 			SelectTask:status,
 			OwnerTask:responsa,
 			RespTeam: equip,
 			RespTeam1: nametask
 			}),
 	    success: function(data){
 	    	
 	    	drawingTable(function(){
 	    		
 	    		idContentBodyTable = $("#taskManagerTable");
 	    		
 	    		
 	    		  $.each(data, function(i, item) {
 	    			 idContentBodyTable.append('<tr class="'+getClassV(item.tskRealPercent)+'"><td>'+item.pkTmTsk +'</td><td>'+item.tskIdDepend+'</td><td>'+
 	    			 	item.tskDescription +'</td><td>'+ item.tskOwner + '</td><td>' +item.systemOperation+'</td><td>'+
 	    			 	item.tskEstimatedStartTime +'</td><td>'+ item.tskEstimatedEndTime +'</td><td>'+
 	    			 	item.tskEstimatedTotalTime + '</td><td>' +item.tskRealStartTime + '</td><td>'+ item.tskRealEndTime +
 	    			 	'</td><td>' + item.tskRealTotalTime + '</td><td>' +item.tskStatus +'</td><td>' +item.tskRealPercent +
 	    			 	'</td><td>' + item.tskEstimatedPercent + '</td><td>' + item.tskTeam + '</td></tr>');

 	             });
 	    	});
 	    	
 	    	
 	    	
 	    }
		});
}

function getClassV(val){
	
	if(val == 100){
		return "info";
	}
	else{
		return "danger";
	}

}

function addZero(value){
	if (value < 10) {
		value = "0" + value;
	}
	return value;
}




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