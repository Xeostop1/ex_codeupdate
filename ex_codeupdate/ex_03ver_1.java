package study0608;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ex_03ver_1 {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int num, num1, num2;
	
		
		//������ ���� ��ü ������ 3������ �����ϱ� ���� 3���� ��ü�� ����
		Reserve1 r1=new Reserve1();
		//r1.sSeat(); r1.aSeat(); r1.bSeat();
			r1.Allseat();
		//�¼� ��ȸ�� ���� ��ü ����
		Check1 c1=new Check1();
		//��Ҹ� ���� ��ü ����
		Cancle1 cancle1=new Cancle1();
		//��ȭ ��Ϻҷ�����
		FileRead1 f1=new FileRead1();
		//��ȭ ��� ����
		//FileWriter1 fw1=new FileWriter1();

		//-- 06.5 ���� 
		//Movie1 movie1=new Movie1("��","���");
		Movie1 movie1=new Movie1();
		
		

		int exit=0;//���α׷� ���Ḧ ���� int 
		System.out.println("��ȭ ���� ���α׷��Դϴ�.");
		while(true) {
			System.out.println("1.���� 2.��ȸ 3.��� 4.������ 5.����");
				num= sc.nextInt();
				
				
				switch(num) {
					case 1:
						//��ȭ����� �ҷ��� �����ֱ�
						f1.read();
						System.out.println("�¼��� �������ּ��� \n1.S�� / 2.A�� / 3.B��");
							num1=sc.nextInt();
						if(num1==1) {
							r1.sbooking();
						}else if(num1==2) {
							r1.abooking();
						}else if(num1==3) {
							r1.bbooking();
						}
						break;
					case 2:
						c1.show();
						break;
					case 3:
						System.out.println("�¼��� �������ּ��� \n1.S�� / 2.A�� / 3.B��");
						num1=sc.nextInt();
						
							if(num1==1) {cancle1.sCancle();}
							else if(num1==2) {cancle1.aCancle();}
							else if(num1==3) {cancle1.bCancle();}
							else System.out.println("�ٽ��Է��� �ּ���");
						break;
					case 4:
						System.out.println("�����ڸ޴� �Դϴ�");
						System.out.println("1.�߰� 2.��ȸ 3.���");
						num2=sc.nextInt();
						
						 if(num2==1) {
							 movie1.addMovie();
							 movie1.toFileString();
						 }
						 else if(num2==2) {movie1.adminRead();}
						 else if(num2==3) {movie1.adminCancle();}
						 else System.out.println("�ٽ��Է��� �ּ���");
						break;
					
					case 5:
						exit=-1;
							System.out.println("���α׷��� ���� �Ǿ����ϴ�.");
							break;	
						
					default:
						System.out.println("1~5���� �Է����ּ���");
					
				}//switch		
				
				if(exit==-1) {
					break;
				}
		}//while
	}//m
}//c

class Reserve1{

	static String[] S= new String[10];
	static String[] A= new String[10];
	static String[] B= new String[10];
	File file1 =new File("src/text/movie.txt");
	String name;
	int num;
	
	Scanner sc=new Scanner(System.in);
	//Ŭ�������� ��ĳ�� �ѹ��� ���!
	
	Reserve1(){}
	
	void Allseat() {
		for(int i=0; i<S.length; i++) {
			S[i]="--- ";
			}
		for(int i=0; i<A.length; i++) {
			A[i]="--- ";
		}
		for(int i=0; i<A.length; i++) {
			B[i]="--- ";
		}
		
	}
	
//	void sSeat() {
//		for(int i=0; i<S.length; i++) {
//			S[i]="--- ";
//		}
//	}
//	
//	void aSeat() {
//		for(int i=0; i<A.length; i++) {
//			A[i]="--- ";
//		}
//	}
//	
//	void bSeat() {
//		for(int i=0; i<A.length; i++) {
//			A[i]="--- ";
//		}
//	}
	
	void screen(){
		System.out.println("\t\t����������������������������������������");
		System.out.println("\t\t��      screen      ��");
		System.out.println("\t\t����������������������������������������");
	}
	
	void seatInfo() {
		System.out.println("\n������ �¼��� ��ȣ�� ������ �ּ���");
		num=sc.nextInt();
		System.out.println("�̸��� �Է��ϼ���");
		name= sc.next();
		
	}
	
	void sbooking() {
			System.out.print ("S�� \n");
			screen();
				for(int i=0; i< S.length; i++) {
					System.out.print(i+1);
					System.out.print(S[i]);
				}
			seatInfo();
		S[num-1]=name;	
	}
	
	void abooking(){
		System.out.print ("A�� \n");
		screen();
			for(int i=0; i< A.length; i++) {
				System.out.print(i+1);
				System.out.print(A[i]);
			}
		seatInfo();	
		A[num-1]=name;
	}
	void bbooking() {
		System.out.print ("B�� \n");
		screen();
			for(int i=0; i< B.length; i++) {
				System.out.print(i+1);
				System.out.print(B[i]);
			}
		seatInfo();	
		B[num-1]=name;
				}
	
}//c

class FileRead1 extends Reserve1{
	File file =new File("src/data/movies.text");
	
	void read(){
	try {
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line="";
			while((line=br.readLine()) !=null) {
			System.out.println(line);
			}
			System.out.println("==============================");
		br.close();
	}catch (FileNotFoundException e) {
		e.printStackTrace();
	}catch(IOException e) {
		e.printStackTrace();
	}
		
}//met
}//c

class Movie1 extends Reserve1{
 String title;
 String genre;
 static final File file =new File("src/data/movies.text");
 
 
 Movie1(){}
 
 //���� ����� ������
 Movie1(String _title, String _genre){
	 title=_title;
	 genre=_genre;
 }
 
 public void save(){
	 
	 try {
		 FileWriter fw=new FileWriter(file, true);
		 fw.write(this.toFileString()+"\n");
		 System.out.println("������ ����Ǿ����ϴ�.");
		 fw.close();
	 }
	 catch(IOException e){
		 System.out.println("���� ������"+e);
	 }
	 
	 
 }
 
 String toFileString() {//��ü������ ���ڿ��� ��ȯ
	 return String.format("%s,%s", title, genre);
 }
 
 public static ArrayList<Movie1> findAll() throws IOException{
	 ArrayList<Movie1> m1=new ArrayList<Movie1>();
	 BufferedReader br=new BufferedReader(new FileReader(file));
	 String line =null;
	 
	 while((line= br.readLine()) !=null) {//������ �� �྿ �о� �ݺ�
		 String[] temp=line.split(","); // ��ǥ�� �������� ���ڿ��� ����
		 Movie1 m=new Movie1(
				 temp[0], //��Ʈ�� ���� 0�ε����� ���� ����
				 temp[1] //��Ʈ�� ���� 1�ε����� �帣 ����
				 );
		 m1.add(m); //��ȭ ��ü�� ��� ����Ʈ�� �߰�
	 }
	 br.close();
	 return m1;	 
 }
 
 void addMovie() {
	 System.out.println("���� �Է�");
	 String title_input=sc.next();
	 title=title_input;
	 
	 System.out.println("�帣 �Է�");
	 String genre_input=sc.next();
	 genre=genre_input;
	 
	 Movie1 m1=new Movie1(title, genre);
	 m1.save();
	 System.out.println("��ϿϷ�");
 }
 
 
 
	
	void adminRead(){
	try {
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line="";
			while((line=br.readLine()) !=null) {
			System.out.println(line);
			}
		br.close();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
		
	
	void adminCancle() {
		
		 try {
			 FileWriter fw=new FileWriter(file);
			 fw.write(" ");
			 System.out.println("������ �����Ǿ����ϴ�.");
			 fw.close();
		 }
		 catch(IOException e){
			 System.out.println("���� �̻���"+e);
		 }
		 
	}//met
	
}//C


//�¼� ��ȸ�� ���� Ŭ����
class Check1 extends Reserve1{
	//extends Reserve1
		//int i, j;
	//	Check1(){}
		
	 void show() {
		 for(int i=0; i<1; i++){
			 System.out.print("S��");
			 for(int j=0; j<S.length; j++) {
				 System.out.print(S[j]);
			 }
		 }
		 System.out.println("");
		 
		 for(int i=0; i<1; i++){
			 System.out.print("A��");
			 for(int j=0; j<A.length; j++) {
				 System.out.print(A[j]);
			 }
		 }
		 System.out.println("");
		 
		 for(int i=0; i<1; i++){
			 System.out.print("B��");
			 for(int j=0; j<B.length; j++) {
				 System.out.print(B[j]);
			 }
		 }
		 System.out.println("");
		 System.out.println("���¼� ��ȸ �Ϸ�\n");	 
	 }
	 
}//c

//�¼� ��Ҹ� ���� Ŭ���� 
class Cancle1 extends Reserve1{
	String name;
	
	Cancle1(){}
	
	void sCancle() {
			System.out.println("S��");
				for (int i = 0; i < S.length; i++) {
					System.out.print(S[i]);
					}				
				System.out.println("\n������ �̸��� �Է����ּ���");
				name =sc.next();
				for (int i = 0; i < S.length; i++) {
					if(S[i].equals(name)) {
						S[i]="---";
					}else {
						System.out.println("�Է��Ͻ� �̸��� ��ġ�ϴ� ������ �����ϴ� \n �ٽ� �Է��� �ּ��� ");
					}
				}//for
			}//method
	
	
	void aCancle() {
		System.out.println("A��");
			for (int i = 0; i < A.length; i++) {
				System.out.print(A[i]);
			}
		System.out.println("\n������ �̸��� �Է����ּ���");
			name =sc.next();
			for (int i = 0; i < A.length; i++) {
				if(A[i].equals(name)) {
					A[i]="---";
				}else {
					System.out.println("�Է��Ͻ� �̸��� ��ġ�ϴ� ������ �����ϴ� \n �ٽ� �Է��� �ּ��� ");
				}//if
			}//for
	}//method

	
	void bCancle() {
		System.out.println("A��");
			for (int j = 0; j < B.length; j++) {
				System.out.print(B[j]);
				}
		System.out.println("\n������ �̸��� �Է����ּ���");
			name =sc.next();
			for (int i = 0; i < B.length; i++) {
				if(B[i].equals(name)) {
					B[i]="---";
			}else {
				System.out.println("�Է��Ͻ� �̸��� ��ġ�ϴ� ������ �����ϴ� \n �ٽ� �Է��� �ּ��� ");
			}//if
		}//for
	}//method
	
}//c
