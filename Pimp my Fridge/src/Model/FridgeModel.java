package Model;

import java.util.ArrayList;

import javax.security.auth.callback.Callback;

public class FridgeModel {
	

private float temperatureint;
private float temperatureext;
private float temperatureconsigne;
private float humidite;
private int id;


public FridgeModel(float temperatureint,float temperatureext,float temperatureconsigne,float humidite,int id){
	this.temperatureconsigne = temperatureconsigne;
	this.humidite = humidite;
	this.setId(id);
	this.temperatureint = temperatureint;
	this.temperatureext = temperatureext;
}

public float getTemperatureext() {
	return temperatureext;
}
public void setTemperatureext(float temperatureext) {
	this.temperatureext = temperatureext;
}
public float getTemperatureconsigne(int id) {
	return temperatureconsigne;
}
public void setTemperatureconsigne(int id,float temperatureconsigne) {
	this.temperatureconsigne = temperatureconsigne;
}
public float getHumidite() {
	return humidite;
}
public void setHumidite(float humidite) {
	this.humidite = humidite;
}
public void setTemperatureint(float temperatureint) {
	this.temperatureint = temperatureint;
}
public float getTemperatureint(){
	return temperatureint;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}


}


