import { Component, OnInit } from '@angular/core';
import { HttpAllCandyService } from 'src/app/services/http-all-candy.service';
import { Item } from 'src/app/models/Item';
import { HttpOrderService } from 'src/app/services/http-order.service';
import { Order } from 'src/app/models/Order';
import { Observable } from 'rxjs';
import { HttpPeopleService } from 'src/app/services/http-people.service';

@Component({
  selector: 'app-inventory',
  templateUrl: './inventory.component.html',
  styleUrls: ['./inventory.component.css']
})
export class InventoryComponent implements OnInit {

  constructor(private allCandy : HttpAllCandyService, private newOrder : HttpOrderService, private putPerson : HttpPeopleService) { }

  ngOnInit(): void {
    this.getAllCandy();
    try {
      let login = localStorage.getItem('email');
      console.log("login" + login);
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
} catch( e) {
    // conversion fails
   console.error( e ) 
} 
  }

  
  itemList: Item[] = [];
  itemList2: Item[] = [];
  orderList: Item[] =[];
  itemTotals: number[] = [];
  

  value: number[] = [];
  total = 0;

  display = false;
  display2 = true;
  display3 = false;
  show: boolean[] = [];
  sw = true;
  sw2 = false;
  
  onPress(cat: any) {
    this.display = true;
    this.display2 = false;
    this.display3 = false;


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
  }

  onPress3() {
  
    this.display = false;
    this.display2 = false;
    this.display3 = false;
    
  }


  submitItem(name: string, num: number, trig: boolean){
    this.allCandy.getCandyByName(name).subscribe(
      (response) => {
        response.qtyOrdered = this.value[num];
        this.orderList.push(response);
        let ol = JSON.stringify(this.orderList);
        localStorage.setItem('cart', ol);
        this.show[num] = trig;
        window.setTimeout(()=>{
          this.show[num] = false;
       }, 1500);
      }
    )

  }

  compute(){
    console.log(this.orderList);
    this.total = 0;
    this.itemTotals = [];


    for (let index = 0; index < this.orderList.length; index++) {
      let qty = this.orderList[index].qtyOrdered;
      let itemT = qty*this.orderList[index].price;
      this.total += qty*this.orderList[index].price;
      this.itemTotals.push(itemT);
    }
    console.log(this.total+"test");
    this.display = false;
    this.display2 = false;
    this.display3 = true;
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
  getAllCandy() {

    this.allCandy.getAllCandy().subscribe(
      (response) => {
        console.log(response)
        this.itemList = response;
      }
    )
  }

  
  buildOrder: Order = new Order(0, 0, "", "", false, []);
  // Starts an empty order
  startNewOrder() {
    this.newOrder.addOrder(this.buildOrder).subscribe(
      (response) => {
        console.log(response);
      }
    ) 
  }

  itemsInCart: Item[] = [];
  // Updates the order with the list of itemsInCart[]
  updateCart() {
    this.newOrder.updateOrder(this.buildOrder).subscribe(
      (response) => {
        response.itemId = this.itemsInCart;
      }
    )
  }

  addOrderToPerson() {

    // this.putPerson.getPersonByEmail()

  }
  

}
