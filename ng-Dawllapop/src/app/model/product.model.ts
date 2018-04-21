export class Product {
	id?: number;
	name: string;
    description: string;
    specifications: string[][];
    tags: string[];
    price: number;
    category: Category;	
}

export class User {
    id?: number;
    name: string;
    email: string;
    location: string;
    image: string;
    passwordHash: string;
    phone: number;
    registerDate: Date;
    activedUser: boolean;
    roles: string[];
    isAdmin: boolean;
}

export class Offer {
    userId: number;
    price: number;
    message: string;
    productId: number;
}

export class Category{
    id?: number;
    name: string;
}