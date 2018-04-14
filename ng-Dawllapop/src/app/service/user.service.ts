import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { User } from "../model/product.model";

const GET_USER_URL = "https://localhost:8443/api/users"
const SEARCH_USERS_URL = "https://localhost:8443/api/users/search"
const USER_OFFERS_URL = "https://localhost:8443/api/offers/user"
const USER_FRIEND_REQUESTS_URL = "https://localhost:8443/api/friendRequest/"

@Injectable()
export class UserService {
    constructor(private http: HttpClient) {}

    getUser(id: number){
        return this.http.get<User>(GET_USER_URL + "/" + id);			
    }
    
    searchUsers(search: string){
        return this.http.get<User[]>(SEARCH_USERS_URL + "/" + search);
    }
    
    addUser(user: User) {
		return this.http.post(GET_USER_URL, user);		
    }
    
    getUserOffers(id: number){
        return this.http.get<any[]>(USER_OFFERS_URL + "/" + id);
    }

    getUserFriendRequests(){
        return this.http.get<any[]>(USER_FRIEND_REQUESTS_URL);
    }
}