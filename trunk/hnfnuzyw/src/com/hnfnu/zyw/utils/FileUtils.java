package com.hnfnu.zyw.utils;

import java.io.File;

public class FileUtils {
	
	public static boolean deleteOneFile(String url){
		File file = new File(url);

		// �ж�Ŀ¼���ļ��Ƿ����
		if (!file.exists()) { // �����ڷ��� true,�����Ѿ�ɾ��
			return true;
		} else {
			//���ھ�ɾ�����ļ�
			if (file.delete()) {
				return true;
			} else {
				return false;
			}
		}
	}

}
