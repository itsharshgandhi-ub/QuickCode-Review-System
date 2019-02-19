import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.css']
})
export class CoursesComponent implements OnInit {
  courseDetails: any;
  courseDetailsAvailable: boolean = false;

  constructor(private Auth: AuthService, private router: Router, ) { }

  ngOnInit() {
    this.Auth.getCourseDetails().subscribe(
      response => {
        this.courseDetails = response;
        this.courseDetailsAvailable = true;
      }, err => {
        console.log("Error : " + JSON.stringify(err));
      }
    )
  }

  loadCourseReview(cid) {
    // this.stat111=true;
    // this.singleCourse=this.courseDetails[Number(cid)-1].cname;

    // document.getElementById("singleCourse").style.display='block';
    // console.log(this.courseDetails[Number(cid)-1].cname);
    this.Auth.setCID(this.courseDetails[Number(cid) - 1].cid);
    this.router.navigate(['/course-review']);
    this.Auth.setLoggedInStatus(true);

  }
  loadUserReviews() {
    this.router.navigate(['/user-reviews']);
    this.Auth.setLoggedInStatus(true);
  }

}
