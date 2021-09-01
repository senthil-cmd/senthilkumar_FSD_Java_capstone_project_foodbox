import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { first } from 'rxjs/operators';
import { AlertService } from 'src/app/service/alert.service';
import { CuisinesService } from 'src/app/service/cuisines.service';
import { ProductService } from 'src/app/service/product.service';
import { SignupComponent } from 'src/app/signup/signup.component';

@Component({
  selector: 'app-addproduct',
  templateUrl: './addproduct.component.html',
  styleUrls: ['./addproduct.component.css']
})
export class AddproductComponent implements OnInit {
  
  productFrom:FormGroup=new FormGroup({})
  loading =false;
  submitted = false;
  isAddmode!:boolean;
  id!:number;
  constructor(
private formBuilder:FormBuilder,
private router:Router,
private productservice:ProductService,
private cuisineservice:CuisinesService,
private alertservice:AlertService,
private route:ActivatedRoute
) { 
  
}
  ngOnInit(): void {
    this.productFrom=this.formBuilder.group({
      id:[],
      code: ['', Validators.required],
      category: ['', Validators.required],
      description: ['', Validators.required],
      price: ['', Validators.required],
      quantity: ['', Validators.required],
      is_active: ['', Validators.required],
      image: ['', Validators.required],
      Cuisine : this.formBuilder.group({
        id:['',Validators.required],
        name:[''],
        description:['']
      }),  })
      this.id=this.route.snapshot.params['id'];
      this.isAddmode=!this.id;
      if(!this.isAddmode){
        this.productservice.getbyid(this.id)
        .pipe(first())
          .subscribe(x => this.productFrom.patchValue(x));
      }

  }
  get f() { return this.productFrom.controls;
  }
  onSubmit(){
  this.submitted = true;

      // reset alerts on submit
      this.alertservice.clear();

      // stop here if form is invalid
      if (this.productFrom.invalid) {
          return;
      }
      this.loading = true;
      if (this.isAddmode) {
        this.createproduct();
    } else {
        this.updateproduct();
    }
}
createproduct(){

}
updateproduct(){

}
}
