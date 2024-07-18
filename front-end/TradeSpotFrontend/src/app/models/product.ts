// src/app/models/product.ts
export interface Product {
    id: number;
    title: string;
    description: string;
    price: number;
    imageUrl?: string; // Optional property for product images
  }
  