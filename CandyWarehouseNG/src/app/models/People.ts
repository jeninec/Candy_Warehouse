//import * as internal from "stream";

export class People{

    id: number;
    firstName: string;
    lastName: string;
    email: string;
    password: string;
    address1: string;
    address2: string;
    city: string;
    state: string;
    zip: string;
    phone: string;
    title: string;


    constructor(id: number, firstName: string, lastName: string, email: string, password: string,
        address1: string, address2: string, city: string, state: string, zip: string,
        phone: string, title: string){

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.title = title;

    }
}