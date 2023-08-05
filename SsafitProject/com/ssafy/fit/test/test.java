package com.ssafy.fit.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import com.google.gson.Gson;
import com.ssafy.fit.model.VideoReview;

public class test {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		String str = null;
		try {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("data/videoReview.json")));
			
			
			while ((str = br.readLine()) != null) {
				sb.append(str).append("\n");
			}
			
			Gson gson = new Gson();
			VideoReview[] arr = gson.fromJson(sb.toString(), VideoReview[].class); // Json, 배열의 클래스
			
			arr[0].setVideoNo(2);
			arr[0].setNickName("adsfsaf");
			arr[0].setReviewNo(1);
			arr[0].setContent("너무재미dlTsp");
			
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("data/videoReview.json")));
			String str2 = gson.toJson(arr);
			bw.write(str2);
			bw.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
