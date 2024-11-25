package com.kh.movie.control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.kh.movie.model.CinemaVO;

public class CinemaRegisterManager {
	public static Scanner sc = new Scanner(System.in); 
	//전체 학생리스트를 출력요청
	public  void selectManager() throws SQLException {
		ArrayList<CinemaVO> cinemaList = new ArrayList<CinemaVO>();
		cinemaList = CinemaDAO.cinemaSelect();
		if(cinemaList == null) {
			System.out.println("데이터가 존재하지 않습니다.");
			return;
		}
		printcinemaList(cinemaList); 
	}

	public  void insertManager() throws SQLException {
		CinemaDAO CinemaDAO = new CinemaDAO();
		CinemaVO svo = new CinemaVO();

		System.out.println("영화관 정보 입력");
		System.out.print("이름 : ");
		String name = sc.nextLine();

		System.out.print("지역 : ");
		String location = sc.nextLine();
		
		CinemaVO CinemaVO = new CinemaVO(0,name,location,0);
		
		boolean successFlag = CinemaDAO.cinemaInsert(CinemaVO);

		if(successFlag == false) {
			System.out.println("입력처리 실패");
			return; 
		}

		System.out.println();

		//sd.getcinema(svo.getSd_id(), svo.getSd_passwd());
	}

	public  void updateManager() throws SQLException {
		System.out.print("수정할 영화관ID를 입력하세요: ");
		int c_id = Integer.parseInt(sc.nextLine());
		System.out.print("새로운 영화관이름을 입력하세요: ");
		String name = sc.nextLine();
		System.out.print("새로운 영화관 위치를 입력하세요: ");
		String location = sc.nextLine();
		
		CinemaVO svo = new CinemaVO();
		boolean successFlag = CinemaDAO.cinemaUpdate(svo);
		
		if(successFlag == true) {
			System.out.println("입력처리 성공");
		}else {
			System.out.println("입력처리 실패");
		}
	}

	public  void deleteManager() throws SQLException {
		System.out.print("삭제할 영화관ID를 입력하세요: ");
		int no = Integer.parseInt(sc.nextLine());
		CinemaVO svo = new CinemaVO();
		svo.setC_id(no);
		boolean successFlag = CinemaDAO.cinemaDelete(svo); 
		
		if(successFlag == true) {
			System.out.println("삭제처리 성공");
		}else {
			System.out.println("삭제처리 실패");
		}
	}

	//전체 학생리스트를 출력진행
	public  void printcinemaList(ArrayList<CinemaVO> cinemaList) {
		System.out.println("============================================");
		for( CinemaVO sv :  cinemaList) {
			System.out.println(sv.toString());
		}
		System.out.println("============================================");
	}
}






