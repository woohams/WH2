package com.test01;

public class Score {
	private int no;
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int sum;
	private double avg;
	private String grade;
	
	public Score() {
	}
	
	public Score(int no, String name, int kor, int eng, int math) {
		
		this.no = no;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}


	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	
	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public void setSum() {
		int sum = kor + eng + math;
		this.sum = sum;
	}
	
	public void setAvg() {
		
		double avg = Math.round((double)((sum*10)/3.0))/10.0;
		this.avg = avg;
	}
	
	public void setGrade() {
		String grade ="";
		switch((int)(avg/10)) {
		case 10: 
		case 9: grade="A";
		break;
		case 8: grade="B";
		break;
		case 7: grade="C";
		break;
		case 6: grade="D";
		break;
		case 5: grade="E";
		break;
		default : grade ="F";
		}
		this.grade = grade;
	}

	@Override
	public String toString() {
		setSum();
		setAvg();
		setGrade();	
		return "Score [no=" + no + ", name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", sum="
				+ sum + ", avg=" + avg + ", grade=" + grade + "]";
	}
	
	
	
	
}
