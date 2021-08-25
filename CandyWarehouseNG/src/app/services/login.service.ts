import { Injectable,} from '@angular/core';
import { People } from 'src/app/models/People';
import { HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) { }

  getUser(param: string): Observable<People> {
    console.log(param);

    return this.http.get<People>(`http://localhost:8080/people/search-email?email=` + param, {responseType: "json"} );
  }
}


