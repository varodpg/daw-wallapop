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
    var specification_row = '<tr><td><div class="form_group"><input type="text" class="form-control w-bg" placeholder="Titulo" name="specifications"></div></td><td><div class="form_group"><input type="text" class="form-control w-bg" name="specifications" placeholder="Especificación"></div></td></tr>';
    $('#specification_table').append(specification_row);    
}

function delete_table_row(){
    $('#specification_table tr:last-child').remove();
}

function edit_product(){
	$('#form_edit_product').submit();
}

function open_file_browser(){
    $('#file_input').click();
}
function checkform() {
    if(document.addProduct.name.value == "") {
        alert("Introduce un nombre al producto");
        return false;
    } 
    if(document.addProduct.description.value == "") {
        alert("Introduce una descripcion al producto");
        return false;
    }
    if(document.addProduct.price.value == "") {
        alert("Introduce un precio al producto");
        return false;
    }
    if(document.addProduct.category.value == "") {
        alert("Introduce una categoria al producto");
        return false;
    }

        document.addProduct.submit();
    
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