import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/model/product';
import { ProductService } from 'src/app/service/product.service';

@Component({
  selector: 'app-manageproduct',
  templateUrl: './manageproduct.component.html',
  styleUrls: ['./manageproduct.component.css']
})
export class ManageproductComponent implements OnInit {

  constructor(private productservice:ProductService) { }

  ngOnInit(): void {
  }
  changed(p:Product){
    this.productservice.updateavilable(p.id,p.is_active).subscribe

  }
}
