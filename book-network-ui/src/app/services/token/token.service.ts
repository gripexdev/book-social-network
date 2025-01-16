import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TokenService {

  // store the token in local storage
  set token(token: string) {
    localStorage.setItem('token', token);
  }

  // get the token from local storage
  get token() {
    return localStorage.getItem('token') as string;
  }
}
