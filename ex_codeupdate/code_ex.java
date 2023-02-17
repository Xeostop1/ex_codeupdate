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
//		  String menu = "*** 코리아 샌드위치 ***\n";
//	        menu += "1. 치즈 샌드위치\n";
//	        menu += "2. 베이컨 샌드위치\n";
//	        menu += "3. 토마토 샌드위치\n";
//	        menu += "4. 종료\n";
//	        
//	        //4. 종료를 위한 변수: exit = -1이 되면 종료 
//	        int exit = 0;
//	        
//	        while(true) {    // exit=-1; 되기 전까지 무한 반복 
//	            int choice = Integer.parseInt(JOptionPane.showInputDialog(menu + "번호를 선택하세요."));
//	            switch(choice) {
//	            case 1:
//	                System.out.println("치즈 샌드위치");
//	                break;
//	            case 2:
//	                System.out.println("베이컨 샌드위치");
//	                break;
//	            case 3:
//	                System.out.println("토마토 샌드위치");
//	                break;
//	            case 4:
//	                exit = -1;
//	                System.out.println("프로그램 종료");
//	                break;
//	            default:
//	                System.out.println("1~3번을 입력하세요!");
//	                // break; 생략가능! 
//	                // 어차피 마지막으로 switch문을 탈출하기 때문이다. 
//	            } // switch
//	            // while 구문을 탈출하기 위한 break;
//	            if (exit == -1) {    
//	                break;
//	            }
	       // } // while
	        
		
		
		
		
		
		

			
			//System.out.println("로그인 성공!");
			Scanner sc = new Scanner(System.in);
			int pw = 1; 
//			
//			//boolean run=true;
//			/*switch(al)
//			{
//			case 1:
//				
//			}*/
			
		
			//System.out.println("비밀번호 입력");
		//	int pw_num = sc.nextInt();
			//int exit=0;	
			while(true) {
				
				System.out.println("비밀번호 입력");
				int pw_num = sc.nextInt();
				if(pw!=pw_num) {
					System.out.println("다시 입력해주세요.");
					//continue;
				}else if(pw==pw_num){
					System.out.println("로그인 성공!");
					Scanner input = new Scanner(System.in);
				//	System.out.println("수정하시겠습니까?");
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
//			System.out.println("수정하시겠습니까?");
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
