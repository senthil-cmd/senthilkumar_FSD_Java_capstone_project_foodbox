import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AlertService } from 'src/app/service/alert.service';
import { CuisinesService } from 'src/app/service/cuisines.service';
import { ProductService } from 'src/app/service/product.service';

@Component({
  selector: 'app-addproduct',
  templateUrl: './addproduct.component.html',
  styleUrls: ['./addproduct.component.css']
})
export class AddproductComponent implements OnInit {
  productFrom:FormGroup=new FormGroup({})
  loding =false;
  submitted = false;
  constructor(
private formBuilder:FormBuilder,
private router:Router,
private productservice:ProductService,
private cuisineservice:CuisinesService,
private alertservice:AlertService
) { 
  
}
  ngOnInit(): void {
    this.productFrom=this.formBuilder.group({
      code: ['', Validators.required],
      category: ['', Validators.required],
      description: ['', Validators.required],
      price: ['', Validators.required],
      quantity: ['', Validators.required],
      is_active: ['', Validators.required],
      image: ['', Validators.required],
      cuisine: ['', Validators.required],
      
    })
  }

}
