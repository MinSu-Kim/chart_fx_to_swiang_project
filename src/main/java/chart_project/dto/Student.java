package chart_project.dto;

public class Student {
	private String stdNo;
	private String stdName;
	private double korScore;
	private double engScore;
	private double mathScore;

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String stdNo) {
		this.stdNo = stdNo;
	}

	public Student(String stdNo, String stdName, double korScore, double engScore, double mathScore) {
		this.stdNo = stdNo;
		this.stdName = stdName;
		this.korScore = korScore;
		this.engScore = engScore;
		this.mathScore = mathScore;
	}

	public String getStdNo() {
		return stdNo;
	}

	public void setStdNo(String stdNo) {
		this.stdNo = stdNo;
	}

	public String getStdName() {
		return stdName;
	}

	public void setStdName(String stdName) {
		this.stdName = stdName;
	}

	public double getKorScore() {
		return korScore;
	}

	public void setKorScore(double korScore) {
		this.korScore = korScore;
	}

	public double getEngScore() {
		return engScore;
	}

	public void setEngScore(double engScore) {
		this.engScore = engScore;
	}

	public double getMathScore() {
		return mathScore;
	}

	public void setMathScore(double mathScore) {
		this.mathScore = mathScore;
	}

	public double getSum() {
		return korScore + engScore + mathScore;
	}

	public double getAvg() {
		return getSum() / 3D;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((stdNo == null) ? 0 : stdNo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (stdNo == null) {
			if (other.stdNo != null)
				return false;
		} else if (!stdNo.equals(other.stdNo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("Student [%s %s %s %s %s %s %6.2f]", stdNo, stdName, korScore, engScore, mathScore,
				getSum(), getAvg());
	}

}
