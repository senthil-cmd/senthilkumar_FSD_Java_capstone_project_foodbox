import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class UserserviceService {
   baseurl = "http://localhost:8080";
  constructor(private http:HttpClient) {
    


   }
   register(user: User) {
    const headers = { 'content-type': 'application/json'}  
    const body=JSON.stringify(user);
    return this.http.post(this.baseurl+`/api/user/`, body,{'headers':headers});
}
}
