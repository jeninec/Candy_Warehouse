import { Component, OnInit } from '@angular/core';
import { HttpAllCandyService } from 'src/app/services/http-all-candy.service';
import { HttpOrderService } from 'src/app/services/http-order.service';
import { HttpPeopleService } from 'src/app/services/http-people.service';
import { Item } from 'src/app/models/Item';
import { Order } from 'src/app/models/Order';
import { People } from 'src/app/models/People';
import { Router } from '@angular/router';

@Component({
  selector: 'app-manager',
  templateUrl: './manager.component.html',
  styleUrls: ['./manager.component.css']
})
export class ManagerComponent implements OnInit {

  constructor(private router: Router, private peopleHttp: HttpPeopleService ,private itemHttp: HttpAllCandyService, private orderHttp: HttpOrderService) { }

  ngOnInit(): void {
    if(localStorage.getItem("title") == "admin" || localStorage.getItem("title") == "manager"){
      this.displayItems();
    } else{
      this.router.navigateByUrl("/home");
    }
  }

  showEmps: boolean = false;
  showItems: boolean = true;
  showOrders: boolean = false;
  showAddMenu: boolean = false;
  selectOption: string = "Show Employees";

  itemList: Item[] = [];
  orderList: Order[] = [];
  employeeList: People[] = [];

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


  displayEmployees() {
    this.showEmps = true;
    this.showItems = false;
    this.showOrders = false;

    if(this.showAddMenu === true){
      this.showAddMenu = false;
    }

    this.peopleHttp.getAllEmployees().subscribe(
      (response) => {
        console.log(response);
        this.employeeList = response;
      }
    );
  }

  displayItems(){
    this.showItems = true;
    this.showEmps = false;
    this.showOrders = false;

    this.itemHttp.getAllCandy().subscribe(
      (response) => {
        console.log(response);
        this.itemList = response;
      }
    );
  }

  displayOrders(){
    this.showOrders = true;
    this.showItems = false;
    this.showEmps = false;

    if(this.showAddMenu === true){
      this.showAddMenu = false;
    }

    this.orderHttp.getAllOrders().subscribe(
      (response) => {
        console.log(response);
        this.orderList = response;
      }
    );

  }

  addItemMenu(){
    this.showAddMenu = ! this.showAddMenu;
  }

  itemName: string = "";
  itemCategory: string = "";
  itemPrice: number = 0.00;
  itemQuantity: number = 0;
  itemDescription: string = "";
  itemImgSrc: string = "";
  itemQtyOrdered: number = 0;
  
  submitItem(){
    console.log(this.itemName);
    console.log(this.itemCategory);
    console.log(this.itemPrice);

    this.itemHttp.addCandy(new Item(0, this.itemName, this.itemCategory, this.itemPrice,
      this.itemQuantity, this.itemDescription, this.itemImgSrc)).subscribe(
      (response) => {
        console.log(response);
        this.itemList.push(response);
        this.resetValues();
      },
      (response) => {
        console.log(response);
        console.log("Failed to add Movie.");
      }
    );
    () => {
      this.resetValues();
    }

  }

  resetValues(){
    this.itemName = "";
    this.itemCategory = "";
    this.itemPrice = 0.00;
    this.itemQuantity = 0;
    this.itemDescription = "";
    this.itemImgSrc = "";
    this.itemQtyOrdered = 0;
  }
}
