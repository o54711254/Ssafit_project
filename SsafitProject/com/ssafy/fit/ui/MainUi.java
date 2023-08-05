package com.ssafy.fit.ui;

import com.ssafy.fit.util.SsafitUtil;

public class MainUi {
	public void service() {
		SsafitUtil.printLine();
		System.out.println("자바로 구현하는 SSAFIT");
		SsafitUtil.printLine();
		SsafitUtil.printLine();
		System.out.println("1. 영상정보");
		System.out.println("0. 종료");
		SsafitUtil.printLine();
		
		int menu = SsafitUtil.inputInt("메뉴를 선택하세요 : ");
		
		switch (menu) {
		case 0:
			exit();
		case 1:
//			SsafitUtil.screenClear();
			SsafitUtil.printLine();
			System.out.println("1. 영상목록");
			System.out.println("0. 이전으로");
			SsafitUtil.printLine();
			

		default:
			break;
		}

	}
	
	private void exit() {
		System.exit(0);
	}
}
