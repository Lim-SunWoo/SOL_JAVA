package ex;

public class _4for {

		public static void main(String[] args) {
			
			for (int i=0; i<26; i++) {
				System.out.printf("%c", 'A'+i);
			}
			System.out.println();
			
			for (int i='A'; i<='Z'; i++) {
				System.out.printf("%c",i);
			}
			System.out.println();
			
			for (int i='A'; i<='Z'; i++) {
				if (i%2!=0) {	
					System.out.printf("%c",i);
				}
				else	 System.out.printf("%c",i+32);
			}
			System.out.println();
			
			for (int i='A'; i<='Z'; i++) {
				if (i%3==2) {	
					System.out.printf("%c",i);
				}
				else	 System.out.printf("%c",i+32);
			}
			System.out.println();
			
			for (int i='A'; i<='Z'; i++) {
				System.out.printf("%c",i);
				if (i%3==1) {	
					System.out.printf("%s", "-");
				}
			}
		
		}		
}
