import { Component, OnInit } from '@angular/core';
import { Product, User } from '../model/product.model';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  private product: Product;
  private user: User;
  constructor() { }

  ngOnInit() {
  }

}
