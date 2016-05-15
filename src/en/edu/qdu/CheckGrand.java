package en.edu.qdu;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CheckGrand {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		File f = new File("G:\\student"); // ѧ���ĳɼ��ļ���
		// ��ʦ��ѡ����Ĵ��ļ���
		// ѧ�����ѡ������ļ�.txt

		// �ҵ�����ѧ���Ĵ𰸵��ļ���ַ���洢
		List<Student> list = new ArrayList<Student>();
		File[] file = f.listFiles();
		

		// �ȵ�������ѧ���Ĵ𰸵��ļ�·��ʹ��ArrayList���ϴ洢
		for (int i = 0; i < file.length; i++) {
			Student student = new Student(file[i]);
			list.add(student);
		}
		BufferedWriter out = new BufferedWriter(new FileWriter("G:\\teacher\\grands.txt"));
		// ��ʼ�ɼ�����
		out.write("ѧ������:       ����");
		out.newLine();
		
		for (int i = 0; i < list.size(); i++) {
			FileInputStream in1 = new FileInputStream("G:\\teacher\\answer.txt");
			int c, c1;
			int num = 0;// ������¼��ȷ�Ĵ���
			while (((c = list.get(i).getInName().read()) != -1) && ((c1 = in1.read()) != -1)) {
				if (c == c1) {
					num++;
				}
			}
			System.out.println(num);
			list.get(i).getInName().close();
			in1.close();
			String name = list.get(i).getStuName();
			System.out.println(list.get(i).getStuName());
			int grand = num * 4;
			out.write(name+"         "+grand);
			out.newLine();

		}
		out.close();
	}
}
