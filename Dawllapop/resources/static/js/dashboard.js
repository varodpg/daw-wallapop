$(document).ready(function(){
	$(".btn-main-sm *").html(function(searchandreplace6, sreplace6) {
        return sreplace6.replace('false', 'en venta');
    }, 5000);
	$(".btn-main-sm *").html(function(searchandreplace7, sreplace7) {
        return sreplace7.replace('true', 'vendido');
    }, 5000);
	$("#pills-home *").html(function(searchandreplace8, sreplace8) {
        return sreplace8.replace('new', 'nuevo');
    }, 5000);
	$("#pills-home *").html(function(searchandreplace9, sreplace9) {
        return sreplace9.replace('not_new', 'seminuevo');
    }, 5000);

});



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