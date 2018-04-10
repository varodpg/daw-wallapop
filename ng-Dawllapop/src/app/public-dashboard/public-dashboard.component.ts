import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductService } from '../service/product.service';
import { UserService } from '../service/user.service';
import { User, Product } from '../model/product.model';
import { DashboardService } from '../service/dashboard.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-public-dashboard',
  templateUrl: './public-dashboard.component.html',
  styleUrls: ['./public-dashboard.component.css']
})
export class PublicDashboardComponent implements OnInit {

  private user: User;
  private images_url = "https://localhost:8443/imgs";
  private sellingProducts: Product[];
  private soldProducts: Product[];
  private userAssessments: any[];

  constructor(private activatedRoute: ActivatedRoute, private productService: ProductService, 
    private router: Router, private userService: UserService, private dashboardService: DashboardService,
    private modalService: NgbModal) {     
  }

  ngOnInit() {    
    this.sellingProducts = [];
    this.soldProducts = [];
    this.userAssessments = [];

    this.userService.getUser(this.activatedRoute.snapshot.params['id']).subscribe(data => {      
      this.user = data;      
    });    

    this.dashboardService.getSellignProducts(this.activatedRoute.snapshot.params['id']).subscribe(data => {
      data.forEach(element => {        
        this.sellingProducts.push(element);
      });
    });

    this.dashboardService.getUserAssessments(this.activatedRoute.snapshot.params['id']).subscribe(data => {
      data.forEach(element => {        
        this.userAssessments.push(element);
      });
    });   
  }

  openModal(content) {    
    this.modalService.open(content);
  }

}
