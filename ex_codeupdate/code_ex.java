package study0615;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.Scanner;

//import javax.swing.JOptionPane;

public class code_ex {
	
	public static void main (String []args) throws IOException {
//		  String menu = "*** �ڸ��� ������ġ ***\n";
//	        menu += "1. ġ�� ������ġ\n";
//	        menu += "2. ������ ������ġ\n";
//	        menu += "3. �丶�� ������ġ\n";
//	        menu += "4. ����\n";
//	        
//	        //4. ���Ḧ ���� ����: exit = -1�� �Ǹ� ���� 
//	        int exit = 0;
//	        
//	        while(true) {    // exit=-1; �Ǳ� ������ ���� �ݺ� 
//	            int choice = Integer.parseInt(JOptionPane.showInputDialog(menu + "��ȣ�� �����ϼ���."));
//	            switch(choice) {
//	            case 1:
//	                System.out.println("ġ�� ������ġ");
//	                break;
//	            case 2:
//	                System.out.println("������ ������ġ");
//	                break;
//	            case 3:
//	                System.out.println("�丶�� ������ġ");
//	                break;
//	            case 4:
//	                exit = -1;
//	                System.out.println("���α׷� ����");
//	                break;
//	            default:
//	                System.out.println("1~3���� �Է��ϼ���!");
//	                // break; ��������! 
//	                // ������ ���������� switch���� Ż���ϱ� �����̴�. 
//	            } // switch
//	            // while ������ Ż���ϱ� ���� break;
//	            if (exit == -1) {    
//	                break;
//	            }
	       // } // while
	        
		
		
		
		
		
		

			
			//System.out.println("�α��� ����!");
			Scanner sc = new Scanner(System.in);
			int pw = 1; 
//			
//			//boolean run=true;
//			/*switch(al)
//			{
//			case 1:
//				
//			}*/
			
		
			//System.out.println("��й�ȣ �Է�");
		//	int pw_num = sc.nextInt();
			//int exit=0;	
			while(true) {
				
				System.out.println("��й�ȣ �Է�");
				int pw_num = sc.nextInt();
				if(pw!=pw_num) {
					System.out.println("�ٽ� �Է����ּ���.");
					//continue;
				}else if(pw==pw_num){
					System.out.println("�α��� ����!");
					Scanner input = new Scanner(System.in);
				//	System.out.println("�����Ͻðڽ��ϱ�?");
					int ch = input.nextInt();
					switch(ch) {
					}
				}
			}
				
		
//		
//			FileReader fr = new FileReader("src/data/read1.txt");
//			BufferedReader br = new BufferedReader(fr);
//			
//			FileWriter fw = new FileWriter("src/data/write2.txt");
//			BufferedWriter bw = new BufferedWriter(fw);
//			
//			System.out.println("�����Ͻðڽ��ϱ�?");
//			int buf;
//			while((buf = br.read() ) !=-1 )
//			{
//				System.out.print((char)buf);
//				bw.write(buf);
//			}
			
			//br.close();
			//bw.close();
				
		
		
		
				
//			
		
		
	}//m
}//c
