import { Component, OnInit } from '@angular/core';
import { HttpAllCandyService } from 'src/app/services/http-all-candy.service';
import { Item } from 'src/app/models/Item';

@Component({
  selector: 'app-inventory',
  templateUrl: './inventory.component.html',
  styleUrls: ['./inventory.component.css']
})
export class InventoryComponent implements OnInit {

  constructor(private allCandy : HttpAllCandyService) { }

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
    console.log(this.orderList);

    try {
      this.orderList = JSON.parse(localStorage.getItem('cart') || '[]');
} catch( e) {
    // conversion fails
   console.error( e ) 
} 
    console.log(this.orderList);
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
  }

  submitItem(name: string, num: number, trig: boolean){
    this.allCandy.getCandyByName(name).subscribe(
      (response) => {
        response.qtyOrdered = this.value[num];
        this.orderList.push(response);
        console.log(this.orderList);
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

}