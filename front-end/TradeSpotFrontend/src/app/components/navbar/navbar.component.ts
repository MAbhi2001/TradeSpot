import { Component } from '@angular/core';
import { Router } from '@angular/router';
import {faCoffee,faUser} from '@fortawesome/free-solid-svg-icons';


@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {
  icon=faUser;
}
