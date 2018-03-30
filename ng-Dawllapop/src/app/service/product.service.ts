import { Injectable } from "@angular/core";
import { Product } from "../model/product.model";
import { HttpClient } from "@angular/common/http";

const BASE_URL = "https://localhost:8443/api/products/user/2"

@Injectable()
export class ProductService {
    constructor(private http: HttpClient) {}

    getLastProducts(){
        return this.http.get<Product[]>(BASE_URL);			
    }
}