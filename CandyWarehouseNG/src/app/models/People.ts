import { Order } from './Order';

export class People{

    id: number;
    firstname: string;
    lastname: string;
    email: string;
    password: string;
    address1: string;
    address2: string;
    city: string;
    state: string;
    zip: string;
    phone: string;
    title: string;
    orderId: Order[];


    constructor(id: number, firstname: string, lastname: string, email: string, password: string,
        address1: string, address2: string, city: string, state: string, zip: string,
        phone: string, title: string, orderId:Order[]){

        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.title = title;
        this.orderId = orderId;

    }
}