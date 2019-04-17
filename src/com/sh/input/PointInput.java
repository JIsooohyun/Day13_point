package com.sh.input;

import java.util.Scanner;

import com.sh.point.PointDTO;

public class PointInput {  //입력담당
	private Scanner sc ;
	
	public PointInput() {
		sc = new Scanner(System.in);
	}
	
	//setPoint 
	public PointDTO setPoint() { //정보를 입력받기
		PointDTO pointDTO = new PointDTO();
		
		System.out.println("번호를 입력하세요");
		pointDTO.setNum(sc.nextInt());
		
		System.out.println("아이디를 입력하세요");
		pointDTO.setSid(sc.next());
		
		System.out.println("국어점수를 입력하세요");
		pointDTO.setKor(sc.nextInt());
		
		System.out.println("영어점수를 입력하세요");
		pointDTO.setEng(sc.nextInt());
		
		System.out.println("수학점수를 입력하세요");
		pointDTO.setMath(sc.nextInt());
		
		System.out.println("반번호를 입력하세요");
		pointDTO.setBnum(sc.nextInt());
		
		pointDTO.setTotal(pointDTO.getKor()+pointDTO.getEng()+pointDTO.getMath());
		pointDTO.setAvg(pointDTO.getTotal()/3.0);
		return pointDTO;
	}

	public int setNum(String str) {
		
		System.out.println(str+"번호를 입력");
		int num = sc.nextInt();
		
		
		
		return num;
	}
}














