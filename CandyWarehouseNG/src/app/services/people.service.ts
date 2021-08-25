import { Injectable } from '@angular/core';
import { People } from '../models/People';

@Injectable({
  providedIn: 'root'
})
export class PeopleService {

  constructor() { }

  people: People = new People(0, "", "", "", "", "", "", "" , "", "", "", "", []);

}
