package basic;

import java.util.Scanner;

public class StudentDAO {
	private Student[] list;
	private int cnt;
	private Scanner scan;
	
	StudentDAO(){
		list = new Student[10];
		scan = new Scanner(System.in);
	}
	
	public Student[] list() {
		return list;
	}
	
	public int getCnt() {
		return cnt;
	}

	public void insert() {
		Student stu;
		
		System.out.print("�й� �Է� >> ");
		String id = scan.nextLine();
		
		System.out.print("�̸� �Է� >> ");
		String name = scan.nextLine();
		
		try {
			while(true) {
				System.out.print("���� �Է� >> ");
				int score = Integer.parseInt(scan.nextLine());
				
				if(score>=0 && score<=100) {
					stu = new Student(id, name, score);
					
					if(cnt > list.length-1) {
						System.out.println("�� �̻� ����� �� �����ϴ�.");
					}
					
					for(int i=0; i<cnt; i++) {
						if(stu.equals(list[i])) {
							System.out.println("�̹� ��ϵ� ID�Դϴ�.");
						}
					}
					
					list[cnt++] = stu;
					
					System.out.println("����� �Ϸ��!");
					
					break;
				}
				
				System.out.println("0 ~ 100������ ���� �Է����ּ���!");
			}
		}catch(NumberFormatException e) {
			System.out.println("������ ���������� �Է��Ͽ��� �մϴ�.");
		}
	}

	public void inquire() {
		for(int i=0; i<cnt; i++) {
			System.out.println("ID : " + list[i].getId() + " �̸� : " + list[i].getName() + " ���� : " + list[i].getScore());
		}
	}

	public void update() {
		System.out.print("������ ID�� �Է� >> ");
		String id = scan.nextLine();
		
		for(int i=0; i<cnt; i++) {
			if(id.equals(list[i].getId())) {
				System.out.print("������ ID >> ");
				String new_id = scan.nextLine();
				
				System.out.print("������ �̸� >> ");
				String new_name = scan.nextLine();
				
				while(true) {
					System.out.println("������ ���� >> ");
					int new_score = scan.nextInt();
					
					if(new_score>=0 && new_score<=100) {
						Student new_stu = new Student(new_id,new_name, new_score);
						list[i] = new_stu;
						return;
					}
					
					System.out.println("0 ~ 100������ ���� �Է����ּ���!");
				}
			}
		}
	}

	public void delete() {
		System.out.print("������ �л��� ID�� �Է��ϼ���. >> ");
		String del_id = scan.nextLine();
		
		boolean found = false;
		int tempIndex = 0;
		
		for(int i=0; i<cnt; i++) {
			if(del_id.equals(list[i].getId())) {
				found = true;
				tempIndex = i;
			}
		}
		
		if(found) {
			list[tempIndex] = null;
			
			for(int i=tempIndex; i<cnt; i++) {
				list[i] = list[i+1];
			}
			cnt--;
			System.out.println("id : " + del_id + "�� �����Ǿ����ϴ�.");
		}else {
			System.out.println("������ ID ����!");
		}
	}

}
