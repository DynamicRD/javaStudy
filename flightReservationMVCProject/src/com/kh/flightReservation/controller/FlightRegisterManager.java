package com.kh.flightReservation.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import com.kh.flightReservation.model.FlightVO;

public class FlightRegisterManager {
	public Scanner sc = new Scanner(System.in);

	public void insertManager() {
		FlightDAO fdao = new FlightDAO();
		// 항공사 번호,출발날짜,출발공항,도착공항,가격,좌석
		System.out.print("항공사 번호 입력 >>");
		int aNo = Integer.parseInt((sc.nextLine()).trim());
		System.out.print("출발날짜 입력 (예: yyyy-MM-dd) >> ");
		String dateString = (sc.nextLine()).trim();
		Date departmentDate = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			java.util.Date utilDate = sdf.parse(dateString);
			departmentDate = new Date(utilDate.getTime());
			System.out.println("출발 날짜는: " + departmentDate);
		} catch (Exception e) {
			System.out.println("잘못된 날짜 형식입니다. 올바른 형식(yyyy-MM-dd)으로 입력해주세요.");
		}
		System.out.print("출발공항 입력 >>");
		String departmentAirport =(sc.nextLine()).trim();
		System.out.print("도착공항 입력 >>");
		String arrivalAirport = (sc.nextLine()).trim();
		System.out.print("가격 입력 >>");
		int price = Integer.parseInt((sc.nextLine()).trim());
		System.out.print("좌석 입력 >>");
		String seat = (sc.nextLine()).trim();

		FlightVO fvo = new FlightVO(0, aNo,departmentDate, departmentAirport, arrivalAirport, price, seat);
		boolean successFlag = fdao.flightInsert(fvo);

		if (successFlag == true) {
			System.out.println("항공편 정보를 입력 하였습니다.");
		} else {
			System.out.println("항공편 정보를 입력 실패 하였습니다.");
		}
	}

	public void salaryUpProcManager() {
		FlightDAO fdao = new FlightDAO();
		FlightVO fvo = new FlightVO();
		
		ArrayList<FlightVO> flightList = fdao.flightSelect(fvo);
		if (flightList.size() != 0) {
			printflightList(flightList);
		} else {
			System.out.println("출력할 데이터가 없습니다.");
			return;
		}

		System.out.print("인상할 항공사 번호 입력: >>");
		int aNo = Integer.parseInt(sc.nextLine());
		boolean successFlag = fdao.flightSalaryUpProc(aNo);


		// 화면출력
		if (successFlag == true) {
			System.out.println("항공사 번호가 " +aNo + "인 항공편의 가격을 10% 인상하였습니다.");
		} else {
			System.out.println("항공사 번호가 " +aNo + "인 항공편의 가격을 10% 인상하였습니다.");
		}
		
	}
	
	
	public void selectManager() {
		FlightDAO fdao = new FlightDAO();
		FlightVO fvo = new FlightVO();
		ArrayList<FlightVO> flightList = fdao.flightSelect(fvo);
		if (flightList.size() != 0) {
			printflightList(flightList);
		} else {
			System.out.println("출력할 데이터가 없습니다.");
		}
	}

	public void deleteManager() {
		FlightDAO fdao = new FlightDAO();
		FlightVO fvo = new FlightVO();

		ArrayList<FlightVO> flightList = fdao.flightSelect(fvo);
		if (flightList.size() != 0) {
			printflightList(flightList);
		} else {
			System.out.println("출력할 데이터가 없습니다.");
			return;
		}
		System.out.print("삭제할 항공편 일련번호 >>");
		int no = Integer.parseInt((sc.nextLine()).trim());
		System.out.println("no=" + no);
		FlightVO fvo2 = new FlightVO();
		fvo2.setNo(no);
		System.out.println("fvo2=" + fvo2.toString());
		boolean successFlag = fdao.flightDelete(fvo2);

		if (successFlag == true) {
			System.out.println("항공편 일련번호가 " +no + "인 항공편을 삭제 하였습니다.");
		} else {
			System.out.println("항공편 일련번호가 " +no + "인 항공편을 삭제 실패하였습니다.");
		}
	}

	public void updateManager() {
		FlightDAO fdao = new FlightDAO();
		FlightVO fvo = new FlightVO();
		
		ArrayList<FlightVO> flightList = fdao.flightSelect(fvo);
		if (flightList.size() != 0) {
			printflightList(flightList);
		} else {
			System.out.println("출력할 데이터가 없습니다.");
			return;
		}

		System.out.print("수정할 항공편 일련번호선택>>");
		int no = Integer.parseInt(sc.nextLine());
		System.out.print("항공사 번호 입력 >>");
		int aNo = Integer.parseInt((sc.nextLine()).trim());
		System.out.print("출발날짜 입력 (예: yyyy-MM-dd) >> ");
		String dateString = (sc.nextLine()).trim();
		Date departmentDate = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			java.util.Date utilDate = sdf.parse(dateString);
			departmentDate = new Date(utilDate.getTime());
			System.out.println("출발 날짜는: " + departmentDate);
		} catch (Exception e) {
			System.out.println("잘못된 날짜 형식입니다. 올바른 형식(yyyy-MM-dd)으로 입력해주세요.");
		}
		System.out.print("출발공항 입력 >>");
		String departmentAirport =(sc.nextLine()).trim();
		System.out.print("도착공항 입력 >>");
		String arrivalAirport = (sc.nextLine()).trim();
		System.out.print("가격 입력 >>");
		int price = Integer.parseInt((sc.nextLine()).trim());
		System.out.print("좌석 입력 >>");
		String seat = (sc.nextLine()).trim();

		fvo = new FlightVO(no, aNo, departmentDate, departmentAirport, arrivalAirport, price, seat);
		boolean successFlag = fdao.flightUpdate(fvo);

		// 화면출력
		if (successFlag == true) {
			System.out.println("항공편 일련번호가 " +no + "인 항공편을 수정 하였습니다.");
		} else {
			System.out.println("항공편 일련번호가 " +no + "인 항공편을 수정실패 하였습니다.");
		}
	}

	public void selectSortManager() {
		FlightDAO fdao = new FlightDAO();
		FlightVO fvo = new FlightVO();
		ArrayList<FlightVO> flightList = fdao.flightSelectSort(fvo);
		if (flightList.size() != 0) {
			printflightList(flightList);
		} else {
			System.out.println("출력할 데이터가 없습니다.");
		}
	}

	public void printflightList(ArrayList<FlightVO> flightList) {
		System.out.println("==============================================================================");
		System.out.println("항공편 일련번호\t항공사 번호\t\t출발날짜\t\t출발공항\t도착공항\t가격\t좌석");
		for (FlightVO data : flightList) {
			System.out.println(data.getNo()+"\t\t"+data.getaNo()+"\t\t"+data.getDepartmentDate()+"\t"+data.getDepartmentAirport()+"\t"+data.getArrivalAirport()+"\t"+data.getPrice()+"\t"+data.getSeat());
		}
		System.out.println("==============================================================================");
	}

}