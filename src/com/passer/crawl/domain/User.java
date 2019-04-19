package com.passer.crawl.domain;

import lombok.Data;

/**
* @Description: 用户类，包含用户的一些属性信息<p>
* @author: passer<p>
* @version：2019年4月10日 上午8:54:11<p>
*/
@Data
public class User {
	//用户ID
	private String userId;
	//用户昵称
	private String nickname;
	//用户个人介绍，个人签名
	private String sinature;
	//用户定位信息
	private String locationInfo;
	//性别：男为1，女为2
	private int gender;
	//个人描述
	private String description;
	private String detailDescription;
	//省，为身份证前六位号码
	private String province;
	//市，为身份证前六位号码
	private String city;
	//生日,为1970-1-1至生日期毫秒数
	private Long birthday;
	//用户头像ID
	private Long avatarImgId;
	//用户头像链接
	private String avatarUrl;
	//用户背景图片ID
	private Long backgroundImgId;
	//用户背景图片链接
	private String backgroundUrl;
}