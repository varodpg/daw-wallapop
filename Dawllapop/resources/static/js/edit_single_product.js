function add_product(){
    console.log("Entro en js add_product");
    $('#form_add_product').submit();
}

function add_product_tag(){
    var tag_text;
    tag_text = $("#tf_tag").val();
    $("#div_tags").append('<span class="badge badge-pill badge-primary">' + tag_text + '</span><input name="tags" value="'+ tag_text +'" style="display:none">');
    $("#tf_tag").val("");
}

function add_table_row(){    
	var id_espect = $("#specification_table tr").length;
    var specification_row = '<tr><td><div class="form_group"><input type="text" class="form-control w-bg" placeholder="Titulo" name="especifications[' + id_espect + ']"></div></td><td><div class="form_group"><input type="text" class="form-control w-bg" name="especifications[' + id_espect + ']" placeholder="Especificación"></div></td></tr>';
    $('#specification_table').append(specification_row);    
}

function delete_table_row(){
    $('#specification_table tr:last-child').remove();
}

function edit_product(){
    swal({
        title: 'Exito',
        text: 'Se ha editado tu producto correctamente',
        type: 'success'
    }, function(){
        window.location.replace("dashboard.html");
    });  
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