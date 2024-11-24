package com.kh.movie.control;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import com.kh.movie.model.AudienceVO;


public class AudienceRegisterManager {
	public static Scanner sc = new Scanner(System.in);

	public static void selectManager() throws SQLException {
		ArrayList<AudienceVO> audienceList = new ArrayList<AudienceVO>();
		audienceList = AudienceDAO.audienceSelect();
		if(audienceList == null) {
			System.out.println("데이터가 존재하지 않습니다.");
			return;
		}
		printAudienceList(audienceList);
	}

	public static void printAudienceList(ArrayList<AudienceVO> audienceList) {
		System.out.println("============================================");
		for( AudienceVO avo :  audienceList) {
			System.out.println(avo.toString());
		}
		System.out.println("============================================");
	}

	public static void insertManager() throws SQLException {
		AudienceVO avo = new AudienceVO();
		AudienceDAO audienceDao = new AudienceDAO();
		boolean exitFlag = false;
		String name = null;
		int phone = 0;
		int c_id = 0;
		while (!exitFlag) {
			System.out.print("입력할 이름을 입력하시오: ");
			name = sc.nextLine();
			System.out.print("입력할 전화번호를 입력하시오: ");
			try {
				phone = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("숫자를 입력하세요");
				System.out.println();
				continue;
			}
			System.out.print("영화관ID를 입력하시오: ");
			try {
				c_id = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("숫자를 입력하세요");
				System.out.println();
				continue;
			}
			
			exitFlag = true;
		}
		
		boolean successFlag = AudienceDAO.audienceInsert(avo);
		if (successFlag == true) {
			System.out.println("입력처리 성공");
		} else {
			System.out.println("입력처리 실패");
		}
	}

	public static void deleteManager() throws SQLException {

		int a_id = 0;
		boolean exitFlag = false;
		while (!exitFlag) {
			System.out.print("삭제할 관객 ID를 입력하세요: ");
			try {
				a_id = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("숫자를 입력하세요");
				System.out.println();
				continue;
			}
			exitFlag = true;
		}
		AudienceVO avo = new AudienceVO();
		avo.setA_id(a_id);
		boolean successFlag = AudienceDAO.audienceDelete(avo);
		if (successFlag = true) {
			System.out.println("삭제처리 성공");
		} else {
			System.out.println("삭제처리 실패");
		}
	}

	public static void updataManager() throws SQLException {
		boolean exitFlag = false;
		int a_id = 0;
		String name = null;
		int phone = 0;
		int c_id = 0;
		while (!exitFlag) {
			System.out.print("수정할 관객 ID를 입력하세요: ");
			try {
				a_id = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("숫자를 입력하세요");
				System.out.println();
				continue;
			}
			System.out.print("수정할 이름을 입력하시오: ");
			name = sc.nextLine();
			System.out.print("수정할 전화번호를 입력하시오: ");
			try {
				phone = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("숫자를 입력하세요");
				System.out.println();
				continue;
			}
			System.out.print("수정할 영화관ID를 입력하시오: ");
			try {
				c_id = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("숫자를 입력하세요");
				System.out.println();
				continue;
			}
			exitFlag = true;
		}
		AudienceVO avo = new AudienceVO(a_id, name, phone,c_id);
		boolean successFlag = AudienceDAO.audienceUpdate(avo);
		if (successFlag = true) {
			System.out.println("수정처리 성공");
		} else {
			System.out.println("수정처리 실패");
		}
	}

}
