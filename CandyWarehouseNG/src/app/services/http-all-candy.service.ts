import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Item } from '../models/Item';


@Injectable({
  providedIn: 'root'
})
export class HttpAllCandyService {

  constructor(private http : HttpClient) { }

  getAllCandy() :Observable<Item[]>{
    return this.http.get<Item[]>('http://localhost:8080/items');
  }
}
