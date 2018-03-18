RELEVANT INFORMATION
 All API queries must be preceded by /api

Searches
 Below are queries regarding the search for offers

User

Add new user

Add a user to the system.

URL:

/users

Method:
```
POST
```

Data params:
```
{
	"name" : "Nuevo usuario",
	"email" : "email@gmail.com",
	"location" : "Móstoles",
	"image" : "",
	"passwordHash" : "password",
	"phone" : "676767676"
}
```

Success response:
```
{
    "url": "/user/",
    "id": 4,
    "name": "Nuevo usuario",
    "email": "email@gmail.com",
    "location": "Móstoles",
    "image": "",
    "phone": 676767676,
    "registerDate": null,
    "activatedUser": false,
    "isAdmin": false
}
```

Update user

Update a user into the system.

URL:

/users/id

Method:
```
PUT
```
Url params:
Required
 	id = [long]
Data params:
```
{
	"name" : "Usuario modificado",
	"email" : "email@gmail.com",
	"location" : "Móstoles",
	"image" : "",
	"passwordHash" : "password",
	"phone" : "676767676"
}
```

Success response:
```
{
    "url": "/user/",
    "id": 4,
    "name": "Usuario modificado",
    "email": "email@gmail.com",
    "location": "Móstoles",
    "image": "",
    "phone": 676767676,
    "registerDate": null,
    "activatedUser": false,
    "isAdmin": false
}
```
Product

Add new product

Add a product to the system.

URL:

/products

Method:
```
POST
```

Data params:
```
{
	"name" : "Nuevo producto",
	"description" : "Nueva descripcion",
	"state" : "new",
	"especifications": [
	  {
		"procesador": "intel",
		"SO": "Android",		
		]
	  },
	{
		tags: ["Informatica", "Movil grande"]
	},
	"price" : "300€",
	"sold" : "false",
	
}
```

Success response:
```
{
    "url": "/products/",
    "id": 6,
    "name": "Nuevo producto",
    "description": "Nueva descripcion",
    "state": "new",
    "especifications": [
	  {
		"procesador": "intel",
		"SO": "Android",		
		]
	  },
	{
		tags: ["Informatica", "Movil grande"]
	},
	"price" : "300€",
	"sold" : "false",
	"date" : "12/05/18"
}
```
Update product

Update a product into the system.

URL:

/product/idUser/idProduct

Method:
```
PUT
```
Url params:
Required
 	idUser = [long]
	idProduct = [long]
Data params:
```
{
	"name" : "Nuevo producto",
	"description" : "Nueva descripcion",
	"state" : "new",
	"especifications": [
	  {
		"procesador": "intel",
		"SO": "Android",		
		]
	  },
	{
		tags: ["Informatica", "Movil grande"]
	},
	"price" : "300€",
	"sold" : "false",
	
}
```

Success response:
```
{
    "url": "/products/",
    "id": 6,
    "name": "Nuevo producto",
    "description": "Nueva descripcion",
    "state": "new",
    "especifications": [
	  {
		"procesador": "intel",
		"SO": "Android",		
		]
	  },
	{
		tags: ["Informatica", "Movil grande"]
	},
	"price" : "300€",
	"sold" : "false",
	"date" : "12/05/18"
}
```
Get products

Get a products into the system.

URL:

/product/id

Method:
```
GET
```
Url params:
Required
 	id = [long]	

Success response:
```
{
    "url": "/products/",
    "id": 6,
    "name": "Nuevo producto",
    "description": "Nueva descripcion",
    "state": "new",
    "especifications": [
	  {
		"procesador": "intel",
		"SO": "Android",		
		]
	  },
	{
		tags: ["Informatica", "Movil grande"]
	},
	"price" : "300€",
	"sold" : "false",
	"date" : "12/05/18"
}
```
Delete product

Delete a product into the system.

URL:

/product/id

Method:
```
DELETE
```
Url params:
Required
 	id = [long]	

Success response:
```
{null}



