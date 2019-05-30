
public class Main {

	public static void main(String[] args) {
//		// TODO Auto-generated method stub
		
//		PseudoExponentialDist ped = new PseudoExponentialDist(1000, 100);
//		ped.simulate();
//		ped.showData();
		
//		PseudoErlangK2Dist pek = new PseudoErlangK2Dist(10, 1);
//		pek.simulate();
//		pek.showData();
		
		PseudoPoissonDist ppd = new PseudoPoissonDist(1000, 50);
		ppd.simulate();
		ppd.showData();
		System.out.println("--------------------------");
		ChangedDist cd = new ChangedDist(ppd, 1, 0, 5);
		cd.simulate();
		cd.showData();
		System.out.println("상관계수 : " + Dist.getCorrelationCoefficient(ppd, cd));
		
		System.out.println("");
	}

}
