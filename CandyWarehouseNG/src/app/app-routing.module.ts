import { NgModule, Component } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { EmployeeComponent } from './components/employee/employee.component';
import { ManagerComponent } from './components/manager/manager.component';
import { AdminComponent } from './components/admin/admin.component';
import { UserComponent } from './components/user/user.component';
import { InventoryComponent } from './components/inventory/inventory.component';
import { LoginComponent } from './components/login/login.component';
import { AboutPageComponent } from './components/about-page/about-page.component';
import { HomePageComponent } from './components/home-page/home-page.component';
import { EditUserComponent } from './components/edit-user/edit-user.component';
import { RegisterComponent } from './components/register/register.component';

const routes: Routes = [
  {path: 'employee', component: EmployeeComponent},
  {path: 'manager', component: ManagerComponent},
  {path: 'admin', component: AdminComponent},
  {path: 'user', component: UserComponent},
  {path: 'inventory', component: InventoryComponent},
  {path: 'login', component: LoginComponent},
  {path: 'about', component: AboutPageComponent},
  {path: 'home', component: HomePageComponent},
  {path: 'editUser/:userid', component: EditUserComponent},
  {path: 'register', component: RegisterComponent},
  { path: '', redirectTo: '/home', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
