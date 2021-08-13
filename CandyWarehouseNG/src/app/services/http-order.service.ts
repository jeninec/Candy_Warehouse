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
    return this.http.post<Order>('http://localhost:8080/orders', order, { headers: this.postHeaders });
  }
  updateOrder(order : Order) : Observable<Order> { 
    return this.http.put<Order>(`http://localhost:8080/orders/${order.id}` , order, { headers: this.postHeaders });
  }




}
