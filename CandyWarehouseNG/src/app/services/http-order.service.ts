import { Injectable } from '@angular/core';
import {HttpClient,HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Order } from '../models/Order'; 
import { identifierModuleUrl } from '@angular/compiler';

@Injectable({
  providedIn: 'root'
})
export class HttpOrderService {

  constructor(private http : HttpClient) {}

  private postHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
  getAllOrders(): Observable<Order[]> {

    return this.http.get<Order[]> ('http://localhost:8080/orders');
  }

  addOrder(order : Order) : Observable<Order> {
    return this.http.post<Order>('http://localhost:8080/orders',Order,{ headers: this.postHeaders });
  }
  deleteOrder(order:Order) : Observable<Order> { 
    // may be we shold to add Id
    return this.http.put<Order>('http://localhost:/orders'+  Order ,Order,{ headers: this.postHeaders });
  }

}
