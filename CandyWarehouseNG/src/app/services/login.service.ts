import { Injectable } from '@angular/core';
import { People } from 'src/app/models/People';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  //currentUser: People = {};

  private postHeaders = new HttpHeaders({'Content-type':'application/json'});

  constructor(private http: HttpClient) { }

  login(user: People): Observable<People> {
    return this.http.post<People>('http://localhost:4200/login', user, { headers: this.postHeaders });
  }
  
}
