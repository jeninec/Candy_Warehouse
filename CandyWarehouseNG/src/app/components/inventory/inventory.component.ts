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
  
  onPress(cat: any) {
    this.display = true;
    this.display2 = false;
    console.log(cat);
    this.orderList = JSON.parse(localStorage.getItem('cart') || '[]');
    this.allCandy.getCat(cat).subscribe(
      (response) => {
        console.log(response);
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
  }

  submitItem(name: string, num: number, trig: boolean){
    this.allCandy.getCandyByName(name).subscribe(
      (response) => {
        response.qtyOrdered = this.value[num];
        this.orderList.push(response);
        let ol = JSON.stringify({ this: this.orderList })
        localStorage.setItem('cart', ol);
        console.log(this.orderList);
        this.show[num] = trig;
        window.setTimeout(()=>{
          this.show[num] = false;
       }, 1500);
      }
    )

  }

  compute(){
    for (let index = 0; index < this.orderList.length; index++) {
      let qty = this.orderList[index].qtyOrdered;
      let itemT = qty*this.orderList[index].price;
      this.total += qty*this.orderList[index].price;
      this.itemTotals.push(itemT);
    }
    console.log(this.total);
    this.display = false;
    this.display2 = false;
    this.display3 = true;
  }

  formatter = new Intl.NumberFormat('en-US', {
    style: 'currency',
    currency: 'USD',
  });
  
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
