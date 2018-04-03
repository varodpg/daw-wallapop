import { Injectable } from "@angular/core";
import { Product } from "../model/product.model";
import { HttpClient } from "@angular/common/http";

const LAST_PRODUCTS_URL = "https://localhost:8443/api/products/user/2"
const GET_SINGLE_PRODUCT_URL = "https://localhost:8443/api/products/"

@Injectable()
export class ProductService {
    constructor(private http: HttpClient) {}

    getLastProducts(){
        return this.http.get<Product[]>(LAST_PRODUCTS_URL);			
    }

    getSingleProduct(id: number | string){
        return this.http.get<Product>(GET_SINGLE_PRODUCT_URL + id);
    }
}