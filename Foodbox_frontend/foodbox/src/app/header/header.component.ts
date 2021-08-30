import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../model/user';
import { AuthenticationServiceService } from '../service/authentication-service.service';
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  currentUser: User = new User;
  
  constructor(
    private router: Router,
    private authenticationService: AuthenticationServiceService
) {
    this.authenticationService.currentUser.subscribe(x => this.currentUser = x);
    
}


  ngOnInit(): void {
  }
  logout() {
    this.authenticationService.logout();
    this.router.navigate(['/home'])
}
}
