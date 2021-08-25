import { HttpPeopleService } from './../../services/http-people.service';
import { People } from './../../models/People';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  constructor(private router: Router, private peopleHttp: HttpPeopleService) { }

  ngOnInit(): void {
    if(localStorage.getItem("title") == "admin"){
      this.displayAllUsers();
    } else{
      this.router.navigateByUrl("/home");
    }
  }

  userList: People[] = [];
  fnameInput: string = "";
  lnameInput: string = "";
  emailInput: string = "";

  fakePeopleList: Array<any> = [
    {"id": 1, "name": "Jack Frank", "email": "jf@gmail.com", "address1": "30 JackFrank St", 
    "address2": "", "city" : "Frankville", "state": "Alabama", "zip": "09823", 
    "phone": "902-232-1231", "title": "Employee"},
    {"id": 2, "name": "Guido Murt", "email": "gm@gmail.com", "address1": "22 Street St", 
    "address2": "", "city" : "Chicago", "state": "Illinois", "zip": "123123", 
    "phone": "232-542-1231", "title": "Employee"}
  ];

  displayAllUsers() {
    this.peopleHttp.getAllPeople().subscribe(
      (response) => {
        console.log(response);
        this.userList = response;
      }
    );
  }

  searchByName(){    
    if(this.fnameInput == ""){
      this.displayAllUsers();
    } else {
      this.peopleHttp.getPersonByName(this.fnameInput, this.lnameInput).subscribe(
        (response) => {
          console.log(response);
          this.userList = [];
          this.userList.push(response);
        }
      );
    }
  }

  searchByEmail(){
    if(this.emailInput == ""){
      this.displayAllUsers();
    } else {
      this.peopleHttp.getPersonByEmail(this.emailInput).subscribe(
        (response) => {
          console.log(response);
          this.userList = [];
          this.userList.push(response);
        }
      );
    }
  }
  
}
