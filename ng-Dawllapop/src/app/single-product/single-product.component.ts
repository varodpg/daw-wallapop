import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { ProductService } from '../service/product.service';
import { Product, User, Offer } from '../model/product.model';
import {NgbModal, NgbActiveModal} from '@ng-bootstrap/ng-bootstrap';
import { LoginService } from '../login/login.service';
import { OfferService } from '../service/offer.service';

@Component({
  selector: 'app-single-product',
  templateUrl: './single-product.component.html',
  styleUrls: ['./single-product.component.css']
})
export class SingleProductComponent implements OnInit {

  private product: Product;
  private user: User;
  private images_url = "https://localhost:8443/imgs";
  private offer: Offer;

  constructor(private router: Router, private productService: ProductService, activatedRoute: ActivatedRoute,
    private modalService: NgbModal, private loginService: LoginService, private offerService: OfferService, 
    public activeModal: NgbActiveModal) { 
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

  openOffer(content){
    this.offer = new Offer();
    this.modalService.open(content);    
  }

  addOffer(){
    this.offer.userId = this.loginService.user.id;
    this.offer.productId = this.product.id;
    this.offerService.addOffer(this.offer.price, this.offer.userId, this.offer.productId, this.offer.message).subscribe();
    this.activeModal.dismiss();      
  }

}
