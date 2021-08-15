import { Component, OnInit } from '@angular/core';
import { HttpAllCandyService } from 'src/app/services/http-all-candy.service';
import { Item } from 'src/app/models/Item';
import { HttpOrderService } from 'src/app/services/http-order.service';
import { HttpPeopleService } from 'src/app/services/http-people.service';
import { PeopleService } from 'src/app/services/people.service'
import { People } from 'src/app/models/People';
import { Order } from 'src/app/models/Order';

@Component({
  selector: 'app-inventory',
  templateUrl: './inventory.component.html',
  styleUrls: ['./inventory.component.css']
})
export class InventoryComponent implements OnInit {

  constructor(private allCandy : HttpAllCandyService,  private peopleHttp: HttpPeopleService, private newOrder : HttpOrderService, private peopleServ: PeopleService) { }

  ngOnInit(): void {
    this.getAllCandy();
    try {
      let login = localStorage.getItem('email');
      
      if(login != null){
        this.sw = false;
        this.sw2 = true;
      }
    } catch( e) {
    // conversion fails
    console.error( e ) 
    } 

    try {
      this.orderList = JSON.parse(localStorage.getItem('cart') || '[]');
      this.qtyO = JSON.parse(localStorage.getItem('qtyO') || '[]');
} catch( e) {
    // conversion fails
   console.error( e ) 
} 
  }


  
  itemList: Item[] = [];
  itemList2: Item[] = [];
  orderList: Item[] =[];
  itemTotals: number[] = [];
  user: People = new People(0, "", "", "", "", "", "", "" , "", "", "", "", []);
  qtyO: number[] = [];

  value: number[] = [];
  total = 0;

  display = false;
  display2 = true;
  display3 = false;
  display4 = false;
  display5 = true;
  show: boolean[] = [];
  sw = true;
  sw2 = false;
  sw3 = true;
  sw4 = false;
  sh = 5.75;
  tbt = 0;
  tax = 0;
  newtotal = 0;
  bo: Order = new Order(0,0,"","",false,[],[]);
  per: People = new People(0, "", "", "", "", "", "", "" , "", "", "", "", []);

  options = '';
  
  onPress(cat: any) {
    this.display = true;
    this.display2 = false;
    this.display3 = false;
    this.display4 = false;
    this.display5 = false;


    this.allCandy.getCat(cat).subscribe(
      (response) => {
        this.itemList2 = response;
        for (let index = 0; index < this.itemList2.length; index++) {
          this.value[index] = 0;
        }
        for (let index = 0; index < this.itemList2.length; index++) {
          this.show[index] = false;
        }
      }
    );
  }
  onPress2() {
    this.display = false;
    this.display2 = true;
    this.display3 = false;
    this.display4 = false;
    this.display5 = false;
  }

  onPress3() {
  
    this.display = false;
    this.display2 = false;
    this.display3 = false;
    this.display4 = true;
    this.display5 = false;
    this.displayInfo();
  }


  submitItem(name: string, num: number, trig: boolean){
    this.allCandy.getCandyByName(name).subscribe(
      (response) => {
        this.qtyO.push(this.value[num]);
        this.orderList.push(response);
        let ol = JSON.stringify(this.orderList);
        let qo = JSON.stringify(this.qtyO);
        localStorage.setItem('cart', ol);
        localStorage.setItem('qtyO', qo);
        this.show[num] = trig;
        console.log(this.qtyO);
        console.log(this.orderList);




        window.setTimeout(()=>{
          this.show[num] = false;
       }, 1500);
      }
    )

  }

  compute(){
    
    this.total = 0;
    this.itemTotals = [];


    for (let index = 0; index < this.orderList.length; index++) {
      let qty = this.qtyO[index];
      let itemT = qty*this.orderList[index].price;
      this.total += qty*this.orderList[index].price;
      this.itemTotals.push(itemT);
    }
    
    this.display = false;
    this.display2 = false;
    this.display3 = true;
    this.display4 = false;
    this.display5 = false;
    this.tbt = this.total + this.sh;
    this.tax = this.total * 0.06;
    this.newtotal = this.tbt + this.tax;
  }

  formatter = new Intl.NumberFormat('en-US', {
    style: 'currency',
    currency: 'USD',
  });
  
  deleteItem(numy: number){
    this.orderList.splice(numy, 1);
    let ol = JSON.stringify(this.orderList);
    localStorage.setItem('cart', ol);
    this.compute();
  }

  displayInfo() {

    var email = localStorage.getItem("email");
     

    if (email != null){
      this.peopleHttp.getPersonByEmail(email.toString()).subscribe(
    
      (response) => {
        
        this.user = response;
        if(this.user.address2 == ""){
          this.sw3 = false;
        }
      }

      )
    }
    
  }


  updateEmp() {
    console.log(this.peopleServ.people);

  this.peopleHttp.updatePeople(this.peopleServ.people).subscribe(
    (response) => {
      console.log("updated person");
    }
  );
}

buildOrder: Order = new Order(0, 0, "", "", false, [], []);
// Starts a new order with whatever is in the cart and updates the user with said order
checkoutOrder() {
  this.display = false;
  this.display2 = false;
  this.display3 = false;
  this.display4 = false;
  this.display5 = true;

  this.buildOrder.itemId = this.orderList;
  this.buildOrder.qtyO = this.qtyO;
  this.buildOrder.totalPrice = this.newtotal;
  let dateTime = new Date().toLocaleString()
  this.buildOrder.dateOrdered = dateTime;
  this.buildOrder.shippingType = this.options;

  this.newOrder.addOrder(this.buildOrder).subscribe(
    (response) => {
      this.buildOrder = response;
      console.log(response);
      this.addOrderToPerson();
    }
  ) 
}

email: string = JSON.stringify(localStorage.getItem("email"));
emailNoQuotes = this.email.replace(/"/g, '');
// Updates the user with their order
addOrderToPerson() {
  this.bo = this.buildOrder;
  for (let index = 0; index < this.orderList.length; index++) {
  this.allCandy.getCandyByName(this.orderList[index].name).subscribe(
    (response) => {
      response.qty = response.qty - this.qtyO[index];
      this.allCandy.updateCandy(response).subscribe(
  (response) => {
    console.log("updated item");
  }
);


    }
  )
  }

  localStorage.removeItem("qtyO");
  localStorage.removeItem("cart");
  console.log(this.emailNoQuotes);
  this.peopleHttp.getPersonByEmail(this.emailNoQuotes).subscribe(
    (response) => {
      let person = response;
      console.log(this.buildOrder);
      person.orderId.push(this.buildOrder);
      this.peopleHttp.updatePeople(person).subscribe(
        (updatedPerson) => {
          console.log(updatedPerson);
          this.per = updatedPerson;
          if(this.per.address2 != ""){
            this.sw4 = true;
          }
        }
      )
    }
  )

}
  
  getAllCandy() {

    this.allCandy.getAllCandy().subscribe(
      (response) => {
        console.log(response)
        this.itemList = response;
      }
    )
  }

}