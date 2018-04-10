import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { ProductService } from '../service/product.service';
import { Product } from '../model/product.model';
import { User } from "../model/product.model";
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-edit-single-product',
  templateUrl: './edit-single-product.component.html',
  styleUrls: ['./edit-single-product.component.css']
})
export class EditSingleProductComponent implements OnInit {

  private product: Product;
  private user: User;

  constructor(private router: Router,private userService: UserService, private productService: ProductService, activatedRoute: ActivatedRoute) { 
    let id = activatedRoute.snapshot.params['id'];
    let userId = activatedRoute.snapshot.params['userId'];
    if(userId){

      this.userService.getUser(userId).subscribe(data => {
        this.user = data;
      });
      
      if(id){
        this.productService.getSingleProduct(id).subscribe(data => {
          this.product = data;
      
        });
      }
    }

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
