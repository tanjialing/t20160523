package com.xheditor.servlet;

import java.io.*;
import java.net.URL;

/**
 * Title:��̬ҳ�澲̬��
 */
public class GoToHtml {
	/**
	 * 
	 * @param page
	 *            ��ž�̬ҳ��ı����ļ�·����c,d,e,f,g��
	 * @param url_addr
	 *            ��Ҫ���ɵľ�̬ҳ��URL��ַ(http://)
	 * @return
	 */
	public boolean PrintPage(String page, String url_addr) {
		System.out.println("page" + page);
		String newPage = "";
		// �ж�����ı���·���Ƿ����ԡ�jsp��β��
		if (page.endsWith(".html")) {
			System.out.println("this is end with xxx.html");
			int bias = page.lastIndexOf("/");// bias(б�ߵ���˼)��ȡ���һ��б�ߵ�λ��
			System.out.println("the last / at :" + bias);
			newPage = page.substring(0, bias);
			System.out.println("newPage:" + newPage);
		}
		// ����ļ��в����ھʹ���һ��
		File ff = new File(newPage);
		ff.mkdirs();
		URL url;
		String rLine = null;
		PrintWriter fileOut = null;
		InputStream ins = null;
		try {
			url = new URL(url_addr);
			System.out.println(url + ".......");
			ins = url.openStream();
			BufferedReader bReader = new BufferedReader(new InputStreamReader(
					ins, "utf-8"));// ��ȡ����Ϊgb2312���ļ�
			FileOutputStream out = new FileOutputStream(page);
			OutputStreamWriter writer = new OutputStreamWriter(out, "utf-8");
			fileOut = new PrintWriter(writer);
			// ѭ��ȡȡ����,��д��Ŀ���ļ���
			while ((rLine = bReader.readLine()) != null) {
				String tmp_rLine = rLine;
				System.out.println(tmp_rLine);
				int str_len = tmp_rLine.length();
				if (str_len > 0) {
					fileOut.println(tmp_rLine);
					fileOut.flush();
				}
				tmp_rLine = null;
			}
			url = null;
			return true;
		} catch (IOException e) {
			System.out.println("error: " + e.getMessage());
			e.printStackTrace();
			return false;
		} catch (Exception es) {
			System.out.println(es.getMessage());
			return false;
		} finally {// �ر���Դ
			fileOut.close();
			try {
				ins.close();
			} catch (IOException ex) {
				// �ر�����������
				ex.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		GoToHtml gth = new GoToHtml();
		// �в�������ô�������������������������������������������������������������
		String urlString = "http://localhost:8080/testXheditor/index.jsp";
		String path = System.getProperty("user.dir");
		System.out.println("--------"+path+"---------");
		// ȡ������ʱ����Ϊhtml���ļ���
		gth.PrintPage(path+"/WebRoot/index1.html", urlString);
		// ���ɵ��ļ���ϢҪ�������ݿ��У����ݿ�ı������ƣ�������������������������
	}
}