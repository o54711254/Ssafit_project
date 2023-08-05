package com.ssafy.fit.test;

import com.ssafy.fit.ui.MainUi;
import com.ssafy.fit.ui.VideoUi;
import com.ssafy.fit.util.SsafitUtil;

public class SsafitApplication {
	public static void main(String[] args) {
		// 어플리케이션 실행시 최초 메인화면
		MainUi mu = new MainUi();
		
		while (true) {

			mu.service();
			// 영상정보 메인화면 - 메뉴를 선택하세요
			int menu2 = SsafitUtil.inputInt("메뉴를 선택하세요 : ");

			if (menu2 == 0) {
				SsafitUtil.screenClear();
				mu.service();
			} else if (menu2 == 1) {
				// 영상목록 화면 ~ 영상상세 화면까지
				VideoUi.getInstance().service();
			}
		}

	}
}
