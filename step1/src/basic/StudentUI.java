package basic;

import java.util.Scanner;

public class StudentUI {
	private Scanner scan;
	private StudentDAO dao;
	
	StudentUI(){
		scan = new Scanner(System.in);
		dao = new StudentDAO();
	}
	
	private void showUsage() {
		boolean bFlag = true;
		
		while(bFlag) {
			System.out.println("1.등록 2.조회 3.수정 4.삭제 0.종료");
			
			String menu = scan.nextLine();
			
			if(menu.equals("0")) {
				System.out.println("시스템 종료");
				bFlag = false;
				return;
			}else {
				getUserInput(menu);
			}
		}
	}
	
	public void getUserInput(String strMenu) {
		if(strMenu.equals("1")) {
			System.out.println("등록");
			dao.insert();
		}
		else if(strMenu.equals("2")) {
			System.out.println("조회");
			dao.inquire();
		}
		else if(strMenu.equals("3")) {
			System.out.println("수정");
			dao.update();
		}
		else if(strMenu.equals("4")) {
			System.out.println("삭제");
			dao.delete();
		}
		else {
			System.out.println("0 ~ 4 사이의 숫자를 입력하세요.");
		}
	}

	public static void main(String[] args) {
		StudentUI ui = new StudentUI();
		ui.showUsage();
	}

}
