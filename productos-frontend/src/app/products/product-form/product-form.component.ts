import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ProductService, Product } from '../../services/product.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-product-form',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './product-form.component.html',
  styles: []
})
export class ProductFormComponent {
  product: Product = {
    name: '',
    description: '',
    price: 0,
    quantity: 0
  };

  constructor(
    private productService: ProductService,
    private router: Router
  ) {}

  onSubmit(): void {
    this.productService.createProduct(this.product).subscribe({
      next: (data) => {
        console.log('Producto creado:', data);
        this.router.navigate(['/products']);
      },
      error: (error) => {
        console.error('Error al crear producto:', error);
      }
    });
  }
}
