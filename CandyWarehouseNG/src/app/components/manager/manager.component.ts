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
  selectOption: string = "Show Employees";

  toggleShow() {
    this.isEmps = ! this.isEmps;
    this.isItems = ! this.isItems;
    if(this.selectOption === "Show Employees"){
      this.selectOption = "Show Items";
    } else {
      this.selectOption = "Show Employees";
    }
  }

}
