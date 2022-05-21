package edu.umb.cs681.hw10;

public class MultiThread implements Runnable {

    public void run() {
    	Aircraft objAircraft = new Aircraft(new Position(49.8,-88.6,1400));
        System.out.println("The Aircraft's original position is: "+ objAircraft.getPosition());
        objAircraft.setPosition(objAircraft.getPosition().changeAlt(1500));
        System.out.println("The Aircraft's original position is changed to: "+ objAircraft.getPosition());
        objAircraft.setPosition(new Position(46.1, -90.3, 700));
        System.out.println("The Aircraft's new position is: "+ objAircraft.getPosition());
    }

    public static void main(String[] args) {
    	
    	Thread T1 = new Thread(new MultiThread());
		Thread T2 = new Thread(new MultiThread());
		Thread T3 = new Thread(new MultiThread());

		T1.start();
		T2.start();
		T3.start();

		try {
			T1.join();
			T2.join();
			T3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}        
    }
}
