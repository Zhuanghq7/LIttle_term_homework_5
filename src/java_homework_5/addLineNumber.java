package java_homework_5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class addLineNumber {
	public static void main(String args[]){
		
		File f = new File("MyTEXT.java");
		try {
			FileOutputStream fout = new FileOutputStream(f);
			try {
				OutputStreamWriter opsw = new OutputStreamWriter(fout, "GBK");
				try {
					opsw.write("Hello World!");
					opsw.write("\r\n");
					opsw.write("nice to meet you my friends!");
					opsw.write("\r\n");
					opsw.write("holy fuck, whos fucking flash boom!!");
					opsw.write("\r\n");
					opsw.write("正在前往漓江塔");
					opsw.write("\r\n");
					opsw.flush();
					opsw.close();
					fout.close();
					//*********************新建文本写入四行文字***********************
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File f2 = new File("MyTEXT_2.txt");
		MyFun(f2);
	}
	
	public static void MyFun(File f){
		ArrayList<String> list=new ArrayList<String>();
		try {
			System.out.println("显示原来的文本：");
			FileInputStream fin = new FileInputStream(f);
			InputStreamReader ipsr = new InputStreamReader(fin);
			BufferedReader br = new BufferedReader(ipsr);
			int k = 0;
			for (String line = br.readLine(); line != null; line = br.readLine()) {
				System.out.println(line);
			    list.add(""+(++k)+" "+line);
			}
			br.close();
			ipsr.close();
			fin.close();
			FileOutputStream fout = new FileOutputStream(f);
			OutputStreamWriter opsw = new OutputStreamWriter(fout, "GBK");
			for(int i = 0;i<list.size();i++){
				//System.out.println(list.get(i));
				opsw.write(list.get(i));
				opsw.write("\r\n");
			}
			opsw.flush();
			fout.flush();
			fout.close();
			opsw.close();
			
			System.out.println("");
			System.out.println("显示修改完成的文本：");
			FileInputStream fin1 = new FileInputStream(f);
			InputStreamReader ipsr1 = new InputStreamReader(fin1);
			BufferedReader br1 = new BufferedReader(ipsr1);

			for (String line = br1.readLine(); line != null; line = br1.readLine()) {
				System.out.println(line);
			}
			br1.close();
			fin1.close();
			ipsr1.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
