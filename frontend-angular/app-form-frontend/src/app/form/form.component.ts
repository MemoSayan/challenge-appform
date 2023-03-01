import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { UserService } from '../services/user.service';
import { Usuario } from '../usuarios/usuarios.json';
import  swal  from 'sweetalert2'

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {


  constructor(private userService: UserService) { }

  ngOnInit(): void {
  }

  user = {
    name: '',
    lastName: '',
    email: '',
    jobTitle: '',
    phone: '',
  };

  public create(): void {
    if(this.user == null){
      swal( 'Error',  ` Debe completar los campos `, 'error')
     }
     if(this.user.name == null || this.user.lastName == null){
      swal( 'Error',  ` Nombre y apellidos son requeridos`, 'error')
     }

     if(this.user.email == null ){
      swal( 'Error', `El correo es requerido`, 'error')
     }
   
     if(this.user != null  ){
      this.userService.registerUser(this.user).subscribe(
        jsonUser => {
          swal(
          'Nuevo Usuario', 
          ` Usuario creado con éxito : ${jsonUser.user.name} con el token : ${jsonUser.user.token}`,
          'success')
        }
      );
     }
   
  }



}
