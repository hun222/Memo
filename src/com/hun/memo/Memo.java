package com.hun.memo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Memo {
	//���� Ŀ�ǵ�
	public static final String EXIT = "/exit";
	
	public static final String MEMO_DR = "c:/temp2/memo/";
	
	//�����ڿ��� �޸� ������ ���丮 ����
	public Memo() {
		File dir = new File(MEMO_DR);
		if(!dir.exists()) {
			dir.mkdirs();
		}
	}
	//��ɾ�����Լ�
	public void showCommand() {
		System.out.println("��ɾ �Է��ϼ���.");
		System.out.println("1.���� 2.�б� 3.���� 4.���� 0.���α׷�����");
	}

	public void write(Scanner sc) {
		System.out.println("--���� ���--");
		StringBuilder sb = new StringBuilder();
		//keyboard input
		while(true) {
			String line = sc.nextLine();
			if(line.equals(EXIT)){
				break;
			}else {
				sb.append(line + "\r\n");
			}
		}
		//�ۼ� ������ ������ ���Ϸ� ����.
		if(!sb.toString().equals("")) {
			//��.����ð� �����ͼ� ���ϸ����� �����.
			long now = System.currentTimeMillis();
			//��.�����_�ú���.txt ���Ϸ� ������
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_hhmmss");
			String filename = sdf.format(now)+".txt";
			//��. ������ ������ ���ϰ�� ����
			Path path = Paths.get(MEMO_DR, filename);

			String fn = MEMO_DR+filename;
			try {
				//��. ���Ͼ���
				//Files.write(path, sb.toString().getBytes());
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fn),"UTF-8"));
				bw.write(sb.toString());
				bw.flush();
				bw.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
			System.out.println("�޸� ����Ͽ����ϴ�.");
		}
	}
	
	//���ϸ�Ϻ���
	public void list() {
		File file = new File(MEMO_DR);
		String fileList[] = file.list();
		for(String filename : fileList) {
			System.out.println(filename);
		}
	}
	
	public void read(String filename) {
		Path path = Paths.get(MEMO_DR, filename);
		String s ="";
		try {
			BufferedReader br = Files.newBufferedReader(path);
			while((s = br.readLine())!=null) {
				System.out.println(s);
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("--read end--");
	}
	public void delete(String filename) {
		File file = new File(MEMO_DR+filename);
		if(file.exists()) {
			if(file.delete()) {
				System.out.println("�����Ϸ�");
			}else {
				System.out.println("��������");
			}
		}else {
			System.out.println("file not exist");
		}
	}
	public void modify(Scanner sc, String filename) {
		File file = new File(MEMO_DR+filename);
		Path path = Paths.get(MEMO_DR, filename);
		StringBuilder sb = new StringBuilder();
		String s = "";
		
		//���� ���� stringbuilder�� ����
		try {
			BufferedReader br = Files.newBufferedReader(path);
			while((s = br.readLine())!=null) {
				sb.append(s+"\r\n");
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//���������ϸ� ���� �߰��ϱ�
		if(file.exists()) {
			try {
				//�߰��� ���� �Է¹ޱ�
				System.out.println("--�߰��� ���� �Է�--");
				while(true) {
					String line = sc.nextLine();
					if(line.equals(EXIT)){
						break;
					}else {
						sb.append(line + "\r\n");
					}
				}
				//���Ͼ���
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"UTF-8"));
				bw.append(sb.toString());
				bw.flush();
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("file�� �������� �ʽ��ϴ�.");
		}
		
		
	}
}
