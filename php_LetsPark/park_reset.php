<?php
session_start();
header("Content-Type: text/html; charset=UTF-8");
$parknum=$_REQUEST["parknum"];
$onoff=$_REQUEST["onoff"];


include_once "config.php";
$conn=mysql_connect(DB_HOST,DB_USER,DB_PASSWORD) or die("failed connection");

mysql_select_db(DB_NAME,$conn)or die("failed db connection");
mysql_query("set names utf8");


mysql_query("update letspark set onoff='off',dt=now(),id=' '" );




?>
