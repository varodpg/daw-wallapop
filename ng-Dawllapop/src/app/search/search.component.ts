import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductService } from '../service/product.service';
import { UserService } from '../service/user.service';
import { User, Product } from '../model/product.model';
import { element } from 'protractor';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  private searchUsers: User[];
  private searchProducts: Product[];

  constructor(private activatedRoute: ActivatedRoute,  private productService: ProductService, 
    private router: Router, private userService: UserService) { }

  ngOnInit() {

    this.searchUsers = [];
    this.searchProducts = [];

    let search = this.activatedRoute.snapshot.params['search'];
    this.userService.searchUsers(search).subscribe(data => {
      if(data != null){
        data.forEach(element => {        
          this.searchUsers.push(element);
        });
      }
    }, error => {
      //console.log("No se encuentran usuarios");
    });

    this.productService.searchProducts(search).subscribe(data => {
      if(data != null){
        data.forEach(element => {
          this.searchProducts.push(element);
        });
      }
    },error => {
      //console.log("No se encuentran productos");
    }
  );
  }

}
