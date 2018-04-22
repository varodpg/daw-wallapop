import { Component, OnInit } from '@angular/core';
import { Product, Category } from '../model/product.model';
import { ProductService } from '../service/product.service';
import { element } from 'protractor';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {

	private product: Product;
	private added = false;
	private addedProduct: any;
	private categories : Category[];
	private categoryName: string;
	private fileToUpload: File = null;

	addProduct(){
		
		this.categories.forEach(category => {			
			if(category.name == this.categoryName){				
				this.product.category = category;				
			}
		});
		this.productService.addProduct(this.product).subscribe(
			result => {
				this.added = true;
				this.addedProduct = result;
				this.productService.addProductImage(this.addedProduct.id, this.fileToUpload).subscribe();
			}
		);		
	}

	constructor(private productService: ProductService) { }

	ngOnInit() {
		this.product=new Product();
		this.product.specifications = [];
		this.addSpecificationRow();
		this.categories = [];
		this.productService.getCategories().subscribe(data => {
			data.forEach(
				element => this.categories.push(element) 
			);
		});
	}

	addSpecificationRow() {
		let empty_elem : string[];
		empty_elem = [];		
		this.product.specifications.push(empty_elem);
	}
	
	deleteSpecificationRow() {
		this.product.specifications.splice(this.product.specifications.length - 1, 1);
	}

	handleFileInput(files: FileList) {
		this.fileToUpload = files.item(0);
	}

}