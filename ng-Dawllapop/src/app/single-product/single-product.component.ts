import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { ProductService } from '../service/product.service';
import { Product, User } from '../model/product.model';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-single-product',
  templateUrl: './single-product.component.html',
  styleUrls: ['./single-product.component.css']
})
export class SingleProductComponent implements OnInit {

  private product: Product;
  private user: User;
  private images_url = "https://localhost:8443/imgs";

  constructor(private router: Router, private productService: ProductService, activatedRoute: ActivatedRoute,private modalService: NgbModal) { 
    let id = activatedRoute.snapshot.params['id'];
    this.productService.getSingleProduct(id).subscribe(data => {
      this.product = data;
      this.user = data['user'];
    });    
  }

  openModal(content) {
    this.modalService.open(content);
  }

  openModalLg(content){
    this.modalService.open(content, { size: 'lg' });
  }

  ngOnInit() {
  }

}
