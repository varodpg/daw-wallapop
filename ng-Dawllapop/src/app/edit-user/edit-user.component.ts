import { Component, OnInit } from '@angular/core';
import { User } from '../model/product.model';
import { UserService } from '../service/user.service';
import { Router, ActivatedRoute } from '@angular/router';
import { ProductService } from '../service/product.service';
import { LoginService } from '../login/login.service';

@Component({
  selector: 'app-edit-user',
  templateUrl: './edit-user.component.html',
  styleUrls: ['./edit-user.component.css']
})
export class EditUserComponent implements OnInit {

  private user: User;
	private edited = false;

	constructor(private userService: UserService,private router: Router,activatedRoute: ActivatedRoute,private loginService: LoginService) { 

	}

	
  save(){
    this.userService.editUser(this.user).subscribe();
  }


	ngOnInit() {
    this.user = new User();
    if(this.loginService.isLogged){
      this.user = this.loginService.user;
    }
	}
}
