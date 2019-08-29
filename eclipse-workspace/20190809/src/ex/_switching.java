package ex;

public class _switching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//  1   2   3   4   5   6   7   8   9  10  11 12
		// 31 28 31 30 31 30 31 31 30 31 30 31 
		
		int  month= 4;
		
		int last_day;
		
		switch(month){
/*			case 1: last_day = 31;
			break;
			case 2: last_day = 28;
			break;
			case 3: last_day = 31;
			break;
			case 4: last_day = 30;
			break;
			case 5: last_day = 31;
			break;
			case 6: last_day = 30;
			break;
			case 7: last_day = 31;
			break;
			case 8: last_day = 31;
			break;
			case 9: last_day = 30;
			break;
			case 10: last_day = 31;
			break;
			case 11: last_day = 30;
			break;
			case 12: last_day = 31;
			break;*/
			// --> 
		
			case 1: last_day = 31; break;
			case 2: last_day = 28; break;
			case 3: 
			case 5:
			case 7:
			case 8:
			case 10:
			case 12: last_day = 31; break;
			case 4:
			case 6:
			case 9:
			case 11: last_day = 30; break;	 // 혹은 유효성 검사 후 defalt = 30
		}

	}
}
