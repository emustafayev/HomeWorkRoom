
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Document</title>
  <link rel="stylesheet" href="/Static/room.css">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<div class="container">
  <h1 class="align-self-center" style="text-align: center">Room List</h1>
  <table class="table table-hover">
    <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Area</th>
      <th scope="col">Floor Type</th>
      <th scope="col">Color</th>
      <th scope="col">price</th>
    </tr>
    </thead>
    <tbody>
    <#list rooms as room>
      <tr>
        <th scope="row">${room.ID}</th>
        <td>${room.area}</td>
        <td>${room.floor}</td>
        <td>${room.color}</td>
        <td>${room.price}</td>
      </tr>
    </#list>
        </tbody>
  </table>
  <a href="/home/" class="alert-info container align-bottom bg-info text-uppercase bg-danger">Back To Home</a>
</div>
</body>
</html>

