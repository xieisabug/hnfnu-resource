package com.hnfnu.zyw.website.utils;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import org.apache.commons.io.output.FileWriterWithEncoding;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import freemarker.core.ReturnInstruction.Return;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreemarkerUtil {
	//getTemplate("01.ftl")
	public Template getTemplate(String name) {
		try {
			//通过Freemaker的Configuration读取相应的ftl
			Configuration cfg = new Configuration();
			//设定去哪里读取相应的ftl模板文件
			cfg.setClassForTemplateLoading(this.getClass(),"../ftl");
			cfg.setDefaultEncoding("utf-8");
			//在模板文件目录中找到名称为name的文件
			Template temp = cfg.getTemplate(name);
			return temp;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void print(String name,Map<String,Object> root) {
		try {
			//通过Template可以将模板文件输出到相应的流
			Template temp = this.getTemplate(name);
			temp.process(root, new PrintWriter(System.out));
		} catch (TemplateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void fprint(String name,Map<String,Object> root,String outFile) {
		FileWriterWithEncoding out = null;
		try {
			//通过一个文件输出流，就可以写到相应的文件中
			out =new FileWriterWithEncoding(new File("D:\\webservice\\ftl\\"+outFile), "utf-8");
			 //= new FileWriter(new File("D:\\webservice\\ftl\\"+outFile));
			Template temp = this.getTemplate(name);
			temp.process(root, out);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		} finally {
			try {
				if(out!=null) out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean fprint(String name,Map<String,Object> root,String filePath,String fileName) {
		FileWriterWithEncoding out = null;
		try {
			//通过一个文件输出流，就可以写到相应的文件中
			out = new FileWriterWithEncoding(new File(filePath+fileName),"utf-8");
			Template temp = this.getTemplate(name);
			temp.process(root, out);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} catch (TemplateException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if(out!=null) out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
	
}
