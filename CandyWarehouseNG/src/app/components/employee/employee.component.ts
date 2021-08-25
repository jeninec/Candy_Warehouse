import { Component, OnInit } from '@angular/core';
import { Router,NavigationEnd } from '@angular/router';
import { HttpOrderService } from 'src/app/services/http-order.service';
import { Order } from 'src/app/models/Order';
import { Item } from "src/app/models/Item";
@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  constructor(private httpOrders : HttpOrderService,private router: Router) {
     this.router.events.subscribe((e) => {
    if (e instanceof NavigationEnd) {

      this.displayAllOrder();
             }
       });
  }
  
  ngOnInit(): void {
  }
  OrdersList : Order[] = [];
  
displayAllOrder(){
this.httpOrders.getAllOrders().subscribe((Response) => {
  console.log(Response);
  this.OrdersList = Response;
  // orderItems:Item [] = this.OrdersList.itemId[];
  });
  console.log(this.OrdersList);
}

updateOrder(orderU:any){
  orderU.shipped = true;
  this.httpOrders.updateOrder(orderU).subscribe(data => {
    console.log(data);
  });

}

formatter = new Intl.NumberFormat('en-US', {
  style: 'currency',
  currency: 'USD',
});

}
