package com.passer.crawl.extract;

import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.passer.crawl.domain.Comments;
import com.passer.crawl.util.EncryptUtils;
import com.passer.crawl.util.GsonUtils;


/** 
 * @ClassName: Comment<p>
 * @description: <p>
 * @author: passer<p>
 * @Date: 2019年3月25日 下午3:38:35<p>
 */
public class CommentExtract {

	public static Comments extract(String songSuffix) throws Exception {
		Map<String,String> map = EncryptUtils.encryptParams();
		Document document = Jsoup.connect("http://music.163.com/weapi/v1/resource/comments/R_SO_4_" + songSuffix)
				.cookie("appver", "1.5.0.75771").header("Referer", "http://music.163.com/").data("params", map.get("params"))
				.data("encSecKey", map.get("encSecKey")).ignoreContentType(true).post();
		return getComments(document);
	}
	
	public static Comments getComments(Document document) {
		return GsonUtils.parseJsonWithGson(document.text(), Comments.class);
	}
}
