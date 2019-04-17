package com.sh.view;

import java.util.ArrayList;

import com.sh.point.PointDTO;

public class PointView {  //출력담당
	
	public void view(String message) {
		System.out.println(message);
		
	}
	
	public void view(PointDTO pointDTO) {
		System.out.println("NUM : "+pointDTO.getNum());
		System.out.println("SID : "+pointDTO.getSid());
		System.out.println("KOR : "+pointDTO.getKor());
		System.out.println("ENG : "+pointDTO.getEng());
		System.out.println("MATH : "+pointDTO.getMath());
		System.out.println("TOTAL : "+pointDTO.getTotal());
		System.out.println("AVG : "+pointDTO.getAvg());
		System.out.println("BNUM : "+pointDTO.getBnum());
		System.out.println("=======================");
		
	}
	
	public void view(ArrayList<PointDTO> ar) {
		for(PointDTO pointDTO: ar) {
			this.view(pointDTO);
		}
		
	}

}
