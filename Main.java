package net.ukr.geka3;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Network kyivstar = new Network();
		
		Phone lg = new Phone(123);
		Phone htc = new Phone(456);
		Phone nokia = new Phone(789);
		
		lg.registerTo(kyivstar);
		htc.registerTo(kyivstar);
		nokia.registerTo(kyivstar);
		
		lg.call(456);
		nokia.call(123);
		htc.hangUp();
		nokia.call(123);
		nokia.hangUp();
		nokia.unregister();
		lg.call(789);
		
		
		
	}

}
