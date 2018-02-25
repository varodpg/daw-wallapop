$(document).ready(function(){
	var page = 0;
    //Logo loading
   
    $(document).ajaxStart(function(){
        $("#wait").css("display", "block");
    });
    $(document).ajaxComplete(function(){
        $("#wait").css("display", "none");
    });
    
    //jquery remember filters checked on the form through inputs on the end of the html with values 
    //printed by the model with mustache
    if($("#product_n").val()=="new"){
    		$("#product_new").prop('checked', true);
    }
    if($("#product_n").val()=="null"){
		$("#product_new").prop('checked', false);
    }
    if($("#product_nn").val()=="not_new"){
		$("#product_not_new").prop('checked', true);
    }
    if($("#product_nn").val()=="null"){
		$("#product_not_new").prop('checked', false);
    }
    
    
    $("#showMore").click(function(){
    	page++;
    	var srt_val1 = $('select.changeSort').val();
    var id = $( "#actual_id" ).val();
    var pi = $( "#inf" ).val();
    var pt = $( "#p_top" ).val();
    var pn = $( "#product_n" ).val();
    var pnn = $( "#product_nn" ).val();
    
        //alert("The paragraph was clicked.");
        $.ajax({
        		url: "/categoryAjax/" + id + "/" + pi + "/" + pt  + "/" + pn + "/" + pnn + "/?sort=" + srt_val1,
        		data: {
        			'page': page, 
        			'size': 10,
        			  },
        		dataType: "json",
        		success: function(items){
        			 $.each(items.content, function (key,value){
        				html='<div class="col-sm-12 col-lg-4 col-md-6"><div class="product-item bg-light"><div class="card"><div class="thumb-content"><b>' 
        				+ value['id'] + 
        				'</b><a href="category/ ' + value['id'] + '"><img class="card-img-top img-fluid" src="images/products/products-1.jpg" alt="Card image cap"></a></div>'
        				+ '<div class="card-body"><h4 class="card-title"><a href="https://www.amazon.es/Apple-Macbook-Ordenador-port%C3%A1til-Teclado/dp/B0721BNGVR/ref=sr_1_2?ie=UTF8&qid=1517394780&sr=8-2&keywords=macbook+12">' 
        				+ value['name'] + 
        				'</a></h4><ul class="list-inline product-meta"><li class="list-inline-item"><a href="/category"><i class="fa fa-folder-open-o"></i>Informatica</a></li><li class="list-inline-item"><a href=""><i class="fa fa-calendar"></i>'
        				+ '27 de diciembre</a>'+ 
        				'</li></ul><p class="card-text">'
        				+ value['description']+
        				+ '</p></div></div></div></div>';
        			

	        			if(items.last==true){
	        				$("#showMore").css("display", "none");
	        			}else{
	        				$("#showMore").css("display", "block");
	        			}
					  
        				$('#productsList').append(html);
        			 //alert("exito" + page+ "o");
        			 });
        			 //$('#productsList').append("Mas productos" + page);
        			 //var cadena = '<div>hola</div>';
        			 //$('#productosLista').append(cadena);
        }});
    });
    
    $("select.changeSort").change(function(){
    		 var srt_val = $('select.changeSort').val();   		 
    		 var id2 = $( "#actual_id" ).val();
    		 var pi2 = $( "#inf" ).val();
    		 var pt2 = $( "#p_top" ).val();
    		 var pn2 = $( "#product_n" ).val();
    		 var pnn2 = $( "#product_nn" ).val();
     	 $( "#sort_type" ).val(srt_val);
     	 //reset variable from "show more" to show again from 0 
     	 page = 0;
     	 
    		 $.ajax({
    			 url: "/categoryAjax/" + id2 + "/" + pi2 + "/" + pt2 + "/" + pn2 + "/" + pnn2 + "/?sort=" + srt_val,
    			 data: {
         			'page': 0, 
         			'size': 10,
         			  },
         	 dataType: "json",
    			 success: function(result){
    				 $('#productsList').empty();
    				 $.each(result.content, function (key,value){
    					 
    					 html2='<div class="col-sm-12 col-lg-4 col-md-6"><div class="product-item bg-light"><div class="card"><div class="thumb-content"><b>' 
    	        				+ value['id'] + 
    	        				'</b><a href="category/ ' + value['id'] + '"><img class="card-img-top img-fluid" src="' + value['mainImage'] + '" alt="Card image cap"></a></div>'
    	        				+ '<div class="card-body"><h4 class="card-title"><a href="https://www.amazon.es/Apple-Macbook-Ordenador-port%C3%A1til-Teclado/dp/B0721BNGVR/ref=sr_1_2?ie=UTF8&qid=1517394780&sr=8-2&keywords=macbook+12">' 
    	        				+ value['name'] + 
    	        				'</a></h4><ul class="list-inline product-meta"><li class="list-inline-item"><a href="/category"><i class="fa fa-folder-open-o"></i>Informatica</a></li><li class="list-inline-item"><a href=""><i class="fa fa-calendar"></i>'
    	        				+ '27 de diciembre</a>'+ 
    	        				'</li></ul><p class="card-text">'
    	        				+ value['description']+
    	        				+ '</p></div></div></div></div>';
    					 

    					 if(result.last==true){
    	        				$("#showMore").css("display", "none");
    	        		     }else{
    		        				$("#showMore").css("display", "block");
    		        			}
    					 
    					 
    					 $('#productsList').append(html2);
    				 });
    			 
    			 
    	        }});
    		
    		
    });
    
    
});
