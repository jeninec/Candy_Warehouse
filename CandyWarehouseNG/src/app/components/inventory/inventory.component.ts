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

}
