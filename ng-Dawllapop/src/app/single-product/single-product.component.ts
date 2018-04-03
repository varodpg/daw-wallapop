import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { ProductService } from '../service/product.service';
import { Product } from '../model/product.model';

@Component({
  selector: 'app-single-product',
  templateUrl: './single-product.component.html',
  styleUrls: ['./single-product.component.css']
})
export class SingleProductComponent implements OnInit {

  private product: Product;

  constructor(private router: Router, private productService: ProductService, activatedRoute: ActivatedRoute) { 
    let id = activatedRoute.snapshot.params['id'];
    this.productService.getSingleProduct(id).subscribe(data => {
      this.product = data;
    });
   }

  ngOnInit() {
  }

}
