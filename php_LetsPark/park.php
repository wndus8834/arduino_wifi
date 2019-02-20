<?php
session_start();
header("Content-Type: text/html; charset=UTF-8");
$parknum=$_REQUEST["parknum"];
$onoff=$_REQUEST["onoff"];


include_once "config.php";
$conn=mysql_connect(DB_HOST,DB_USER,DB_PASSWORD) or die("failed connection");

mysql_select_db(DB_NAME,$conn)or die("failed db connection");
mysql_query("set names utf8");

$query="select * from givelove_user where id='".$id."'";

$query="select * from letspark where parknum='".$parknum."'";

$result1=mysql_fetch_array(mysql_query($query,$conn));
// 주차장 넘버에 맞는 현재 상태 가져오기
echo $result1[1];
echo $onoff;

	if(strcmp($result1[1],$onoff)){
		//아두이노에서 뿌려준 값하고 서버에 있는 값 과 다를 경우  ==   이전에 저장되어있는 값이 바뀌 었을 경우   on > off   ,  off >on
		// 이 경우에는 날짜와 현재 상태를 바꿔 준다.
		mysql_query("update letspark set onoff='".$onoff."',dt=now() where parknum='".$parknum."'");
		echo "z";

	}
	;


// $size=mysql_num_rows(mysql_query($query,$conn));
// if($size==0){
// 	echo "y";
// }
// else{ echo "n";}










?>
