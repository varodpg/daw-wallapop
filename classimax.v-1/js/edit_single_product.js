function add_product_tag(){
    var tag_text;
    tag_text = $("#tf_tag").val();
    $("#div_tags").append('<span class="badge badge-pill badge-primary">' + tag_text + '</span>');
    $("#tf_tag").val("");
}

function add_table_row(){    
    var specification_row = '<tr><td><div class="form_group"><input type="text" class="form-control w-bg" placeholder="Titulo"></div></td><td><div class="form_group"><input type="text" class="form-control w-bg" placeholder="Especificación"></div></td></tr>';
    $('#specification_table').append(specification_row);
}

function delete_table_row(){
    $('#specification_table tr:last-child').remove();
}

function open_file_browser(){
    $('#file_input').click();
}

function preview_image(){    
    var file    = document.querySelector('#file_input').files[0];
    var reader  = new FileReader();
    var src;
    
    reader.onloadend = function () {
        src = reader.result;
        $('#images_row').prepend('<div class="col-md-2"><img class="w-100" src="'+ src +'"></div>');
    }
    
    if (file) {
        reader.readAsDataURL(file);
    }   
}