import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from './about/about.component';
import { ManagecuisinesComponent } from './admin/managecuisines/managecuisines.component';
import { ManageproductComponent } from './admin/manageproduct/manageproduct.component';
import { ManageuserComponent } from './admin/manageuser/manageuser.component';
import { CartComponent } from './cart/cart.component';
import { CheckoutComponent } from './checkout/checkout.component';
import { ContactComponent } from './contact/contact.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';

const routes: Routes = [
  {path:'',redirectTo:'home',pathMatch:'full'},
  {path:'home',component:HomeComponent},
  {path:'cart',component:CartComponent},
  {path:'contact',component:ContactComponent},
  {path:'about',component:AboutComponent},
  {path:'login',component:LoginComponent},
  {path:'signup',component:SignupComponent},
  {path:'manageproduct',component:ManageproductComponent},
  {path:'managecuisines',component:ManagecuisinesComponent},
  {path:'manageuser',component:ManageuserComponent},
  {path:'updateuser/:id',component:SignupComponent},
  {path:'checkout',component:CheckoutComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
