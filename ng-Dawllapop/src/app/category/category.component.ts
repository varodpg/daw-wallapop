import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { ProductService } from '../service/product.service';
import { Product } from '../model/product.model';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {

  products: Product[];
  products1: Product[];
  products2: Product[];
  products3: Product[];
  products4: Product[];
  products5: Product[];
  number_of_1: number;
  number_of_2: number;
  number_of_3: number;
  number_of_4: number;
  number_of_5: number;

  constructor(private router: Router, private productService: ProductService, activatedRoute: ActivatedRoute) { 
    let id = activatedRoute.snapshot.params['id'];

    console.log(id);

    this.productService.getCategoryProducts(id).subscribe(response => {      
        this.products = [];

        response.forEach(element => {
          this.products.push(element);
        });
        console.log(this.products);    
    });    

  }

 ngOnInit() {
        this.productService.getCategoryProducts(1).subscribe(response => {      
          this.number_of_1=response.length;
         }); 
         
         this.productService.getCategoryProducts(2).subscribe(response => {      
          this.number_of_2=response.length;
         }); 

         this.productService.getCategoryProducts(3).subscribe(response => {      
          this.number_of_3=response.length;

         }); 

         this.productService.getCategoryProducts(4).subscribe(response => {      
          this.number_of_4=response.length;

         }); 

         this.productService.getCategoryProducts(5).subscribe(response => {      
          this.number_of_5=response.length;
         }); 
  }

}
