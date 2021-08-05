import { People } from './../../models/People';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  nameInput: string = "";
  emailInput: string = "";

  fakePeopleList: Array<any> = [
    {"id": 1, "name": "Jack Frank", "email": "jf@gmail.com", "address1": "30 JackFrank St", 
    "address2": "", "city" : "Frankville", "state": "Alabama", "zip": "09823", 
    "phone": "902-232-1231", "title": "Employee"},
    {"id": 2, "name": "Guido Murt", "email": "gm@gmail.com", "address1": "22 Street St", 
    "address2": "", "city" : "Chicago", "state": "Illinois", "zip": "123123", 
    "phone": "232-542-1231", "title": "Employee"}
  ];

  searchByName(){
    alert(this.nameInput);
  }

  searchByEmail(){
    alert(this.emailInput);
  }
  
}
