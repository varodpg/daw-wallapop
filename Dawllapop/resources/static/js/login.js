function open_signup(){
    $('#login_modal').modal('toggle');
    setTimeout(function(){
        $('#signup_modal').modal('toggle');
    },400);    
}

function open_file_browser_profile(){
    $('#profile_img_input').click();
}

function preview_profile_image(){
    var file    = document.querySelector('#profile_img_input').files[0];
    var reader  = new FileReader();
    var src;
    
    reader.onloadend = function () {
        src = reader.result;
        $('#signup_img').html('<img src="'+ src +'">');
    }
    
    if (file) {
        reader.readAsDataURL(file);
    }
}
function add_user(){
   
    $('#form_add_user').submit();
}