package en.edu.qdu;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Student {
	private FileInputStream inName;
	private String stuName;

	public Student(File inName1) throws FileNotFoundException {
		super();
		stuName=inName1.getName();
		inName=new FileInputStream(inName1);
		
	}

	public FileInputStream getInName() {
		return inName;
	}

	public void setInName(FileInputStream inName) {
		this.inName = inName;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	
	
}
