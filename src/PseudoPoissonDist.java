import java.util.Random;

public class PseudoPoissonDist extends Dist{
//	private double probability;         //�̰Ŷ� �ؿ� �Ŷ� ���ؼ� ���� �� ����
//	private int probabilityIntervalNum; //domain?
//	private int intervalNum;            //domain? 2�� �� domain ������ �� ����
//	private int trialNum; //REPEAT
//
//	private double[] probabilityArray; //�̰Ŷ�
//	private int[] successNumArray;     //�̰� ���ļ� pointSet���� ������ �� �ְڴ�
	private int successNum; //???
	
	public static final int REPEAT = 10000;
	public double lambda;

	public PseudoPoissonDist(int domain, int lambda) {
		super(domain);
		this.lambda = lambda;
		
		pointSet = new Point[domain];
		for(int i=0;i<pointSet.length;i++)
			pointSet[i] = new Point();
	}
	
	public void simulate() {
		for(int i=0;i<REPEAT;i++) {
			successNum = 0;
			
			for(int j=0;j<domain;j++) {
				int randomNum = new Random().nextInt(domain);
				if(randomNum<lambda)
					successNum++;
			}
			//System.out.println(successNum);
			(this.pointSet[successNum].x)++;
			//System.out.println(this.pointSet[successNum].value);
		}
		
		for(int i=0;i<pointSet.length;i++) {
			this.pointSet[i].value = i;
			this.pointSet[i].y = this.pointSet[i].x / REPEAT;
		}
	}
}
