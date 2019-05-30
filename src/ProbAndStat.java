
public class ProbAndStat {
	public static int fact(int n) {
		int result=1;
		
		for(int i=n;i>0;i--)
			result = result * i;
		
		return result;
	}
	
	public static int combination(int n, int r) {
		return fact(n)/fact(r)/fact(n-r);
	}
}
