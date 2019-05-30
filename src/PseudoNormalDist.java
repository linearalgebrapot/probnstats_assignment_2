import java.util.Random;

public class PseudoNormalDist extends Dist{
	public static final int REPEAT = 10000;
	double prob;
	double sd;
	
	public PseudoNormalDist(int domain, double sd) {
		super(domain);
		this.sd = sd;
		
		pointSet = new Point[domain];
		
		for(int i=0;i<pointSet.length;i++)
			pointSet[i] = new Point();
		
		//domain * p * (1-p) = sd^2
		//p - p^2 = sd^2/domain -> p^2 - p + sd^2/domain = 0 -> p = 
		prob = (1+Math.sqrt(1-4*1*sd*sd/domain))/2;
	}
	
	public int getRandomNorVal() { // W ~ N(np, np(1-p)
		int count = 0;
		int check;
		Random rnd = new Random();
		
		for(int i=0;i<REPEAT;i++) {
			check = rnd.nextInt(domain);
			
			if(check < domain * prob)
				count++;
		}
		
		return(int)(count-this.domain*this.prob);
	}
	
	public void simulate() {}
	
}
