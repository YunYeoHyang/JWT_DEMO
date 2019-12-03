import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {User} from "../mobule/user";

@Injectable({
  providedIn: 'root'
})
export class AppService {

  constructor(private http: HttpClient) { }

  signup(user: User): Observable<any>{
    return this.http.post(`/api/login` , user ,{responseType: "text"})
    // localhost:8088/login
  }
}
