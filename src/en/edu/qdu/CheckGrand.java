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
		File f = new File("G:\\student"); // 学生的成绩文件夹
		// 老师的选择题的答案文件夹
		// 学生最后选择题的文件.txt

		// 找到所有学生的答案的文件地址并存储
		List<Student> list = new ArrayList<Student>();
		File[] file = f.listFiles();
		

		// 先导入所有学生的答案的文件路径使用ArrayList集合存储
		for (int i = 0; i < file.length; i++) {
			Student student = new Student(file[i]);
			list.add(student);
		}
		BufferedWriter out = new BufferedWriter(new FileWriter("G:\\teacher\\grands.txt"));
		// 开始成绩批改
		out.write("学生名字:       分数");
		out.newLine();
		
		for (int i = 0; i < list.size(); i++) {
			FileInputStream in1 = new FileInputStream("G:\\teacher\\answer.txt");
			int c, c1;
			int num = 0;// 用来记录正确的答案数
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
