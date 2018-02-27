$(function(){
	var rate;
	$('.ratings').each(function(){
		rate = $(this).attr("rate");
		for(i = 0; i < rate; i++){
			$(this).append("<li class='list-inline-item'><i class='fa fa-star selected'></i></li>");
		}
	});
	
	$.ajax({
		url: "getUserFriends",
		type: "POST",
		success: function(data){
			for(i = 0; i < data.length; i++){
				$('#friendsList').append("<div class='row' style='border: 1px solid #aaa; border-radius: 2px;margin: 0px 0px 10px 0px; padding: 2px 0px;'><div class='col-md-4'><img style='width: 100%; border-radius: 100px' src='/images/user/user-thumb.jpg'></div><div class='col-md-8' style='text-align: left; font-size: 18px'><div class='row'>"+ data[i][5] +"</div><div class='row' style='color: red'>Desconectado</div></div></div>");
			}
		}, error: function(data){
			console.log("Fallo");
			console.log(data);
		}, done: function(data){
			console.log("Done");
			console.log(data);
		}
	});
});

function showFriendsList(){
	
}