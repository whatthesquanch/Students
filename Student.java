import java.util.ArrayList;
import java.util.Comparator;

class Student {
	int rollno;
	String name;
	String address;

	public Student(int rollno, String name, String address) {
		this.rollno = rollno;
		this.name = name;
		this.address = address;
	}
	
	public int getRollno() {
		return rollno;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAddress() {
		return address;
	}
}

class NameComparator implements Comparator<Student> {
	public int compare(Student s1, Student s2) {
		return s1.getRollno() - s2.getRollno();
	}
}

class RollnoComparator implements Comparator<Student> {
	public int compare(Student s1, Student s2) {
		return s1.getRollno() - s2.getRollno();
		}


	public static void main(String[] args) {
		ArrayList<Student> students = new ArrayList<>();
		students.add(new Student(101, "Alohi", "808 Mahalo Avenue"));
		students.add(new Student(102, "Bulla", "777 Aloha Drive"));
		students.add(new Student(103, "Clinton", "123 Lane"));
		students.add(new Student(104, "David", "95-164 Hinano Lane"));
		students.add(new Student(105, "Ehukai", "1047 Lumi Street"));
		students.add(new Student(106, "Faith", "95-1250 Waikalani Drive"));
		students.add(new Student(107, "Greg", "94-1049 Lani Avenue"));
		students.add(new Student(108, "Hoolai", "680 Kamehameha Place"));
		students.add(new Student(109, "Ihilani", "349 Hill Court"));
		students.add(new Student(110, "Jimmy", "705 Makakilo Street"));
		
		selectionSort(students, new NameComparator());
		System.out.println("Sorted by Name:");
		for (Student student : students) {
			System.out.println(student.getName() + " " + student.getRollno() + " " + student.getAddress());
			
		}
		
		selectionSort(students, new RollnoComparator());
		System.out.println("\nSorted by Rollno:");
		for (Student student : students) {
			System.out.println(student.getName() + " " + student.getRollno() + " " + student.getAddress());
		}

	}
	
	public static void selectionSort(ArrayList<Student> students, Comparator<Student> comparator) {
		int n = students.size();
		for (int i = 0;i < n; i++) {
			int minIndex = i;
			for(int j = i + 1; j < n; j++) {
				if (comparator.compare(students.get(j), students.get(minIndex)) < 0) {
					minIndex = j;
				}
			}
			
			if (minIndex != i) {
				Student temp = students.get(i);
				students.set(i,  students.get(minIndex));
				students.set(minIndex, temp);
			}
		}
	}

}
