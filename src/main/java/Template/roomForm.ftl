<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
  <title>Room</title>
</head>
<body>
<div class="alert alert-danger" role="alert">
  ${ message }
</div>
<div class="container">
  <form method="post">
    <div class="form-row">
      <div class="form-group col-md-6">
        <label for="inputEmail4">Room Width</label>
        <input type="text" class="form-control" name="width" placeholder="Width">
      </div>
      <div class="form-group col-md-6">
        <label for="inputPassword4">Room Height</label>
        <input type="text" class="form-control" name="height" placeholder="Height">
      </div>
    </div>
    <label for="inputEmail4">Floor Type</label>
    <div class="form-group col-md-4">
      <select name="floor_type" class="form-control">
        <#list floor_types as type>
          <option>${type}</option>
        </#list>
      </select>
    </div>
    <label for="inputEmail4">Color</label>
    <div class="form-group col-md-4">
      <select name="color" class="form-control">
        <#list colors as c>
          <option>${c}</option>
        </#list>
      </select>
    </div>


    <div class="form-row">
      <div class="form-group col-md-6">
        <label for="worker_count">Worker count</label>
        <input type="text" class="form-control" name="worker_count" placeholder="Workers">
      </div>

      <div class="form-group col-md-2">
        <label for="salary">Salary per worker</label>
        <input type="text" class="form-control" name="salary" placeholder="Salary">
      </div>
    </div>
    <div class="form-group col-md-4">
      <button type="submit" class="btn btn-primary">Calculate</button>
    </div>
  </form>
  <div class="container" style="float: right">
    <h1></h1>
    <a href="/rooms/" class="alert-info container align-bottom bg-info text-uppercase bg-danger">See The Whole List</a>
  </div>


</div>

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>



