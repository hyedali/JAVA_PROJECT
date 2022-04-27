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
		
		System.out.print("학번 입력 >> ");
		String id = scan.nextLine();
		
		System.out.print("이름 입력 >> ");
		String name = scan.nextLine();
		
		try {
			while(true) {
				System.out.print("성적 입력 >> ");
				int score = Integer.parseInt(scan.nextLine());
				
				if(score>=0 && score<=100) {
					stu = new Student(id, name, score);
					
					if(cnt > list.length-1) {
						System.out.println("더 이상 등록할 수 없습니다.");
					}
					
					for(int i=0; i<cnt; i++) {
						if(stu.equals(list[i])) {
							System.out.println("이미 등록된 ID입니다.");
						}
					}
					
					list[cnt++] = stu;
					
					System.out.println("등록이 완료됨!");
					
					break;
				}
				
				System.out.println("0 ~ 100까지의 수만 입력해주세요!");
			}
		}catch(NumberFormatException e) {
			System.out.println("점수는 정수형으로 입력하여야 합니다.");
		}
	}

	public void inquire() {
		for(int i=0; i<cnt; i++) {
			System.out.println("ID : " + list[i].getId() + " 이름 : " + list[i].getName() + " 성적 : " + list[i].getScore());
		}
	}

	public void update() {
		System.out.print("수정될 ID를 입력 >> ");
		String id = scan.nextLine();
		
		for(int i=0; i<cnt; i++) {
			if(id.equals(list[i].getId())) {
				System.out.print("수정할 ID >> ");
				String new_id = scan.nextLine();
				
				System.out.print("수정할 이름 >> ");
				String new_name = scan.nextLine();
				
				while(true) {
					System.out.println("수정할 성적 >> ");
					int new_score = scan.nextInt();
					
					if(new_score>=0 && new_score<=100) {
						Student new_stu = new Student(new_id,new_name, new_score);
						list[i] = new_stu;
						return;
					}
					
					System.out.println("0 ~ 100까지의 수만 입력해주세요!");
				}
			}
		}
	}

	public void delete() {
		System.out.print("삭제할 학생의 ID를 입력하세요. >> ");
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
			System.out.println("id : " + del_id + "가 삭제되었습니다.");
		}else {
			System.out.println("삭제할 ID 없음!");
		}
	}

}
