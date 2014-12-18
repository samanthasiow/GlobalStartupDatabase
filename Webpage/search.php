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

	<div class = "content">
		<div class = "profile">
			<?php
				include 'conf.php';
			    include 'open.php';
			    $name = $_GET['result'];
			    $sql    = 'CALL ShowStartupIDByName("' . $name .  '")';
			    $result = mysqli_query($conn, $sql);
				
			        if (!$result) {
			            echo "DB Error, could not query the database. :-( <br/>";
			            echo 'MySQL Error: ' . mysql_error() . '<br/>';
			            exit;
			        }

			        $row = mysqli_fetch_assoc($result);

					if ( !is_null($row['Error Message']) ) {
			            echo "No Startup exists with that name.<br/>";
			            printf(' <a href="index.php">Return Home</a> ');
			            exit;
			        }

			        else {
			        	$row = mysqli_fetch_assoc($result);	        
			        	header('Location: ' . 'report.php?startupID='.$row['id']);
			        	die();
			    	}	        
			?>
		<div>
	</div>


	
</body>     
</html> 


