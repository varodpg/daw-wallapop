$(document).ready(function(){
	var page = 0;
	
    //Logo loading
   
    $(document).ajaxStart(function(){
        $("#wait").css("display", "block");
    });
    $(document).ajaxComplete(function(){
        $("#wait").css("display", "none");
    });
    
    
    $("#showMore").click(function(){
    	page++;
        //alert("The paragraph was clicked.");
        $.ajax({
        		url: "/categoryAjax",
        		data: {
        			'page': page, 
        			'size': 10, 
        			  },
        		dataType: "json",
        		success: function(items){
        			 $.each(items.content, function (key,value){
        				html='<div class="col-sm-12 col-lg-4 col-md-6"><div class="product-item bg-light"><div class="card"><div class="thumb-content"><b>' 
        				+ value['id'] + 
        				'</b><a href="https://www.amazon.es/Apple-Macbook-Ordenador-port%C3%A1til-Teclado/dp/B0721BNGVR/ref=sr_1_2?ie=UTF8&qid=1517394780&sr=8-2&keywords=macbook+12"><img class="card-img-top img-fluid" src="images/products/products-1.jpg" alt="Card image cap"></a></div>'
        				+ '<div class="card-body"><h4 class="card-title"><a href="https://www.amazon.es/Apple-Macbook-Ordenador-port%C3%A1til-Teclado/dp/B0721BNGVR/ref=sr_1_2?ie=UTF8&qid=1517394780&sr=8-2&keywords=macbook+12">' 
        				+ value['name'] + 
        				'</a></h4><ul class="list-inline product-meta"><li class="list-inline-item"><a href="/category"><i class="fa fa-folder-open-o"></i>Informatica</a></li><li class="list-inline-item"><a href=""><i class="fa fa-calendar"></i>'
        				+ '27 de diciembre</a>'+ 
        				'</li></ul><p class="card-text">'
        				+ value['description']+
        				+ '</p></div></div></div></div>';
        			if(items.last==true){
        				$("#showMore").css("display", "none");
        			}
        				
        				
						
						
								
				
						
					  
        				
					  
        				$('#productsList').append(html);
        			 //alert("exito" + page+ "o");
        			 });
        			 //$('#productsList').append("Mas productos" + page);
        			 //var cadena = '<div>hola</div>';
        			 //$('#productosLista').append(cadena);
        }});
    });
});
