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
			System.out.println("1.��� 2.��ȸ 3.���� 4.���� 0.����");
			
			String menu = scan.nextLine();
			
			if(menu.equals("0")) {
				System.out.println("�ý��� ����");
				bFlag = false;
				return;
			}else {
				getUserInput(menu);
			}
		}
	}
	
	public void getUserInput(String strMenu) {
		if(strMenu.equals("1")) {
			System.out.println("���");
			dao.insert();
		}
		else if(strMenu.equals("2")) {
			System.out.println("��ȸ");
			dao.inquire();
		}
		else if(strMenu.equals("3")) {
			System.out.println("����");
			dao.update();
		}
		else if(strMenu.equals("4")) {
			System.out.println("����");
			dao.delete();
		}
		else {
			System.out.println("0 ~ 4 ������ ���ڸ� �Է��ϼ���.");
		}
	}

	public static void main(String[] args) {
		StudentUI ui = new StudentUI();
		ui.showUsage();
	}

}
