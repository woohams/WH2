import java.util.Calendar;
import java.util.Scanner;

public class Cal {

	public static void main(String[] args) {

		Calendar cal = Calendar.getInstance();
		Scanner sc = new Scanner(System.in);
	
		System.out.println("년도를 입력하세요 : ");
		int year = sc.nextInt();
		System.out.println("월을 입력하세요 : ");
		int month = sc.nextInt();

		cal.set(Calendar.YEAR, year); 	//입력받은 년도
		cal.set(Calendar.MONTH, month); //입력받은 월

		System.out.println("---------["+year+"년 "+month+"월]---------");
		System.out.println("   일      월      화      수      목     금      토");

		cal.set(year, month-1, 1); 	//입력받은 월의 1일로 세팅
									//month는 0이 1월이므로 -1을 해준다
		  
		int end = cal.getActualMaximum(Calendar.DATE); 	//해당 월 마지막 날짜
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); 	//해당 날짜의 요일(1:일요일 … 7:토요일)
		

		for(int i = 1; i <= end; i++) {
			if(i == 1) {
				for(int j = 1; j < dayOfWeek; j++) {
					System.out.print("    ");
				}
			}
			
			if( i < 10) { 	//한자릿수일 경우 공백을 추가해서 줄맞추기
				System.out.print(" ");
			}
			
			System.out.print(" " + i + " ");
			if(dayOfWeek % 7 == 0) { 	//한줄에 7일씩 출력
				System.out.println();
			}
			dayOfWeek++;
		}
		
		System.out.println(" ");
		System.out.println("-----------------------------");
		
	}
} 

