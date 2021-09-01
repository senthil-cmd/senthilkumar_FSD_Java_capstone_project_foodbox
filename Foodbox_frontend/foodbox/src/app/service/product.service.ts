import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Product } from '../model/product';

const baseurl = `${environment.apiurl}/product/`;
const headers = { 'content-type': 'application/json'} 
@Injectable({
  providedIn: 'root'
})
export class ProductService {
  constructor(private http:HttpClient) {
  }
  getall(){
    
    return this.http.get<Product[]>(baseurl,{'headers':headers});
  }
  getallavailable(){
    return this.http.get<Product[]>(`${baseurl}avilable`,{'headers':headers});
  }

  getbycuisines(cuisine:string){
    return this.http.get<Product[]>(`${baseurl}bycuisines/${cuisine}`,{'headers':headers});
  }
  register(Product: Product) {
    
   const body=JSON.stringify(Product);
   return this.http.post(baseurl, body,{'headers':headers});
}
 getbyid(id:number){
   return this.http.get<Product>(`${baseurl}${id}`);

 }

 update(id:number,Product:Product){
   const body=JSON.stringify(Product);
   return this.http.put(`${baseurl}${id}`, body,{'headers':headers});
 }
 delete(id:number){
   return this.http.delete(`${baseurl}${id}`,{'headers':headers});
 }
  updateavilable(id:number,status:string){
    return this.http.patch(`${baseurl}isavliable/${id}/${status}`,{'headers':headers});
  }

}
