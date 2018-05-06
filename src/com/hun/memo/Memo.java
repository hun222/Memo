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
	//종료 커맨드
	public static final String EXIT = "/exit";
	
	public static final String MEMO_DR = "c:/temp2/memo/";
	
	//생성자에서 메모를 저장할 디렉토리 생성
	public Memo() {
		File dir = new File(MEMO_DR);
		if(!dir.exists()) {
			dir.mkdirs();
		}
	}
	//명령어출력함수
	public void showCommand() {
		System.out.println("명령어를 입력하세요.");
		System.out.println("1.쓰기 2.읽기 3.수정 4.삭제 0.프로그램종료");
	}

	public void write(Scanner sc) {
		System.out.println("--쓰기 모드--");
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
		//작성 내용이 있으면 파일로 쓴다.
		if(!sb.toString().equals("")) {
			//가.현재시간 가져와서 파일명으로 만든다.
			long now = System.currentTimeMillis();
			//나.년월일_시분초.txt 파일로 포맷팅
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_hhmmss");
			String filename = sdf.format(now)+".txt";
			//다. 내용을 저장할 파일경로 설정
			Path path = Paths.get(MEMO_DR, filename);

			String fn = MEMO_DR+filename;
			try {
				//라. 파일쓰기
				//Files.write(path, sb.toString().getBytes());
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fn),"UTF-8"));
				bw.write(sb.toString());
				bw.flush();
				bw.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
			System.out.println("메모를 등록하였습니다.");
		}
	}
	
	//파일목록보기
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
				System.out.println("삭제완료");
			}else {
				System.out.println("삭제실패");
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
		
		//기존 내용 stringbuilder에 저장
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
		
		
		//파일존재하면 내용 추가하기
		if(file.exists()) {
			try {
				//추가할 내용 입력받기
				System.out.println("--추가할 내용 입력--");
				while(true) {
					String line = sc.nextLine();
					if(line.equals(EXIT)){
						break;
					}else {
						sb.append(line + "\r\n");
					}
				}
				//파일쓰기
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"UTF-8"));
				bw.append(sb.toString());
				bw.flush();
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("file이 존재하지 않습니다.");
		}
		
		
	}
}
