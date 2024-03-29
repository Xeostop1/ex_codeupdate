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
	
		
		//예약을 위한 객체 생성→ 3층위를 생성하기 위해 3개의 객체를 만듬
		Reserve1 r1=new Reserve1();
		//r1.sSeat(); r1.aSeat(); r1.bSeat();
			r1.Allseat();
		//좌석 조회를 위한 객체 생성
		Check1 c1=new Check1();
		//취소를 위한 객체 생성
		Cancle1 cancle1=new Cancle1();
		//영화 목록불러오기
		FileRead1 f1=new FileRead1();
		//영화 목록 저장
		//FileWriter1 fw1=new FileWriter1();

		//-- 06.5 수정 
		//Movie1 movie1=new Movie1("명량","사극");
		Movie1 movie1=new Movie1();
		
		

		int exit=0;//프로그램 종료를 위한 int 
		System.out.println("영화 예약 프로그램입니다.");
		while(true) {
			System.out.println("1.예약 2.조회 3.취소 4.관리자 5.종료");
				num= sc.nextInt();
				
				
				switch(num) {
					case 1:
						//영화목록을 불러와 보여주기
						f1.read();
						System.out.println("좌석을 선택해주세요 \n1.S석 / 2.A석 / 3.B석");
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
						System.out.println("좌석을 선택해주세요 \n1.S석 / 2.A석 / 3.B석");
						num1=sc.nextInt();
						
							if(num1==1) {cancle1.sCancle();}
							else if(num1==2) {cancle1.aCancle();}
							else if(num1==3) {cancle1.bCancle();}
							else System.out.println("다시입력해 주세요");
						break;
					case 4:
						System.out.println("관리자메뉴 입니다");
						System.out.println("1.추가 2.조회 3.취소");
						num2=sc.nextInt();
						
						 if(num2==1) {
							 movie1.addMovie();
							 movie1.toFileString();
						 }
						 else if(num2==2) {movie1.adminRead();}
						 else if(num2==3) {movie1.adminCancle();}
						 else System.out.println("다시입력해 주세요");
						break;
					
					case 5:
						exit=-1;
							System.out.println("프로그램이 종료 되었습니다.");
							break;	
						
					default:
						System.out.println("1~5번을 입력해주세요");
					
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
	//클래스에서 스캐너 한번만 사용!
	
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
		System.out.println("\t\t┌──────────────────┐");
		System.out.println("\t\t│      screen      │");
		System.out.println("\t\t└──────────────────┘");
	}
	
	void seatInfo() {
		System.out.println("\n예약할 좌석을 번호로 선택해 주세요");
		num=sc.nextInt();
		System.out.println("이름을 입력하세요");
		name= sc.next();
		
	}
	
	void sbooking() {
			System.out.print ("S석 \n");
			screen();
				for(int i=0; i< S.length; i++) {
					System.out.print(i+1);
					System.out.print(S[i]);
				}
			seatInfo();
		S[num-1]=name;	
	}
	
	void abooking(){
		System.out.print ("A석 \n");
		screen();
			for(int i=0; i< A.length; i++) {
				System.out.print(i+1);
				System.out.print(A[i]);
			}
		seatInfo();	
		A[num-1]=name;
	}
	void bbooking() {
		System.out.print ("B석 \n");
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
 
 //무비를 만드는 생성자
 Movie1(String _title, String _genre){
	 title=_title;
	 genre=_genre;
 }
 
 public void save(){
	 
	 try {
		 FileWriter fw=new FileWriter(file, true);
		 fw.write(this.toFileString()+"\n");
		 System.out.println("파일이 저장되었습니다.");
		 fw.close();
	 }
	 catch(IOException e){
		 System.out.println("파일 미저장"+e);
	 }
	 
	 
 }
 
 String toFileString() {//객체정보를 문자열로 변환
	 return String.format("%s,%s", title, genre);
 }
 
 public static ArrayList<Movie1> findAll() throws IOException{
	 ArrayList<Movie1> m1=new ArrayList<Movie1>();
	 BufferedReader br=new BufferedReader(new FileReader(file));
	 String line =null;
	 
	 while((line= br.readLine()) !=null) {//파일을 한 행씩 읽어 반복
		 String[] temp=line.split(","); // 쉽표를 기준으로 문자열을 나눔
		 Movie1 m=new Movie1(
				 temp[0], //스트링 템프 0인덱스에 제목 저장
				 temp[1] //스트링 템프 1인덱스에 장르 저장
				 );
		 m1.add(m); //영화 객체를 어레이 리스트에 추가
	 }
	 br.close();
	 return m1;	 
 }
 
 void addMovie() {
	 System.out.println("제목 입력");
	 String title_input=sc.next();
	 title=title_input;
	 
	 System.out.println("장르 입력");
	 String genre_input=sc.next();
	 genre=genre_input;
	 
	 Movie1 m1=new Movie1(title, genre);
	 m1.save();
	 System.out.println("등록완료");
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
			 System.out.println("파일이 삭제되었습니다.");
			 fw.close();
		 }
		 catch(IOException e){
			 System.out.println("파일 미삭제"+e);
		 }
		 
	}//met
	
}//C


//좌석 조회를 위한 클래스
class Check1 extends Reserve1{
	//extends Reserve1
		//int i, j;
	//	Check1(){}
		
	 void show() {
		 for(int i=0; i<1; i++){
			 System.out.print("S석");
			 for(int j=0; j<S.length; j++) {
				 System.out.print(S[j]);
			 }
		 }
		 System.out.println("");
		 
		 for(int i=0; i<1; i++){
			 System.out.print("A석");
			 for(int j=0; j<A.length; j++) {
				 System.out.print(A[j]);
			 }
		 }
		 System.out.println("");
		 
		 for(int i=0; i<1; i++){
			 System.out.print("B석");
			 for(int j=0; j<B.length; j++) {
				 System.out.print(B[j]);
			 }
		 }
		 System.out.println("");
		 System.out.println("전좌석 조회 완료\n");	 
	 }
	 
}//c

//좌석 취소를 위한 클래스 
class Cancle1 extends Reserve1{
	String name;
	
	Cancle1(){}
	
	void sCancle() {
			System.out.println("S석");
				for (int i = 0; i < S.length; i++) {
					System.out.print(S[i]);
					}				
				System.out.println("\n예약한 이름을 입력해주세요");
				name =sc.next();
				for (int i = 0; i < S.length; i++) {
					if(S[i].equals(name)) {
						S[i]="---";
					}else {
						System.out.println("입력하신 이름과 일치하는 정보가 없습니다 \n 다시 입력해 주세요 ");
					}
				}//for
			}//method
	
	
	void aCancle() {
		System.out.println("A석");
			for (int i = 0; i < A.length; i++) {
				System.out.print(A[i]);
			}
		System.out.println("\n예약한 이름을 입력해주세요");
			name =sc.next();
			for (int i = 0; i < A.length; i++) {
				if(A[i].equals(name)) {
					A[i]="---";
				}else {
					System.out.println("입력하신 이름과 일치하는 정보가 없습니다 \n 다시 입력해 주세요 ");
				}//if
			}//for
	}//method

	
	void bCancle() {
		System.out.println("A석");
			for (int j = 0; j < B.length; j++) {
				System.out.print(B[j]);
				}
		System.out.println("\n예약한 이름을 입력해주세요");
			name =sc.next();
			for (int i = 0; i < B.length; i++) {
				if(B[i].equals(name)) {
					B[i]="---";
			}else {
				System.out.println("입력하신 이름과 일치하는 정보가 없습니다 \n 다시 입력해 주세요 ");
			}//if
		}//for
	}//method
	
}//c
