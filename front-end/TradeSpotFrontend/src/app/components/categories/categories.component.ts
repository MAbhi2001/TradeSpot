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
    { name: 'Electronics', imageUrl: 'assets/electronics.jpg' },
    { name: 'Furniture', imageUrl: 'assets/furniture.jpg' },
    { name: 'Fashion', imageUrl: 'assets/clothing.jpg' },
    { name: 'Books', imageUrl: 'assets/books.jpg' },
    { name: 'Vehicles', imageUrl: 'assets/vehicles.jpg' }
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
    // Optionally implement logic for live search
  }

  searchProducts(): void { // Updated method name
    if (this.searchQuery.trim()) {
      this.productService.searchProducts(this.searchQuery).subscribe(products => { // Updated method call
        this.products = products; // Updated
      });
    } else {
      this.loadProducts(); // Reset to featured products if search query is empty
    }
  }
  
  loadProductsByCategory(categoryName: string): void {
    // Optionally, you can filter products by category and load them
    // Optionally, you can filter products by category and load them
    this.productService['getProductsByCategory'](categoryName).subscribe(
      (products: Product[]) => this.products = products,
      (      error: any) => console.error(`Error fetching ${categoryName} products`, error)
    );
  }

}
