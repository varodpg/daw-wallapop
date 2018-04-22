import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { ProductService } from '../service/product.service';
import { Product, User } from '../model/product.model';
import { LoginService } from '../login/login.service';


@Component({
  selector: 'app-edit-single-product',
  templateUrl: './edit-single-product.component.html',
  styleUrls: ['./edit-single-product.component.css']
})
export class EditSingleProductComponent implements OnInit {

  private product: Product;
  private user: User;
  private category: String;


  constructor(private router: Router, private loginService: LoginService, private productService: ProductService, private activatedRoute: ActivatedRoute) {    
  }


  ngOnInit() {
    this.product = new Product();
    if(this.loginService.isLogged){

      let id = this.activatedRoute.snapshot.params['id'];
      this.user = this.loginService.user;

      this.productService.getSingleProduct(id).subscribe(data =>{
        this.product = data;
      });
    }
  }


  save(){
    this.productService.saveProduct(this.user.id,this.product).subscribe();
  }

}
