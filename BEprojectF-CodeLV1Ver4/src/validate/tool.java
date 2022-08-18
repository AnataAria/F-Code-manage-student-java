package validate;

public class tool {
	public double caculateAverage(double a, double b, double c) {
		return (a + b + c)/3.0;
	}
	public boolean checkGrade(double a) {
		if(a > 6) return true;
		return false;
	}
}
