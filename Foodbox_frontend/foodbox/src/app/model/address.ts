import { User } from "./user";

export class Address {
    id?: number;
    address_1:string="";
    address_2:string="";
    city:string="";
    state:string="";
    country:string="";
    postal_code:string="";
    user:User=new User();
}
