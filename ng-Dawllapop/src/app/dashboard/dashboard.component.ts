import { Component, OnInit } from '@angular/core';
import { Product, User } from '../model/product.model';
import { LoginService } from '../login/login.service';
import { UserService } from '../service/user.service';
import { Router } from '@angular/router';
import { DashboardService } from '../service/dashboard.service';
import { element } from 'protractor';

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
  private userOffers: any[];
  private friendRequests: any[];

  constructor( private loginService: LoginService, private userService: UserService, private router: Router,
    private dashboardService: DashboardService) { }

  ngOnInit() {        
    this.sellingProducts = [];
    this.soldProducts = [];
    this.userAssessments = [];
    this.buyedProducts = [];
    this.userOffers = [];
    this.friendRequests = [];

    this.userService.getUser(this.loginService.user.id).subscribe(data => {      
      this.user = data;      
    });    

    this.dashboardService.getSellignProducts(this.loginService.user.id).subscribe(data => {
      data.forEach(element => {        
        this.sellingProducts.push(element);
      });
    });

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

    this.userService.getUserOffers(this.loginService.user.id).subscribe(data => {
      data.forEach(
        element => {
          this.userOffers.push(element);
        }
      );
    });

    this.userService.getUserFriendRequests().subscribe(data => {
      data.forEach(element => {
        this.friendRequests.push(element);
      });
    });
  }

}
