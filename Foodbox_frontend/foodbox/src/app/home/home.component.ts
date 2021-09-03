import { Component, OnInit } from '@angular/core';
import { CartLine } from '../cart-line';
import { Cuisine } from '../model/cuisine';
import { Product } from '../model/product';
import { AlertService } from '../service/alert.service';
import { CuisinesService } from '../service/cuisines.service';
import { ProductService } from '../service/product.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  search:string='';
  productlist:Array<Product>=[];
  cuisinelist:Array<Cuisine>=[]; 
  constructor(private prdservice:ProductService,
    private prd:Product,
    private cartline:CartLine,
    private alertservice:AlertService,
    private cuisineservice:CuisinesService) { }

  ngOnInit(): void {

    this.prdservice.getallavailable().subscribe(result=>{this.productlist=result},
      error=>{this.alertservice.error(error.error.message+"product fetch failure")
      })
      this.cuisineservice.getall().subscribe(result=>{this.cuisinelist=result},
        error=>{this.alertservice.error(error.error.message+"cuisine fetch failure")
        })
  }
  csearch(c:Cuisine){
    this.search=c.name;
  }
  countVal:number= 0;
  
  searchitem(){
    this.productlist.filter
  }
addtocartline(pdt:Product){
this.cartline.product=pdt;
this.cartline.buying_price=pdt.price;
this.cartline.product_count=this.countVal;
this.cartline.total=pdt.price*this.countVal;
}

}
