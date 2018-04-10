import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { ProductService } from '../service/product.service';
import { Product } from '../model/product.model';
import { Inject, Injectable } from '@angular/core';
import { DOCUMENT } from '@angular/platform-browser';
import { Http } from '@angular/http';
import { HttpClient } from "@angular/common/http";


@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {

  products: Product[];
  number_of_1: number;
  number_of_2: number;
  number_of_3: number;
  number_of_4: number;
  number_of_5: number;
  private domain;
  private URLimages: string;
  private page: number;
  private id: number;

  checkboxNew:boolean;
  checkboxNotNew:boolean;
  new: string;
  not_new: string;

  constructor(@Inject(DOCUMENT) private document: any, private http: Http, private router: Router, private productService: ProductService, activatedRoute: ActivatedRoute) { 
    this.id = activatedRoute.snapshot.params['id'];
    this.domain=this.document.location.hostname;
    this.URLimages="https://"+this.domain+":8443/imgs/";
    this.page=1;

    this.new="new";
    this.not_new="not_new";

    console.log(this.URLimages);
    console.log(this.id);
    
    this.showProductsAndReload();
  }

  public showProductsAndReload(){
    this.productService.getCategoryProducts(this.id).subscribe(response => {      
      this.products = [];

      response.forEach(element => {
        this.products.push(element);
      });
      console.log(this.products);    
  });  
  }

  public filt(){
    
    if(this.checkboxNotNew){
      //Reset pagination to show products for beggining filtering
      this.page=0;
      this.not_new="not_new";
      console.log("seminuevo pulsado");
    }else{
      this.not_new="null";
    } 
     
    if(this.checkboxNew){
      this.page=0;
      this.new="new";
      console.log("nuevo pulsado");
    }else{
      this.new="null";
    }  

    this.products = [];
    this.loadMoreItems();

  }
  
  loadMoreItems(){
    let url = "https://"+this.domain+":8443/api/products/category/filter/" + this.id + "/" + this.new + "/" + this.not_new + "?page=" + this.page;

    this.http.get(url).subscribe(response => {

        console.log(response);
        let data = response.json();
        console.log(data);

        data.forEach(element => {
          this.products.push(element);
        });

      },
      error => console.error(error)
    );
    this.page=this.page+1;
    console.log("asdasda");

  }



 ngOnInit() {
  
        this.productService.getCategoryNumberProducts(1).subscribe(response => {      
          this.number_of_1=response;
         }); 
         
         this.productService.getCategoryNumberProducts(2).subscribe(response => {      
          this.number_of_2=response;
         }); 

         this.productService.getCategoryNumberProducts(3).subscribe(response => {      
          this.number_of_3=response;

         }); 

         this.productService.getCategoryNumberProducts(4).subscribe(response => {      
          this.number_of_4=response;

         }); 

         this.productService.getCategoryNumberProducts(5).subscribe(response => {      
          this.number_of_5=response;
         }); 
  }

}
