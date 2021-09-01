import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Cuisine } from '../model/cuisine';

const baseurl = `${environment.apiurl}/cuisines/`;
const headers = { 'content-type': 'application/json'} 

@Injectable({
  providedIn: 'root'
})
export class CuisinesService {
  constructor(private http:HttpClient) {
  }
  getall(){
    
    return this.http.get<Cuisine[]>(baseurl,{'headers':headers});
  }

  register(Cuisine: Cuisine) {
    
   const body=JSON.stringify(Cuisine);
   return this.http.post(baseurl, body,{'headers':headers});
}
 getbyid(id:number){
   return this.http.get<Cuisine>(`${baseurl}${id}`);

 }

 update(id:number,Cuisine:Cuisine){
   const body=JSON.stringify(Cuisine);
   return this.http.put(`${baseurl}${id}`, body,{'headers':headers});
 }
 delete(id:number){
   return this.http.delete(`${baseurl}${id}`,{'headers':headers});
 }
 
}
