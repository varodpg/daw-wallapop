import { Injectable } from "@angular/core";
import { Product, User } from '../model/product.model';
import { HttpClient } from "@angular/common/http";

const LAST_PRODUCTS_URL = "https://localhost:8443/api/products/"
const GET_SINGLE_PRODUCT_URL = "https://localhost:8443/api/products/"
const ADD_PRODUCT_URL = "https://localhost:8443/api/products/"
const GET_CATEGORY_PRODUCTS = "https://localhost:8443/api/products/category/"
const GET_CATEGORY_PRODUCTS_TOTAL = "https://localhost:8443/api/products/category/"
const SEARCH_PRODUCTS_URL = "https://localhost:8443/api/products/search"
const EDIT_PRODUCT = "https://localhost:8443/api/products/"

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

    getCategoryNumberProducts(id: number | string){
        return this.http.get<number>(GET_CATEGORY_PRODUCTS + id + "/total");		
    }

    searchProducts(search: String){
        return this.http.get<Product[]>(SEARCH_PRODUCTS_URL + "/" + search);
    }

    saveProduct(product: Product){
        return this.http.post(ADD_PRODUCT_URL, product);
    }
}