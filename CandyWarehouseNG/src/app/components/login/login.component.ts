import { Component, OnInit } from '@angular/core';
import { People } from 'src/app/models/People';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private login: LoginService) { }

  ngOnInit(): void {
  }

}
