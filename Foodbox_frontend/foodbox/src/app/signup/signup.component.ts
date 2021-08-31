import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { first } from 'rxjs/operators';
import { AlertService } from '../service/alert.service';
import { AuthenticationServiceService } from '../service/authentication-service.service';
import { UserserviceService } from '../service/userservice.service';

@Component({

  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  registerForm: FormGroup = this.formBuilder.group({
    firstName: ['', Validators.required],
    lastName: ['', Validators.required],
    email: ['', Validators.required],
    contact_number: ['', Validators.required],
    password: ['', [Validators.required, Validators.minLength(6)]]});
  loading = false;
  submitted = false;
  isAddmode!:boolean;
  id!:number;
  constructor(
    private formBuilder: FormBuilder,
    private route:ActivatedRoute,
    private router: Router,
    private authenticationService: AuthenticationServiceService,
    private userService: UserserviceService,
    private alertService: AlertService

  ) { 
    


}

  ngOnInit(): void { 
    this.id = this.route.snapshot.params['id'];
    this.isAddmode = !this.id;
    if (!this.isAddmode) {
      this.userService.getbyid(this.id)
          .pipe(first())
          .subscribe(x => this.registerForm.patchValue(x));
  }
}
  get f() { return this.registerForm.controls;
  }
  
    
  
  
  

  onSubmit() {
      this.submitted = true;

      // reset alerts on submit
      this.alertService.clear();

      // stop here if form is invalid
      if (this.registerForm.invalid) {
          return;
      }

      this.loading = true;
      if (this.isAddmode) {
        this.createUser();
    } else {
        this.updateUser();
    }
}
private createUser(){
      this.userService.register(this.registerForm.value)
          .pipe(first())
          .subscribe(
              data => {
                  this.alertService.success('Registration successful', true);
                  this.router.navigate(['/login']);
              },
              error => {
                  this.alertService.error(error.error.message);
                  this.loading = false;
              });
  }
  private updateUser(){
    this.userService.update(this.id,this.registerForm.value)
          .pipe(first())
          .subscribe(
              data => {
                  this.alertService.success('update successful', true);
                  this.router.navigate(['/login']);
              },
              error => {
                  this.alertService.error(error.error.message);
                  this.loading = false;
              });
  }
}




