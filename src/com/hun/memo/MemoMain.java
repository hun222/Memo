package com.hun.memo;

import java.util.Scanner;

public class MemoMain {
	public static void main(String[] args) {
		// 1. Ű�����Է����� ��ɾ�ޱ�
		// 1)���� 2)�б� 3)���� 4)����
		
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
				System.out.print("���� ���ϸ��� �Է��ϼ���: ");
				memo.read(sc.nextLine());
				break;
			case "3":
				System.out.print("������ ���ϸ��� �Է��ϼ���: ");
				memo.modify(sc,sc.nextLine());
				break;
			case "4":
				System.out.print("������ ���ϸ��� �Է��ϼ���: ");
				memo.delete(sc.nextLine());
				break;
			case "0":
				runFlag = false;
				break;
			default:
				System.out.println("��ɾ �߸��Ǿ����ϴ�.");
			}
		}
		
		System.out.println("���α׷��� ����Ǿ����ϴ�.");

	}

}
