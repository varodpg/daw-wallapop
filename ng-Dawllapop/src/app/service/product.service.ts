import { Injectable } from "@angular/core";
import { Product } from "../model/product.model";
import { User } from "../model/product.model";
import { HttpClient } from "@angular/common/http";
import { Http, Headers, RequestOptions } from '@angular/http';

const LAST_PRODUCTS_URL = "https://localhost:8443/api/products/"
const GET_SINGLE_PRODUCT_URL = "https://localhost:8443/api/products/"
const ADD_PRODUCT_URL = "https://localhost:8443/api/products/"
const GET_CATEGORY_PRODUCTS = "https://localhost:8443/api/products/category/"
<<<<<<< HEAD
const EDIT_PRODUCT = "https://localhost:8443/api/products/"
=======
const GET_CATEGORY_PRODUCTS_TOTAL = "https://localhost:8443/api/products/category/"
const SEARCH_PRODUCTS_URL = "https://localhost:8443/api/products/search"
>>>>>>> c9a24a2bb5f9d9e814f2e03904a277098fdd68c5

@Injectable()
export class ProductService {
    constructor(private http: HttpClient) {}

    getLastProducts(){
        return this.http.get<Product[]>(LAST_PRODUCTS_URL);			
    }

    getSingleProduct(id: number | string){
        return this.http.get<Product>(GET_SINGLE_PRODUCT_URL + id);
    }
    addProduct(product: Product) {
		return this.http.post(ADD_PRODUCT_URL, product);		
    }
    
    getCategoryProducts(id: number | string){
        return this.http.get<Product[]>(GET_CATEGORY_PRODUCTS + id);		
    }

    saveProduct(user: User, product: Product){
        const body = JSON.stringify(product);

        if(product.id && user.id){
            return this.http.put(EDIT_PRODUCT + user.id + "/" + product.id, body);
        }

    }

    searchProducts(search: String){
        return this.http.get<Product[]>(SEARCH_PRODUCTS_URL + "/" + search);
    }
}