package com.hun.memo;

import java.util.Scanner;

public class MemoMain {
	public static void main(String[] args) {
		// 1. 키보드입력으로 명령어받기
		// 1)쓰기 2)읽기 3)수정 4)삭제
		
		Memo memo = new Memo();
		
		
		Scanner sc = new Scanner(System.in);
		boolean runFlag = true;
		while(runFlag) {
			memo.showCommand();
			String cmd = sc.nextLine();
		
			switch(cmd) {
			case "1":
				memo.write(sc);
				break;
			case "2":
				memo.list();
				System.out.print("읽을 파일명을 입력하세요: ");
				memo.read(sc.nextLine());
				break;
			case "3":
				System.out.print("수정할 파일명을 입력하세요: ");
				memo.modify(sc,sc.nextLine());
				break;
			case "4":
				System.out.print("삭제할 파일명을 입력하세요: ");
				memo.delete(sc.nextLine());
				break;
			case "0":
				runFlag = false;
				break;
			default:
				System.out.println("명령어가 잘못되었습니다.");
			}
		}
		
		System.out.println("프로그램이 종료되었습니다.");

	}

}
