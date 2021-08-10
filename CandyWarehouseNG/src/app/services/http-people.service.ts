import { People } from './../models/People';
import { Injectable } from '@angular/core';
import { Observable, ObservedValuesFromArray } from 'rxjs';
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

  getPeople(id: string): Observable<People>{
    return this.http.get<People>('http://localhost:8080/people/' + id);
  }

  getPersonByEmail(email: string): Observable<People>{
    return this.http.get<People>('http://localhost:8080/people/search-email?email=' + email);
  }

  getAllEmployees(): Observable<People[]>{
    return this.http.get<People[]>('http://localhost:8080/people/search-title?title=employee');
  }

  updatePeople(people: People): Observable<People> {
    return this.http.put<People>('http://localhost:8080/people/' + people.id, people, { headers: this.postHeaders });
  }

  deletePeople(id: number): Observable<boolean>{
    return this.http.delete<boolean>('http://localhost:8080/people/' + id);
  }

}