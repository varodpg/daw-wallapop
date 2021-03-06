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



Friend Request

Add friend request

Add a friend request to a user

URL:
	/friendRequest/

Method:
``````
POST
```````

URL Params:
	None

Data Params:
	````
	{
		"idUser": 3,
		"message": "hi"
	}
	````

Success response:
	{
		"url": "/friend_request/",
		"id": 4,
		"message": "hi",
		"state": "pending",
		"creationDate": 1521392397432,
		"from": {
			"url": "/user/",
			"id": 1,
			"name": "Alvaro",
			"email": "varo@hotmail.com",
			"location": "Móstoles",
			"image": "",
			"phone": 677654565,
			"registerDate": 1521392353000,
			"activatedUser": true,
			"isAdmin": true
		},
		"to": {
			"url": "/user/",
			"id": 3,
			"name": "David",
			"email": "david.r.3.a@gmail.com",
			"location": "Alcorcon",
			"image": "",
			"phone": 612595959,
			"registerDate": 1521392354000,
			"activatedUser": true,
			"isAdmin": false
		}
	}

Accept friend request

An user accepts one friend request

URL:
	/friendRequest/accept/id

Method:
`````
	PUT
`````

URL params:
	Required
 	id = [long]	

Data Params:
``````
	None
``````

Success response:

{
    "url": "/friend_request/",
    "id": 3,
    "message": "hi",
    "state": "accepted",
    "creationDate": 1521393837000,
    "from": {
        "url": "/user/",
        "id": 1,
        "name": "Alvaro",
        "email": "varo@hotmail.com",
        "location": "Móstoles",
        "image": "",
        "phone": 677654565,
        "registerDate": 1521393686000,
        "activatedUser": true,
        "isAdmin": true
    },
    "to": {
        "url": "/user/",
        "id": 2,
        "name": "Juanma",
        "email": "juanma@hotmail.com",
        "location": "Alcorcon",
        "image": "",
        "phone": 45678900,
        "registerDate": 1521393686000,
        "activatedUser": true,
        "isAdmin": false
    }
}

Refuse friend request

An user refuses one friend request

URL:
	/friendRequest/refuse/id

Method:
`````
	PUT
`````

URL params:
	Required
 	id = [long]	

Data Params:
``````
	None
``````

Success response

{
    "url": "/friend_request/",
    "id": 3,
    "message": "hi",
    "state": "refused",
    "creationDate": 1521393837000,
    "from": {
        "url": "/user/",
        "id": 1,
        "name": "Alvaro",
        "email": "varo@hotmail.com",
        "location": "Móstoles",
        "image": "",
        "phone": 677654565,
        "registerDate": 1521393686000,
        "activatedUser": true,
        "isAdmin": true
    },
    "to": {
        "url": "/user/",
        "id": 2,
        "name": "Juanma",
        "email": "juanma@hotmail.com",
        "location": "Alcorcon",
        "image": "",
        "phone": 45678900,
        "registerDate": 1521393686000,
        "activatedUser": true,
        "isAdmin": false
    }
}

Get friend requests

Get all the user´s friend requests

URL:
	/friendRequest/

URL Params:
``````
	None
``````

Data Params:
```````
	None
```````

Success Response:
	[
		{
			"url": "/friend_request/",
			"id": 2,
			"message": "Hola",
			"state": "pending",
			"creationDate": 1521394169000,
			"from": {
				"url": "/user/",
				"id": 3,
				"name": "David",
				"email": "david.r.3.a@gmail.com",
				"location": "Alcorcon",
				"image": "",
				"phone": 612595959,
				"registerDate": 1521394169000,
				"activatedUser": true,
				"isAdmin": false
			},
			"to": {
				"url": "/user/",
				"id": 2,
				"name": "Juanma",
				"email": "juanma@hotmail.com",
				"location": "Alcorcon",
				"image": "",
				"phone": 45678900,
				"registerDate": 1521394169000,
				"activatedUser": true,
				"isAdmin": false
			}
		}
	]

Get friends

Get all the user´s friends

URL: 
	/friends

URL Params:
``````
	None
``````

Data Params:
``````
	None
``````

Success Response:

[
    [
        1,
        true,
        "varo@hotmail.com",
        "",
        true,
        "Móstoles",
        "Alvaro",
        "$2a$10$ydkng0aMARBLUaTjh2nHs.5n0BZg8OXUyOThCqfqxuU3LSilYSSyO",
        677654565,
        1521394169000,
        "/user/"
    ]
]

Assessments

Add an assessment

An user logged can add an assessment

URL:
	/assessments/

URL Params:
``````
	None
``````

Data Params:
{
	"idUser": 2,
	"message": "hola esta es un assessment hecho desde rest",
	"value": 2
}

Success Response:
{
    "url": "/assessment/",
    "text": "hola esta es un assessment hecho desde rest",
    "value": 2,
    "date": 1521394833519
}

Get user assessments

Return all the user´s assessments

URL:
	/assessments/user/{id}

URL Params:
	Required
 		id = [long]	

Data Params:
``````
	None
``````

Success Response:
[
    {
        "url": "/assessment/",
        "id": 1,
        "text": "Gran vendedor",
        "value": 4,
        "date": 1521394169000,
        "userFrom": {
            "url": "/user/",
            "id": 2,
            "name": "Juanma",
            "email": "juanma@hotmail.com",
            "location": "Alcorcon",
            "image": "",
            "phone": 45678900,
            "registerDate": 1521394169000,
            "activatedUser": true,
            "isAdmin": false
        },
        "userTo": {
            "url": "/user/",
            "id": 1,
            "name": "Alvaro",
            "email": "varo@hotmail.com",
            "location": "Móstoles",
            "image": "",
            "phone": 677654565,
            "registerDate": 1521394169000,
            "activatedUser": true,
            "isAdmin": true
        }
    },
    {
        "url": "/assessment/",
        "id": 2,
        "text": "Gran vendedor, mejor persona",
        "value": 3,
        "date": 1521394169000,
        "userFrom": {
            "url": "/user/",
            "id": 3,
            "name": "David",
            "email": "david.r.3.a@gmail.com",
            "location": "Alcorcon",
            "image": "",
            "phone": 612595959,
            "registerDate": 1521394169000,
            "activatedUser": true,
            "isAdmin": false
        },
        "userTo": {
            "url": "/user/",
            "id": 1,
            "name": "Alvaro",
            "email": "varo@hotmail.com",
            "location": "Móstoles",
            "image": "",
            "phone": 677654565,
            "registerDate": 1521394169000,
            "activatedUser": true,
            "isAdmin": true
        }
    }
]





DASHBOARD

Get Products Selling

URL:
	/api/dashboard/{id}/selling

URL Params:
``````
	Required
 		id = [long]
``````

Data Params:
	None


Success Response:
[
    {
        "url": "/product/",
        "id": 1,
        "name": "Escritorio",
        "description": "Escritorio de mesa con gran capacidad de\r\n\t\t\t\t\t\t\t\tespacio",
        "state": "new",
        "specifications": [
            [
                "CPU",
                "4,1GHZ"
            ],
            [
                "Grafica",
                "GTX 1080"
            ],
            [
                "RAM",
                "6GB"
            ]
        ],
        "tags": [
            "mac",
            "escritorio",
            "ordenador",
            "grande",
            "fino"
        ],
        "price": 800,
        "images": [
            "image-0.jpg"
        ],
        "mainimage": "image-0.jpg",
        "sold": false,
        "date": 1521400609000,
        "category": {
            "url": "/category/",
            "id": 2,
            "name": "Inmobiliaria"
        },
        "user": {
            "url": "/user/",
            "id": 1,
            "name": "Alvaro",
            "email": "varo@hotmail.com",
            "location": "Móstoles",
            "image": "",
            "phone": 677654565,
            "registerDate": 1521400609000,
            "activatedUser": true,
            "isAdmin": true
        },
        "offers": [],
        "especifications": [
            [
                "CPU",
                "4,1GHZ"
            ],
            [
                "Grafica",
                "GTX 1080"
            ],
            [
                "RAM",
                "6GB"
            ]
        ]
    },
    {
        "url": "/product/",
        "id": 2,
        "name": "Escritorio Pequeño",
        "description": "Escritorio de mesa para habitaciones\r\n\t\t\t\t\t\t\t\tpequeñas",
        "state": "new",
        "specifications": [
            [
                "CPU",
                "4,1GHZ"
            ],
            [
                "Grafica",
                "GTX 1080"
            ],
            [
                "RAM",
                "6GB"
            ]
        ],
        "tags": [
            "mac",
            "escritorio",
            "ordenador",
            "grande",
            "fino"
        ],
        "price": 300,
        "images": [
            "image-0.jpg"
        ],
        "mainimage": "image-0.jpg",
        "sold": false,
        "date": 1521400609000,
        "category": {
            "url": "/category/",
            "id": 2,
            "name": "Inmobiliaria"
        },
        "user": {
            "url": "/user/",
            "id": 1,
            "name": "Alvaro",
            "email": "varo@hotmail.com",
            "location": "Móstoles",
            "image": "",
            "phone": 677654565,
            "registerDate": 1521400609000,
            "activatedUser": true,
            "isAdmin": true
        },
        "offers": [],
        "especifications": [
            [
                "CPU",
                "4,1GHZ"
            ],
            [
                "Grafica",
                "GTX 1080"
            ],
            [
                "RAM",
                "6GB"
            ]
        ]
    },
    {
        "url": "/product/",
        "id": 3,
        "name": "Nokia 8998",
        "description": "Vendo movil en buen estado, y con bateria nueva",
        "state": "not_new",
        "specifications": [
            [
                "CPU",
                "4,1GHZ"
            ],
            [
                "Grafica",
                "GTX 1080"
            ],
            [
                "RAM",
                "6GB"
            ]
        ],
        "tags": [
            "mac",
            "escritorio",
            "ordenador",
            "grande",
            "fino"
        ],
        "price": 530,
        "images": [
            "image-0.jpg"
        ],
        "mainimage": "image-0.jpg",
        "sold": false,
        "date": 1521400609000,
        "category": {
            "url": "/category/",
            "id": 1,
            "name": "Electronica"
        },
        "user": {
            "url": "/user/",
            "id": 1,
            "name": "Alvaro",
            "email": "varo@hotmail.com",
            "location": "Móstoles",
            "image": "",
            "phone": 677654565,
            "registerDate": 1521400609000,
            "activatedUser": true,
            "isAdmin": true
        },
        "offers": [],
        "especifications": [
            [
                "CPU",
                "4,1GHZ"
            ],
            [
                "Grafica",
                "GTX 1080"
            ],
            [
                "RAM",
                "6GB"
            ]
        ]
    },
    {
        "url": "/product/",
        "id": 4,
        "name": "xiaomi mi band 2",
        "description": "Incluye la pulsera de metal en vez de la de plastico",
        "state": "not_new",
        "specifications": [
            [
                "CPU",
                "4,1GHZ"
            ],
            [
                "Grafica",
                "GTX 1080"
            ],
            [
                "RAM",
                "6GB"
            ]
        ],
        "tags": [
            "mac",
            "escritorio",
            "ordenador",
            "grande",
            "fino"
        ],
        "price": 300,
        "images": [
            "image-0.jpg"
        ],
        "mainimage": "image-0.jpg",
        "sold": false,
        "date": 1521400609000,
        "category": {
            "url": "/category/",
            "id": 1,
            "name": "Electronica"
        },
        "user": {
            "url": "/user/",
            "id": 1,
            "name": "Alvaro",
            "email": "varo@hotmail.com",
            "location": "Móstoles",
            "image": "",
            "phone": 677654565,
            "registerDate": 1521400609000,
            "activatedUser": true,
            "isAdmin": true
        },
        "offers": [],
        "especifications": [
            [
                "CPU",
                "4,1GHZ"
            ],
            [
                "Grafica",
                "GTX 1080"
            ],
            [
                "RAM",
                "6GB"
            ]
        ]
    },
    {
        "url": "/product/",
        "id": 5,
        "name": "Samsung galxy s9",
        "description": "Me toco en un sorteo y no lo quiero",
        "state": "new",
        "specifications": [
            [
                "CPU",
                "4,1GHZ"
            ],
            [
                "Grafica",
                "GTX 1080"
            ],
            [
                "RAM",
                "6GB"
            ]
        ],
        "tags": [
            "mac",
            "escritorio",
            "ordenador",
            "grande",
            "fino"
        ],
        "price": 1100,
        "images": [
            "image-0.jpg"
        ],
        "mainimage": "image-0.jpg",
        "sold": false,
        "date": 1521400609000,
        "category": {
            "url": "/category/",
            "id": 1,
            "name": "Electronica"
        },
        "user": {
            "url": "/user/",
            "id": 1,
            "name": "Alvaro",
            "email": "varo@hotmail.com",
            "location": "Móstoles",
            "image": "",
            "phone": 677654565,
            "registerDate": 1521400609000,
            "activatedUser": true,
            "isAdmin": true
        },
        "offers": [],
        "especifications": [
            [
                "CPU",
                "4,1GHZ"
            ],
            [
                "Grafica",
                "GTX 1080"
            ],
            [
                "RAM",
                "6GB"
            ]
        ]
    },
    {
        "url": "/product/",
        "id": 24,
        "name": "Macbook Pro 2017",
        "description": "Es mas rapido y potente que antes, pero mas fino y ligero que nunca. Tiene la pantalla con mas color y brillo jamas vista en un portatil Mac. Y viene con la Touch Bar.",
        "state": "new",
        "specifications": [
            [
                "CPU",
                "4,1GHZ"
            ],
            [
                "Grafica",
                "GTX 1080"
            ],
            [
                "RAM",
                "6GB"
            ]
        ],
        "tags": [
            "mac",
            "escritorio",
            "ordenador",
            "grande",
            "fino"
        ],
        "price": 1900,
        "images": [
            "image-0.jpg"
        ],
        "mainimage": "image-0.jpg",
        "sold": false,
        "date": 1521400609000,
        "category": {
            "url": "/category/",
            "id": 1,
            "name": "Electronica"
        },
        "user": {
            "url": "/user/",
            "id": 1,
            "name": "Alvaro",
            "email": "varo@hotmail.com",
            "location": "Móstoles",
            "image": "",
            "phone": 677654565,
            "registerDate": 1521400609000,
            "activatedUser": true,
            "isAdmin": true
        },
        "offers": [
            {
                "url": "/offer/",
                "id": 1,
                "date": 1521400609000,
                "price": 60,
                "message": "Quiero este precio",
                "state": 0,
                "buyer": {
                    "url": "/user/",
                    "id": 2,
                    "name": "Juanma",
                    "email": "juanma@hotmail.com",
                    "location": "Alcorcon",
                    "image": "",
                    "phone": 45678900,
                    "registerDate": 1521400609000,
                    "activatedUser": true,
                    "isAdmin": false
                }
            },
            {
                "url": "/offer/",
                "id": 2,
                "date": 1521400609000,
                "price": 700,
                "message": "Te ofrezco esto Alvaro, soy David",
                "state": 0,
                "buyer": {
                    "url": "/user/",
                    "id": 3,
                    "name": "David",
                    "email": "david.r.3.a@gmail.com",
                    "location": "Alcorcon",
                    "image": "",
                    "phone": 612595959,
                    "registerDate": 1521400609000,
                    "activatedUser": true,
                    "isAdmin": false
                }
            },
            {
                "url": "/offer/",
                "id": 3,
                "date": 1521400609000,
                "price": 850,
                "message": "toma esto, no subo mas, soy Juanma por cierto",
                "state": 0,
                "buyer": {
                    "url": "/user/",
                    "id": 2,
                    "name": "Juanma",
                    "email": "juanma@hotmail.com",
                    "location": "Alcorcon",
                    "image": "",
                    "phone": 45678900,
                    "registerDate": 1521400609000,
                    "activatedUser": true,
                    "isAdmin": false
                }
            }
        ],
        "especifications": [
            [
                "CPU",
                "4,1GHZ"
            ],
            [
                "Grafica",
                "GTX 1080"
            ],
            [
                "RAM",
                "6GB"
            ]
        ]
    }
]


Get Products Sold

URL:
	/api/dashboard/{id}/sold

URL Params:
``````
	Required
 		id = [long]
``````

Data Params:
	None


Success Response:
[
    {
        "url": "/product/",
        "id": 7,
        "name": "Ratón inalámbrico Razer",
        "description": "Solo lo he usado un mes, tiene el precinto y sus complementos",
        "state": "new",
        "specifications": [
            [
                "CPU",
                "4,1GHZ"
            ],
            [
                "Grafica",
                "GTX 1080"
            ],
            [
                "RAM",
                "6GB"
            ]
        ],
        "tags": [
            "mac",
            "escritorio",
            "ordenador",
            "grande",
            "fino"
        ],
        "price": 35,
        "images": [
            "image-0.jpg"
        ],
        "mainimage": "image-0.jpg",
        "sold": true,
        "date": 1521400609000,
        "category": {
            "url": "/category/",
            "id": 1,
            "name": "Electronica"
        },
        "user": {
            "url": "/user/",
            "id": 2,
            "name": "Juanma",
            "email": "juanma@hotmail.com",
            "location": "Alcorcon",
            "image": "",
            "phone": 45678900,
            "registerDate": 1521400609000,
            "activatedUser": true,
            "isAdmin": false
        },
        "offers": [
            {
                "url": "/offer/",
                "id": 5,
                "date": 1521400609000,
                "price": 50,
                "message": "toma esto, soy Alvaro, quiero ese raton ",
                "state": 1,
                "buyer": {
                    "url": "/user/",
                    "id": 1,
                    "name": "Alvaro",
                    "email": "varo@hotmail.com",
                    "location": "Móstoles",
                    "image": "",
                    "phone": 677654565,
                    "registerDate": 1521400609000,
                    "activatedUser": true,
                    "isAdmin": true
                }
            },
            {
                "url": "/offer/",
                "id": 6,
                "date": 1521401786000,
                "price": 40,
                "message": "",
                "state": 1,
                "buyer": {
                    "url": "/user/",
                    "id": 1,
                    "name": "Alvaro",
                    "email": "varo@hotmail.com",
                    "location": "Móstoles",
                    "image": "",
                    "phone": 677654565,
                    "registerDate": 1521400609000,
                    "activatedUser": true,
                    "isAdmin": true
                }
            }
        ],
        "especifications": [
            [
                "CPU",
                "4,1GHZ"
            ],
            [
                "Grafica",
                "GTX 1080"
            ],
            [
                "RAM",
                "6GB"
            ]
        ]
    }
]

Get Assessments

URL:
	/api/dashboard/{id}/assessment

URL Params:
```
	Required
 		id = [long]
```

Data Params:
	None


Success Response:
[
    {
        "url": "/assessment/",
        "id": 1,
        "text": "Gran vendedor",
        "value": 4,
        "date": 1521410631000,
        "userFrom": {
            "url": "/user/",
            "id": 2,
            "name": "Juanma",
            "email": "juanma@hotmail.com",
            "location": "Alcorcon",
            "image": "",
            "phone": 45678900,
            "registerDate": 1521410630000,
            "activatedUser": true,
            "isAdmin": false
        },
        "userTo": {
            "url": "/user/",
            "id": 1,
            "name": "Alvaro",
            "email": "varo@hotmail.com",
            "location": "Móstoles",
            "image": "",
            "phone": 677654565,
            "registerDate": 1521410630000,
            "activatedUser": true,
            "isAdmin": true
        }
    },
    {
        "url": "/assessment/",
        "id": 2,
        "text": "Gran vendedor, mejor persona",
        "value": 3,
        "date": 1521410631000,
        "userFrom": {
            "url": "/user/",
            "id": 3,
            "name": "David",
            "email": "david.r.3.a@gmail.com",
            "location": "Alcorcon",
            "image": "",
            "phone": 612595959,
            "registerDate": 1521410631000,
            "activatedUser": true,
            "isAdmin": false
        },
        "userTo": {
            "url": "/user/",
            "id": 1,
            "name": "Alvaro",
            "email": "varo@hotmail.com",
            "location": "Móstoles",
            "image": "",
            "phone": 677654565,
            "registerDate": 1521410630000,
            "activatedUser": true,
            "isAdmin": true
        }
    }
]

Get Products With Offers

URL:
	/api/dashboard/{id}/withoffers

URL Params:
```
	Required
 		id = [long]
```

Data Params:
	None


Success Response:
[
    {
        "url": "/product/",
        "id": 24,
        "name": "Macbook Pro 2017",
        "description": "Es mas rapido y potente que antes, pero mas fino y ligero que nunca. Tiene la pantalla con mas color y brillo jamas vista en un portatil Mac. Y viene con la Touch Bar.",
        "state": "new",
        "specifications": [
            [
                "CPU",
                "4,1GHZ"
            ],
            [
                "Grafica",
                "GTX 1080"
            ],
            [
                "RAM",
                "6GB"
            ]
        ],
        "tags": [
            "mac",
            "escritorio",
            "ordenador",
            "grande",
            "fino"
        ],
        "price": 1900,
        "images": [
            "image-0.jpg"
        ],
        "mainimage": "image-0.jpg",
        "sold": false,
        "date": 1521410631000,
        "category": {
            "url": "/category/",
            "id": 1,
            "name": "Electronica"
        },
        "user": {
            "url": "/user/",
            "id": 1,
            "name": "Alvaro",
            "email": "varo@hotmail.com",
            "location": "Móstoles",
            "image": "",
            "phone": 677654565,
            "registerDate": 1521410630000,
            "activatedUser": true,
            "isAdmin": true
        },
        "offers": [
            {
                "url": "/offer/",
                "id": 1,
                "date": 1521410631000,
                "price": 60,
                "message": "Quiero este precio",
                "state": 0,
                "buyer": {
                    "url": "/user/",
                    "id": 2,
                    "name": "Juanma",
                    "email": "juanma@hotmail.com",
                    "location": "Alcorcon",
                    "image": "",
                    "phone": 45678900,
                    "registerDate": 1521410630000,
                    "activatedUser": true,
                    "isAdmin": false
                }
            },
            {
                "url": "/offer/",
                "id": 2,
                "date": 1521410631000,
                "price": 700,
                "message": "Te ofrezco esto Alvaro, soy David",
                "state": 0,
                "buyer": {
                    "url": "/user/",
                    "id": 3,
                    "name": "David",
                    "email": "david.r.3.a@gmail.com",
                    "location": "Alcorcon",
                    "image": "",
                    "phone": 612595959,
                    "registerDate": 1521410631000,
                    "activatedUser": true,
                    "isAdmin": false
                }
            },
            {
                "url": "/offer/",
                "id": 3,
                "date": 1521410631000,
                "price": 850,
                "message": "toma esto, no subo mas, soy Juanma por cierto",
                "state": 0,
                "buyer": {
                    "url": "/user/",
                    "id": 2,
                    "name": "Juanma",
                    "email": "juanma@hotmail.com",
                    "location": "Alcorcon",
                    "image": "",
                    "phone": 45678900,
                    "registerDate": 1521410630000,
                    "activatedUser": true,
                    "isAdmin": false
                }
            }
        ],
        "especifications": [
            [
                "CPU",
                "4,1GHZ"
            ],
            [
                "Grafica",
                "GTX 1080"
            ],
            [
                "RAM",
                "6GB"
            ]
        ]
    }
]

Get Products Buyed By User

URL:
	/api/dashboard/{id}/buyed

URL Params:
```
	Required
 		id = [long]
```

Data Params:
	None


Success Response:

[
    {
        "url": "/product/",
        "id": 23,
        "name": "Play Station 4",
        "description": "Me la regalaron y no la necesito esta completamente nueva",
        "state": "new",
        "specifications": [
            [
                "CPU",
                "4,1GHZ"
            ],
            [
                "Grafica",
                "GTX 1080"
            ],
            [
                "RAM",
                "6GB"
            ]
        ],
        "tags": [
            "mac",
            "escritorio",
            "ordenador",
            "grande",
            "fino"
        ],
        "price": 400,
        "images": [
            "image-0.jpg"
        ],
        "mainimage": "image-0.jpg",
        "sold": true,
        "date": 1521410631000,
        "category": {
            "url": "/category/",
            "id": 4,
            "name": "Videojuegos"
        },
        "user": {
            "url": "/user/",
            "id": 2,
            "name": "Juanma",
            "email": "juanma@hotmail.com",
            "location": "Alcorcon",
            "image": "",
            "phone": 45678900,
            "registerDate": 1521410630000,
            "activatedUser": true,
            "isAdmin": false
        },
        "offers": [
            {
                "url": "/offer/",
                "id": 4,
                "date": 1521410631000,
                "price": 950,
                "message": "toma esto, no subo mas, soy Alvaro ",
                "state": 1,
                "buyer": {
                    "url": "/user/",
                    "id": 1,
                    "name": "Alvaro",
                    "email": "varo@hotmail.com",
                    "location": "Móstoles",
                    "image": "",
                    "phone": 677654565,
                    "registerDate": 1521410630000,
                    "activatedUser": true,
                    "isAdmin": true
                }
            }
        ],
        "especifications": [
            [
                "CPU",
                "4,1GHZ"
            ],
            [
                "Grafica",
                "GTX 1080"
            ],
            [
                "RAM",
                "6GB"
            ]
        ]
    }
]
Get friends Requests

URL:
	/api/dashboard/{id}/friendsRequests

URL Params:
```
	Required
 		id = [long]
```

Data Params:
	None


Success Response:
[
    {
        "url": "/friend_request/",
        "id": 2,
        "message": "Hola",
        "state": "pending",
        "creationDate": 1521410631000,
        "from": {
            "url": "/user/",
            "id": 3,
            "name": "David",
            "email": "david.r.3.a@gmail.com",
            "location": "Alcorcon",
            "image": "",
            "phone": 612595959,
            "registerDate": 1521410631000,
            "activatedUser": true,
            "isAdmin": false
        },
        "to": {
            "url": "/user/",
            "id": 2,
            "name": "Juanma",
            "email": "juanma@hotmail.com",
            "location": "Alcorcon",
            "image": "",
            "phone": 45678900,
            "registerDate": 1521410630000,
            "activatedUser": true,
            "isAdmin": false
        }
    }
]

Accept Offer

URL:
	/api/dashboard/{id}/acceptoffer/{offer_id}

URL Params:
```
	Required
 		id = [long]
		offer_id = [long]
```

Data Params:
	None

Success Response: 200 OK

Decline Offer

URL:
	/api/dashboard/{id}/canceltoffer/{offer_id}

URL Params:
```
	Required
 		id = [long]
		offer_id = [long]
```

Data Params:
	None

Success Response: 200 OK


Decline Friend

URL:
	/api/dashboard/{id}/declineFriendRequest/{friend_id}

URL Params:
```
	Required
 		id = [long]
		friend_id = [long]
```

Data Params:
	None

Success Response: 200 OK


Accept Friend Request

URL:
	/api/dashboard/{id}/acceptFriendRequest/{friend_id}

URL Params:
```
	Required
 		id = [long]
		friend_id = [long]
```

Data Params:
	None

Success Response: 200 OK


Get Friends

URL:
	/api/dashboard/{id}/getFriends/

URL Params:
```
	Required
 		id = [long]
```

Data Params:
	None

Success Response: 



Add Assessment

URL:
	/api/dashboard/{id}/addAssessment/{id_to}
	
Method:
 ```
 POST
 ```

URL Params:
```
	Required
 		id = [long]
		id_tio = [long]
```

Data Params:
{
	"text" : "Muy buen vendedor. Todo perfecto",
	"value" : "5"
}

Success Response: 200 OK








Get Offer by ID: 

URL:
	/api/offer/{id}

URL Params:
```
	Required
 		id = [long]
```

Data Params:
	None

Success Response: 

{
    "url": "/offer/",
    "date": 1521414688000,
    "price": 700,
    "message": "Te ofrezco esto Alvaro, soy David",
    "state": 0
}








Get Category by ID: 

URL:
	/api/category/{id}

URL Params:
```
	Required
 		id = [long]
```

Data Params:
	None

Success Response: 

{
    "url": "/category/",
    "name": "Electronica"
}








Get Category by product: 

URL:
	/api/category/product/{id}

URL Params:
```
	Required
 		id = [long]
```

Data Params:
	None

Success Response: 

{
    "url": "/category/",
    "name": "Inmobiliaria"
}









Get products by category:  

URL:
	/api/products/category/{id}

URL Params:
```
	Required
 		id = [long]
```

Data Params:
	None

Success Response: 

    {
        "url": "/product/",
        "id": 1,
        "name": "Escritorio",
        "description": "Escritorio de mesa con gran capacidad de\r\n\t\t\t\t\t\t\t\tespacio",
        "state": "new",
        "specifications": [
            [
                "CPU",
                "4,1GHZ"
            ],
            [
                "Grafica",
                "GTX 1080"
            ],
            [
                "RAM",
                "6GB"
            ]
        ],
        "tags": [
            "mac",
            "escritorio",
            "ordenador",
            "grande",
            "fino"
        ],
        "price": 800,
        "images": [
            "image-0.jpg"
        ],
        "mainimage": "image-0.jpg",
        "sold": false,
        "date": 1521414687000
    },
    {
        "url": "/product/",
        "id": 2,
        "name": "Escritorio Pequeño",
        "description": "Escritorio de mesa para habitaciones\r\n\t\t\t\t\t\t\t\tpequeñas",
        "state": "new",
        "specifications": [
            [
                "CPU",
                "4,1GHZ"
            ],
            [
                "Grafica",
                "GTX 1080"
            ],
            [
                "RAM",
                "6GB"
            ]
        ],
        "tags": [
            "mac",
            "escritorio",
            "ordenador",
            "grande",
            "fino"
        ],
        "price": 300,
        "images": [
            "image-0.jpg"
        ],
        "mainimage": "image-0.jpg",
        "sold": false,
        "date": 1521414687000
    }










