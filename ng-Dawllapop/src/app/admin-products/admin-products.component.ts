import { Component, OnInit } from '@angular/core';
import { ProductService } from '../service/product.service';
import { Product } from '../model/product.model';
import { element } from 'protractor';

@Component({
  selector: 'app-admin-products',
  templateUrl: './admin-products.component.html',
  styleUrls: ['./admin-products.component.css']
})
export class AdminProductsComponent implements OnInit {

  private products: Product[];

  constructor(private productService: ProductService) { }

  ngOnInit() {
    this.products = [];
    this.productService.getAllproducts().subscribe(data => {
      data.forEach(
        element => this.products.push(element)
      );
    });
  }

}
