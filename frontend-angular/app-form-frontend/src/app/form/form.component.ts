import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { UserService } from '../services/user.service';
import { Usuario } from '../usuarios/usuarios.json';

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
    this.userService.registerUser(this.user).subscribe(
      response => console.log('enviado' + this.user)
    );
  }



}
