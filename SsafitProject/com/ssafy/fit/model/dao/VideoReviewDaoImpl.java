package com.ssafy.fit.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ssafy.fit.model.VideoReview;

public class VideoReviewDaoImpl implements VideoReviewDao {
	private static int reviewNo = 1;
	private List<VideoReview> videoReviewDb = new ArrayList<>();
	private static VideoReviewDaoImpl instance = new VideoReviewDaoImpl();
	
	private VideoReviewDaoImpl() {};
	
	public static VideoReviewDaoImpl getInstance() {
		return instance;
	}
	
	public void insertReview(VideoReview videoReview) {
		videoReviewDb.add(videoReview);
	}
	
	public List<VideoReview> selectReview(int videoNo){
		
		List<VideoReview> tempList = new ArrayList<>();
		for(int i = 0; i < videoReviewDb.size(); i++) {
			if(videoReviewDb.get(i).getVideoNo() == videoNo) {
				tempList.add(videoReviewDb.get(i));
			}
		}
		return tempList; 
	}
}
