package edu.monmouth.lab1;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Lab1Fall2026 {
	public static void main(String[] args) {
		final int EXPECTED_ARGS = 1;  // number of cmd args required
		final int SIZE = 5;		// size of first array
		final int UPPER_AGE = 20;	// limit for age
		final int THREE_SIZE = 3;	// size of array to hold 3 students
		final int BADARGS=1, BADREDIRECT=2;
		
		// validate there is 1 and only 1 cmd arg-terminate if not
		if (args.length != EXPECTED_ARGS) {
			System.err.println("Give the name of a log file");
			System.exit(BADARGS);
		}
		
		// redirect stderr & stdout to args[0]
		try {
			PrintStream redirectStream = new PrintStream(args[0]);
			System.setOut(redirectStream);
			System.setErr(redirectStream);
		} catch (FileNotFoundException ioe) {
			System.err.println("Cannot redirect stderr and stdout " + ioe.getMessage());
			ioe.printStackTrace();
			System.exit(BADREDIRECT);
		}

		Student student1 = new Student(100,18,"John"); 
		Student student2 = new Student(101,18,"Jane");
		Student student3 = new Student(102,20,"Larry");
		Student student4 = new Student(103,20,"Karen");
		Student student5 = new Student(104,21,"Karl");
		// declare an array of references to Student objects (use SIZE)
		Student students[] = new Student[SIZE];
		// fill array with Student objects declared above
		
		students[0] = student1;
		students[1] = student2;
		students[2] = student3;
		students[3] = student4;
		students[4] = student5;

		// print number of elements in students array
		int numOfStudents = 0;
		for (int i = 0; i < students.length; i++) {
			if (students[i].equals(null)) {
				break;
			}
			
			numOfStudents++;
		}
		
		System.out.println("Number of students: " + numOfStudents);

		// iterate through students array-print each object
		
		System.out.println("\n-----Students-----");
		int numStudent = 1;
		for (int i = 0; i < students.length; i++) {
			
			if (students[i].equals(null)) {
				numStudent -= 1;
				break;
			}
			
			System.out.println("Student " + (numStudent) + ": " + students[i].toString());
			numStudent++;
		}

		// iterate through students array-print only those with age < UPPER_AGE
		
		System.out.println("\n-----Students Ages Less Than Upper Age-----");
		for (Student s: students) {
			
			if (s.equals(null)) {
				break;
			}
			
			if (s.getAge() < UPPER_AGE) {
				System.out.println(s);
			}
		}
		
		Student studentsToAdd[]= { new Student(200, 22, "Rolf"),
				new Student(201, 23, "Dan")};
		
		// invoke addStudents to add studentsToAdd to the existing array
		Student newStudentArray[]; 
		newStudentArray = addStudents(students, studentsToAdd);

		// iterate through newStudentsArray array-print each object
		System.out.println("\n-----New Students Array-----");
		int numNewStudent = 1;
		for (int i = 0; i < newStudentArray.length; i++) {
			
			System.out.println("Student " + (numNewStudent) + ": "+ newStudentArray[i].toString());
			numNewStudent++;
		}
	}
	
	static public Student[] addStudents(Student[] students, Student[] studentsToAdd) {
		
		Student[] newStudents = new Student[students.length + studentsToAdd.length];
		
		for (int i = 0; i < students.length; i++) {
			newStudents[i] = students[i];
		}
		
		for (int i = 0; i < studentsToAdd.length; i++) {
			newStudents[students.length+i] = studentsToAdd[i];
		}
		
		return newStudents;
		
	}
}
