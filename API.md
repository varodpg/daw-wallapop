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