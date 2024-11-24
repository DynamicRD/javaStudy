package com.kh.movie.control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.kh.movie.model.MovieVO;

public class MovieRegisterManager {
	public static Scanner sc = new Scanner(System.in); 
	//전체 학생리스트를 출력요청
	public  void selectManager() throws SQLException {
		ArrayList<MovieVO> movieList = new ArrayList<MovieVO>();
		movieList = MovieDAO.movieSelect();
		if(movieList == null) {
			System.out.println("데이터가 존재하지 않습니다.");
			return;
		}
		printmovieList(movieList); 
	}

	public  void insertManager() throws SQLException {
		MovieDAO MovieDAO = new MovieDAO();
		MovieVO svo = new MovieVO();

		System.out.println("영화관 정보 입력");
		System.out.print("이름 >>");
		String name = sc.nextLine();

		System.out.print("지역 : ");
		String location = sc.nextLine();
		
		MovieVO MovieVO = new MovieVO();
		
		boolean successFlag = MovieDAO.movieInsert(MovieVO);

		if(successFlag == false) {
			System.out.println("입력처리 실패");
			return; 
		}

		System.out.println();

		//sd.getmovie(svo.getSd_id(), svo.getSd_passwd());
	}

	public  void updateManager() throws SQLException {
		System.out.print("수정할 영화ID를 입력하세요: ");
		int m_id = Integer.parseInt(sc.nextLine());
		System.out.print("새로운 영화타이틀을 입력하세요: ");
		String title = sc.nextLine();
		System.out.print("새로운 영화 장르를 입력하세요: ");
		String genre = sc.nextLine();
		System.out.print("수정할 영화상영시간을 입력하세요: ");
		int duration = Integer.parseInt(sc.nextLine());
		System.out.print("수정할 영화관id를 입력하세요: ");
		int c_id = Integer.parseInt(sc.nextLine());
		MovieVO mvo = new MovieVO();
		boolean successFlag = MovieDAO.movieUpdate(mvo);
		
		if(successFlag == true) {
			System.out.println("입력처리 성공");
		}else {
			System.out.println("입력처리 실패");
		}
	}

	public  void deleteManager() throws SQLException {
		System.out.print("삭제할 영화관ID를 입력하세요: ");
		int no = Integer.parseInt(sc.nextLine());
		MovieVO svo = new MovieVO();
		svo.setC_id(no);
		boolean successFlag = MovieDAO.movieDelete(svo); 
		
		if(successFlag == true) {
			System.out.println("삭제처리 성공");
		}else {
			System.out.println("삭제처리 실패");
		}
	}

	//전체 학생리스트를 출력진행
	public  void printmovieList(ArrayList<MovieVO> movieList) {
		System.out.println("============================================");
		for( MovieVO mv :  movieList) {
			System.out.println(mv.toString());
		}
		System.out.println("============================================");
	}
}






