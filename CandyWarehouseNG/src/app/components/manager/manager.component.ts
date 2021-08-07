import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-manager',
  templateUrl: './manager.component.html',
  styleUrls: ['./manager.component.css']
})
export class ManagerComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  isEmps: boolean = false;
  isItems: boolean = true;
  showAddMenu: boolean = false;
  selectOption: string = "Show Employees";

  fakeItemsList: Array<any> = [
    { "id": 1, "name": "Hershey's", "catagory": "chocolates", "price": 2,
      "qty": 100, "description": "Generic American chocolate"}
  ];

  fakeEmployeeList: Array<any> = [
    {"id": 1, "name": "Jack Frank", "email": "jf@gmail.com", "address1": "30 JackFrank St", 
    "address2": "", "city" : "Frankville", "state": "Alabama", "zip": "09823", 
    "phone": "902-232-1231", "title": "Employee"},
    {"id": 2, "name": "Guido Murt", "email": "gm@gmail.com", "address1": "22 Street St", 
    "address2": "", "city" : "Chicago", "state": "Illinois", "zip": "123123", 
    "phone": "232-542-1231", "title": "Employee"}
  ];


  toggleShow() {
    this.isEmps = ! this.isEmps;
    this.isItems = ! this.isItems;
    if(this.selectOption === "Show Employees"){
      this.selectOption = "Show Items";
    } else {
      this.selectOption = "Show Employees";
    }

    if(this.showAddMenu === true){
      this.showAddMenu = false;
    }
  }

  addItem(){
    this.showAddMenu = ! this.showAddMenu;
  }

  submitItem(){
    alert("Submitting item");
  }

}
