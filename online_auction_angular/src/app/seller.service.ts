import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Seller } from './seller';

@Injectable({
  providedIn: 'root'
})
export class SellerService {

  private baseURL="http://localhost:8091/rest/onlineauction/seller";
  private baseURL1="http://localhost:8091/rest/onlineauction/seller/product"
  private baseURL2="http://localhost:8091/rest/onlineauction/seller/product/bid"
  constructor(private httpClient: HttpClient) { }

  getSellerList(): Observable<Seller[]>{
    return this.httpClient.get<Seller[]>(`${this.baseURL}`);
  }

  insertSeller(seller: Seller): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`, seller)
  }

  getSellerById(sellerID: number): Observable<Seller>{
    return this.httpClient.get<Seller>(`${this.baseURL}/${sellerID}`);
  }

  updateProduct(sellerID: number, seller : Seller): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${sellerID}`,seller)
  }
  deleteProduct(sellerID: number, seller : Seller): Observable<Object>{
    return this.httpClient.put(`${this.baseURL1}/${sellerID}`,seller)
  }

  deleteSeller(sellerID: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${sellerID}`);
  }
  updateBidder(sellerID: number, seller : Seller): Observable<Object>{
    return this.httpClient.put(`${this.baseURL2}/${sellerID}`,seller)
  }
}
