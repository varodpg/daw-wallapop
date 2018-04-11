import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { User } from "../model/product.model";

const GET_USER_URL = "https://localhost:8443/api/users"
const SEARCH_USERS_URL = "https://localhost:8443/api/users/search"

@Injectable()
export class UserService {
    constructor(private http: HttpClient) {}

    getUser(id: number){
        return this.http.get<User>(GET_USER_URL + "/" + id);			
    }
    
    searchUsers(search: string){
        return this.http.get<User[]>(SEARCH_USERS_URL + "/" + search);
    }
}