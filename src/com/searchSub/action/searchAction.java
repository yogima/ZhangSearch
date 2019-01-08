package com.searchSub.action;

import java.io.File;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.searchSub.po.IQuestion;
import com.searchSub.service.ISearchServ;

public class searchAction{
	
	private File uploadImage; //得到上传的文件
	private String uploadImageContentType; //得到文件的类型
	private String uploadImageFileName; //得到文件的名称
	
	private ISearchServ serv = null;
	
	private IQuestion ques = null;
	private String ans;
	
	public ISearchServ getServ() {
		return serv;
	}

	public void setServ(ISearchServ serv) {
		this.serv = serv;
	}

	public String Img() {
		
		ActionContext ctx = ActionContext.getContext();
		//通过ActionContext对象获取请求、会话和上下文对象相关联的Map对象
		Map session=(Map) ctx.getSession();
		
		if(serv.searchByImg(uploadImage,uploadImageContentType,uploadImageFileName) != null) {
			
			System.out.println("fileName:"+uploadImageFileName);
			
			ques = serv.searchByImg(uploadImage,uploadImageContentType,uploadImageFileName);
			System.out.print(ques.getAnswer());
			ans = ques.getAnswer();
			session.put("ques", ques);
			session.put("ans", ans);
			return "success";
		}
		return "fail";
	}
	
	public String search() {
		return "fail";
	}

	public File getUploadImage() {
		return uploadImage;
	}

	public void setUploadImage(File uploadImage) {
		this.uploadImage = uploadImage;
	}

	public String getUploadImageContentType() {
		return uploadImageContentType;
	}

	public void setUploadImageContentType(String uploadImageContentType) {
		this.uploadImageContentType = uploadImageContentType;
	}

	public String getUploadImageFileName() {
		return uploadImageFileName;
	}

	public void setUploadImageFileName(String uploadImageFileName) {
		this.uploadImageFileName = uploadImageFileName;
	}
	
	public IQuestion getQues() {
		return ques;
	}

	public void setQues(IQuestion ques) {
		this.ques = ques;
	}

	public String getAns() {
		return ans;
	}

	public void setAns(String ans) {
		this.ans = ans;
	}
	
	
}