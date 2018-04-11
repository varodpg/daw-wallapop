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
  private images_url = "https://localhost:8443/imgs";

  constructor(private router: Router, private productService: ProductService, activatedRoute: ActivatedRoute) { 
    let id = activatedRoute.snapshot.params['id'];
    this.productService.getSingleProduct(id).subscribe(data => {
      this.product = data;
      this.user = data['user'];
    });    
  }




  ngOnInit() {
  }

    editProduct(){
    this.router.navigate(['/editProduct',this.user.id,this.product.id]);
  }

  save(){
    this.productService.saveProduct(this.user,this.product);
  }

}
