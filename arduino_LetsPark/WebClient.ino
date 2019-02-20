
#include <SPI.h>
#include "WizFi250.h"

int in1 = A0;
int in2 = A1;
int in3 = A2;
int in4 = A3;
int in5 = A4;
int in6 = A5;

int n1,n2,n3,n4,n5,n6;

char ssid[] = "U+Net6B1C";    // your network SSID (name)
char pass[] = "1000000147";          // your network password
int status = WL_IDLE_STATUS;       // the Wifi radio's status
char server[] = "dna110.dothome.co.kr";
// Initialize the Ethernet client object
WiFiClient client;

void printWifiStatus();

void setup() {
  Serial.begin(9600);
  WiFi.init();
    // check for the presence of the shield
    if (WiFi.status() == WL_NO_SHIELD) {
      Serial.println("WiFi shield not present");
      // don't continue
      while (true);
    }
    // attempt to connect to WiFi network
    while ( status != WL_CONNECTED) {
      Serial.print("Attempting to connect to WPA SSID: ");
      Serial.println(ssid);
      // Connect to WPA/WPA2 network
      status = WiFi.begin(ssid, pass);
    }
    // you're connected now, so print out the data
    Serial.println("You're connected to the network");
    printWifiStatus();
    
    pinMode(in1, INPUT);
    pinMode(in2, INPUT);
    pinMode(in3, INPUT);
    pinMode(in4, INPUT);
    pinMode(in5, INPUT);
    pinMode(in6, INPUT);
    n1 = 0;
    n2 = 0;
    n3 = 0;
    n4 = 0;
    n5 = 0;
    n6 = 0;
}

void loop() {

     if(n1 == 0) {
                   if(digitalRead(in1) == LOW) {
                   n1 = 1;
                   if (client.connect(server, 80)) {
                   client.print("GET /work/letspark/park_insert.php?parknum=5&onoff=on");
                   client.println(" HTTP/1.1");
                   client.println("Host: dna110.dothome.co.kr");
                   client.println("Connection: close");
                   client.println();
                   Serial.println("5on");
                   }
                 }
             }
     else {
             if(digitalRead(in1) == HIGH) {
                   n1 = 0;
                   if (client.connect(server, 80)) {
                   client.print("GET /work/letspark/park_insert.php?parknum=5&onoff=off");
                   client.println(" HTTP/1.1");
                   client.println("Host: dna110.dothome.co.kr");
                   client.println("Connection: close");
                   client.println();
                   Serial.println("5off");
                   }
                 }
             }
//----------------------------------------------------------------------------------------
if(n2 == 0) {
                   if(digitalRead(in2) == LOW) {
                   n2 = 1;
                   if (client.connect(server, 80)) {
                   client.print("GET /work/letspark/park_insert.php?parknum=3&onoff=on");
                   client.println(" HTTP/1.1");
                   client.println("Host: dna110.dothome.co.kr");
                   client.println("Connection: close");
                   client.println();
                   Serial.println("3on");
                   }
                 }
             }
     else {
             if(digitalRead(in2) == HIGH) {
                   n2 = 0;
                   if (client.connect(server, 80)) {
                   client.print("GET /work/letspark/park_insert.php?parknum=3&onoff=off");
                   client.println(" HTTP/1.1");
                   client.println("Host: dna110.dothome.co.kr");
                   client.println("Connection: close");
                   client.println();
                   Serial.println("3off");
                   }
                 }
             }
//----------------------------------------------------------------------------------------
if(n3 == 0) {
                   if(digitalRead(in3) == LOW) {
                   n3 = 1;
                   if (client.connect(server, 80)) {
                   client.print("GET /work/letspark/park_insert.php?parknum=1&onoff=on");
                   client.println(" HTTP/1.1");
                   client.println("Host: dna110.dothome.co.kr");
                   client.println("Connection: close");
                   client.println();
                   Serial.println("1on");
                   }
                 }
             }
     else {
             if(digitalRead(in3) == HIGH) {
                   n3 = 0;
                   if (client.connect(server, 80)) {
                   client.print("GET /work/letspark/park_insert.php?parknum=1&onoff=off");
                   client.println(" HTTP/1.1");
                   client.println("Host: dna110.dothome.co.kr");
                   client.println("Connection: close");
                   client.println();
                   Serial.println("1off");
                   }
                 }
             }
//----------------------------------------------------------------------------------------
if(n4 == 0) {
                   if(digitalRead(in4) == LOW) {
                   n4 = 1;
                   if (client.connect(server, 80)) {
                   client.print("GET /work/letspark/park_insert.php?parknum=6&onoff=on");
                   client.println(" HTTP/1.1");
                   client.println("Host: dna110.dothome.co.kr");
                   client.println("Connection: close");
                   client.println();
                   Serial.println("6on");
                   }
                 }
             }
     else {
             if(digitalRead(in4) == HIGH) {
                   n4 = 0;
                   if (client.connect(server, 80)) {
                   client.print("GET /work/letspark/park_insert.php?parknum=6&onoff=off");
                   client.println(" HTTP/1.1");
                   client.println("Host: dna110.dothome.co.kr");
                   client.println("Connection: close");
                   client.println();
                   Serial.println("6off");
                   }
                 }
             }
//----------------------------------------------------------------------------------------
if(n5 == 0) {
                   if(digitalRead(in5) == LOW) {
                   n5 = 1;
                   if (client.connect(server, 80)) {
                   client.print("GET /work/letspark/park_insert.php?parknum=4&onoff=on");
                   client.println(" HTTP/1.1");
                   client.println("Host: dna110.dothome.co.kr");
                   client.println("Connection: close");
                   client.println();
                   Serial.println("4on");
                   }
                 }
             }
     else {
             if(digitalRead(in5) == HIGH) {
                   n5 = 0;
                   if (client.connect(server, 80)) {
                   client.print("GET /work/letspark/park_insert.php?parknum=4&onoff=off");
                   client.println(" HTTP/1.1");
                   client.println("Host: dna110.dothome.co.kr");
                   client.println("Connection: close");
                   client.println();
                   Serial.println("4off");
                   }
                 }
             }
//----------------------------------------------------------------------------------------
if(n6 == 0) {
                   if(digitalRead(in6) == LOW) {
                   n6 = 1;
                   if (client.connect(server, 80)) {
                   client.print("GET /work/letspark/park_insert.php?parknum=2&onoff=on");
                   client.println(" HTTP/1.1");
                   client.println("Host: dna110.dothome.co.kr");
                   client.println("Connection: close");
                   client.println();
                   Serial.println("2on");
                   }
                 }
             }
     else {
             if(digitalRead(in6) == HIGH) {
                   n6 = 0;
                   if (client.connect(server, 80)) {
                   client.print("GET /work/letspark/park_insert.php?parknum=2&onoff=off");
                   client.println(" HTTP/1.1");
                   client.println("Host: dna110.dothome.co.kr");
                   client.println("Connection: close");
                   client.println();
                   Serial.println("2off");
                   }
                 }
             }
//----------------------------------------------------------------------------------------
delay(100);

        
    //while (client.available()) {char c = client.read();Serial.write(c);}
    // if the server's disconnected, stop the client
    /*if (!client.connected()) {
        Serial.println();
        Serial.println("Disconnecting from server...");
        client.stop();
        // do nothing forevermore
        while (true);
        }*/
}

void printWifiStatus() {
  // print the SSID of the network you're attached to
  Serial.print("SSID: ");
  Serial.println(WiFi.SSID());

  // print your WiFi shield's IP address
  IPAddress ip = WiFi.localIP();
  Serial.print("IP Address: ");
  Serial.println(ip);

  // print the received signal strength
  long rssi = WiFi.RSSI();
  Serial.print("Signal strength (RSSI):");
  Serial.print(rssi);
  Serial.println(" dBm");
}


