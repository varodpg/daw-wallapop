import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { User } from "../model/product.model";

const GET_USER_URL = "https://localhost:8443/api/users"
@Injectable()
export class UserService {
    constructor(private http: HttpClient) {}

    getUser(id: number){
        return this.http.get<User>(GET_USER_URL + "/" + id);			
    }

    addUser(user: User){
        return this.http.post(GET_USER_URL,user);
    }


}