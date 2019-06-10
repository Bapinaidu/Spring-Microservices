import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Article} from "../model/article";
import {Comment} from "../model/comment";
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

let API_URL = 'http://localhost:8765/api/blog/service/';

@Injectable({
  providedIn: 'root'
})
export class BlogService {
  constructor(private http: HttpClient) { }

  createComment(comment:Comment): Observable<any> {
    return this.http.post(API_URL+'comment',JSON.stringify(comment) , {headers: { "Content-Type": "application/json; charset=UTF-8" }});
  }

  filterArticlesByAuthor(userId:string): Observable<any> {
    return this.http.post(API_URL+'user',userId , {headers: { "Content-Type": "application/json; charset=UTF-8" }});
  }

  // filterStudents(courseId:string): Observable<any> {
  //   return this.http.post(API_URL+'students',courseId , {headers: { "Content-Type": "application/json; charset=UTF-8" }});
  // }

  allArticles(): Observable<any> {
    return this.http.post(API_URL , {headers: { "Content-Type": "application/json; charset=UTF-8" }});
  }

  popularArticles(): Observable<any> {
    return this.http.get(API_URL+'popular' , {headers: { "Content-Type": "application/json; charset=UTF-8" }});
  }

  filterArticles(text: string): Observable<any> {
    return this.http.post(API_URL+"filter",text , {headers: { "Content-Type": "application/json; charset=UTF-8" }});
  }
}
