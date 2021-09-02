import { Component, OnInit } from '@angular/core';
import { CartLine } from '../cart-line';
import { Product } from '../model/product';
import { AlertService } from '../service/alert.service';
import { ProductService } from '../service/product.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  search:string='';
  productlist:Array<Product>=[]; 
  constructor(private prdservice:ProductService,
    private prd:Product,
    private cartline:CartLine,
    private alertservice:AlertService) { }

  ngOnInit(): void {

    this.prdservice.getallavailable().subscribe(result=>{this.productlist=result},
      error=>{this.alertservice.error(error.error.message+"product fetch failure")
      })
  }
addtocartline(){

}

}
