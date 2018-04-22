import { Component, Input, Output } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from './login.service';
import { NgbActiveModal, NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';
import { User } from '../model/product.model';
import { UserService } from '../service/user.service';

@Component({
  selector: 'login',
  templateUrl: './login.component.html'
})
export class LoginComponent {

  closeResult: string;
  private registerUser: User;
  private added = false;
  private url = "https://localhost:8443/imgs";

  constructor(private modalService: NgbModal,private loginService: LoginService, private userService: UserService,public activeModal: NgbActiveModal, public router:Router) { }
  ngOnInit() {
    this.registerUser=new User();
  }
  logIn(event: any, user: string, pass: string) {
    
    event.preventDefault();

    this.loginService.logIn(user, pass).subscribe(
      u => console.log(u),
      error => alert('Invalid user or password')
      
    );
    this.activeModal.dismiss();
  }

  logOut() {
    this.loginService.logOut().subscribe(
      response => { },
      error => console.log('Error when trying to log out: ' + error)
    );
    this.activeModal.dismiss();
    this.router.navigate(['index']);
  }
  closeModal(){
    this.activeModal.dismiss();
    this.activeModal.close();
  }

    open(content) {
      this.modalService.open(content).result.then((result) => {
        this.closeResult = `Closed with: ${result}`;
      }, (reason) => {
        this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
      });
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
    addUser(){
      this.userService.addUser(this.registerUser).subscribe(
        result => this.added = true
        
      );
      
    }
  }
  

