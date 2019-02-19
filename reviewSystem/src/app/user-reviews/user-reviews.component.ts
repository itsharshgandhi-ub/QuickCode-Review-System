import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-user-reviews',
  templateUrl: './user-reviews.component.html',
  styleUrls: ['./user-reviews.component.css']
})
export class UserReviewsComponent implements OnInit {
  userReviews:any;
  userReviewsAvailable:boolean = false;
  constructor(private Auth: AuthService) { }

  ngOnInit() {
    this.Auth.getCourseDetails().subscribe(
      response => {
        this.userReviews = response;
        this.userReviewsAvailable = true;
        console.log(response);
      }, err => {
        console.log("Error : " + JSON.stringify(err));
      }
    )
  }

}
