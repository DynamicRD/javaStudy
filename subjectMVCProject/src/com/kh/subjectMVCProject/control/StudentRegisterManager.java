package com.kh.subjectMVCProject.control;


import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.kh.subjectMVCProject.model.StudentVO;
import com.kh.subjectMVCProject.model.SubjectVO;



public class StudentRegisterManager {
	public static Scanner sc = new Scanner(System.in); 
	//전체 학생리스트를 출력요청
	public  void selectManager() throws SQLException {
		ArrayList<StudentVO> studentList = new ArrayList<StudentVO>();
		studentList = StudentDAO.studentSelect();
		if(studentList == null) {
			System.out.println("데이터가 존재하지 않습니다.");
			return;
		}
		printStudentList(studentList); 
	}

	public  void insertManager() throws SQLException {
		SubjectDAO subjectDao = new SubjectDAO();
		StudentDAO studentDao = new StudentDAO();
		StudentVO svo = new StudentVO();
		
		String sd_num; // 학번
		String sd_name; // 이름
		String sd_passwd; // 비밀번호
	
		String sd_birthday; // 생년월일
		String sd_phone; // 핸드폰번호
		String sd_address; // 주소
		String sd_email; // 이메일
	
		System.out.println("학생 정보 입력");
		System.out.print("성명 >> ");
		sd_name = sc.nextLine();
		String id  = null;
		do {
			System.out.print("아이디(8자 이상 12자 이내) : ");
			id = sc.nextLine();
			boolean idcheck = sd.getStudentIdOverlap(id);
			if (idcheck == false) {
				break;
			}
			System.out.println("중복된 아이디입니다. 다시 입력하세요");
		} while (true);

		System.out.print("비밀번호(12자 이내) : ");
		String passwd =sc.nextLine();

		//학과정보
		ArrayList<SubjectVO> subjectList = subjectDao.subjectSelect();
		sdao.getSubjectTotalList();

		System.out.print("학과번호 : ");
		String s_num = sc.nextLine();

		// 학생 번호는 8자리로 생성한다. (연도2자리+학과2자리+일련번호 - 예로06010001) 
		SimpleDateFormat sdf = new SimpleDateFormat("yy");
		String year = sdf.format(new Date());
		//sd_num = year + s_num + sd.getStudentCount(s_num);
		String num = year + s_num + "0001";

		System.out.print("생년월일(8자리: 900829) : ");
		String birthday = sc.nextLine();
		System.out.print("전화번호 : ");
		String phone = sc.nextLine();
		System.out.print("도로명 주소 : ");
		String address = sc.nextLine();
		System.out.print("이메일   : ");
		sd_email = sc.nextLine();

		StudentVO studentVO = new StudentVO(0, num, sd_name, id, passwd, s_num, birthday, phone, address, sd_email, null);
		
		studentDao.studentInsert(studentVO);

		System.out.println();
		System.out.println("등록 학생 정보");
		studentDao.
		sd.getStudent(svo.getSd_id(), svo.getSd_passwd());
		System.out.println();

		//
		
		// 3.statement
		System.out.print("학생 이름을 입력하세요: ");
		String name = sc.nextLine();
		System.out.print("국어 점수를 입력하세요: ");
		int kor = Integer.parseInt(sc.nextLine());
		System.out.print("영어 점수를 입력하세요: ");
		int eng = Integer.parseInt(sc.nextLine());
		System.out.print("수학 점수를 입력하세요: ");
		int mat = Integer.parseInt(sc.nextLine());

		StudentVO studentVO = new StudentVO();  
		boolean successFlag = StudentDAO.studentInsert(studentVO);
		
		if(successFlag == true) {
			System.out.println("입력처리 성공");
		}else {
			System.out.println("입력처리 실패");
		}
	}

	public  void updateManager() throws SQLException {
		System.out.print("수정할 학생의 번호를 입력하세요: ");
		int no = Integer.parseInt(sc.nextLine());
		System.out.print("새로운 이름을 입력하세요: ");
		String name = sc.nextLine();
		System.out.print("새로운 국어 점수를 입력하세요: ");
		int kor = Integer.parseInt(sc.nextLine());
		System.out.print("새로운 영어 점수를 입력하세요: ");
		int eng = Integer.parseInt(sc.nextLine());
		System.out.print("새로운 수학 점수를 입력하세요: ");
		int mat = Integer.parseInt(sc.nextLine());
		
		StudentVO svo = new StudentVO();
		boolean successFlag = StudentDAO.studentUpdate(svo);
		
		if(successFlag == true) {
			System.out.println("입력처리 성공");
		}else {
			System.out.println("입력처리 실패");
		}
	}

	public  void deleteManager() throws SQLException {
		System.out.print("삭제할 학생 번호를 입력하세요: ");
		int no = Integer.parseInt(sc.nextLine());
		StudentVO svo = new StudentVO();
		svo.setNo(no);
		boolean successFlag = StudentDAO.studentDelete(svo); 
		
		if(successFlag == true) {
			System.out.println("삭제처리 성공");
		}else {
			System.out.println("삭제처리 실패");
		}
	}

	public  void sortManager() throws SQLException {
		ArrayList<StudentVO> studentList = null;
		studentList =StudentDAO.studentSort(); 
		printStudentList(studentList);
	}

	//전체 학생리스트를 출력진행
	public  void printStudentList(ArrayList<StudentVO> studentList) {
		System.out.println("============================================");
		for( StudentVO sv :  studentList) {
			System.out.println(sv.toString());
		}
		System.out.println("============================================");
	}
}






