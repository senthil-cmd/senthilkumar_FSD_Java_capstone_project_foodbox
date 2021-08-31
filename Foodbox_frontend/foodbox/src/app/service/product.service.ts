import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
const baseurl = `${environment.apiurl}/product/`;
const headers = { 'content-type': 'application/json'} 
@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor() { }
}
