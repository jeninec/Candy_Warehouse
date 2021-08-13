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
  responseMessage: string = '';
 

  login() {

    console.log(this.email);
    this.loginServ.getUser(this.email).subscribe(
      (response) => {
         const user = response
         console.log(user);
         if(user.email == this.email && user.password == this.password) {
          console.log("Success! Logging in...");
          this.responseMessage = "Success! Logging in...";
          localStorage.setItem("title", user.title);
          localStorage.setItem("email", user.email);

          window.setTimeout(()=>{
            location.reload();
         }, 1500);
          
         }else {  
           console.log("Incorrect credentials");
           this.responseMessage = "Incorrect credentials";
           
         }
      }

    )

  }

  logout(){
    localStorage.removeItem("title");
    localStorage.removeItem("email");
    localStorage.removeItem("qtyO");
    localStorage.removeItem("cart");
    this.responseMessage = "Logging out";
    window.setTimeout(()=>{
      location.reload();
   }, 1500);
  }

}
