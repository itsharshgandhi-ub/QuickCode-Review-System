import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';
import { CoursesComponent } from '../courses/courses.component';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private Auth:AuthService, private router: Router, private courses: CoursesComponent) { }

  ngOnInit() {
    
  }
  loginUser(event){
    event.preventDefault()
    const target = event.target
    const username  = target.querySelector('#username').value
    const password  = target.querySelector('#password').value
    this.Auth.getUserDetails(username,password).subscribe(data=>{
      if(data){
        
        this.router.navigate(['/courses'])
        this.Auth.setLoggedInStatus(true)
        
        // this.Auth.getUserDetails(username,password).subscribe(da=>{

        // })
      }
      else{
        window.alert("Invalid credentials! Please try again.")
      }
    })
    console.log(username,password)
  }

}
