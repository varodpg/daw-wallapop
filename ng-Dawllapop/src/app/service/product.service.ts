import { Injectable } from "@angular/core";
import { Product, User, Category } from '../model/product.model';
import { HttpClient } from "@angular/common/http";

const LAST_PRODUCTS_URL = "https://localhost:8443/api/products/"
const GET_SINGLE_PRODUCT_URL = "https://localhost:8443/api/products/"
const ADD_PRODUCT_URL = "https://localhost:8443/api/products/"
const GET_CATEGORY_PRODUCTS = "https://localhost:8443/api/products/category/"
const GET_CATEGORY_PRODUCTS_TOTAL = "https://localhost:8443/api/products/category/"
const SEARCH_PRODUCTS_URL = "https://localhost:8443/api/products/search"
const EDIT_PRODUCT = "https://localhost:8443/api/products"
const DELETE_PRODUCT_URL = "https://localhost:8443/api/products"
const GET_ALL_PRODUCTS_URL = "https://localhost:8443/api/products/all"
const GET_CATEGORIES_URL = "https://localhost:8443/api/category"
const ADD_IMAGE_URL = "https://localhost:8443/api/products/image"

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

    saveProduct(user: Number, product: Product){
        return this.http.put(EDIT_PRODUCT + "/" + user + "/" + product.id, product);
    }

    deleteProduct(id: number){
        return this.http.delete(DELETE_PRODUCT_URL + "/" + id);
    }

    getAllproducts(){
        return this.http.get<Product[]>(GET_ALL_PRODUCTS_URL);
    }

    getCategories(){
        return this.http.get<Category[]>(GET_CATEGORIES_URL);
    }

    addProductImage(productId: number, fileToUpload: File) {        
        const formData: FormData = new FormData();
        formData.append('file', fileToUpload, fileToUpload.name);
        return this.http.post(ADD_IMAGE_URL + "/" + productId, formData);
    }
}