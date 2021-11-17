package GuessTheNumber;

import java.util.Scanner;

public class MainCode {

	public static void main(String[] args) {
		Scanner pow = new Scanner(System.in);
		System.out.print("Please enter numbers of digits: ");
		int digit = pow.nextInt();
		
		int answer = Random(digit);
		Number Ans = new Number(answer, digit);
		
		Ans.printN();
		
		Scanner Tr = new Scanner(System.in);
		System.out.print("Please enter number: ");
		while (Tr.hasNextInt()) {
			
			int in = Tr.nextInt();		
			Number Ent = new Number(in, digit);
			
			if (Ent.getNum() == Ans.getNum()) {
				System.out.print("Congratulation!");
			} else if (in < Math.pow(10, Math.log10(answer) - 2) || in >= Math.pow(10, Math.log10(answer))) {
				System.out.println("Error!");
				System.out.print("Please enter number: ");
			} else {
				int AnsRep[] = new int[digit];
				int EntRep[] = new int[digit];
				for (int k = digit - 1; k >= 0; k--) {
					AnsRep[k] = Ans.getX(k);
				}
				for (int k = digit - 1; k >= 0; k--) {
					EntRep[k] = Ent.getX(k);
				}
				
				int A = 0;
				int B = 0;
				
				for(int i=0 ; i <= digit-1 ; i++) {
					for (int j=0 ; j <= digit-1 ; j++) {
						int a = AnsRep[i];
						int b = EntRep[j];
						if (a == b) {
							if (i == j) {
								A++;
								AnsRep[i] = 10;
								EntRep[j] = 10;
							} 
						}		
					}					
				}
				
				for(int i=0 ; i <= digit-1 ; i++) {
					for (int j=0 ; j <= digit-1 ; j++) {
						int a = AnsRep[i];
						int b = EntRep[j];
						if (a == b && a < 10) {
							B++;
							AnsRep[i] = 11;
							EntRep[j] = 11;
						}
					}					
				}

				System.out.printf("Your Result is: A*%s , B*%s .", A, B);
				System.out.println();
				System.out.print("Please enter number: ");

			}
		}

	}
	
	public static int Random(int a) {
		double rand = Math.random();
		int numberx = (int) (rand*Math.pow(10, a));
		return numberx;
	}

}
