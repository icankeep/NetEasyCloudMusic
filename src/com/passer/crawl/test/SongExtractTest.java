package com.passer.crawl.test;  
/** 
 * @ClassName: SongExtractTest<p>

 * @description: <p>

 * @author: passer<p>

 * @Date: 2019年3月25日 下午6:11:29<p>
 */

import static org.junit.Assert.*;

import org.junit.Test;

import com.passer.crawl.extract.SongExtract;

public class SongExtractTest {

	@Test
	public void test() throws Exception {
		System.out.println(SongExtract.ExtractSongNameById(210049L));
	}
}
