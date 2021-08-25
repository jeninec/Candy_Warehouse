import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { People } from 'src/app/models/People';
import { HttpPeopleService } from 'src/app/services/http-people.service';
import { PeopleService } from 'src/app/services/people.service';


@Component({
  selector: 'app-edit-user',
  templateUrl: './edit-user.component.html',
  styleUrls: ['./edit-user.component.css']
})
export class EditUserComponent implements OnInit {

  constructor(private route: ActivatedRoute, private router: Router, private peopleHttp: HttpPeopleService
    , private peopleServ: PeopleService) { }

  ngOnInit(): void {
    if(localStorage.getItem("title") == "admin"){
      let id = this.route.snapshot.paramMap.get('userid');
      if(id === null){
        id = "0";
      }
      this.peopleHttp.getPeople(id).subscribe(
        (response) => {
          this.peopleServ.people = response;
        }
      )
    } else {
      this.router.navigateByUrl("/home");
    }
  }

  getPeople() {
    return this.peopleServ.people;
  }

  updateUser(){
    console.log(this.peopleServ.people);
    this.peopleHttp.updatePeople(this.peopleServ.people).subscribe(
      (response) => {
        console.log("User Successfully Updated");
        this.router.navigateByUrl("/admin");
      }
    );
  }

  deleteUser(){
    console.log(this.peopleServ.people);
    this.peopleHttp.deletePeople(this.peopleServ.people.id).subscribe(
      (response) => {
        console.log("User Successfully Deleted");
        this.router.navigateByUrl("/admin");
      }
    );
  }

}
