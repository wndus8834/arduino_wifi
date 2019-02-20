<?php
session_start();
header("Content-Type: text/html; charset=UTF-8");
$parknum=$_REQUEST["parknum"];
$onoff=$_REQUEST["onoff"];


include_once "config.php";
$conn=mysql_connect(DB_HOST,DB_USER,DB_PASSWORD) or die("failed connection");

mysql_select_db(DB_NAME,$conn)or die("failed db connection");
mysql_query("set names utf8");



$query="select * from letspark";

$return_arr=array();

$result=@mysql_query($query,$conn);



while ($row = mysql_fetch_array($result, MYSQL_ASSOC))
{
  $row_array['parknum'] = $row['parknum'];
  $row_array['onoff'] = $row['onoff'];
  $row_array['dt'] = $row['dt'];
  $row_array['phone'] = $row['id'];
    array_push($return_arr, $row_array);
}
echo json_encode($return_arr);

// 	while($row=mysql_fetch_array(mysql_query($query,$conn))){
// 		$row_arr["parknum"]=$row["parknum"];
// 		$row_arr["onoff"]=$row["onoff"];
// 		array_push($return_arr,$row_arr);

// 	}

// echo json_encode($return_arr);


	











?>
