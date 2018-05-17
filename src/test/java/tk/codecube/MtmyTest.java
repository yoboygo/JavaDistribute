package tk.codecube;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.junit.Test;

import tk.codecube.util.CodeUtils;

/**
 * mtmy测试
 * @author songjianlong
 *
 */
public class MtmyTest {

	/**
	 * 妃子校接口测试类
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	@Test
	public void fzxInterfaceTest() throws ClientProtocolException, IOException{
		String url = "http://web-interface:8081/web-train-interface/sysUserCtrl/querySysUserById.do";
//		String paramter = "{'id':'e20a78b4217349d29a7547c649f739e4'}";
		Map<String,String> params = new HashMap<String,String>();
		params.put("id", "e20a78b4217349d29a7547c649f739e4");
		System.out.println(CodeUtils.doPost(url, params));
		return;
	}
}
