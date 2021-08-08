import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private loginServ: LoginService) { }

  ngOnInit(): void {
  }
  
  email: string = '';
  password: string = '';
 

  login() {

    console.log(this.email);
    this.loginServ.getUser(this.email).subscribe(
      (response) => {
         const user = response
         console.log(user);
         if(user.email == this.email && user.password == this.password) {
          console.log("Success! Logging in...")

          switch(user.title) {

            case "employee":
              window.location.href = "./employee.component.html";
              break;
            
            case "manager":
              window.location.href = "CandyWarehouseNG/src/app/components/manager/manager.component.html";
              break;
            
            case "Buyer":
              window.location.href = "./...html";
              break;
            
            case "Admin":
              window.location.href = "./admin.component.html";
              break;
            
            default:
              window.location.href = "./home-page.component.html";
          }

         }else {
           console.log("Incorrect credentials")
         }
      }

    )

  }

}
