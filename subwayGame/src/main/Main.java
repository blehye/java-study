package main;

import java.util.Scanner;

import game.GameManager;
import mini.MiniGame;
import order.OrderManager;
import user.User;
import user.UserManager;
import work.PartTime;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		GameManager gm = new GameManager();
		UserManager um = new UserManager();
		OrderManager om = new OrderManager();
		MiniGame mg = new MiniGame();
		PartTime pt = new PartTime();
		User user = new User();
		while(true) {
			//서브웨이 게임 시작
			gm.gameStartInfo(user);
			
			//입력받기
			om.selectNum();
			
			//유저의 동작 선택
			switch(om.getSelectNum()) {
			
			//1.주문하기
			case "1" :
				if(user.getCash()<4100 && user.getCouponNum()<3) {
					om.setIsCoupon(false);
					System.out.println(user.getUserName()+ "님의 캐시가 주문최소금액(베지:4100원)보다 적습니다.");
				} else if (user.getCash()<4100 && user.getCouponNum()>=3) {
					if (gm.useCoupon(user, om) == true) {
						om.orderMenu(user);
					} else {
						System.out.println(user.getUserName()+ "님의 캐시가 주문최소금액(베지:4100원)보다 적습니다.");
					}
				} else if(user.getCash()>=4100 && user.getCouponNum()<3) {
					om.setIsCoupon(false);
					om.orderMenu(user);		
				} else if(user.getCash()>=4100 && user.getCouponNum()>=3) {
					if (gm.useCoupon(user, om) == true) {
						om.orderMenu(user);
					} else {
						om.orderMenu(user);
					}
				}
				break;
			//2.알바하기	
			case "2" :
				pt.receiveOrder(user);
				break;
			//3.미니게임	
			case "3" :
				mg.miniGame(user, "🐭", "🧀", "🟫", 5, 10);
				break;
			//4.쿠폰보기	
			case "4" :
				um.checkCoupon(user);
				break;
			//5.닉네임변경	
			case "5" :
				um.changeUserName(user);
				break;
			//6.메뉴미리보기	
			case "6" :
				System.out.println("[ 메뉴 미리보기 ]");
				om.showMenu("베지", "에그마요", "이탈리안비엠티", "서브웨이클럽", "스테이크&치즈", 4100, 4600, 5700, 6200, 6900, 7600, 8500, 10400, 11200, 12200);
				System.out.println();
				om.showBread("플랫브레드", "허니오트", "화이트", "파마산오레가노", "위트");
				System.out.println();
				om.showToping("에그마요",1600, "베이컨",1000, "오믈렛", 1300, "아보카도", 1300);
				System.out.println();
				om.showCheese("아메리칸치즈", "슈레드치즈");
				System.out.println();
				om.showSauce("스위트어니언", "스위트칠리", "랜치", "바베큐", "레드와인식초");
				System.out.println();
				break;
			//7.게임설명보기	
			case "7" :
				gm.gameTutorial();
				break;
			default:
				System.out.println("잘못된 선택입니다! 다시 선택해주세요!");
				break;
			}
			
		}
		
	}
}
