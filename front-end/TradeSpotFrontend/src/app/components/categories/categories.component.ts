// src/app/components/home/home.component.ts
import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/app/services/product.service'; 
import { Product } from 'src/app/models/product';

@Component({
  selector: 'app-categories',
  templateUrl: './categories.component.html',
  styleUrls: ['./categories.component.css']
})
export class CategoriesComponent implements OnInit {
  products: Product[] = []; // Updated to Product
  searchQuery: string = '';
  categories: { name: string, imageUrl: string }[] = [
    { name: 'Electronics & Appliances', imageUrl: 'assets/electronics.jpg' },
    { name: 'Furniture', imageUrl: 'assets/furniture.jpg' },
    { name: 'Fashion', imageUrl: 'assets/clothing.jpg' },
    { name: 'Books', imageUrl: 'assets/books.jpg' },
    { name: 'Vehicles', imageUrl: 'assets/vehicles.jpg' },
    // { name: 'Properties', imageUrl: 'assets/vehicles.jpg' },
    // { name: 'Mobiles', imageUrl: 'assets/vehicles.jpg' },
    // { name: 'Bikes', imageUrl: 'assets/vehicles.jpg' },
    // { name: 'Vehicles', imageUrl: 'assets/vehicles.jpg' }
  ];

  constructor(private productService: ProductService) { } // Updated service injection

  ngOnInit(): void {
    this.loadProducts();
  }

  loadProducts(): void {
    this.productService.getProducts().subscribe(
      (products: Product[]) => this.products = products, // Updated
      error => console.error('Error fetching products', error) // Updated
    );
  }

  onSearch(): void {
    
  }

  searchProducts(): void { // Updated method name
    
  }
  
  loadProductsByCategory(categoryName: string): void {
    this.productService.getProducts().subscribe((res)=>{
      console.log(res);
    })

  }
  

}
