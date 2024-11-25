package com.kh.bread.control;

import java.util.Scanner;

import com.kh.bread.model.CustomerVO;
import com.kh.bread.model.ShopVO;

public class ShopRegisterManager {
	// 가게 목록
	public void shopSelect() throws Exception {
		ShopDAO sdao = new ShopDAO();
		System.out.println("전체 메뉴테이블");
		sdao.selectShop();
		System.out.println();
	}
	//가게 등록
	public void shopInsert(int bNo,int income) throws Exception {
		Scanner input = new Scanner(System.in);
		ShopDAO sdao = new ShopDAO();
		ShopVO svo = new ShopVO();
		svo.setbNo(bNo);
		svo.setIncome(income);
		sdao.insertShop(svo);
	}
}
