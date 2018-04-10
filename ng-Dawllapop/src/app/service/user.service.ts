import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { User } from "../model/product.model";

const GET_USER_URL = "https://localhost:8443/api/users"
<<<<<<< HEAD
=======
const SEARCH_USERS_URL = "https://localhost:8443/api/users/search"

>>>>>>> c9a24a2bb5f9d9e814f2e03904a277098fdd68c5
@Injectable()
export class UserService {
    constructor(private http: HttpClient) {}

    getUser(id: number){
        return this.http.get<User>(GET_USER_URL + "/" + id);			
    }

<<<<<<< HEAD
    addUser(user: User){
        return this.http.post(GET_USER_URL,user);
    }


=======
    searchUsers(search: string){
        return this.http.get<User[]>(SEARCH_USERS_URL + "/" + search);
    }
>>>>>>> c9a24a2bb5f9d9e814f2e03904a277098fdd68c5
}