var stompClient = null;
var username;
var chats;

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
				$('#friendsList').append("<div class='row contactCard' onclick='openFriendChat(\"" + data[i][6] + "\")'><div class='col-md-4'><img style='width: 100%; border-radius: 100px' src='/images/user/user-thumb.jpg'></div><div class='col-md-8' style='text-align: left; font-size: 18px'><div class='row'>"+ data[i][6] +"</div></div></div>");
			}
		}
	});
	
	connect();	
});

function showFriendsList(){	
	$('#friendsList').toggle("bind");		
}

function connect() {
	username = $('#usernameTitle').html();
    var socket = new SockJS('/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {        
        stompClient.subscribe('/topic/recieve/' + username, function (greeting) {            
            message = JSON.parse(greeting.body);            
            if($('#friendChat' + message[0]).length > 0){
            		if($("#friendChat" + message[0]).css('display') == "none"){
            			$('#friendButton' + message[0]).addClass('messageAlert');
            		}
            		$('#friendChatBody' + message[0]).append("<p class='friendMessage'>["+message[0]+"]- " + message[1] + "</p>");
            }else {
            		createChatUser(message[0]);
            		$('#friendChatBody' + message[0]).append("<p class='friendMessage'>["+message[0]+"]- " + message[1] + "</p>");
            		$('#friendButton' + message[0]).addClass('messageAlert');
            }
        });
    });
}

function openFriendChat(user) {
	if($('#friendChat' + user).length == 0){
		createChatUser(user);
		$('#friendsList').toggle("bind");
	}
	$("#friendChat"+ user).toggle("bind");
	$('#friendButton' + user).removeClass('messageAlert');
	
}

function sendMessage(user){
	var text = $('#chatText' + user).val();
	$('#chatText' + user).val("");
	$('#friendChatBody' + user).append("<p class='myMessage'>[Yo]- " + text + "</p>");
	stompClient.send("/app/send/" + user,{}, JSON.stringify({'username': username, 'message': text}));
}

function createChatUser(user){
	$('#friendsDiv').append("<div id='friendButton"+ user +"' class='friendsButton' style='right: 90px; font-size: 24px; font-weight: bold; padding-top: 5px' onclick='openFriendChat(\"" + user + "\")'>A</div>");	
	$('#friendsDiv').append("<div id='friendChat"+ user +"' class='friendChat' style='display: none'><div class='row friendChatHeader'><h3 style='width: 100%; text-align: center'>" + user + "</h3></div>" +
							"<div class='friendChatBody' id='friendChatBody" + user + "'></div><div class='row friendChatInput'><div class='col-md-9'><input type='text' id='chatText" + user + "' class='form-control' style='height: 45px; margin-top: 2px;'>"+
							"</div><div class='col-md-3' style='padding-left: 0px; padding-right: 0px'>"+
							"<i class='fa fa-chevron-circle-right' style='font-size: 50px; color: #5672f9;' onclick='sendMessage(\"" + user + "\")'></i></div></div></div></div>");
}