import { Component, OnInit } from '@angular/core';
import { Product } from '../model/product.model';
import { ProductService } from '../service/product.service';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {

  addProduct(product: Product){
    this.productService.addProduct(product);
  }

  constructor(private productService: ProductService) { }

  ngOnInit() {
  }

}

