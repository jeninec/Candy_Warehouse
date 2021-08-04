import { Injectable } from '@angular/core';
//Import model here
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginServService {

  currentUser: model;

  private postHeaders = new HttpHeaders({'Content-type':'application/json'});

  constructor(private http: HttpClient) { }

  login(user: model): Observable<model> {
    return this.http.post<model>('http://localhost:7000/login', user, { headers: this.postHeaders });
  }
}
