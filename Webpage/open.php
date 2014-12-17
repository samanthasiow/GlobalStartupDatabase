<?php

$conn = new mysqli($dbhost, $dbuser, $dbpass); 
if (!$conn) {
    die ('Error connecting to mysql. :-( <br/>');
} 
else {
 //echo 'Yes, we have connected to MySQL! :-) <br/>';
}


if (!mysqli_select_db($conn, $dbname)) {
    echo 'Sorry, could not select database. :-(';
    exit;
}
else {
    //echo 'We have selected the database too! :-)' . '<br/>';
}

?>