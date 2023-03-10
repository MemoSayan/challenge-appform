import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Usuario } from '../usuarios/usuarios.json';
import { Observable, catchError, tap, throwError } from 'rxjs';
import  swal  from 'sweetalert2'




@Injectable({
    providedIn: 'root',
})
export class UserService {

    private httpHeaders = new HttpHeaders({ 'Content-type': 'application/json' })

    constructor(private http: HttpClient) { }

    registerUser(user: Usuario): Observable<any> {
        return this.http.post<any>('http://localhost:8080/user/api/v1/user', user, { headers: this.httpHeaders })
        .pipe(
            catchError((response: any) => { 
                    swal(
                        'Error', 
                        `ocurrio un error al intentar ingrear el usuario  `,
                        'error')
                console.error(`User creation failed ${response}` );
                return throwError(() => response);
            }))
    }
}