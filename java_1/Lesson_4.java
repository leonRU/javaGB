package lesson_4;

import java.util.Random;
import java.util.Scanner;

public class Lesson_4 {
	public static char[][] map;
	public final static int SIZE = 5;
	public final static int DOTS_TO_WIN = 4;
	
	public final static char DOT_EMPTY = '*';
	public final static char DOT_X = 'X';
	public final static char DOT_O = 'O';
	
	public static Scanner sc = new Scanner(System.in);
	public static Random random = new Random();
	
	public static void initMap() {
		map = new char [SIZE][SIZE];
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				map[i][j] = DOT_EMPTY;
			}
		}
	}
	
	public static void printMap() {
		System.out.print("  ");
		for(int i = 1; i <= SIZE; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		for(int i = 0; i < map.length; i++) {
			System.out.printf("%d ", i+1);
			for(int j = 0; j < map[i].length; j++) {
				System.out.printf("%c ", map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void humanTurn() {
		int x, y;
		do {
			System.out.println("Введите координаты в формате X Y");
			x = sc.nextInt()-1;
			y = sc.nextInt()-1;
		}while(!isCellValid(x,y));
		map[y][x] = DOT_X;
	}
	
	public static boolean isCellValid(int x, int y) {
		if(x < 0 || x >= map[0].length || y < 0 || y >= map.length) {
			return false;
		}
		if(map[y][x] != DOT_EMPTY) {
			return false;
		}
		return true;
	}
	
	public static void aiTurn() {
		//на поле 5х5 блокировка игнорирует дополнительные диагонали
		int x=-1;
		int y=-1;
		int countH = 0;
		int countV = 0;
		int countDiag1 = 0;
		int countDiag2 = 0;
		
	out:for(int i = 0; i < map.length; i++) {
			countH = 0;
			countV = 0;
			for(int j = 0; j < map[i].length; j++) {
				if(map[i][j] == DOT_X) {
					countH++;
					if(countH == DOTS_TO_WIN - 1) {
						y = i;
						if(j < map[i].length - 1) {
							x = j +1;
							if(isCellValid(x,y)) {
								break out;
							}
						}
						x = map[i].length - DOTS_TO_WIN;
						if(isCellValid(x,y)) {
							break out;
						}
					}
				}
				if(map[j][i] == DOT_X) {
					countV++;
					if(countV == DOTS_TO_WIN - 1) {
						x = i;
						if(j < map.length - 1) {
							y = j + 1;
							if(isCellValid(x,y)) {
								break out;	
							}
						}
						y = map.length - DOTS_TO_WIN;
						if(isCellValid(x,y)) {
							break out;	
						}
					}
				}
			}
			if(map[i][i] == DOT_X) {
				countDiag1++;
				if(countDiag1 == DOTS_TO_WIN - 1) {
					if(i < map.length - 1) {
						x = i + 1;
						y = i + 1;
						if(isCellValid(x,y)) {
							break;
						}
					}
					x = map.length - DOTS_TO_WIN;
					y = map.length - DOTS_TO_WIN;
					if(isCellValid(x,y)) {
						break;
					}
				}
			}
			if(map[i][map[i].length - 1 - i] == DOT_X) {
				countDiag2++;
				if(countDiag2 == DOTS_TO_WIN - 1) {
					if(i < map.length - 1 && i > 0) {
						y = i + 1;
						x = map.length - 2 - i;
						if(isCellValid(x,y)) {
							break;
						}
					}
					y = map.length - DOTS_TO_WIN;
					x = DOTS_TO_WIN - 1;	
					if(isCellValid(x,y)) {
						break;
					}
				}
			}
		}
		
		if(!isCellValid(x,y)) {
			do {			
				x = random.nextInt(map[0].length);
				y = random.nextInt(map.length);			
			}while(!isCellValid(x,y));
		}
		System.out.println("Компьютер походил в точку " + (x+1) + " " + (y+1));
		map[y][x] = DOT_O;
	}
	
	public static boolean checkWin(char symb) {
		int countH = 0;
		int countV = 0;
		int countDiag1 = 0;
		int countDiag11 = 0;
		int countDiag12 = 0;
		int countDiag2 = 0;
		int countDiag21 = 0;
		int countDiag22 = 0;
//		if(map[0][0] == symb && map[0][1] == symb && map[0][2] == symb) return true;
//		if(map[1][0] == symb && map[1][1] == symb && map[1][2] == symb) return true;
//		if(map[2][0] == symb && map[2][1] == symb && map[2][2] == symb) return true;
//		if(map[0][0] == symb && map[1][0] == symb && map[2][0] == symb) return true;
//		if(map[0][1] == symb && map[1][1] == symb && map[2][1] == symb) return true;
//		if(map[0][2] == symb && map[1][2] == symb && map[2][2] == symb) return true;
//		if(map[0][0] == symb && map[1][1] == symb && map[2][2] == symb) return true;
//		if(map[2][0] == symb && map[1][1] == symb && map[0][2] == symb) return true;
		for(int i = 0; i < map.length; i++) {
			countH = 0;
			countV = 0;
			for(int j = 0; j < map[i].length; j++) {
				if(map[i][j] == symb) {
					countH++;
					if(countH == DOTS_TO_WIN) {
						return true;
					}
				}
				if(map[j][i] == symb) {
					countV++;
					if(countV == DOTS_TO_WIN) {
						return true;
					}
				}
			}
			if(map[i][i] == symb) {
				countDiag1++;
				if(countDiag1 == DOTS_TO_WIN) {
					return true;
				}
			}
			if(i < map.length - 1 && map[i][i+1] == symb) {
				countDiag11++;
				if(countDiag11 == DOTS_TO_WIN) {
					return true;
				}
			}
			if(i < map.length - 1 && map[i+1][i] == symb) {
				countDiag12++;
				if(countDiag12 == DOTS_TO_WIN) {
					return true;
				}
			}
			
			
			if(map[i][map.length - 1 - i] == symb) {
				countDiag2++;
				if(countDiag2 == DOTS_TO_WIN) {
					return true;
				}
			}
			if(i < map.length - 1 && map[i][map.length - 1 - i - 1] == symb) {
				countDiag21++;
				if(countDiag21 == DOTS_TO_WIN) {
					return true;
				}
			}
			if(i < map.length - 1 && map[i+1][map.length - 1 - i] == symb) {
				countDiag22++;
				if(countDiag22 == DOTS_TO_WIN) {
					return true;
				}
			}

		}
		return false;
	}
	
	public static boolean isMapFull() {
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				if(map[i][j] == DOT_EMPTY) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] arg) {
		initMap();
		printMap();
		while(true) {
			humanTurn();
			printMap();
			if(checkWin(DOT_X)) {
				System.out.println("Победил человек");
				break;
			}
			if(isMapFull()) {
				System.out.println("Ничья");
				break;
			}
			aiTurn();
			printMap();
			if(checkWin(DOT_O)) {
				System.out.println("Победил AI");
				break;
			}
			if(isMapFull()) {
				System.out.println("Ничья");
				break;
			}
			
		}
		System.out.println("Игра закончена");
		
	}
}
