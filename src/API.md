==== API ====

---- Distribution.java ----

If you want to "extends Distribution" on your own distribution, follow below.

1. Constructor
	Distribution(int numberOfTrial)
	"numberOfTrial" is number of trials which follow your distribution.

2. setTrial(int idx, double randomVariable)
	Put your random variables.

3. setPointArray()
	You SHOULD call this method before calling "getMean()", "getVariance()", and "showDistributionData()".

Other methods that are public:

getMean() - get mean
getVariance() - get variance
showTrial() - print whole trials (unsorted)
showDistributionData() - print RV, probability, mean, and variance


---- TransformedDistribution.java ----

TransformedDistribution(Distribution distribution, double a, double b, double variance)

Make new distribution Y = aX + b + N(0,variance), with original distribution X.

Parameters:
	distribution - original distribution
	a - constant a
	b - constant b
	variance - variance of normal distribution


---- JointDistribution.java ----

JointDistribution(Distribution distribution1, Distribution distribution2)

Make joint distribution with two distributions.

Other methods that are public:

getMean() - get mean (E[XY])
getCovariance() - get covariance
getCorrelationCoefficient() - get correlation coefficient
showTrial() - print whole trials (unsorted)
showJointDistributionData() - print RV1, RV2, probability, mean, covariance and correlation coefficient


---- Other Distributions ----

[ BinomialDistribution ]

	BinomialDistribution(int numberOfTrial, int numberOfBernoulliTrial, double probability)
	
	Parameters:
		numberOfTrial - number of trials which follow binomial distribution
		numberOfBernoulliTrial - number of Bernoulli trials (n)
		probability - (p)


[ NormalDistribution ]

	NormalDistribution(int numberOfTrial, double mean, double variance)
	
	Parameters:
		numberOfTrial - number of trials which follow normal distribution
		mean - (¥ì)
		variance - (¥ò^2)


[ PoissonDistribution ]

	PoissonDistribution(int numberOfTrial, int numberOfInterval, double lambda)
	
	Parameters:
		numberOfTrial - number of trials which follow Poisson distribution
		numberOfInterval - length of discrete time interval
		lambda - (¥ë)

	
[ UniformDistribution ]

	UniformDistribution(int numberOfTrial, int numberOfInterval)
	UniformDistribution(int numberOfTrial, int numberOfInterval, double from, double to)
	
	Parameters:
		numberOfTrial - number of trials which follow uniform distribution
		numberOfInterval - length of discrete interval
		from - start of interval (default: 0)
		to - end of interval (default: numberOfInterval)
