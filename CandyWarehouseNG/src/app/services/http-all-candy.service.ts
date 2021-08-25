import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Item } from '../models/Item';


@Injectable({
  providedIn: 'root'
})
export class HttpAllCandyService {

  constructor(private http : HttpClient) { }

  private postHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });

  getAllCandy() :Observable<Item[]>{
    return this.http.get<Item[]>('http://localhost:8080/items');
  }

  addCandy(item: Item): Observable<Item>{
    return this.http.post<Item>('http://localhost:8080/items', item, { headers: this.postHeaders });
  }

  updateCandy(item: Item): Observable<Item>{
    return this.http.put<Item>('http://localhost:8080/items/' + item.id, item, { headers: this.postHeaders });
  }

  getCat(param: string): Observable<Item[]> {
    return this.http.get<Item[]>('http://localhost:8080/items/search-cat/?catagory=' + param, {responseType: "json"} );
  }

  getCandyByName(param: string): Observable<Item> {
    return this.http.get<Item>('http://localhost:8080/items/search/?name=' + param, {responseType: "json"} );
  }
}
