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

@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    ManageproductComponent,
    AddproductComponent,
    ManagecuisinesComponent,
    ManageuserComponent,
    HeaderComponent,
    PageNotFoundComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
