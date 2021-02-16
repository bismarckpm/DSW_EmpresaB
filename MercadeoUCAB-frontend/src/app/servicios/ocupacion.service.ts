import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Ocupacion } from '../modelos/ocupacion';

@Injectable({
  providedIn: 'root'
})
export class OcupacionService {

  url: string = '//45.76.60.252:8080/pruebaORM-1.0-SNAPSHOT/api/';
  

  constructor( private http: HttpClient) { }

  getOcupaciones():Observable<Ocupacion[]>{
    return this.http.get<Ocupacion[]>(this.url + 'ocupacion/allOcupacion');
  }
}
