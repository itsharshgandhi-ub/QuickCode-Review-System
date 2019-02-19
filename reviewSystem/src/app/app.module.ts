import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule} from '@angular/router';
import { HttpClientModule} from '@angular/common/http';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { AuthGuard } from './auth.guard';
import { AuthService } from './auth.service';
import { CoursesComponent } from './courses/courses.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatGridListModule} from '@angular/material/grid-list';
import { CourseReviewComponent } from './course-review/course-review.component';
import { UserReviewsComponent } from './user-reviews/user-reviews.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    CoursesComponent,
    CourseReviewComponent,
    UserReviewsComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatGridListModule,
    RouterModule.forRoot([
      {
        path:'login',
        component: LoginComponent
      },
      {
        path:'courses',
        component:CoursesComponent
      },
      {
        path: 'course-review',
        component: CourseReviewComponent
      },
      {
        path: 'user-reviews',
        component: UserReviewsComponent
      },
      {
        path: '',
        component: LoginComponent
      }
    ])
  ],
  providers: [AuthService,AuthGuard,CoursesComponent],
  bootstrap: [AppComponent]
})
export class AppModule { }
