package njhm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<Integer>();
		int[] arr = {2,6,13};
		for(int i = 1; i<29; i++) {
				list.add(i);
		}
		
		for(int i=0; i<arr.length; i++) {
			list.remove(list.indexOf(arr[i]));
		}
		Collections.shuffle(list);
		Collections.shuffle(list);
		for(int i=1; i<list.size()+1;i++) {
			System.out.print(list.get(i-1)+"\t");
			
			if(i%5==0) {
				System.out.println();
			}
		}
		
	}
	
}
