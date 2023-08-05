package com.ssafy.fit.ui;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ssafy.fit.model.Video;
import com.ssafy.fit.model.VideoReview;
import com.ssafy.fit.test.VideoDao;
import com.ssafy.fit.util.SsafitUtil;

public class VideoUi {
	private VideoDao videoDao;
	private static VideoUi instance = new VideoUi();

	private VideoUi() {

	}

	public static VideoUi getInstance() {
		return instance;
	}

	// 영상정보 메인화면
	public void service() {
		SsafitUtil.printLine();
		System.out.println("전체 8개"); // 시간남으면 length.
		SsafitUtil.printLine();
		listVideo();
		SsafitUtil.printLine();
		System.out.println("1. 영상상세");
		System.out.println("0. 이전으로");
		SsafitUtil.printLine();

		int menu = SsafitUtil.inputInt("메뉴를 선택하세요 : ");
		if (menu == 0) {
			MainUi mu = new MainUi();
			mu.service();
		}else if(menu == 1) {
			detailVideo();
		}

	}

	// GSON을 통해 비디오 조회
	private void listVideo() {

		StringBuilder sb = new StringBuilder();
		String str = null;

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("data/video.json")));
			while ((str = br.readLine()) != null) {
				sb.append(str).append("\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// sb에 모든 문자열이 모여있음
		Gson gson = new Gson();
		Type listType = new TypeToken<ArrayList<Video>>() {
		}.getType();

		List<Video> list = gson.fromJson(sb.toString(), listType);

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	}

	// 영상상세 선택 화면
	private void detailVideo() {
		////////////////////
		StringBuilder sb = new StringBuilder();
		String str = null;

		// gson에 있는 정보를 불러오기
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("data/video.json")));
			while ((str = br.readLine()) != null) {
				sb.append(str).append("\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// sb에 모든 문자열이 모여있음
		Gson gson = new Gson();
		Type listType = new TypeToken<ArrayList<Video>>() {
		}.getType();

		List<Video> list = gson.fromJson(sb.toString(), listType);

		//////////////////////

		int videoNo = SsafitUtil.inputInt("영상번호를 입력하세요 : ");

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getNo() == videoNo) {
				SsafitUtil.printLine();
				System.out.println("번호 : " + list.get(i).getNo());
				System.out.println("제목 : " + list.get(i).getTitle());
				System.out.println("운동 : " + list.get(i).getPart());
				System.out.println("영상 URL : " + list.get(i).getUrl());
				SsafitUtil.printLine();
				SsafitUtil.printLine();

				reviewEA(videoNo);

//				// 이미 등록 되어 있는 리뷰들
//				listReview();

				System.out.println("1. 리뷰등록");
				System.out.println("0. 이전으로");
				SsafitUtil.printLine();
				int menu3 = SsafitUtil.inputInt("메뉴를 선택하세요 : ");
				if (menu3 == 0) {
					service();
				} else if (menu3 == 1) {
					VideoReviewUi vri = VideoReviewUi.getInstance(videoNo);
					vri.service(videoNo);

				}

			}
		}
	}
	
	public void reviewEA(int videoNo) {
	      StringBuilder sb = new StringBuilder();
	      String str = null;

	      // gson에 있는 정보를 불러오기
	      try {
	         BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("data/videoReview.json")));
	         while ((str = br.readLine()) != null) {
	            sb.append(str).append("\n");
	         }
	      } catch (IOException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	      // sb에 모든 문자열이 모여있음
	      Gson gson = new Gson();
	      VideoReview[] arr = gson.fromJson(sb.toString(), VideoReview[].class);
	      int cnt = 0;
	      for (int i = 0; i < arr.length; i++) {
	         if (arr[i].getVideoNo() == videoNo) {
//	            System.out.println(arr[i].getReviewNo()+" "+arr[i].getNickName()+" "+arr[i].getContent());
	            cnt++;
	         }
	      }
	      int idx = 0;
	      VideoReview[] result = new VideoReview[cnt];
	      for (int i = 0; i < arr.length; i++) {
	         if (arr[i].getVideoNo() == videoNo) {
	            result[idx++] = arr[i];
	         }
	      }
	      System.out.println("영상리뷰 : " + result.length + "개");
	      SsafitUtil.printLine();
	      
	      for (int i = 0; i < arr.length; i++) {
	         if (arr[i].getVideoNo() == videoNo) {
	            System.out.println(arr[i].getReviewNo() + " " + arr[i].getNickName() + " " + arr[i].getContent());
	            cnt++;
	         }
	      }
	      SsafitUtil.printLine();
	   }
}
