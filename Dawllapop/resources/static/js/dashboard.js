$(function(){
	var rate;
	$('.ratings').each(function(){
		rate = $(this).attr("rate");
		for(i = 0; i < rate; i++){
			$(this).append("<li class='list-inline-item'><i class='fa fa-star selected'></i></li>");
		}
	});
});