package com.passer.crawl.domain;

import java.util.List;

import lombok.Data;

/**
 * @description:评论集合类，包含一个请求返回的所有评论<p>
 * @author: passer<p>
 * @Date: 2019年3月25日 下午5:26:21<p>
 */
@Data
public class Comments {
	private List<Comment> hotComments;
}
