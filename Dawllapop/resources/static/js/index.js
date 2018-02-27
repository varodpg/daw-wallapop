$(document).ready(function(){
	$(".product-item *").html(function(searchandreplace5, sreplace5) {
        return sreplace5.replace('new', 'nuevo');
    });
	
    $(".product-item *").html(function(searchreplace6, sreplace6) {
        return sreplace6.replace('not_nuevo', 'seminuevo');
    });
	
}
);



$('.carousel').carousel({
	interval : 3000
});

$('#searchButton').on("click",function(){
	console.log("gooooooo");
	$('#searchForm').submit();
});

function add_new_assessmet() {
	$('#form_add_assessment').submit();
}
function closeUser(){
	$('#formDelete').submit();
}