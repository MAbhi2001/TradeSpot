import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router'; // Import RouterModule and Routes

import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { ProductService } from './services/product.service';
import { NavbarComponent } from './components/navbar/navbar.component';
import { LoginComponent } from './components/login/login.component';
import { ForgotPasswordComponent } from './components/forgot-password/forgot-password.component';
import { NotFoundComponentComponent } from './components/not-found-component/not-found-component.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome'; 
import { AppRoutingModule } from './app-routing.module';
import { RegisterComponent } from './components/register/register.component';

// Define your routes here
const routes: Routes = [
  { path: '', component: HomeComponent },
  // Add other routes here
];

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavbarComponent,
    LoginComponent,
    ForgotPasswordComponent,
    NotFoundComponentComponent,
    RegisterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    RouterModule,
    FontAwesomeModule // Import RouterModule and configure routes
  ],
  providers: [ProductService],
  bootstrap: [AppComponent]
})
export class AppModule { 

}
