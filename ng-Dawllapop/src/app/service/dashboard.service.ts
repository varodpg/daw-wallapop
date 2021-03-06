import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { User, Product } from "../model/product.model";

const DASHBOARD_BASE_URL = "https://localhost:8443/api/dashboard"
const SELLING_BASE_URL = "selling"
const SOLD_BASE_URL = "sold"
const ASSESSMENT_BASE_URL = "assessment"
const BUYED_BASE_URL = "buyed"
const GET_OFFERS_URL = "withoffers"
const ACCEPT_OFFER_URL = "acceptoffer"
const REFUSE_OFFER_URL = "canceltoffer"
const ADD_ASSESSMENT_URL = "https://localhost:8443/api/assessments/"
const ALL_ASSESSMENT_URL = "https://localhost:8443/api/assessments/all"
const DELETE_ASSESSMENT_URL = "https://localhost:8443/api/assessments/"

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

    getUserOffers(id: number){
        return this.http.get<any[]>(DASHBOARD_BASE_URL + "/" + id + "/" + GET_OFFERS_URL);
    }

    acceptOffer(idUser: number, idOffer: number){
        return this.http.put(DASHBOARD_BASE_URL + "/" + idUser + "/" + ACCEPT_OFFER_URL + "/" + idOffer,null);
    }

    refuseOffer(idUser: number, idOffer: number){
        return this.http.put(DASHBOARD_BASE_URL + "/" + idUser + "/" + REFUSE_OFFER_URL + "/" + idOffer,null);
    }

    sendAssessment(idUser: number, assessmentMessage: string){
        return this.http.post(ADD_ASSESSMENT_URL, {idUser: idUser, message: assessmentMessage, value: 5});
    }

    getAllAssessments(){
        return this.http.get<any[]>(ALL_ASSESSMENT_URL);
    }

    deleteAssessment(id: number){
        return this.http.delete(DELETE_ASSESSMENT_URL + "/" + id);
    }
}