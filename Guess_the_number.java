import java.util.Scanner;
import java.util.Arrays;

public class Guess_the_number {
	
	//隨機數字
	private static double rand = Math.random();

	public static void main(String[] args) {
		
		//幾位
		Scanner pow = new Scanner(System.in);
		System.out.print("Please enter numbers of digits: ");
		int howmuch = pow.nextInt();
		//答案
		double answer = rand*(Math.pow(10, howmuch));
		int answerint = (int) answer;
		//2個陣列
		int[] answerSingle = new int[howmuch];
		int[] inputSingle = new int[howmuch];
		int[] replicaAnswer = Arrays.copyOf(answerSingle, howmuch);
		//測試 列印答案
		System.out.println(answerint);
		// 要array!
		for (int k = howmuch - 1; k >= 0; k--) {
			answerSingle[k] = brEak(answerint);
			answerint = (int) answerint / 10;
		}
		// 0起頭 fail
		//int digit = howmuch;
		//if (answerSingle[0] == 0) {
		//		digit--;
		//	}
		//for (int f = 1; f <= howmuch-1; f++) {
		//	if(answerSingle[f-1] == 0 && answerSingle[f] == 0) {
		//		digit--;
		//	}
		//}
		//測試digit
		//System.out.println(digit);
		// 測試答案
		for (int k = 0; k <= howmuch - 1; k++) {
			System.out.print(answerSingle[k] + " ");
		}
		System.out.println();
		// 猜數字 輸入
		Scanner Tr = new Scanner(System.in);
		System.out.print("Please enter number: ");
		while (Tr.hasNextInt()) {
			int enTer = Tr.nextInt();
		//建立幾對幾錯
			int trUe = 0;
			int faUse = 0;
		// 輸入值判定範圍
			if (enTer < 1 * (Math.pow(10, howmuch - 1)) || enTer >= 10 * (Math.pow(10, howmuch - 1))) {
				System.out.println("Error!");
				System.out.print("Please enter number: ");
			} else {
		// 猜數字 拆數字
				for (int k = howmuch - 1; k >= 0; k--) {
					inputSingle[k] = brEak(enTer);
					enTer = (int) enTer / 10;
				}
		// 測試輸入值
				for (int k = 0; k <= howmuch - 1; k++) {
					System.out.print(inputSingle[k] + " ");
				}
		// 判定
		//		for (int k = 0; k <= howmuch - 1; k++) {
		//			if (inputSingle[k] == (answerSingle[k])) {
		//				trUe++;
		//			} else {
		//				faUse++;
		//			}
		//		}
		//判定A and B
				System.out.println();
				for(int l=0; l <= howmuch-1; l++) {
					replicaAnswer[l] = answerSingle[l];
				}
				int A = 0;
				int B = 0;
				for(int i=0 ; i <= howmuch-1 ; i++) {
					for (int j=0 ; j <= howmuch-1 ; j++) {
						int a = replicaAnswer[i];
						int b = inputSingle[j];
						if( a == b) {
							if(i==j) {
								A++;
								replicaAnswer[i] = 10;
								inputSingle[j] = 10;
							}
							else if (i != j) {
								B++;
							}
						}
						if (a == b) {
							if (i == j) {
								System.out.print("A");
							} else if (i != j) {
								System.out.print("B");
							}
						} else {
							System.out.print("*");
						}
					}
					System.out.println();
				}

				System.out.printf("Your Result is: A*%s , B*%s .", A, B);
				System.out.println();
				if(Arrays.equals(answerSingle,inputSingle)) {
					System.out.print("Congratulation!");
				}else {
					System.out.print("Please enter number: ");
				}
				
			}
		}
	}
		

	public static int brEak(int number) {
		double numberN = number / 10;
		int numberint = (int) numberN;
		int X = number - numberint * 10;
		return X;
	}
	


}
