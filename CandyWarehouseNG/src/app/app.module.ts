import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EmployeeComponent } from './components/employee/employee.component';
import { AdminComponent } from './components/admin/admin.component';
import { ManagerComponent } from './components/manager/manager.component';
import { InventoryComponent } from './components/inventory/inventory.component';
import { UserComponent } from './components/user/user.component';
import { LoginComponent } from './components/login/login.component';

@NgModule({
  declarations: [
    AppComponent,
    EmployeeComponent,
    AdminComponent,
    ManagerComponent,
    InventoryComponent,
    UserComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }