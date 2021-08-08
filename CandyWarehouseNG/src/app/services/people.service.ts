import { Injectable } from '@angular/core';
import { People } from '../models/People';

@Injectable({
  providedIn: 'root'
})
export class PeopleService {

  constructor() { }

<<<<<<< HEAD
  people: People = new People(0, "", "", "", "", "", "", "" , "", "", "", "", []);
=======
  people: People = new People(0, "", "", "", "", "", "", "" , "", "", "", "", [] );
>>>>>>> 91b72579fc1a94c303c99c66220a1fba72bd4618
}
