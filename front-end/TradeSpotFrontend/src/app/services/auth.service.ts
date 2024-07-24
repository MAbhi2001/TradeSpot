import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { register } from '../models/register';
import { login } from '../models/login';
import { token } from '../models/token';
import { user } from '../models/user';


const BASE_URL="http://localhost:8080"
@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }
  
  register(signUpRequest: register) {
    return this.http.post(BASE_URL + "/user/signup", signUpRequest);
  }

  login(loginRequest: login) {
    return this.http.post(BASE_URL + "/user/login", loginRequest);
 
  }

  getUser(token:token) {
    return this.http.post<user>(BASE_URL + "/user/getByToken", token, {
      headers: this.createAuthorizationHeader()
    });
  }

  createAuthorizationHeader() {
    const jwtToken = sessionStorage.getItem("jwt");
    if (jwtToken) {
      console.log("jwt token", jwtToken);
      return new HttpHeaders().set(
        "Authorization","Bearer "+ jwtToken
      )
      
    }
    else {
      console.log("jwt not found");
      
    }
    return new HttpHeaders();
  }
}


