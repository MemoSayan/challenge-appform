import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Usuario } from '../usuarios/usuarios.json';
import { Observable } from 'rxjs';




@Injectable({
    providedIn: 'root',
})
export class UserService {

    private httpHeaders = new HttpHeaders({ 'Content-type': 'application/json' })

    constructor(private http: HttpClient) { }

    registerUser(user: Usuario): Observable<any> {
        return this.http.post('http://localhost:8080/user/api/v1/user', user, { headers: this.httpHeaders }
        );
    }
}