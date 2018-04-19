import { Component, OnInit, Input } from '@angular/core';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import { UserService } from '../service/user.service';
import { User } from '../model/product.model';
import { Router, ActivatedRoute } from '@angular/router';
import { LoginService} from '../login/login.service'
import { LoginComponent} from '../login/login.component'
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  closeResult: string;
  private registerUser: User;
  private added = false;
  private url = "https://localhost:8443/imgs";
  private userLogin : string;
  private event : any;
  private pass : string;

  constructor(public activeModal: NgbActiveModal, private modalService: NgbModal, private userService: UserService,private router: Router, 
    private loginService: LoginService ) { }

  ngOnInit() {
    this.registerUser=new User();
  }

  open(content) {
    this.modalService.open(content).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
  }

  addUser(){
		this.userService.addUser(this.registerUser).subscribe(
      result => this.added = true
      
		);
		
	}
  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return  `with: ${reason}`;
    }
  }
  closeModal(){
    this.activeModal.dismiss();
  }

  logIn(){
    this.loginService.logIn(this.userLogin, this.pass);
    console.log("eeeeeeeeeeeeeeeeeey"+ this.userLogin)
    this.activeModal.dismiss();
  }
  
}
