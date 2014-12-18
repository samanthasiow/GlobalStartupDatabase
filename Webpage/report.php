<html> 
<link rel="stylesheet" href="style.css">

<head>
	<title>Startup Database </title>	
</head>

<body>
	<div class = "header">
		
    <h1 style = "padding-top:30px"> Final Database Project</h1>
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
		    $id = $_GET['startupID'];

		    $sql    = 'CALL GetStartupInfoByID(' . $id .  ')';
		    $result = mysqli_query($conn, $sql);
			
	        // check if the query successfully executed
	        if (!$result) {
	            echo "DB Error, could not query the database. :-( <br/>";
	            echo 'MySQL Error: ' . mysql_error() . '<br/>';
	            exit;
	        }

		    while ($row = mysqli_fetch_assoc($result)) {            
	            echo '<p>' . '<img class = "logo" src=' . ' " ' .  $row['imgURL'] . ' " ' . ' style=width:75px;height:75px>' ;
	            echo '<a class = "name">' . $row['StartupName'] . '<br/></a>';	           
	            echo $row['HighConcept'] .  '</p>';
			}
		?>
		</div>

		<div class = "founders">

			<p class = "sectionTitle"> Founders </p>

			<?php
			include 'conf.php';
		    include 'open.php';
		    $id = $_GET['startupID'];

		    $sql    = 'CALL ShowRolesByStartupID(' . $id .  ', "founder")';
		    $result = mysqli_query($conn, $sql);
			
	        // check if the query successfully executed
	        if (!$result) {
	            echo "DB Error, could not query the database. :-( <br/>";
	            echo 'MySQL Error: ' . mysql_error() . '<br/>';
	            exit;
	        }

		    while ($row = mysqli_fetch_assoc($result)) {            
	            echo '</p> <a class = "name">' . $row['Name'] . '<br/></a></p>';
			}
		?>
		</div>

		<div class = "investors">

			<p class = "sectionTitle"> Investors </p>

			<?php
			include 'conf.php';
		    include 'open.php';
		    $id = $_GET['startupID'];

		    $sql    = 'CALL ShowRolesByStartupID(' . $id .  ', "past_investor")';
		    $result = mysqli_query($conn, $sql);
			
	        // check if the query successfully executed
	        if (!$result) {
	            echo "DB Error, could not query the database. :-( <br/>";
	            echo 'MySQL Error: ' . mysql_error() . '<br/>';
	            exit;
	        }

		    while ($row = mysqli_fetch_assoc($result)) {            
	            echo '</p> <a class = "name">' . $row['Name'] . '<br/></a></p>';
			}
		?>
		</div>

		<div class = "employees">

			<p class = "sectionTitle"> Employees </p>

			<?php
			include 'conf.php';
		    include 'open.php';
		    $id = $_GET['startupID'];

		    $sql    = 'CALL ShowRolesByStartupID(' . $id .  ', "employee")';
		    $result = mysqli_query($conn, $sql);
			
	        // check if the query successfully executed
	        if (!$result) {
	            echo "DB Error, could not query the database. :-( <br/>";
	            echo 'MySQL Error: ' . mysql_error() . '<br/>';
	            exit;
	        }

		    while ($row = mysqli_fetch_assoc($result)) {            
	            echo '</p> <a class = "name">' . $row['Name'] . '<br/></a></p>';
			}
		?>
		</div>


	</div>

</body>

</html>