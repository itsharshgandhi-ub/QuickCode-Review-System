import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-course-review',
  templateUrl: './course-review.component.html',
  styleUrls: ['./course-review.component.css']
})
export class CourseReviewComponent implements OnInit {

  courseReviews:any;
  singleCourse:any;
  courseReviewsAvailable:boolean=false;

  constructor(private Auth:AuthService) { }

  ngOnInit() {
    this.Auth.getCourseReviews().subscribe(
      response =>{
        // console.log(response)
        this.courseReviews = response;
        this.singleCourse = this.courseReviews[0];
        this.courseReviewsAvailable=true;
        console.log(response);
      }, err=>{
        console.log("Error : " + JSON.stringify(err));
      }
    )
  }

}
