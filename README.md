확률통계론 과제2

주제: 두 변수 X, Y의 상관계수 분석 

1. 변수 X 생성 
  프로그램 언어 라이브러리에서 random 발생 함수를 사용하여 생성 
  어떤 확률 분포도 가능: Uniform, Poisson, Normal distribution….
2. 변수 Y 생성: Y=aX+b +N(0, σ2) 
  a≠0이고, a 와 b는 임의로 설정
3. X와 Y사이의 상관계수 분석
  두 변수의 marginal, joint distribution (확률분포) 구하기
  x-y 2차원 평면상에서 두 변수의 분포 그래프 표시 
  표준편차 σ 를 3가지로 다르게 하여 상관계수를 각각 구하고 비교

고려 사항
  발생하는 변수 x 값의 범위와 정밀도, 표준편차의 크기 설정 
  예: X = 0부터 100인 정수, Y: 0부터 max_Y인 정수, 표준편차= 5, 10, 20  
  변수를 발생하는 총 횟수
  100,000 회 이상 실시 
보고서 제출
  ppt 형식으로 10 페이지 정도 작성
  6월 4일 수업시간 직전에 인쇄본 제출
  개인 또는 팀 과제로 팀 구성은 자유롭게 최대 4명까지…


[ Distribution.java ]

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


[ TransformedDistribution.java ]

	TransformedDistribution(Distribution distribution, double a, double b, double variance)

	Make new distribution Y = aX + b + N(0,variance), with original distribution X.

	Parameters:
		distribution - original distribution
		a - constant a
		b - constant b
		variance - variance of normal distribution


[ JointDistribution.java ]

	JointDistribution(Distribution distribution1, Distribution distribution2)

	Make joint distribution with two distributions.

	Other methods that are public:

	getMean() - get mean (E[XY])
	getCovariance() - get covariance
	getCorrelationCoefficient() - get correlation coefficient
	showTrial() - print whole trials (unsorted)
	showJointDistributionData() - print RV1, RV2, probability, mean, covariance and correlation coefficient


[ Other Distributions ]

---- BinomialDistribution ----

	BinomialDistribution(int numberOfTrial, int numberOfBernoulliTrial, double probability)
	
	Parameters:
		numberOfTrial - number of trials which follow binomial distribution
		numberOfBernoulliTrial - number of Bernoulli trials (n)
		probability - (p)


---- NormalDistribution ----

	NormalDistribution(int numberOfTrial, double mean, double variance)
	
	Parameters:
		numberOfTrial - number of trials which follow normal distribution
		mean
		variance


---- PoissonDistribution ----

	PoissonDistribution(int numberOfTrial, int numberOfInterval, double lambda)
	
	Parameters:
		numberOfTrial - number of trials which follow Poisson distribution
		numberOfInterval - length of discrete time interval
		lambda

	
---- UniformDistribution ----

	UniformDistribution(int numberOfTrial, int numberOfInterval)
	UniformDistribution(int numberOfTrial, int numberOfInterval, double from, double to)
	
	Parameters:
		numberOfTrial - number of trials which follow uniform distribution
		numberOfInterval - length of discrete interval
		from - start of interval (default: 0)
		to - end of interval (default: numberOfInterval)