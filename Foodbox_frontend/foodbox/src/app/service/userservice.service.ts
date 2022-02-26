import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../model/user';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { initializeApp } from 'firebase/app';
import { Database, equalTo, get, objectVal, orderByChild, orderByValue, query, ref,set } from '@angular/fire/database';
import { child, push, remove } from 'firebase/database';
import { provideDatabase } from '@angular/fire/database';
const baseurl = `${environment.apiurl}/user/`;
const headers = { 'content-type': 'application/json'} 
@Injectable({
  providedIn: 'root'
})
export class UserserviceService {

  private  userlist:Observable<User[]>
  constructor(private http:HttpClient,
    private database:Database) {
      const doc = ref(database, 'useiron-portfolio-333206-default-rtdb');
      this.userlist = objectVal(doc)
   }


   getall(){
     return this.userlist;
   }

   getbyid(Id:string){
    const doc = ref(this.database, 'user/'+Id);
     return get(doc);
     
   }
   register(user: User){

  const key = push(ref(this.database,'iron-portfolio-333206-default-rtdb')).key
  
    const doc = ref(this.database, 'iron-portfolio-333206-default-rtdb');
    set(doc,user)
    console.log(user)
    console.log(doc)
    }
 
  
   
  update(Id:string,user:User){ 
    
  const doc = ref(this.database, 'user/'+Id);
  set(doc,user)
  
  }
  delete(Id:string){
    const doc = ref(this.database, 'user/'+Id);
    remove(doc);
    
  }
  getbyemail(email:string){
    const byemail = query(ref(this.database,'user'),orderByChild('email'),equalTo(email))
    return byemail
  }
   /*getall(){
     
     return this.http.get<User[]>(baseurl,{'headers':headers});
   }

   register(user: User) {
     
    const body=JSON.stringify(user);
    return this.http.post(baseurl, body,{'headers':headers});
}
  //getbyid(id:number){
   // return this.http.get<User>(`${baseurl}${id}`);

  }

  update(id:number,user:User){
    const body=JSON.stringify(user);
    return this.http.put(`${baseurl}${id}`, body,{'headers':headers});
  }
  delete(id:number){
    return this.http.delete(`${baseurl}${id}`,{'headers':headers});
  }
*/
}

