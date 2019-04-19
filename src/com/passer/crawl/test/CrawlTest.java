package com.passer.crawl.test;  
/** 
 * @description: 爬取测试类<p>
 * @author: passer<p>
 * @Date: 2019年3月25日 下午5:47:14<p>
 */

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.passer.crawl.domain.Comment;
import com.passer.crawl.extract.CommentExtract;
import com.passer.crawl.extract.SongExtract;

public class CrawlTest {
	@Test
	public void test() throws Exception {
		Long songId = 210049L;
		List<Comment> hotComments = CommentExtract.extract(songId + "?").getHotComments();
		System.out.println("歌曲名：" + SongExtract.ExtractSongNameById(songId));
		System.out.println("网易云热评：");
		System.out.println("--------------------------");
		for(Comment comment : hotComments) {
			System.out.println("时间:" + new Date(comment.getTime()).toLocaleString());
			System.out.println("用户:" + comment.getUser().getNickname());
			System.out.println("评论:" + comment.getContent());
			System.out.println("--------------------------");
		}
	}
	
	 @Test
	public void test1() throws Exception {
		System.out.println(new Date(-2209017600000L));
	}
}
