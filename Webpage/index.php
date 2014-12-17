<html> 
<link rel="stylesheet" href="style.css">

<head>
	<title>Startup Database </title>	
</head>

<body>
	<div class = "header">
		
    <h1 style = "padding-top:30px">Final Database Project</h1>
    <h2 style = "padding-bottom:-10px">By Daniel Jalova and Samantha Siow</h2>

    	<div class = "searchBox">
			<form action="action_page.php">
			<input type="text" name="result" value="">	
			<input type="submit" value="Submit">
			</form>

		</div>

	</div>

	<div id = "content">
		<table class = "results">
			<colgroup>
				<col class = "SSN">
				<col class = "LName">
				<col class = "FName">
			</colgroup>

			<tr>

			<th> SSN </th>
			<th> LName </th>
			<th> FName </th>

			</tr>

			<?php
			include 'conf.php';
	    	include 'open.php';

	    	$sql    = 'SELECT * FROM Rawscores WHERE SSN != 0001 AND SSN != 0002 ORDER BY Section DESC, Lname ASC, Fname ASC';
	        $result = mysqli_query($conn, $sql);

	        // check if the query successfully executed
	        if (!$result) {
	            echo "DB Error, could not query the database. :-( <br/>";
	            echo 'MySQL Error: ' . mysql_error() . '<br/>';
	            exit;
	        }

		    while ($row = mysqli_fetch_assoc($result)) {
	            echo '<tr>' ;
	            echo '<td>' . '<a href=' . ' " ' . 'report.php?startupID=' . $row['SSN'] . ' " ' . '>' . $row['SSN'] . '</a>' . '</td>' ;
	            echo '<td>' . $row['LName'] .  '</td>';
	            echo '<td>' . $row['FName'] .  '</td>';
	            echo '</tr>';
			}

			?>

		</table>
	</div>
	
</body>     
</html> 


