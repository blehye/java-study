package order;

import java.util.Scanner;

import user.User;

public class OrderManager {
	private String menu;
	private String bread;
	private String menuSize;
	private String cheese;
	private String toping;
	private String noVegetable;
	private String sauce;
	private String setMenu;
	private String selectNum;
	private int menuPrice = 0;
	private String menuNum;
	private boolean is30cm = false;
	private boolean isCoupon = false;
	
	
	public void orderMenu(User user) {
		//메뉴 총금액 초기화
		this.menuPrice = 0;
		//처음 인삿말
		welcome(user);
		
		//1.메뉴선택
		while(true) {
			//메뉴안내
			cashAndPriceInfo(user);
			
			showMenu("베지", "에그마요", "이탈리안비엠티", "서브웨이클럽", "스테이크&치즈", 4100, 4600, 5700, 6200, 6900, 7600, 8500, 10400, 11200, 12200);
			
			//메뉴 입력받기
			selectNum();
			setMenuNum(getSelectNum());
			
			//이상한값인지 판단 후 true면 메뉴 다시 안내
			if(checkWeirdNum1()) {
				System.out.println("\n잘못된 선택입니다! 다시 선택해주세요!");
				continue;
			}
			//금액부족 판단 -> 부족하면 메뉴 다시안내
			boolean isLackOfCash = checkLackOfCach(user, 4100, 4600, 5700, 6200, 6900);
			if(isLackOfCash && (isCoupon==false)) {
				continue;
			}
			//금액부족 판단 -> 안부족하면 금액계산
			calcMenu(4100, 4600, 5700, 6200, 6900);
			
			setMenu(getSelectNum(), "베지", "에그마요", "이탈리안비엠티", "서브웨이클럽", "스테이크&치즈");
			break;
			
		}
		//2.빵선택
		while(true) {
			//빵안내
			cashAndPriceInfo(user);
			showBread("플랫브레드", "허니오트", "화이트", "파마산오레가노", "위트");
			
			//빵 입력받기
			selectNum();
			
			//이상한값인지 판단 후 true면 메뉴 다시 안내
			if(checkWeirdNum1()) {
				System.out.println("\n잘못된 선택입니다! 다시 선택해주세요!");
				continue;
			}
			//빵은 금액계산 불필요
			setBread(getSelectNum(),"플랫브레드", "허니오트", "화이트", "파마산오레가노", "위트");
			break;
		}
		//3.사이즈선택
		while(true) {
			//사이즈안내
			cashAndPriceInfo(user);
			showMenuSize();
			
			//사이즈 입력받기
			selectNum();
			
			//이상한값인지 판단 후 true면 메뉴 다시 안내
			if(checkWeirdNum2()) {
				System.out.println("\n잘못된 선택입니다! 다시 선택해주세요!");
				continue;
			}
			
			if(getSelectNum().equals("1")) {
				setIs30cm(false);
				setMenuSize(getSelectNum(), "15cm", "30cm");
				break;
			}
			setIs30cm(true);
			
			//selectNum=2인경우 금액부족 판단 -> 부족하면 메뉴 다시안내
			boolean isLackOfCash = checkLackOfCach2(user, 3500, 3900, 4700, 5000, 5300);
			if(isLackOfCash && (isCoupon==false)) {
				continue;
			}
			//금액부족 판단 -> 안부족하면 금액계산
			calcMenu2(3500, 3900, 4700, 5000, 5300);
			
			setMenuSize(getSelectNum(), "15cm", "30cm");
			
			break;
		}
		//4.치즈선택
		while(true) {
			cashAndPriceInfo(user);
			showCheese("아메리칸치즈", "슈레드치즈");
			
			//치즈 입력받기
			selectNum();
			
			//이상한값인지 판단 후 true면 메뉴 다시 안내
			if(checkWeirdNum2()) {
				System.out.println("\n잘못된 선택입니다! 다시 선택해주세요!");
				continue;
			}
			//치즈는 금액계산 불필요
			setCheese(getSelectNum(), "아메리칸치즈", "슈레드치즈");
			break;
		}
		
		//5.추가토핑선택
		while(true) {
			cashAndPriceInfo(user);
			showToping("에그마요",1600, "베이컨",1000, "오믈렛", 1300, "아보카도", 1300);
			
			//추가토핑 입력받기
			selectNum();
			
			//이상한값인지 판단 후 true면 메뉴 다시 안내
			if(checkWeirdNum1()) {
				System.out.println("\n잘못된 선택입니다! 다시 선택해주세요!");
				continue;
			}
			
			if(getIs30cm()) {
				//금액부족 판단 -> 부족하면 메뉴 다시안내
				boolean isLackOfCash = checkLackOfCach(user, 3200, 2000, 2600, 2600, 0);
				if(isLackOfCash && (isCoupon==false)) {
					continue;
				}
				//금액부족 판단 -> 안부족하면 금액계산
				calcMenu(3200, 2000, 2600, 2600, 0);
				
				setToping(getSelectNum(), "에그마요", "베이컨", "오믈렛", "아보카도", "추가안함");
				
				break;
			}
			
			//금액부족 판단 -> 부족하면 메뉴 다시안내
			boolean isLackOfCash = checkLackOfCach(user, 1600, 1000, 1300, 1300, 0);
			if(isLackOfCash && (isCoupon==false)) {
				continue;
			}
			//금액부족 판단 -> 안부족하면 금액계산
			calcMenu(1600, 1000, 1300, 1300, 0);
			
			setToping(getSelectNum(), "에그마요", "베이컨", "오믈렛", "아보카도", "추가안함");
			
			break;
		}
		//6.빼고싶은야채선택
		while(true) {
			cashAndPriceInfo(user);
			showVegetable("할라피뇨", "올리브", "토마토", "피망", "없음");
			
			//추가토핑 입력받기
			selectNum();
			
			//이상한값인지 판단 후 true면 메뉴 다시 안내
			if(checkWeirdNum1()) {
				System.out.println("\n잘못된 선택입니다! 다시 선택해주세요!");
				continue;
			}
			//추가토핑은 금액계산 불필요
			setNoVegetable(getSelectNum(), "할라피뇨", "올리브", "토마토", "피망", "없음");
			break;
		}
		//7.소스선택
		while(true) {
			cashAndPriceInfo(user);
			showSauce("스위트어니언", "스위트칠리", "랜치", "바베큐", "레드와인식초");
			
			//소스 입력받기
			selectNum();
			
			//이상한값인지 판단 후 true면 메뉴 다시 안내
			if(checkWeirdNum1()) {
				System.out.println("\n잘못된 선택입니다! 다시 선택해주세요!");
				continue;
			}
			//소스는 금액계산 불필요
			setSauce(getSelectNum(), "스위트어니언", "스위트칠리", "랜치", "바베큐", "레드와인식초");
			break;
		}
		//8.세트메뉴 선택
		while(true) {
			cashAndPriceInfo(user);
			showSetMenu("쿠키음료세트", 1900, "추가안함");
			
			//세트메뉴 입력받기
			selectNum();
			
			//이상한값인지 판단 후 true면 메뉴 다시 안내
			if(checkWeirdNum2()) {
				System.out.println("\n잘못된 선택입니다! 다시 선택해주세요!");
				continue;
			}
			//금액부족 판단 -> 부족하면 메뉴 다시안내
			boolean isLackOfCash = checkLackOfCach(user, 1900, 0);
			if(isLackOfCash && (isCoupon==false)) {
				continue;
			}
			//금액부족 판단 -> 안부족하면 금액계산
			calcMenu(1900, 0);
			
			setSetMenu(getSelectNum(), "쿠키음료세트", "추가안함");
			
			break;
		}
		
		if(isCoupon == false) {
			//9.쿠폰미사용: 메뉴전달, 계산
			notice(user);
			
			//10.쿠폰획득
			getCoupon(user);
		} else {
			//9.쿠폰사용: 메뉴 무료
			noticeFree(user);
		}
		
	}
	public void welcome(User user) {
		System.out.println("-------------------------------------------------");
		System.out.println(user.getUserName()+"님 어서오세요! 서브웨이입니다~");
	}
	
	public void showMenu(String menu1, String menu2, String menu3, String menu4, String menu5, int menu1Price15cm, int menu2Price15cm, int menu3Price15cm, int menu4Price15cm, int menu5Price15cm, int menu1Price30cm, int menu2Price30cm, int menu3Price30cm, int menu4Price30cm, int menu5Price30cm) {
		System.out.println("====================== 메뉴판 ======================");
		System.out.println("1. " + menu1 + "       | 15cm : " + menu1Price15cm + "원 | 30cm : "+ menu1Price30cm + "원");
		System.out.println("2. " + menu2 + "    | 15cm : " + menu2Price15cm + "원 | 30cm : "+ menu2Price30cm + "원");
		System.out.println("3. " + menu3 + "| 15cm : " + menu3Price15cm + "원 | 30cm : "+ menu3Price30cm + "원");
		System.out.println("4. " + menu4 + "  | 15cm : " + menu4Price15cm + "원 | 30cm : "+ menu4Price30cm + "원");
		System.out.println("5. " + menu5 + " | 15cm : " + menu5Price15cm + "원 | 30cm : "+ menu5Price30cm + "원");
		System.out.println("==================================================");
		System.out.print("STEP1. 메뉴를 선택해주세요 : ");
	}
	
	public void selectNum() {
		Scanner sc = new Scanner(System.in);
		setSelectNum(sc.nextLine());
	}
	
	public boolean checkWeirdNum1() {
		String num = getSelectNum();
		if(!num.equals("1") && !num.equals("2") && !num.equals("3") && !num.equals("4") && !num.equals("5")) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean checkWeirdNum2() {
		String num = getSelectNum();
		if(!num.equals("1") && !num.equals("2")) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean checkLackOfCach(User user,int menu1Price, int menu2Price, int menu3Price, int menu4Price, int menu5Price) {
		switch(getSelectNum()) {
		case "1":
			if((user.getCash() < getMenuPrice() + menu1Price) && (getIsCoupon() == false)) {
				System.out.println("\n캐쉬가 부족합니다. 다시 선택해주세요.");
				return true;
			} else {
				return false;
			}
		case "2":
			if((user.getCash() < getMenuPrice() + menu2Price) && (getIsCoupon() == false)) {
				System.out.println("\n캐쉬가 부족합니다. 다시 선택해주세요.");
				return true;
			} else {
				return false;
			}
		case "3":
			if((user.getCash() < getMenuPrice() + menu3Price) && (getIsCoupon() == false)) {
				System.out.println("\n캐쉬가 부족합니다. 다시 선택해주세요.");
				return true;
			} else {
				return false;
			}
		case "4":
			if((user.getCash() < getMenuPrice() + menu4Price) && (getIsCoupon() == false)) {
				System.out.println("\n캐쉬가 부족합니다. 다시 선택해주세요.");
				return true;
			} else {
				return false;
			}
		case "5":
			if((user.getCash() < getMenuPrice() + menu5Price) && (getIsCoupon() == false)) {
				System.out.println("\n캐쉬가 부족합니다. 다시 선택해주세요.");
				return true;
			} else {
				return false;
			}
		default:
			return false;
		}
	}
	
	public boolean checkLackOfCach2(User user,int menu1Price, int menu2Price, int menu3Price, int menu4Price, int menu5Price) {
		switch(getMenuNum()) {
		case "1":
			if((user.getCash() < getMenuPrice() + menu1Price) && (getIsCoupon() == false)) {
				System.out.println("\n캐쉬가 부족합니다. 다시 선택해주세요.");
				return true;
			} else {
				return false;
			}
		case "2":
			if((user.getCash() < getMenuPrice() + menu2Price) && (getIsCoupon() == false)) {
				System.out.println("\n캐쉬가 부족합니다. 다시 선택해주세요.");
				return true;
			} else {
				return false;
			}
		case "3":
			if((user.getCash() < getMenuPrice() + menu3Price) && (getIsCoupon() == false)) {
				System.out.println("\n캐쉬가 부족합니다. 다시 선택해주세요.");
				return true;
			} else {
				return false;
			}
		case "4":
			if((user.getCash() < getMenuPrice() + menu4Price) && (getIsCoupon() == false)) {
				System.out.println("\n캐쉬가 부족합니다. 다시 선택해주세요.");
				return true;
			} else {
				return false;
			}
		case "5":
			if((user.getCash() < getMenuPrice() + menu5Price) && (getIsCoupon() == false)) {
				System.out.println("\n캐쉬가 부족합니다. 다시 선택해주세요.");
				return true;
			} else {
				return false;
			}
		default:
			return false;
		}
	}
	
	//checkLackOfCach() 메소드 오버로딩
	public boolean checkLackOfCach(User user,int menu1Price, int menu2Price) {
		switch(getSelectNum()) {
		case "1":
			if((user.getCash() < getMenuPrice() + menu1Price) && (getIsCoupon() == false)) {
				System.out.println("\n캐쉬가 부족합니다. 다시 선택해주세요.");
				return true;
			} else {
				return false;
			}
		case "2":
			if((user.getCash() < getMenuPrice() + menu2Price) && (getIsCoupon() == false)) {
				System.out.println("\n캐쉬가 부족합니다. 다시 선택해주세요.");
				return true;
			} else {
				return false;
			}
		default:
			return false;
		}
	}
	
	public void calcMenu(int menu1Price, int menu2Price, int menu3Price, int menu4Price, int menu5Price) {
		switch(getSelectNum()) {
		case "1" :
			setMenuPrice(getMenuPrice() + menu1Price);
			break;
		case "2" :
			setMenuPrice(getMenuPrice() + menu2Price);
			break;
		case "3" :
			setMenuPrice(getMenuPrice() + menu3Price);
			break;
		case "4" :
			setMenuPrice(getMenuPrice() + menu4Price);
			break;
		case "5" :
			setMenuPrice(getMenuPrice() + menu5Price);
			break;	
		}
		
	}
	
	public void calcMenu2(int menu1Price, int menu2Price, int menu3Price, int menu4Price, int menu5Price) {
		switch(getMenuNum()) {
		case "1" :
			setMenuPrice(getMenuPrice() + menu1Price);
			break;
		case "2" :
			setMenuPrice(getMenuPrice() + menu2Price);
			break;
		case "3" :
			setMenuPrice(getMenuPrice() + menu3Price);
			break;
		case "4" :
			setMenuPrice(getMenuPrice() + menu4Price);
			break;
		case "5" :
			setMenuPrice(getMenuPrice() + menu5Price);
			break;	
		}
		
	}
	
	//calcMenu() 메소드 오버로딩
	public void calcMenu(int menu1Price, int menu2Price) {
		switch(getSelectNum()) {
		case "1" :
			setMenuPrice(getMenuPrice() + menu1Price);
			break;
		case "2" :
			setMenuPrice(getMenuPrice() + menu2Price);
			break;
		}
		
	}
	
	public void showBread(String bread1, String bread2, String bread3, String bread4, String bread5) {
		System.out.println("====================== 빵 선택 =====================");
		System.out.println("\t\t1. " + bread1);
		System.out.println("\t\t2. " + bread2);
		System.out.println("\t\t3. " + bread3);
		System.out.println("\t\t4. " + bread4);
		System.out.println("\t\t5. " + bread5);
		System.out.println("==================================================");
		System.out.print("STEP2. 빵을 선택해주세요 : ");
	}
	
	public void showMenuSize() {
		System.out.println("==================== 사이즈 선택 ====================");
		System.out.println("\t\t1. 15cm");
		System.out.println("\t\t2. 30cm");
		System.out.println("==================================================");
		System.out.print("STEP3. 사이즈를 선택해주세요 : ");
	}
	
	public void showCheese(String cheese1, String cheese2) {
		System.out.println("==================== 치즈 선택 =====================");
		System.out.println("\t\t1. " + cheese1);
		System.out.println("\t\t2. " + cheese2);
		System.out.println("==================================================");
		System.out.print("STEP4. 치즈를 선택해주세요 : ");
	}

	public void showToping(String toping1, int toping1Price, String toping2, int toping2Price, String toping3, int toping3Price, String toping4, int toping4Price) {
		System.out.println("=================== 추가토핑 선택 ====================");
		System.out.println("1."+toping1+"(15cm : "+toping1Price+"원 / 30cm : "+toping1Price*2+"원)");
		System.out.println("2."+toping2+"(15cm : "+toping2Price+"원 / 30cm : "+toping2Price*2+"원)");
		System.out.println("3."+toping3+"(15cm : "+toping3Price+"원 / 30cm : "+toping3Price*2+"원)");
		System.out.println("4."+toping4+"(15cm : "+toping4Price+"원 / 30cm : "+toping4Price*2+"원)");
		System.out.println("5.선택안함");
		System.out.println("==================================================");
		System.out.print("STEP5. 추가토핑을 선택해주세요 : ");
	}
	public void showVegetable(String vegetable1, String vegetable2, String vegetable3, String vegetable4, String vegetable5) {
		System.out.println("================== 빼고싶은 야채 선택 ==================");
		System.out.println("\t\t1. " + vegetable1);
		System.out.println("\t\t2. "+ vegetable2);
		System.out.println("\t\t3. " + vegetable3);
		System.out.println("\t\t4. " + vegetable4);
		System.out.println("\t\t5. " + vegetable5);
		System.out.println("===================================================");
		System.out.print("STEP6. 빼고싶은 야채를 선택해주세요 : ");
	}
	public void showSauce(String sauce1, String sauce2, String sauce3, String sauce4, String sauce5) {
		System.out.println("===================== 소스 선택 =====================");
		System.out.println("\t\t1. " + sauce1);
		System.out.println("\t\t2. " + sauce2);
		System.out.println("\t\t3. " + sauce3);
		System.out.println("\t\t4. " + sauce4);
		System.out.println("\t\t5. " + sauce5);
		System.out.println("===================================================");
		System.out.print("STEP7. 소스를 선택해주세요 : ");
	}
	public void showSetMenu(String setMenu1, int setMenu1Price, String setMenu2) {
		System.out.println("===================== 세트 선택 ======================");
		System.out.println("\t\t1. "+setMenu1+" (+"+ setMenu1Price +"원)");
		System.out.println("\t\t2. " + setMenu2);
		System.out.println("===================================================");
		System.out.print("STEP8. 세트를 선택해주세요 : ");
	}
	
	public void notice(User user) {
		System.out.println(".\n.\n.\n.\n.");
		System.out.println(user.getUserName() + "님 주문하신 메뉴 나왔습니다.");
		System.out.println(toString());
		System.out.println("\n결제 도와드리겠습니다~ 총 " + getMenuPrice() + "원 입니다.");
		user.setCash(user.getCash() - getMenuPrice());
		System.out.println("\n감사합니다. 맛있게드세요~!");
	}
	
	public void noticeFree(User user) {
		System.out.println(".\n.\n.\n.\n.");
		System.out.println(user.getUserName() + "님 주문하신 메뉴 나왔습니다.");
		System.out.println(toString());
		System.out.println("쿠폰 3장을 사용하셔서 무료로 드립니다~");
		System.out.println("\n감사합니다. 맛있게드세요~!");
		System.out.println("\n\n쿠폰 3장 차감...");
	}
	
	public void getCoupon(User user) {
		user.setCouponNum(user.getCouponNum()+1);
		System.out.println("\n~ 서브웨이 쿠폰 1개 획득! ~");
	}
	
	public void cashAndPriceInfo(User user) {
		System.out.println("\n나의 캐쉬 : " + user.getCash() + "\t현재 메뉴가격 : " + getMenuPrice());
	}
	
	@Override
	public String toString() {
		return "\n\t\t[ 영 수 증 ]\n\n\t▶ 메뉴 : " + menu + "\n\t▶ 빵 : " + bread + "\n\t▶ 메뉴 사이즈 : " + menuSize + "\n\t▶ 치즈 : " + cheese
				+ "\n\t▶ 추가토핑 : " + toping + "\n\t▶ 빼고싶은 야채 : " + noVegetable + "\n\t▶ 소스 : " + sauce + "\n\t▶ 세트 메뉴 : " + setMenu+ "\n\t▶ 총 금액 : " + menuPrice +"원\n";
	}
	
	public String getMenu() {
		return menu;
	}
	public void setMenu(String selectNum, String menu1, String menu2, String menu3, String menu4, String menu5) {
		switch(selectNum) {
		case "1" :
			this.menu = menu1;
			break;
		case "2" :
			this.menu = menu2;
			break;
		case "3" :
			this.menu = menu3;
			break;
		case "4" :
			this.menu = menu4;
			break;
		case "5" :
			this.menu = menu5;
			break;
		}
	}
	public String getBread() {
		return bread;
	}
	public void setBread(String selectNum, String bread1, String bread2, String bread3, String bread4, String bread5) {
		switch(selectNum) {
		case "1" :
			this.bread = bread1;
			break;
		case "2" :
			this.bread = bread2;
			break;
		case "3" :
			this.bread = bread3;
			break;
		case "4" :
			this.bread = bread4;
			break;
		case "5" :
			this.bread = bread5;
			break;
		}
	}
	public String getMenuSize() {
		return menuSize;
	}
	public void setMenuSize(String selectNum, String menuSize15cm, String menuSize30cm) {
		switch(selectNum) {
		case "1" :
			this.menuSize = menuSize15cm;
			break;
		case "2" :
			this.menuSize = menuSize30cm;
			break;
		}
	}
	public String getCheese() {
		return cheese;
	}
	public void setCheese(String selectNum, String cheese1, String cheese2) {
		switch(selectNum) {
		case "1" :
			this.cheese = cheese1;
			break;
		case "2" :
			this.cheese = cheese2;
			break;
		}
	}
	public String getToping() {
		return toping;
	}
	public void setToping(String selectNum, String toping1, String toping2, String toping3, String toping4, String toping5) {
		switch(selectNum) {
		case "1" :
			this.toping = toping1;
			break;
		case "2" :
			this.toping = toping2;
			break;
		case "3" :
			this.toping = toping3;
			break;
		case "4" :
			this.toping = toping4;
			break;
		case "5" :
			this.toping = toping5;
			break;
		}
	}
	public String getNoVegetable() {
		return noVegetable;
	}
	public void setNoVegetable(String selectNum, String noVegetable1, String noVegetable2, String noVegetable3, String noVegetable4, String noVegetable5) {
		switch(selectNum) {
		case "1" :
			this.noVegetable = noVegetable1;
			break;
		case "2" :
			this.noVegetable = noVegetable2;
			break;
		case "3" :
			this.noVegetable = noVegetable3;
			break;
		case "4" :
			this.noVegetable = noVegetable4;
			break;
		case "5" :
			this.noVegetable = noVegetable5;
			break;
		}
	}
	public String getSauce() {
		return sauce;
	}
	public void setSauce(String selectNum, String sauce1, String sauce2, String sauce3, String sauce4, String sauce5) {
		switch(selectNum) {
		case "1" :
			this.sauce = sauce1;
			break;
		case "2" :
			this.sauce = sauce2;
			break;
		case "3" :
			this.sauce = sauce3;
			break;
		case "4" :
			this.sauce = sauce4;
			break;
		case "5" :
			this.sauce = sauce5;
			break;
		}
	}
	public String getSetMenu() {
		return setMenu;
	}
	public void setSetMenu(String selectNum, String setMenu1, String setMenu2) {
		switch(selectNum) {
		case "1" :
			this.setMenu = setMenu1;
			break;
		case "2" :
			this.setMenu = setMenu2;
			break;
		}
	}
	public String getSelectNum() {
		return selectNum;
	}
	public void setSelectNum(String selectNum) {
		this.selectNum = selectNum;
	}
	public int getMenuPrice() {
		return menuPrice;
	}
	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}
	
	public boolean getIsCoupon() {
		return isCoupon;
	}
	
	public void setIsCoupon(boolean isCoupon) {
		this.isCoupon = isCoupon;
	}
	public boolean getIs30cm() {
		return is30cm;
	}
	public void setIs30cm(boolean is30cm) {
		this.is30cm = is30cm;
	}
	public String getMenuNum() {
		return menuNum;
	}
	public void setMenuNum(String menuNum) {
		this.menuNum = menuNum;
	}
	
	
	
	

}
