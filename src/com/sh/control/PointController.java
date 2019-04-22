package com.sh.control;

import java.util.ArrayList;
import java.util.Scanner;

import com.sh.input.PointInput;
import com.sh.point.PointDAO;
import com.sh.point.PointDTO;
import com.sh.view.PointView;

public class PointController { //컨드롤러
	private PointDAO pointDAO;
	private PointInput pointInput;
	private PointView pointView;
	private Scanner sc;

	public PointController() {
		pointView = new PointView();
		pointInput = new PointInput();
		pointDAO = new PointDAO();
		sc = new Scanner(System.in);
	}

	public void start() throws Exception{
		ArrayList<PointDTO> ar = null;
		PointDTO pointDTO = null;
		boolean check = true;

		while(check) {
			System.out.println("1. 정보 추가");
			System.out.println("2. 정보 삭제");
			System.out.println("3. 정보 번호로 조회");
			System.out.println("4. 정보 전체 조회");
			System.out.println("5. 종료");
			System.out.println("----입력----");
			int select = sc.nextInt();

			String str = null;
			int num = 0;
			switch(select) {
			case 1 :
				pointDTO = pointInput.setPoint();
				//int num = pointDAO.teacherMax();
				//pointDTO.setNum(num+1);
				select = pointDAO.insert(pointDTO);
				String message = "추가 실패";
				if(select>0) {
					message = "추가 성공";
				}
				pointView.view(message);
				break;

			case 2 :
				select = pointInput.setNum("삭제");
				select = pointDAO.delete(select);
				String message2 = "삭제 실패";
				if(select>0) {
					message2 = "삭제 성공";
				}
				pointView.view(message2);
				break;

			case 3:
				select = pointInput.setNum("조회");
				pointDTO = pointDAO.selectOne(select);
				if(pointDTO != null) {
					pointView.view(pointDTO);
				}else {
					pointView.view("없는 번호");
				}
				break;

			case 4:
				ar = pointDAO.selectList();
				pointView.view(ar);
				break;

			default:
				System.out.println("종료합니다.");
				check =! check;
				break;
			}

		}


	}

}
