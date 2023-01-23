package user;

import java.util.Scanner;

public class UserManager {
	private int couponMax = 15;
	public void changeUserName(User user) {
		Scanner sc = new Scanner(System.in);
		System.out.print("변경할 닉네임을 입력해주세요 : ");
		user.setUserName(sc.nextLine());
	}
	
	public void checkCoupon(User user) {
		System.out.println("-------------------------------------------------");
		System.out.println("[ " + user.getUserName() +"님의 쿠폰북 ]\n");
		
		String[] arr = new String[couponMax];
		
		for(int i=0; i<couponMax; i++) {
			arr[i] = "⚪";
		}
		
		for(int i=0; i<user.getCouponNum(); i++) {
			arr[i] = "⚫";
		}
		
		System.out.println("  　 /)⋈/)\n"
				+ "   (｡•ㅅ•｡)♡\n"
				+ "  ┏--∪-∪━━━━━━━━━━━━━┓");
		
		for(int i=0; i<couponMax; i++) {
			if(i==0) {
				System.out.print("     ");
			}
			
			if(i%5==0 && i!=0) {
				System.out.println();
				System.out.print("     ");
			}
			
			System.out.print(arr[i]);
		}
		
		System.out.println("\n  ┗-━━━━━━━━━━━━━┛");
		
		System.out.println("\n쿠폰 3개 모으면 샌드위치 1개 무료");
		System.out.println("-------------------------------------------------");
		
	}
}
