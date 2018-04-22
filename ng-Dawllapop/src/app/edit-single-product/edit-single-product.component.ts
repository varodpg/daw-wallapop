import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { ProductService } from '../service/product.service';
import { Product, User, Category } from '../model/product.model';
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
  private categories : Category[];
	private categoryName: string = "";


  constructor(private router: Router, private loginService: LoginService, private productService: ProductService, private activatedRoute: ActivatedRoute) {    
  }


  ngOnInit() {
    this.product = new Product();
    this.product.category = new Category();
    this.product.specifications = [];
    if(this.loginService.isLogged){

      let id = this.activatedRoute.snapshot.params['id'];
      this.user = this.loginService.user;
      this.categories = [];
      this.productService.getCategories().subscribe(data => {
        data.forEach(
          element => this.categories.push(element) 
        );
      });
      this.productService.getSingleProduct(id).subscribe(data =>{
        this.product = data;      
        this.categoryName = this.product.category.name;
      });      
    }
  }

  addSpecificationRow() {
		let empty_elem : string[];
		empty_elem = [];		
		this.product.specifications.push(empty_elem);
	}
	
	deleteSpecificationRow() {
		this.product.specifications.splice(this.product.specifications.length - 1, 1);
	}


  save(){
    this.categories.forEach(category => {			
			if(category.name == this.categoryName){				
				this.product.category = category;				
			}
		});
    this.productService.saveProduct(this.user.id,this.product).subscribe();
  }

}
