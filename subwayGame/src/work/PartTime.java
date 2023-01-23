package work;

import order.OrderManager;
import user.User;

public class PartTime {
	private int intMenu;
	private int intBread;
	private int intMenuSize;
	private int intCheese;
	private int intToping;
	private int intNoVegetable;
	private int intSauce;
	private int intSetMenu;
	private int selectNum;
	private int menuPrice = 0;
	private String menu;
	private String bread;
	private String menuSize;
	private String cheese;
	private String toping;
	private String noVegetable;
	private String sauce;
	private String setMenu;
	
	public void receiveOrder(User user) {
		OrderManager om = new OrderManager();
		//총금액 초기화
		this.menuPrice = 0;
		
		//컴퓨터가 메뉴를 숫자로 랜덤 선택
		this.intMenu = (int)((Math.random()*5)+1);
		this.intBread = (int)((Math.random()*5)+1);
		this.intMenuSize = (int)((Math.random()*2)+1);
		this.intCheese = (int)((Math.random()*2)+1);
		this.intToping = (int)((Math.random()*5)+1);
		this.intNoVegetable = (int)((Math.random()*5)+1);
		this.intSauce = (int)((Math.random()*5)+1);
		this.intSetMenu = (int)((Math.random()*2)+1);
		//랜덤 숫자에 따라 메뉴 세팅해주기
		setMenu(this.intMenu, "베지", "에그마요", "이탈리안비엠티", "서브웨이클럽", "스테이크&치즈");
		setBread(this.intBread,"플랫브레드", "허니오트", "화이트", "파마산오레가노", "위트");
		setMenuSize(this.intMenuSize, "15cm", "30cm");
		setCheese(this.intCheese, "아메리칸치즈", "슈레드치즈");
		setToping(this.intToping, "에그마요", "베이컨", "오믈렛", "아보카도", "추가안함");
		setNoVegetable(this.intNoVegetable, "할라피뇨", "올리브", "토마토", "피망", "없음");
		setSauce(this.intSauce, "스위트어니언", "스위트칠리", "랜치", "바베큐", "레드와인식초");
		setSetMenu(this.intSetMenu, "쿠키음료세트", "추가안함");
		
		//총 금액 계산하기
		calcMenu(this.intMenu, 4100, 4600, 5700, 6200, 6900);
		if (this.intMenuSize == 2) {
			calcMenu(this.intMenu,3500, 3900, 4700, 5000, 5300);			
		}
		calcMenu(this.intToping,1600, 1000, 1300, 1300, 0);
		calcMenu(this.intSetMenu, 1900, 0);
		
		//영수증 출력하기
		System.out.println(toString());
		//알바하기 설명
		partTimeInfo();
		
		while(true) {
			om.showMenu("베지", "에그마요", "이탈리안비엠티", "서브웨이클럽", "스테이크&치즈", 4100, 4600, 5700, 6200, 6900, 7600, 8500, 10400, 11200, 12200);
			om.selectNum();
			if(checkWeirdNum1(om, this.intMenu)) {
				System.out.println("\n영수증을 다시 확인해주세요!");
				continue;
			}
			break;
		}
		
		while(true) {
			om.showBread("플랫브레드", "허니오트", "화이트", "파마산오레가노", "위트");
			om.selectNum();
			if(checkWeirdNum1(om, this.intBread)) {
				System.out.println("\n영수증을 다시 확인해주세요!");
				continue;
			}
			break;
		}
		while(true) {
			om.showMenuSize();
			om.selectNum();
			if(checkWeirdNum1(om, this.intMenuSize)) {
				System.out.println("\n영수증을 다시 확인해주세요!");
				continue;
			}
			break;
		}
		while(true) {
			om.showCheese("아메리칸치즈", "슈레드치즈");
			om.selectNum();
			if(checkWeirdNum1(om, this.intCheese)) {
				System.out.println("\n영수증을 다시 확인해주세요!");
				continue;
			}
			break;
		}
		while(true) {
			om.showToping("에그마요",1600, "베이컨",1000, "오믈렛", 1300, "아보카도", 1300);
			om.selectNum();
			if(checkWeirdNum1(om, this.intToping)) {
				System.out.println("\n영수증을 다시 확인해주세요!");
				continue;
			}
			break;
		}
		while(true) {
			om.showVegetable("할라피뇨", "올리브", "토마토", "피망", "없음");
			om.selectNum();
			if(checkWeirdNum1(om, this.intNoVegetable)) {
				System.out.println("\n영수증을 다시 확인해주세요!");
				continue;
			}
			break;
		}
		while(true) {
			om.showSauce("스위트어니언", "스위트칠리", "랜치", "바베큐", "레드와인식초");
			om.selectNum();
			if(checkWeirdNum1(om, this.intSauce)) {
				System.out.println("\n영수증을 다시 확인해주세요!");
				continue;
			}
			break;
		}
		while(true) {
			om.showSetMenu("쿠키음료세트", 1900, "추가안함");
			om.selectNum();
			if(checkWeirdNum1(om, this.intSetMenu)) {
				System.out.println("\n영수증을 다시 확인해주세요!");
				continue;
			}
			break;
		}
		goodBye(user);
		user.setCash(user.getCash() + 15000);
		System.out.println("캐시 15000원 획득!");
		
	}
	
	public void calcMenu(int intSelectNum, int menu1Price, int menu2Price, int menu3Price, int menu4Price, int menu5Price) {
		switch(intSelectNum) {
		case 1 :
			setMenuPrice(getMenuPrice() + menu1Price);
			break;
		case 2 :
			setMenuPrice(getMenuPrice() + menu2Price);
			break;
		case 3 :
			setMenuPrice(getMenuPrice() + menu3Price);
			break;
		case 4 :
			setMenuPrice(getMenuPrice() + menu4Price);
			break;
		case 5 :
			setMenuPrice(getMenuPrice() + menu5Price);
			break;	
		}
		
	}
	//calcMenu() 메소드 오버로딩
	public void calcMenu(int intSelectNum, int menu1Price, int menu2Price) {
		switch(intSelectNum) {
		case 1 :
			setMenuPrice(getMenuPrice() + menu1Price);
			break;
		case 2 :
			setMenuPrice(getMenuPrice() + menu2Price);
			break;
		}
		
	}
	
	public void partTimeInfo() {
		System.out.println("영수증을 보고 손님이 주문한 샌드위치를 만들어보세요!\n");
	}
	
	public boolean checkWeirdNum1(OrderManager om, int num) {
		if(!om.getSelectNum().equals(Integer.toString(num))) {
			return true;
		} else {
			return false;
		}
	}
	
	public void goodBye(User user) {
		System.out.println("\n"+user.getUserName() + " : 손님 주문하신 샌드위치 나왔습니다~");
	}
	
	

	public int getSelectNum() {
		return selectNum;
	}

	public void setSelectNum(int selectNum) {
		this.selectNum = selectNum;
	}

	public int getMenuPrice() {
		return menuPrice;
	}

	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(int intMenu, String menu1, String menu2, String menu3, String menu4, String menu5) {
		switch(intMenu) {
		case 1 :
			this.menu = menu1;
			break;
		case 2 :
			this.menu = menu2;
			break;
		case 3 :
			this.menu = menu3;
			break;
		case 4 :
			this.menu = menu4;
			break;
		case 5 :
			this.menu = menu5;
			break;
		}
	}
	
	public String getBread() {
		return bread;
	}

	public void setBread(int intBread, String bread1, String bread2, String bread3, String bread4, String bread5) {
		switch(intBread) {
		case 1 :
			this.bread = bread1;
			break;
		case 2 :
			this.bread = bread2;
			break;
		case 3 :
			this.bread = bread3;
			break;
		case 4 :
			this.bread = bread4;
			break;
		case 5 :
			this.bread = bread5;
			break;
		}
	}

	public String getMenuSize() {
		return menuSize;
	}
	
	public void setMenuSize(int intMenuSize, String menuSize15cm, String menuSize30cm) {
		switch(intMenuSize) {
		case 1 :
			this.menuSize = menuSize15cm;
			break;
		case 2 :
			this.menuSize = menuSize30cm;
			break;
		}
	}

	public String getCheese() {
		return cheese;
	}

	public void setCheese(int intCheese, String cheese1, String cheese2) {
		switch(intCheese) {
		case 1 :
			this.cheese = cheese1;
			break;
		case 2 :
			this.cheese = cheese2;
			break;
		}
	}

	public String getToping() {
		return toping;
	}

	public void setToping(int intToping, String toping1, String toping2, String toping3, String toping4, String toping5) {
		switch(intToping) {
		case 1 :
			this.toping = toping1;
			break;
		case 2 :
			this.toping = toping2;
			break;
		case 3 :
			this.toping = toping3;
			break;
		case 4 :
			this.toping = toping4;
			break;
		case 5 :
			this.toping = toping5;
			break;
		}
	}
	
	public String getNoVegetable() {
		return noVegetable;
	}

	public void setNoVegetable(int intNoVegetable, String noVegetable1, String noVegetable2, String noVegetable3, String noVegetable4, String noVegetable5) {
		switch(intNoVegetable) {
		case 1 :
			this.noVegetable = noVegetable1;
			break;
		case 2 :
			this.noVegetable = noVegetable2;
			break;
		case 3 :
			this.noVegetable = noVegetable3;
			break;
		case 4 :
			this.noVegetable = noVegetable4;
			break;
		case 5 :
			this.noVegetable = noVegetable5;
			break;
		}
	}

	public String getSauce() {
		return sauce;
	}

	public void setSauce(int intSauce, String sauce1, String sauce2, String sauce3, String sauce4, String sauce5) {
		switch(intSauce) {
		case 1 :
			this.sauce = sauce1;
			break;
		case 2 :
			this.sauce = sauce2;
			break;
		case 3 :
			this.sauce = sauce3;
			break;
		case 4 :
			this.sauce = sauce4;
			break;
		case 5 :
			this.sauce = sauce5;
			break;
		}
	}

	public String getSetMenu() {
		return setMenu;
	}

	public void setSetMenu(int intSetMenu, String setMenu1, String setMenu2) {
		switch(intSetMenu) {
		case 1 :
			this.setMenu = setMenu1;
			break;
		case 2 :
			this.setMenu = setMenu2;
			break;
		}
	}

	@Override
	public String toString() {
		return "\n\t\t[ 영 수 증 ]\n\n\t▶ 메뉴 : " + menu + "\n\t▶ 빵 : " + bread + "\n\t▶ 메뉴 사이즈 : " + menuSize + "\n\t▶ 치즈 : " + cheese
				+ "\n\t▶ 추가토핑 : " + toping + "\n\t▶ 빼고싶은 야채 : " + noVegetable + "\n\t▶ 소스 : " + sauce + "\n\t▶ 세트 메뉴 : " + setMenu+ "\n\t▶ 총 금액 : " + menuPrice +"원\n";
	}
	
}
