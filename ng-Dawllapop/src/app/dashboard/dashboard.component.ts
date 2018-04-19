import { Component, OnInit } from '@angular/core';
import { Product, User } from '../model/product.model';
import { LoginService } from '../login/login.service';
import { UserService } from '../service/user.service';
import { Router } from '@angular/router';
import { DashboardService } from '../service/dashboard.service';
import { element } from 'protractor';
import { ProductService } from '../service/product.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {  
  private user: User;
  private sellingProducts: Product[];
  private soldProducts: Product[];
  private userAssessments: any[];
  private buyedProducts: Product[];
  private productOffers: any[];
  private friendRequests: any[];
  private assessmentText: string;

  constructor( private loginService: LoginService, private userService: UserService, private router: Router,
    private dashboardService: DashboardService, private productService: ProductService) { }

  ngOnInit() {            
    this.soldProducts = [];
    this.userAssessments = [];
    this.buyedProducts = [];
    this.friendRequests = [];

    this.userService.getUser(this.loginService.user.id).subscribe(data => {      
      this.user = data;      
    });    

    this.loadSellingProducts();
    this.loadProductOffers();
    this.loadSoldProducts();

    this.dashboardService.getUserAssessments(this.loginService.user.id).subscribe(data => {
      data.forEach(element => {        
        this.userAssessments.push(element);
      });
    });
    
    this.dashboardService.getBuyedProducts(this.loginService.user.id).subscribe(data => {
      data.forEach(element => {
        this.buyedProducts.push(element);
      })
    });    

    this.userService.getUserFriendRequests().subscribe(data => {
      data.forEach(element => {
        this.friendRequests.push(element);
      });
    });
  }

  deleteProduct(id: number){        
    this.productService.deleteProduct(id).subscribe(
      result => this.loadSellingProducts()
    );
    
  }

  loadSellingProducts(){
    this.sellingProducts = [];
    this.dashboardService.getSellignProducts(this.loginService.user.id).subscribe(data => {
      data.forEach(element => {        
        this.sellingProducts.push(element);
      });
    });
  }

  loadProductOffers(){
    this.productOffers = [];
    this.dashboardService.getUserOffers(this.loginService.user.id).subscribe(data => {
      data.forEach(
        element => {
          this.productOffers.push(element);
        }
      );
    });
  }

  loadSoldProducts(){
    this.soldProducts = [];
    this.dashboardService.getSoldProducts(this.loginService.user.id).subscribe(data => {
      data.forEach(
        element => {
          this.soldProducts.push(element);
        }
      );
    });
  }

  acceptOffer(offerId){
    return this.dashboardService.acceptOffer(this.loginService.user.id, offerId).subscribe(
      response => this.loadProductOffers()
    );    
  }

  refuseOffer(offerId){
    return this.dashboardService.refuseOffer(this.loginService.user.id, offerId).subscribe(
      response => this.loadProductOffers()
    );
  }

  sendAssessment(userId){
    return this.dashboardService.sendAssessment(userId, this.assessmentText).subscribe(response => {
    this.assessmentText = "";
    });
  }
}
