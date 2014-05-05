package com.hnfnu.zyw;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.hnfnu.zyw.utils.EncodeUtils;
import org.junit.Test;


public class OtherTest {

	@Test
	public void testClassNameRegex(){
		Pattern pattern = Pattern.compile("[A-Z][a-z]*");
		Matcher m = pattern.matcher("UserRoleMenuJoin");
		while(m.find()) {
			System.out.println(m.group());
		}
	}

    @Test
    public void testEncode(){
        String password = "123456";
        System.out.println(EncodeUtils.generatePassword(password));
    }
}
