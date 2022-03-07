## Add Movie page

**Request Get "/"**

````http request
GET http://localhost:8080/
````

**Response**

````html
<!DOCTYPE html>
<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
    <title>Add new Movie</title>
</head>
<body>

<h1>Add movie</h1>
<form action="http://localhost:8080/" method="post">
    <p>Movie name: <input type="text" name="name"></p>
    <p><input type="submit" value="Submit"></p>
</form>

</body></html>
````

**Request Post "/"**

````http request
POST http://localhost:8080/
````

**Response**

````html

<!DOCTYPE HTML>
<html>
<head>
    <title>Getting Started: Handling Form Submission</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
<h1>Movies</h1>
<table>
    <thead>
    <tr>
        <th scope="col"></th>
        <th scope="col">Movie name</th>
    </tr>
    </thead>
    <tbody>
        <tr>
            <td>7</td>
            <td>newMovie</td>
        </tr>
    </tbody>
</table>
<a href="/;jsessionid=E8FE76BF0C2C2F5B64FE1B7A1D34F397">Add Movie</a>
</body>
</html>
````
**Request Post "/addMovieByPath/{name}"**

````http request
POST http://localhost:8080/addMovieByPath/Avengers
````

**Response**

````html

<!DOCTYPE HTML>
<html>
<head>
    <title>Getting Started: Handling Form Submission</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
<h1>Movies</h1>
<table>
    <thead>
    <tr>
        <th scope="col"></th>
        <th scope="col">Movie name</th>
    </tr>
    </thead>
    <tbody>
        <tr>
            <td>7</td>
            <td>newMovie</td>
        </tr>
        <tr>
            <td>8</td>
            <td>Avengers</td>
        </tr>
    </tbody>
</table>
<a href="/">Add Movie</a>
</body>
</html>
````