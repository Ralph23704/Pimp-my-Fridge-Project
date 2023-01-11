//variable pour la sonde DHT12
#include "DHT.h"
#include "stdlib.h"
#define DHTPIN 2  // Pin où est branché la sonde
#define DHTTYPE DHT22   //définition du type de la sonde (DHT11, DHT22, ...)
// Initialisation de la sonde.
DHT dht(DHTPIN, DHTTYPE);


void setup() {
  Serial.begin(9600);
  pinMode(5, OUTPUT); //Défintion du PIN 5 de l'Arduino en mode sortie/
  dht.begin();
}
  double Thermister(int RawADC) {
  double Temp;
  // See http://en.wikipedia.org/wiki/Thermistor for explanation of formula
  Temp = log(((10240000/RawADC) - 10000));
  Temp = 1 / (0.00148144 + (0.00026268 * Temp) + (0.00000017572 * Temp * Temp * Temp));
  Temp = Temp - 273.15;           // Convert Kelvin to Celcius
  return Temp;
}

void loop() {

  //Déclaration des tableaux pour envoyer les résultats sur le port série pour l'interface java
  char humidite[10]; 
  char tempint[10];
  char tempext[10];
  char erreur[10]; 

  float h = dht.readHumidity();  //Lecture de l'hygrométrie sur la sonde DHT22
  
  float t = dht.readTemperature();  //Lecture de la température sur la sonde DHT22

  double tempq = Thermister(analogRead(0));  // Read sensor;
 

  
  // Boucle pour vérifier que la sonde DHT22 est bien branché
  if (isnan(h) || isnan(t)) {
    Serial.println("La sonde DHT22 n'est pas branché");
    return;
  }
  
 
  int temperatureconsigne = 0; //Déclaration de Consigne
  temperatureconsigne = Serial.read(); //On récupére la consigne de tempéarature envoyer de l'interface java
  
  snprintf(humidite, 10, "%f", h);
  snprintf(tempint, 10, "%f", t);
  snprintf(tempext, 10, "%f", tempq);
  String tempsext = String(tempq);
  String humidite = String(h);
  String tempsint = String(t);
  String pie = "jambon";
  String finale = (humidite + pie + tempsint + pie + tempsext);
    
  
  if ( temperatureconsigne == 1) {
    digitalWrite(5, HIGH); // Allume le module peltier

    }
   else if(consigne == 0) {
  digitalWrite(5, LOW); // Eteind le module peltier
    }

    
  Serial.println(finale);
 
  delay(2000);
}
