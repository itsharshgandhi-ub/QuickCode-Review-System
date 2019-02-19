import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private loggedInStatus = false
  private username:string;
  private cid:string;
  
  constructor(private http: HttpClient) { }

  setLoggedInStatus(value:boolean){
    this.loggedInStatus = value
  }
  get isLoggedIn(){
    return this.loggedInStatus
  }

  setCID(cid:string){
    this.cid=cid;
  }

  getUserDetails(username, password){
    this.username = username;
    return this.http.post('/api/auth',{
      username,password
    })
  }
  getCourseDetails(){
    let headers = new HttpHeaders();
    headers.append('Content-Type', 'application/json');
    let params = new HttpParams().set('username',this.username);
    return this.http.get('/api/courses', { headers,params});
  }
  getCourseReviews(){
    let headers = new HttpHeaders();
    headers.append('Content-Type', 'application/json');
    let params = new HttpParams().set('cid',this.cid);
    return this.http.get('/api/courseReviews', { headers,params});
  }
  getUserReviews(){
    let headers = new HttpHeaders();
    headers.append('Content-Type', 'application/json');
    let params = new HttpParams().set('username',this.username);
    return this.http.get('/api/userCoursesReviews', { headers,params});
  }
}
