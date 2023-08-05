package com.ssafy.fit.model.dao;

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
import com.ssafy.fit.test.VideoDao;

public class VideoDaoImpl implements VideoDao{
	private List<Video> list = new ArrayList<>();
	private static VideoDaoImpl instance = new VideoDaoImpl();
	
	private VideoDaoImpl() {}
	
	public static VideoDaoImpl getInstance() {
		return instance;
	}

	@Override
	public List<Video> selectVideo(){
		
	    return null;
	}

	@Override
	public Video selectVideoByNo(int no) {
		
		return null;
	}
	
	
}
