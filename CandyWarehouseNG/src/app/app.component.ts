import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'CandyWarehouseNG';

  ngOnInit() {
    if(localStorage.getItem("title") == "admin"){
      this.isAdmin = true;
      this.isManager = true;
      this.isEmployee = true;
    }
    else if(localStorage.getItem("title") == "manager"){
      this.isManager = true;
      this.isEmployee = true;
    }
    else if(localStorage.getItem("title") == "employee"){
      this.isEmployee = true;
    }
  }

  isAdmin: boolean = false;
  isManager: boolean = false;
  isEmployee: boolean = false;
}
