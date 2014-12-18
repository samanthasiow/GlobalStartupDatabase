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

<!--
	<form name="myform" action="index.php" method="POST">
		<div align="center">
			<select name="mydropdown">
				<option value="Milk">Fresh Milk</option>
				<option value="Cheese">Old Cheese</option>
				<option value="Bread">Hot Bread</option>
			</select>
		</div>
	</form>
-->
	<div id = "content">
		<table class = "results">
			<colgroup>
				<col class = "thumbnail">
				<col class = "Startup Name">
				<col class = "Description">
				<col class = "Website">
			</colgroup>

			<tr>

			<th>  </th>
			<th> Startup Name </th>
			<th> Description </th>
			<th> Company Link </th>

			</tr>

			<?php
			include 'conf.php';
	    	include 'open.php';

	    	$sql    = 'CALL AllStartupListings()';
	        $result = mysqli_query($conn, $sql);

	        // check if the query successfully executed
	        if (!$result) {
	            echo "DB Error, could not query the database. :-( <br/>";
	            echo 'MySQL Error: ' . mysql_error() . '<br/>';
	            exit;
	        }

		    while ($row = mysqli_fetch_assoc($result)) {
	            echo '<tr>' ;
	            echo '<td>' . '<img src=' . ' " ' .  $row['imgURL'] . ' " ' . ' style=width:50px;height:50>' . '</td>' ;
	            echo '<td>' . '<a href=' . ' " ' . 'report.php?startupID=' . $row['id'] . ' " ' . '>' . $row['StartupName'] . '</a>' . '</td>' ;	           
	            echo '<td>' . $row['HighConcept'] .  '</td>';
	            echo '<td align = "center">' . '<a href=' . ' " ' . $row['URL'] . ' "> '  . 'Link </a>' . '</td>' ;
	            echo '</tr>';
			}

			?>

		</table>
	</div>
	
</body>    
</html> 
