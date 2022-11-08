import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Profesor } from '../models/profesor';

@Injectable({
  providedIn: 'root'
})
export class ProfesorService {

  private url: string = "http://localhost:8080/api/v1/profesor";

  constructor(
    private http:HttpClient
  ) { }

  save(profesor:Profesor):Observable<Profesor>{
    return this.http.post<Profesor>(this.url,profesor);
  }

  update(cedula:number, profesor:Profesor) : Observable<Profesor>{
    let newUrl= this.url+"/"+cedula;
    return this.http.put<Profesor>(newUrl, profesor);
  }

  delete(cedula:number): Observable<any>{
    let newUrl= this.url+"/"+cedula;
    return this.http.delete<any>(newUrl);
  }

  findAll(): Observable<Profesor[]> {
    return this.http.get<Profesor[]>(this.url);
  }

  findByCedula(cedula:number) : Observable<Profesor>{
    let newUrl= this.url+"/"+cedula;
    return this.http.get<Profesor>(newUrl);
  }

}
