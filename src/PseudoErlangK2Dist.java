//import java.util.Random;
//
//public class PseudoErlangK2Dist extends Dist{
//	public static final int REAPEAT = 10000;
//	public int lambda;
//	public double prob;
//	public int[] recordEachInterval;
//	//----------------------------
//	public double compareMean;
//	public double compareVariance;
//	int failureCount=0;
//	//----------------------------
//	
//	public PseudoErlangK2Dist(int domain, int lambda) { //�룄硫붿씤 1000, �엺�떎 4
//		super(domain);
//		this.lambda = lambda;
//		this.prob = lambda/domain;
//		recordEachInterval = new int[domain];
//		
//		for(int i=0;i<this.recordEachInterval.length;i++) {
//			this.recordEachInterval[i] = 0;
//		}
//	}
//	
//	public void simulatePseudoErlangK2Dist() {
//		 //0 ~ domain-1 以묒뿉�꽌 �궃�닔 �븯�굹 戮묒븘�꽌 洹� �궃�닔媛� �엺�떎蹂대떎 �옉�떎硫� success!
//		int i=0, j=0;
//		
//		for(i=0;i<REAPEAT;i++) {
//			Random rnd = new Random();
//			int firstSuccess = 0, secondSuccess = 0, thirdSuccess = 0, fourthSuccess = 0;
//			//int tmp1, tmp2;
//			for(j=0;j<domain;j++) {
//				int isThisSuccess = rnd.nextInt(domain);
//				//System.out.println(j + "th : " + isThisSuccess);
////				if(isThisSuccess < lambda && firstSuccess == 0) { //愿�痢≪씠 �꽦怨� && �븘吏� �꽦怨� X
////					firstSuccess = j;
////				}
////				
////				if(isThisSuccess < lambda && firstSuccess == j-1) { //愿�痢≪씠 �꽦怨� && 吏곸쟾 愿�痢≪뿉 �꽦怨� -> 泥ル쾲吏� �뿰�냽�맂 �몢 踰덉쓽 �꽦怨�
////					secondSuccess = j;
////				}
////				
////				if(isThisSuccess < lambda && secondSuccess != 0 ) { //愿�痢≪씠 �꽦怨� && �씠誘� �몢 踰� �꽦怨�
////					thirdSuccess = j;
////				}
////				
////				if(isThisSuccess < lambda && firstSuccess != 0 && thirdSuccess == j-1) { //愿�痢≪씠 �꽦怨� && 吏곸쟾 愿�痢≪뿉 �꽦怨� -> �몢踰덉㎏ �뿰�냽�맂 �몢 踰덉쓽 �꽦怨�
////					fourthSuccess = j;
////					break;
////				}
//			}
//			//System.out.println("�몢 踰덉㎏ �뿰�냽�맂 �몢 踰덉쓽 �꽦怨듭씠 愿�痢〓맂 吏곹썑 : " + fourhtSuccess + "  " + secondSuccess);
//			if(fourthSuccess - secondSuccess < 0) {
//				failureCount++;
//				System.out.println("At " + i + "th repeat, " +  j + "th try, Something went wrong");
//				System.out.println(fourthSuccess + " - " + secondSuccess + " = " + (fourthSuccess - secondSuccess));
//				//System.exit(0);
//			}
//			if(fourthSuccess != 0) {
//				//System.out.println("At " + i + "th repeat, " + (thirdSuccess - firstSuccess));
//				this.recordEachInterval[fourthSuccess - secondSuccess]++;
//			}
//		}
//		double m=0;
//		double p=0;
//		for(i=0;i<this.pointSet.length;i++) {
//			this.pointSet[i].x = i;
//			this.pointSet[i].value = (double)i/domain;
//			this.pointSet[i].y = (double)(this.recordEachInterval[i])/REAPEAT;
//			
////			if(this.pointSet[i].y != 0) {
////				//System.out.println("(" + pointSet[i].x + ", " + pointSet[i].y + ") : " + pointSet[i].value);
////				m = m + (this.pointSet[i].value*this.pointSet[i].y);	
////				//System.out.println((this.pointSet[i].value*this.pointSet[i].y) + "瑜� �뜑�빐�꽌 " + m + "�씠 �릺�뿀�떎.");
////				p += pointSet[i].y;
////			}
//			compareMean += (double)i/domain * (double)(this.recordEachInterval[i])/(REAPEAT);
//			compareVariance += (double)i/domain * (double)i/domain * (double)(this.recordEachInterval[i])/(REAPEAT);
//		}
//		//System.out.println(m);
//		//System.out.println(p);
//		compareVariance -= compareMean * compareMean;
//		
//	}
//	
//	public void showData() {
//		System.out.println("Show data : ");
////		for(int i=0;i<pointSet.length;i++) 
////			System.out.println("(" + pointSet[i].x + ", " + pointSet[i].y + ") : " + pointSet[i].value);
//		System.out.println("failureCount : " + failureCount);
//		System.out.println("Domain : 0 <= x <= " + (domain-1));
//		System.out.println("k : " + 2 + ", lambda : " + lambda);
//		System.out.println("Mean : " + getMean());
//		System.out.println("compareMean : " + compareMean);
//		System.out.println("Variance : " + getVariance());
//		System.out.println("compareVariance : " + compareVariance);
//	}
//}

import java.util.Random;

public class PseudoErlangK2Dist extends Dist{
	public static final int REAPEAT = 10000;
	public int ramda;
	public double prob;
	public int[] recordEachInterval;
	//----------------------------
	public double compareMean;
	public double compareVariance;
	int failureCount=0;
	//----------------------------
	
	public PseudoErlangK2Dist(int domain, int ramda) {
		super(domain);
		this.ramda = ramda;
		this.prob = ramda/domain;
		recordEachInterval = new int[domain];
		
		for(int i=0;i<this.recordEachInterval.length;i++) {
			this.recordEachInterval[i] = 0;
		}
	}
	
	public void simulate() {
		int i=0, j=0;
		
		for(i=0;i<REAPEAT;i++) {
			Random rnd = new Random();
			int firstSuccess = -1, secondSuccess = -2, thirdSuccess = -3;
			//int tmp1, tmp2;
			for(j=0;j<domain;j++) {
				int isThisSuccess = rnd.nextInt(domain);
				if(isThisSuccess < ramda && secondSuccess != -2) {
					thirdSuccess = j;
					break;
				}
				
				if(isThisSuccess < ramda && firstSuccess != -1  && secondSuccess == -2) {
					secondSuccess = j;
				}
				
				if(isThisSuccess < ramda && firstSuccess == -1) {
					firstSuccess = j;
				}			
			}
			if(thirdSuccess - firstSuccess < 0) {
				failureCount++;
			}
			if(thirdSuccess != -3) {
				this.recordEachInterval[thirdSuccess - firstSuccess]++;
			}
		}
		double m=0;
		double p=0;
		for(i=0;i<this.pointSet.length;i++) {
			this.pointSet[i].x = i;
			this.pointSet[i].value = (double)i/(domain-2);
			this.pointSet[i].y = (double)(this.recordEachInterval[i])/(REAPEAT-failureCount);
		
			compareMean += (double)i/domain * (double)(this.recordEachInterval[i])/(REAPEAT);
			compareVariance += (double)i/domain * (double)i/domain * (double)(this.recordEachInterval[i])/(REAPEAT);
			
			System.out.println(this.pointSet[i].y);
		}
		compareVariance -= compareMean * compareMean;
	}
	
	public void showData() {
		System.out.println("Show data : ");
		System.out.println("�씠�긽�븿 : " + this.pointSet[1].y);
		System.out.println("failureCount : " + failureCount);
		System.out.println("Domain : 0 <= x <= " + (domain-1));
		System.out.println("lambda : " + ramda);
		System.out.println("Mean : " + getMean());
		//System.out.println("compareMean : " + compareMean);
		System.out.println("Variance : " + getVariance());
		//System.out.println("compareVariance : " + compareVariance);
	}
}


