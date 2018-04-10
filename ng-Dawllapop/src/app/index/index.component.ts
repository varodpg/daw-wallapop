import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProductService } from '../service/product.service';
import { Product } from '../model/product.model';

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css']
})
export class IndexComponent implements OnInit {
  
  products: Product[];
  private search: string;

  constructor(private router: Router, private productService: ProductService) { }

  ngOnInit() {   
    this.productService.getLastProducts().subscribe(data => {      
      this.products = [];
      data['content'].forEach(element => {        
        this.products.push(element);
      });
      
    });        
  }

}