package mini;

import java.util.Scanner;

import user.User;

public class MiniGame {
	public void miniGame(User u, String user, String target, String block, int targetNum, int arrSize) {
		String[][] arr =  new String[arrSize][arrSize];
		
		for(int i=0; i<arrSize; i++) {
			for(int j=0; j<arrSize; j++) {
				arr[i][j] = block;		}
		}
		
		for(int i=0; i<targetNum; i++) {
			//랜덤 좌표에 치즈 생성
			int row = (int)(Math.random()*arrSize);
			int col = (int)(Math.random()*arrSize);
			
			//유저가 (0,0)에서 시작하므로 치즈는 (0,0)에 생기면 안됨
			while(row == 0 && col == 0) {
				row = (int)(Math.random()*arrSize);
				col = (int)(Math.random()*arrSize);
			}
			//치즈 중복 제거
			while(arr[row][col] == target) {
				row = (int)(Math.random()*arrSize);
				col = (int)(Math.random()*arrSize);
			}
			
			arr[row][col] = target;
		}
		
		int x = 0;
		int y = 0;
		
		System.out.println("\t[ 미니게임 ]");
		System.out.println("치즈" + targetNum + "개를 모두 먹으면 승리!\n");
		
		while(true) {
			if(arr[x][y] == target) {
				arr[x][y] = block;
				targetNum--;
				
				
				if(targetNum <= 0) {
					System.out.println("치즈를 모두 먹었습니다. 게임을 종료합니다.");
					u.setCash(u.getCash() + 10000);
					System.out.println("캐시 10000원 획득!");
					break;
				}
			}
			arr[x][y] = user;
			for(int i=0; i<arrSize; i++) {
				for(int j=0; j<arrSize; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
			
			System.out.print("방향키 입력(w:위 a:왼쪽 s:아래 d:오른쪽) : ");
			Scanner sc = new Scanner(System.in);
			String str = sc.nextLine();
			
			if(str.equals("w")) {
				arr[x--][y] = user;
				int x2 = x+1;
				arr[x2][y] = block;
				if(x<0) {
					x=0;
					System.out.println("더이상 위로 움직일 수 없습니다.");
					continue;
				}else {
					System.out.println("");
				}
				
			}else if(str.equals("a")) {
				arr[x][y--] = user;
				int y2 = y+1;
				arr[x][y2] = block;
				if(y<0) {
					y=0;
					System.out.println("더이상 왼쪽으로 움직일 수 없습니다.");
					continue;
				}else {
					System.out.println("");
				}
			}else if(str.equals("s")) {
				arr[x++][y] = user;
				int x2 = x-1;
				arr[x2][y] = block;
				if(x>(arrSize-1)) {
					x=(arrSize-1);
					System.out.println("더이상 아래쪽으로 움직일 수 없습니다.");
					continue;
				}else {
					System.out.println("");
				}
			}else if(str.equals("d")) {
				arr[x][y++] = user;
				int y2 = y-1;
				arr[x][y2] = block;
				if(y>(arrSize-1)) {
					y=(arrSize-1);
					System.out.println("더이상 오른쪽으로 움직일 수 없습니다.");
					continue;
				}else {
					System.out.println("");
				}
			}
		}
		
		
	}
}
