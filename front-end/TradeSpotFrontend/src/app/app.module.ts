import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router'; // Import RouterModule and Routes

import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { ProductService } from './services/services/product.service'; 

// Define your routes here
const routes: Routes = [
  { path: '', component: HomeComponent },
  // Add other routes here
];

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(routes) // Import RouterModule and configure routes
  ],
  providers: [ProductService],
  bootstrap: [AppComponent]
})
export class AppModule { }
