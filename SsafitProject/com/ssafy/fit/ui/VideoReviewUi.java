package com.ssafy.fit.ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import com.google.gson.Gson;
import com.ssafy.fit.model.VideoReview;
import com.ssafy.fit.model.dao.VideoReviewDao;
import com.ssafy.fit.model.dao.VideoReviewDaoImpl;
import com.ssafy.fit.util.SsafitUtil;

public class VideoReviewUi {
	private VideoReviewDao videoReviewDao;
	private static VideoReviewUi instance;
	private int videoNo;

	private VideoReviewUi(int videoNo) {
		videoReviewDao = VideoReviewDaoImpl.getInstance();
		this.videoNo = videoNo;
	}

	public static VideoReviewUi getInstance(int videoNo) {
		if (instance == null)
			instance = new VideoReviewUi(videoNo);
		return instance;
	}

//	public static VideoReviewUi getInstance(int videoNo) {
//		if(instance == null) instance = new VideoReviewUi(videoNo);
//		return instance;
//	}

	public void service(int videoNo) {
		int cnt = 0;
		int reviewNo = cnt++;
		String nickName = SsafitUtil.input("닉네임 : ");
		String content = SsafitUtil.input("내용 : ");
		registReview(videoNo, reviewNo, nickName, content);
		

	}


	public void registReview(int videoNo, int reviewNo, String nickName, String content) {
		StringBuilder sb = new StringBuilder();
		String str = null;
		try {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("data/videoReview.json")));
			
			
			while ((str = br.readLine()) != null) {
				sb.append(str).append("\n");
			}
			
			Gson gson = new Gson();
			VideoReview[] arr = gson.fromJson(sb.toString(), VideoReview[].class); // Json, 배열의 클래스
			
			arr[reviewNo].setVideoNo(videoNo);
			arr[reviewNo].setNickName(nickName);
			arr[reviewNo].setContent(content);
			
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("data/videoReview.json")));
			String str2 = gson.toJson(arr);
			bw.write(str2);
			bw.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
