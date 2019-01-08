package com.searchSub.service;

import java.io.File;
import java.util.ArrayList;

import com.searchSub.po.Question;

public interface ISearchServ {
	public Question searchByImg(File uploadImage,String uploadImageContentType,String uploadImageFileName);
}
