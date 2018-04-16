import { Component, OnInit } from '@angular/core';
import { User } from '../model/product.model';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-edit-user',
  templateUrl: './edit-user.component.html',
  styleUrls: ['./edit-user.component.css']
})
export class EditUserComponent implements OnInit {

  private user: User;
	private edited = false;

	edituser(){
		this.userService.editUser(this.user).subscribe(
			result => this.edited = true
		);
		
	}

	constructor(private userService: UserService) { }

	ngOnInit() {
		this.user=new User();

	}
}
