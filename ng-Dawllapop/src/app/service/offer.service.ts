import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";

const ADD_OFFER_URL = "https://localhost:8443/api/offers/"

@Injectable()
export class OfferService {
    constructor(private http: HttpClient) {}

    public addOffer(price: number, userId: number, productId: number, message: string){
        return this.http.post(ADD_OFFER_URL, {
            price: price, 
            userId: userId,
            productId: productId,
            message: message
        });
    }
}