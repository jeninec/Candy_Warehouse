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
    if(localStorage.getItem("title") == null){
      this.notLoggedIn = true;
    } else {
      this.notLoggedIn = false;
    }
  }
  
  email: string = '';
  password: string = '';
  responseMessage: string = '';
 
  notLoggedIn: boolean = true;

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
          location.reload();
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
    this.responseMessage = "Logging out";
    location.reload();
  }

}
