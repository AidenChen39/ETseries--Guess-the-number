import java.util.Scanner;
import java.util.Arrays;

public class Guess_the_number {
	
	//�H���Ʀr
	private static double rand = Math.random();

	public static void main(String[] args) {
		
		//�X��
		Scanner pow = new Scanner(System.in);
		System.out.print("Please enter numbers of digits: ");
		int howmuch = pow.nextInt();
		//����
		double answer = rand*(Math.pow(10, howmuch));
		int answerint = (int) answer;
		//2�Ӱ}�C
		int[] answerSingle = new int[howmuch];
		int[] inputSingle = new int[howmuch];
		int[] replicaAnswer = Arrays.copyOf(answerSingle, howmuch);
		//���� �C�L����
		System.out.println(answerint);
		// �narray!
		for (int k = howmuch - 1; k >= 0; k--) {
			answerSingle[k] = brEak(answerint);
			answerint = (int) answerint / 10;
		}
		// 0�_�Y fail
		//int digit = howmuch;
		//if (answerSingle[0] == 0) {
		//		digit--;
		//	}
		//for (int f = 1; f <= howmuch-1; f++) {
		//	if(answerSingle[f-1] == 0 && answerSingle[f] == 0) {
		//		digit--;
		//	}
		//}
		//����digit
		//System.out.println(digit);
		// ���յ���
		for (int k = 0; k <= howmuch - 1; k++) {
			System.out.print(answerSingle[k] + " ");
		}
		System.out.println();
		// �q�Ʀr ��J
		Scanner Tr = new Scanner(System.in);
		System.out.print("Please enter number: ");
		while (Tr.hasNextInt()) {
			int enTer = Tr.nextInt();
		//�إߴX��X��
			int trUe = 0;
			int faUse = 0;
		// ��J�ȧP�w�d��
			if (enTer < 1 * (Math.pow(10, howmuch - 1)) || enTer >= 10 * (Math.pow(10, howmuch - 1))) {
				System.out.println("Error!");
				System.out.print("Please enter number: ");
			} else {
		// �q�Ʀr ��Ʀr
				for (int k = howmuch - 1; k >= 0; k--) {
					inputSingle[k] = brEak(enTer);
					enTer = (int) enTer / 10;
				}
		// ���տ�J��
				for (int k = 0; k <= howmuch - 1; k++) {
					System.out.print(inputSingle[k] + " ");
				}
		// �P�w
		//		for (int k = 0; k <= howmuch - 1; k++) {
		//			if (inputSingle[k] == (answerSingle[k])) {
		//				trUe++;
		//			} else {
		//				faUse++;
		//			}
		//		}
		//�P�wA and B
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
