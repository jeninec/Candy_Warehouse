import { People } from './../models/People';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {HttpClient,HttpHeaders} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class HttpPeopleService {

  constructor(private http : HttpClient) { }

  private postHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });

  getAllPeople(): Observable<People[]>{
    return this.http.get<People[]>('http://localhost:8080/people');
  }
}