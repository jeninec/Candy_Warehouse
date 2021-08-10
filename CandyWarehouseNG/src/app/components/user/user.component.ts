import { Component, OnInit } from '@angular/core';
import { HttpPeopleService } from 'src/app/services/http-people.service';
import { PeopleService } from 'src/app/services/people.service'
import { People } from 'src/app/models/People';
import { ActivatedRoute, Router } from '@angular/router'

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  constructor(private route: ActivatedRoute, private router: Router, private peopleHttp: HttpPeopleService, private peopleServ: PeopleService) { }

  ngOnInit(): void {
    if(localStorage.getItem("title") == "admin" || localStorage.getItem("title") == "manager" || localStorage.getItem("title") == "employee" || localStorage.getItem("title") == "buyer"){

      this.displayInfo();
    }
    else {
      this.router.navigateByUrl("/home");
    }
  }

  showInfo: boolean = true;
  editInfo: boolean = false;

  //uid: string = localStorage.getItem("id").toString();
  user: People = new People(0, "", "", "", "", "", "", "" , "", "", "", "", []);

  displayInfo() {
    this.showInfo = true;
    this.editInfo = false;

  

    var uid = this.route.snapshot.paramMap.get('id');
    var til = this.route.snapshot.paramMap.get('title');
    var email = this.route.snapshot.paramMap.get('email');
    console.log(uid);
    console.log(til);
    console.log(email);
    
      if(uid == null){
        uid = "4";
      }

    this.peopleHttp.getPeople(uid).subscribe(
    
      (response) => {
        console.log(response);
        this.peopleServ.people = response;
        this.user = response;
      }
    )

  }

  changeInfo() {
    this.showInfo = false;
    this.editInfo = true;
    
  }
    
  updateEmp() {
      console.log(this.peopleServ.people);

    this.peopleHttp.updatePeople(this.peopleServ.people).subscribe(
      (response) => {
        alert("Movie Successfully Updated");
        this.router.navigateByUrl("/movies");
      }
    );
  }


}
