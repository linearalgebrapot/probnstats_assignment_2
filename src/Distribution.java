import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;

public class Distribution {	
	private double[] trial; // result of every trial(every random variable)
	private Point[] pointArray; // result of x(random variable) and y(probability)
	
	protected Distribution(int numberOfTrial) {
		if (numberOfTrial > 1) {
			trial = new double[numberOfTrial];
			for(int i=0; i<trial.length; i++) {
				trial[i] = 0;
			}
		}
		else System.out.println("numberOfTrial is not enough");
	}
	
	protected Distribution(Distribution otherDistribution) {
		double[] trial = otherDistribution.getTrial();
		Point[] pointArray = otherDistribution.getPointArray();
		
		this.trial = new double[trial.length];
		for (int i=0; i<trial.length; i++) {
			this.trial[i] = trial[i];
		}
		this.pointArray = new Point[pointArray.length];
		for (int i=0; i<pointArray.length; i++) {
			this.pointArray[i] = new Point(pointArray[i]);
		}
	}
	
	protected void setTrial(int idx, double randomVariable) {
		if (idx >= 0 && idx < trial.length) trial[idx] = randomVariable;
		else System.out.println("setTrial_idx error");
	}
	
	protected double[] getTrial() {
		double[] tmpTrial = new double[trial.length];
		System.arraycopy(trial, 0, tmpTrial, 0, trial.length);
		return tmpTrial;
	}
	
	protected int getNumberOfTrial() {
		return trial.length;
	}
	
	protected void setPointArray() {
		// sort trial
		double[] sortedTrial = new double[trial.length];
		System.arraycopy(trial, 0, sortedTrial, 0, trial.length);
		Arrays.sort(sortedTrial);
		
		// get number of unique x
		int numberOfUniqueX = 1;
		double previousX = sortedTrial[0];
		for (int i=1; i<sortedTrial.length; i++) {
			if (previousX != sortedTrial[i]) numberOfUniqueX++;
			previousX = sortedTrial[i];
		}
		
		// initialize pointArray
		pointArray = new Point[numberOfUniqueX];
		for (int i=0; i<pointArray.length; i++) {
			pointArray[i] = new Point();
		}
		
		// set pointArray (x is unique x, y is frequency)
		pointArray[0].setX(sortedTrial[0]);
		pointArray[0].setY(1);
		int pointArrayIndex = 0;
		for (int i=1; i<sortedTrial.length; i++) {
			if(pointArray[pointArrayIndex].getX() == sortedTrial[i]) {
				pointArray[pointArrayIndex].setY(pointArray[pointArrayIndex].getY()+1);
			}
			else {
				pointArrayIndex++;
				pointArray[pointArrayIndex].setX(sortedTrial[i]);
				pointArray[pointArrayIndex].setY(1);
			}
		}
		
		// change y (from frequency to probability)
		for (int i=0; i<pointArray.length; i++) {
			pointArray[i].setY(pointArray[i].getY() / sortedTrial.length);
		}
	}
	
	protected Point[] getPointArray() {
		Point[] tmpPointArray = new Point[pointArray.length];
		for (int i=0; i<pointArray.length; i++) {
			tmpPointArray[i] = new Point(pointArray[i]);
		}
		return tmpPointArray;
	}
	
	public double getMean() {
		double mean = 0;
		for (int i=0; i<pointArray.length; i++) {
			mean += pointArray[i].getX() * pointArray[i].getY();
		}
		return mean;
	}
	
	public double getVariance() {
		double secondMoment = 0;
		for (int i=0; i<pointArray.length; i++) {
			secondMoment += Math.pow(pointArray[i].getX(), 2) * pointArray[i].getY();
		}
		
		double variance = secondMoment - Math.pow(getMean(), 2);
		return variance;
	}
	
	public void showTrial() {
		System.out.println("trial :");
		for (int i=0; i<trial.length; i++) {
			System.out.println(trial[i]);
		}
	}
	
	public void showDistributionData() {
		System.out.println("RV, probability :");
		for (int i=0; i<pointArray.length; i++) {
			System.out.println(pointArray[i].getX() + " " + pointArray[i].getY());
		}
		System.out.println("mean : " + getMean());
		System.out.println("variance : " + getVariance());
	}
	
	public void writeDistributionData() {
	      Scanner sc = new Scanner(System.in);
	      PrintWriter outputStream = null;
	      String fileName;
	      
	      try {
	         System.out.print("파일 이름  : ");
	         fileName = sc.nextLine();
	         if(fileName.equals("d")) {
	            Calendar cal = Calendar.getInstance();
	            
	            fileName = Integer.toString(cal.get(Calendar.YEAR))+"-"+Integer.toString(cal.get(Calendar.MONTH)+1)+"-"+Integer.toString(cal.get(Calendar.DAY_OF_MONTH))+" "+Integer.toString(cal.get(Calendar.HOUR))+"-"+Integer.toString(cal.get(Calendar.MINUTE))+"-"+Integer.toString(cal.get(Calendar.SECOND))+".txt";
	            //System.out.println(fileName);
	         }
	         outputStream = new PrintWriter(fileName);
	      }
	      catch(FileNotFoundException e) {
	         System.out.println("Problem opening files.");
	         System.exit(0);;
	      }
	      
	      outputStream.println("RV, probability :");
	      for (int i=0; i<pointArray.length; i++) {
	         outputStream.println(pointArray[i].getX() + " " + pointArray[i].getY());
	      }
	      outputStream.println("mean : " + getMean());
	      outputStream.println("variance : " + getVariance());
	      
	      outputStream.close();
	      sc.close();
	   }
}