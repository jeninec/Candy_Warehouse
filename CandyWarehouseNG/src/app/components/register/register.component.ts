import { Component, OnInit } from '@angular/core';
import { HttpPeopleService } from 'src/app/services/http-people.service';
import { PeopleService } from 'src/app/services/people.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private router: Router, private peopleHttp: HttpPeopleService, private peopleServ: PeopleService) { }

  ngOnInit(): void {
  }

  id: number = 0;
  firstName: string = "";
  lastName: string = "";
  email: string = "";
  password: string = "";
  address1: string = "";
  address2: string = "";
  city: string = "";
  state: string = "";
  zip: string = "";
  phone: string = "";
  title: string = "buyer";
  orderId: Array<any> = [];

  json: any = {};

  createAccount(){
    this.json = 
    {
      "firstname" : this.firstName,
      "lastname" : this.lastName,
      "email" : this.email,
      "password" : this.password,
      "address1" : this.address1,
      "address2" : this.address2,
      "city" : this.city,
      "state" : this.state,
      "zip" : this.zip,
      "phone" : this.phone,
      "title" : this.title,
      "orderId" : this.orderId
    }

    console.log(this.json);
    this.peopleHttp.addPeople(this.json).subscribe(
      (response) => {
        console.log("User Successfully Created");
        console.log(response);
        this.router.navigateByUrl("/login");
      }
    );
  }

}
