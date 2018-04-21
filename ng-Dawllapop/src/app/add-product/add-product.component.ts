import { Component, OnInit } from '@angular/core';
import { Product } from '../model/product.model';
import { ProductService } from '../service/product.service';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {

	private product: Product;
	private added = false;

	addProduct(){
		this.productService.addProduct(this.product).subscribe(
			result => this.added = true
		);
		
	}

	constructor(private productService: ProductService) { }

	ngOnInit() {
		this.product=new Product();
		this.product.specifications = [];
		this.addSpecificationRow();
	}

	addSpecificationRow() {
		let empty_elem : string[];
		empty_elem = [];		
		this.product.specifications.push(empty_elem);
	}
	
	deleteSpecificationRow() {
		this.product.specifications.splice(this.product.specifications.length - 1, 1);
	}

	seeSpecs(){
		console.log(this.product.specifications);
	}
}