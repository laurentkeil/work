package Bataillon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueuePoints {

	public Double[] centre;
	List<Double[]> listePoints;
	private double Dmax = 5.0;
	
	
	public QueuePoints (int size) {
		centre = new Double[2];
		centre[0] = 0.0; //x
		centre[1] = 0.0; //y
		this.listePoints = new ArrayList<Double[]>(size);
		for(int i=0 ; i < size ; i++){
			Double[] pos = new Double[2];
			pos[0] = 0.0; //x
			pos[1] = 0.0; //y
			listePoints.add(pos);
		}
	}
	
	public synchronized void move (Double[] dist, int id) {
		double posx = listePoints.get(id)[0]; //ancienne pos
		double posy = listePoints.get(id)[1];
		double centrex = centre[0]; //ancien centre
		double centrey = centre[1]; //ancien centre
		
		Double[] newPos = new Double[2];
		newPos[0] = posx + dist[0];
		newPos[1] = posy + dist[1];
		listePoints.get(id)[0] = newPos[0]; //nouvelle pos
		listePoints.get(id)[1] = newPos[1];
		centre[0] = centre[0] + dist[0]/listePoints.size(); //nouveau centre
		centre[1] = centre[1] + dist[1]/listePoints.size();
		
		while(distance(newPos) >= Dmax){
			listePoints.get(id)[0] = posx; //on remet tout
			listePoints.get(id)[1] = posy;
			centre[0] = centrex;
			centre[1] = centrey;
			try{
				wait();
			} catch (InterruptedException e) {}
		}
		
		listePoints.get(id)[0] = newPos[0]; //nouvelle pos
		listePoints.get(id)[1] = newPos[1];
		centre[0] = centrex + dist[0]/listePoints.size(); //nouveau centre
		centre[1] = centrey + dist[1]/listePoints.size();
		
		System.out.println("centre : " + Arrays.toString(centre));
		
		notifyAll();
	}
	
	private final double square (double x) {
		return x*x;
	}
	
	//distance entre le point pos et le nouveau centre du bataillon
	public double distance (Double pos[]){
		return Math.sqrt(square(centre[0]-pos[0]) + square(centre[1]-pos[1]));
	}
	
}
