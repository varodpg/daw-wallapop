# RELEVANT INFORMATION
All API queries must be preceded by /api

Searches
Below are queries regarding the search for offers

User

Add new user

Add a user to the system.

## URL:

/users

## Method:
```
POST
```

## Data param:
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

## Success response:
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
