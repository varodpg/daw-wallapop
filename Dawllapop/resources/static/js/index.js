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