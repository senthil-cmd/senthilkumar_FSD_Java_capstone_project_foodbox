import { Cuisine } from "./cuisine";

export class Product {
    id?:number;
    code:string ="";
    description:string="";
    price:number=0;
    quantity:number=0;
    is_active:boolean=false;
    image:string="";
    cuisine:Cuisine={
        id:0,name:"",description:""
    };



}
