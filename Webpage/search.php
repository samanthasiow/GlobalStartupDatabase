<html> 
<link rel="stylesheet" href="style.css">

<head>
	<title>Startup Database </title>	
</head>

<body>
	<div class = "header">
		
    <h1 style = "padding-top:30px"> Final Database Project </h1>
    <h2 style = "padding-bottom:-10px">By Daniel Jalova and Samantha Siow</h2>

    	<div class = "searchBox">
			<form action="search.php">
			<input type="text" name="result" value="">	
			<input type="submit" value="Startup Search">
			</form>
		</div>

	</div>

	<?php
		include 'conf.php';
	    include 'open.php';
	    $name = $_GET['result'];
	    echo $name;
	    $sql    = 'CALL ShowStartupIDByName("' . $name .  '")';
	    $result = mysqli_query($conn, $sql);
		
			if (!$result) {
	            echo "No Startup exists with that name.<br/>";
	            exit;
	        }

	        $row = mysqli_fetch_assoc($result);
	        
	        header('Location: ' . 'report.php?startupID='.$row['id']);
	        die();
	?>

	
</body>     
</html> 


