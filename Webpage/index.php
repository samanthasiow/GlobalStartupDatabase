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


	<div align="center" class = "dropDown">

		<form name="myform" action="index.php" method="POST">
			<select name="location">
				<option disabled="disabled" selected="selected">Select a location.</option>				

				<?php
					include 'conf.php';
			    	include 'open.php';

			    	$sql    = 'SELECT DISTINCT location FROM StartupLocation ORDER BY location ASC';
			        $result = mysqli_query($conn, $sql);

			        // check if the query successfully executed
			        if (!$result) {
			            echo "DB Error, could not query the database. :-( <br/>";
			            echo 'MySQL Error: ' . mysql_error() . '<br/>';			            
			        }

				    while ($row = mysqli_fetch_assoc($result)) {
			            echo '<option value=' . '"' . $row[location] . '"' . '>' . $row[location] . "</option>";
					}
				?>

			</select>
			<input type="submit" value="Filter by Location" />

			<select name="market">
				<option disabled="disabled" selected="selected">Select a market.</option>	
				<?php
					include 'conf.php';
			    	include 'open.php';

			    	$sql    = 'SELECT DISTINCT market FROM StartupMarkets ORDER BY market ASC';
			        $result = mysqli_query($conn, $sql);

			        // check if the query successfully executed
			        if (!$result) {
			            echo "DB Error, could not query the database. :-( <br/>";
			            echo 'MySQL Error: ' . mysql_error() . '<br/>';			            
			        }

				    while ($row = mysqli_fetch_assoc($result)) {
			            echo '<option value=' . '"' . $row['market'] . '"' . '>' . $row['market'] . "</option>";
					}
				?>

			</select>
			<input type="submit" value="Filter by Market" />

			<input type="submit" value="Reset" />

		</form>

	</div>

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
	
	    	if ( isset($_POST['location']) ) {
	    		$sql = 'CALL ShowStartupByLocation(' . '"'. $_POST['location'] . '"' .')';
	    	}

	    	else if ( isset($_POST['market']) ) {
	    		$sql = 'CALL ShowStartupByMarket(' . '"'. $_POST['market'] . '"' .')';
	    	}

	    	else {
	    		$sql = 'CALL AllStartupListings()';
	    	}

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
-