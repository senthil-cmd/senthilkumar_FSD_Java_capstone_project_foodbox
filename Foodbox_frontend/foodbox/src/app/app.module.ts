import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FooterComponent } from './footer/footer.component';
import { ManageproductComponent } from './admin/manageproduct/manageproduct.component';
import { AddproductComponent } from './admin/addproduct/addproduct.component';
import { ManagecuisinesComponent } from './admin/managecuisines/managecuisines.component';
import { ManageuserComponent } from './admin/manageuser/manageuser.component';
import { HeaderComponent } from './header/header.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { HomeComponent } from './home/home.component';
import { CartComponent } from './cart/cart.component';
import { ContactComponent } from './contact/contact.component';
import { AboutComponent } from './about/about.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {  HttpClientModule } from '@angular/common/http';
import { AlertComponent } from './alert/alert.component';
import { AddcuisinesComponent } from './admin/addcuisines/addcuisines.component';
import { CheckoutComponent } from './checkout/checkout.component';
import { NgxPayPalModule } from 'ngx-paypal';



@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    ManageproductComponent,
    AddproductComponent,
    ManagecuisinesComponent,
    ManageuserComponent,
    HeaderComponent,
    PageNotFoundComponent,
    HomeComponent,
    CartComponent,
    ContactComponent,
    AboutComponent,
    LoginComponent,
    SignupComponent,
    AlertComponent,
    AddcuisinesComponent,
    CheckoutComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    NgxPayPalModule
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { 
 

}
