package Main;

import Controller.Controller;

public class Main {
	private static boolean test = true;
	public static void main(String[] args) {
		Controller c = new Controller();
	   
		while (test == true){
			c.run();
		};
	}

}
