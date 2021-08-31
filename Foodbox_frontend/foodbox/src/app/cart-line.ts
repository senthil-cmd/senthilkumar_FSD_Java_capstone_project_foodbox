import { count } from "rxjs/operators";
import { Product } from "./model/product";

export class CartLine {
    id?:number;
    total:number=0;
    product:Product= new Product;
    buying_price:number =0;
    product_count:number=0;
}
