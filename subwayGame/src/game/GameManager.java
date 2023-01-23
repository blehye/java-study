package game;

import java.util.Scanner;

import order.OrderManager;
import user.User;

public class GameManager {
	
	public void gameStartInfo(User user) {
		System.out.println("-------------------------------------------------");
		System.out.println(""
				+ "⠀⠀⠀⠀⢠⣾⣿⠿⠿⠏⢠⣿⡿⠀⣸⣿⡟⢠⣿⡿⠿⣿⣿⠆⣿⣿⠁⣰⣿⣿⠀⣰⣿⡟⢀⣾⣿⣿⡟⠸⣿⣷⠀⣠⣾⡿⠿⣿⡿⠆\n"
				+ "⠀⠀⠀⠀⢸⣿⣧⡀⠀⢀⣿⣿⠃⢠⣿⣿⠁⣾⣿⣧⣤⣿⠟⠀⣿⡿⢰⡿⣻⡟⣰⣿⠏⢠⣿⡿⢹⣿⡇⠀⣿⣿⣼⣿⠏⠀⠈⠀⠀⠀\n"
				+ "⠀⠀⢀⠄⠈⢻⣿⣷⡀⣼⣿⡟⠀⣾⣿⠇⣸⣿⡿⠛⣿⣿⡆⢸⣿⣷⣿⢃⣿⣷⣿⠏⢠⣿⣟⣁⣿⣿⡇⠀⣿⣿⡿⠁⠀⠀⠀⠀⠀⠀\n"
				+ "⠰⣿⣿⣶⣶⣾⣿⡿⠀⣿⣿⣷⣾⣿⠏⢠⣿⣿⣧⣴⣿⡿⠃⣼⣿⣿⠃⢸⣿⣿⠏⢠⣿⡿⠿⢿⣿⣿⠀⢰⣿⣿⠃⠀⠀⠀⠀⠀⠀⠀\n"
				+ "⠀⠹⠛⠛⠛⠛⠉⠀⠀⠙⠛⠛⠋⠁⠀⠘⠛⠛⠛⠋⠉⠀⠀⠙⠛⠃⠀⠚⠛⠋⠀⠛⠛⠀⠀⠘⠛⠛⠀⠛⠛⠃⠀⠀⠀⠀⠀⠀⠀⠀\n");
		
		System.out.println("【 1.주문하기 】\t\t"+"   ᕱ,,,ᕱ⠀ ⠀➶ ⠀➴⠀");
		System.out.println("【 2.알바하기 】\t\t"+"  (๑◕ܫ◕๑) ➶⠀⠀⠀ ⠀➴⠀");
		System.out.println("【 3.미니게임 】\t\t"+"  ૮⠀⠀⑅ ⠀づ ⠀⠀⠀⠀⠀⠀⠀➵");
		System.out.println("【 4.쿠폰보기 】\t\t"+"   ∪  ∪");
		System.out.println("【 5.닉네임변경 】\t\t"+"【 "+ user.getUserName() + " 】");
		System.out.println("【 6.메뉴미리보기 】\t\t"+"【 캐시 : "+ user.getCash() +"원 】");
		System.out.println("【 7.게임설명보기 】\t\t");
		System.out.println("-------------------------------------------------");
		System.out.print("숫자를 선택해주세요 : ");
	}
	
	public void gameTutorial() {
		System.out.println("※ 알바하기, 미니게임을 통해 캐시를 모으세요!");
		System.out.println("※ 알바 1번하면 15000원, 미니게임 1번하면 10000원을 획득합니다!");
		System.out.println("※ 샌드위치를 1번 주문할 때마다 쿠폰 1개를 받을 수 있습니다.");
		System.out.println("※ 쿠폰 3장을 모으면 샌드위치 1개를 무료로 받을 수 있습니다.");
	}
	
	public boolean useCoupon(User user, OrderManager om) {
		while(true) {
			System.out.println("\nQ. 쿠폰 3장을 사용하시겠습니까?");
			System.out.println("1. 예(쿠폰3장 차감)");
			System.out.println("2. 아니오");
			System.out.print("숫자를 입력해주세요 : ");
			om.selectNum();
			
			if(!om.getSelectNum().equals("1")&&!om.getSelectNum().equals("2")) {
				System.out.println("\n잘못된 입력입니다. 다시 입력해주세요.\n");
				continue;
			}
			
			if(om.getSelectNum().equals("1")) {
				user.setCouponNum(user.getCouponNum()-3);
				om.setIsCoupon(true);
				return true;
				
			} else {
				om.setIsCoupon(false);
				return false;
			}
		}
		
	}
	
}