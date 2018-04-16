import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { ProductService } from '../service/product.service';
import { Product, User } from '../model/product.model';

@Component({
  selector: 'app-edit-single-product',
  templateUrl: './edit-single-product.component.html',
  styleUrls: ['./edit-single-product.component.css']
})
export class EditSingleProductComponent implements OnInit {

  private product: Product;
  private user: User;
  private url_imgs = "https://localhost:8443/imgs";
  private added: boolean;
  private categoryId: string;
  private category: string;

  constructor(private router: Router, private productService: ProductService, activatedRoute: ActivatedRoute) { 
    let id = activatedRoute.snapshot.params['id'];
    this.productService.getSingleProduct(id).subscribe(data => {
      this.product = data;
      this.categoryId = data.category;
      this.user = data['user'];
      switch(this.categoryId){
        case "1":
          this.category = "Electrónica e Informática"; 
          break;
      }
    });    
  }


  ngOnInit() {
  }


  save(){
    this.productService.saveProduct(this.product);
  }

}
