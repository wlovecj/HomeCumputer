package test.demo1;

import java.sql.ResultSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.HashMap;
import java.util.Hashtable;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * Test fastjson
 * @author 83889
 * @date 2018年8月21日 下午8:31:11
 * 
 */
public class TestJson {

	public static void main(String[] args) {
		String s1="{\"name\":\"zhangsan\",\"sex\":\"man\"}";
		JSONObject json=JSON.parseObject(s1);
		Set<Entry<String,Object>> col=json.entrySet(); 
		for(Entry<String,Object> entry:col) {
			System.out.println(entry.getKey()+entry.getValue());
		}
		
		Set<String> set=json.keySet();
		for (String tmp : set) {
			System.out.println(tmp + json.get(tmp));
			
		}

	}

}
