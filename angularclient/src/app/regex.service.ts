import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {RegEx} from "./regex";

@Injectable({
  providedIn: 'root'
})
export class RegExService {

  private baseUrl = "http://localhost:8080/regex"

  constructor(private httpClient: HttpClient) {
  }

  getRegExList(): Observable<RegEx[]> {
    return this.httpClient.get<RegEx[]>(`${this.baseUrl}/all`);
  }

  createRegEx(regEx: RegEx): Observable<Object> {
    return this.httpClient.post(`${this.baseUrl}/create`, regEx);
  }

  getRegExById(id: number): Observable<RegEx> {
    return this.httpClient.get<RegEx>(`${this.baseUrl}/${id}`);
  }

  updateRegEx(id: number, regEx: RegEx): Observable<Object> {
    return this.httpClient.put(`${this.baseUrl}/${id}`, regEx);
  }

  deleteRegEx(id: number): Observable<Object> {
    return this.httpClient.delete(`${this.baseUrl}/${id}`);
  }
}
