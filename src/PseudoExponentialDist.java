import java.util.Random;

public class PseudoExponentialDist extends Dist{
	public static final int REAPEAT = 10000;
	public double lambda;
	public double prob;
	public int[] recordEachInterval;
	//----------------------------
	public double compareMean;
	public double compareVariance;
	int failureCount=0;
	//----------------------------
	
	public PseudoExponentialDist(int domain, double lambda) { //도메인 1000, 람다 4
		super(domain);
		this.lambda = lambda;
		this.prob = lambda/domain;
		recordEachInterval = new int[domain];
		
		for(int i=0;i<this.recordEachInterval.length;i++) {
			this.recordEachInterval[i] = 0;
		}
	}
	
	public void simulate() {
		 //0 ~ domain-1 중에서 난수 하나 뽑아서 그 난수가 람다보다 작다면 success!
		int i=-1, j=-1;
		int firstSuccess;
		int secondSuccess;
		
		for(i=0;i<REAPEAT;i++) {
			Random rnd = new Random();
			firstSuccess = -1;
			secondSuccess = -2;
			for(j=0;j<domain;j++) {
				int randNum = rnd.nextInt(domain);
				if(randNum < lambda && firstSuccess != -1) { //두 번째 성공을 먼저 체크하고
					secondSuccess = j;
					break;
				}	
				if(randNum < lambda && firstSuccess == -1) { //첫 번째 성공을 나중에
					firstSuccess = j;
				}
			}
			if(secondSuccess - firstSuccess < 0) { //secondSuccess가 없어서 음수인 케이스 == 성공이 2번 관측되지 않은 케이스
				failureCount++;
			}
			if(secondSuccess != -2) {
				this.recordEachInterval[secondSuccess - firstSuccess]++;
			}
		}
		for(i=0;i<this.pointSet.length;i++) {
			this.pointSet[i].x = i;
			this.pointSet[i].value = (double)i/(domain-1);
			this.pointSet[i].y = (double)(this.recordEachInterval[i])/(REAPEAT-failureCount);

			compareMean += (double)i/domain * (double)(this.recordEachInterval[i])/(REAPEAT);
			compareVariance += (double)i/domain * (double)i/domain * (double)(this.recordEachInterval[i])/(REAPEAT);
			
			System.out.println(this.pointSet[i].y);
		}
		compareVariance -= compareMean * compareMean;
	}
	
	public void showData() {
		System.out.println("Show data : ");
		System.out.println("failureCount : " + failureCount);
		System.out.println("Domain : 0 <= x <= " + (domain-1));
		System.out.println("lambda : " + lambda);
		System.out.println("Mean : " + getMean());
		System.out.println("compareMean : " + compareMean);
		System.out.println("Variance : " + getVariance());
		System.out.println("compareVariance : " + compareVariance);
	}
}
