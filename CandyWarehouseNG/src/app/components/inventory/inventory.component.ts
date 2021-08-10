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

  display = false;
  display2 = true;
  display3 = false;
  
  onPress(cat: any) {
    this.display = true;
    this.display2 = false;
    console.log(cat);
    this.allCandy.getCat(cat).subscribe(
      (response) => {
        console.log(response);
        this.itemList2 = response;
      }
    );
    
  }
  onPress2() {
    this.display = false;
    this.display2 = true;
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
