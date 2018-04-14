import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { User, Product } from "../model/product.model";

const DASHBOARD_BASE_URL = "https://localhost:8443/api/dashboard/"
const SELLING_BASE_URL = "selling"
const SOLD_BASE_URL = "sold"
const ASSESSMENT_BASE_URL = "assessment"
const BUYED_BASE_URL = "buyed"

@Injectable()
export class DashboardService {
    constructor(private http: HttpClient) {}

    getSellignProducts(id: number){
        return this.http.get<Product[]>(DASHBOARD_BASE_URL + "/" + id + "/" + SELLING_BASE_URL);			
    }

    getSoldProducts(id: number){
        return this.http.get<Product[]>(DASHBOARD_BASE_URL + "/" + id + "/" + SOLD_BASE_URL);
    }

    getBuyedProducts(id: number){
        return this.http.get<Product[]>(DASHBOARD_BASE_URL + "/" + id + "/" + BUYED_BASE_URL);
    }

    getUserAssessments(id: number){
        return this.http.get<Product[]>(DASHBOARD_BASE_URL + "/" + id + "/" + ASSESSMENT_BASE_URL);
    }
}