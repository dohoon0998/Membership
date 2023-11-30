package member;

import java.util.ArrayList;
import java.util.Scanner;

public class membership {

	public static void main(String[] args) {
		 Scanner sc = new Scanner (System.in);
	      
		 //ArrayList = 저장 용량이 초과되었을 떄 초과된 만큼 저장 용량이 늘어남.
         ArrayList<String> newPw = new ArrayList<String>();
         ArrayList<String> newId = new ArrayList<String>();
         String userPw;
         String userId;
         
         boolean nowLog = false;//2
         boolean nowSign = false;//3
         boolean make = false;//4
         boolean roop = true;//1
         
         while(roop == true) {
            System.out.println("1.로그인 2.회원가입 3.로그아웃 4.회원목록 5.종료");
            int i = sc.nextInt();
            
         switch(i) {
         case 1 :
            Loop2 :
                 while (true) { //loop2 반복문 실행
                    if (nowLog == true) { //로그인중일때 실행
                      System.out.println("이미 로그인 상태입니다"); 
                      break Loop2; //loop2 반복문을 나옴
                   }
                    System.out.println("로그인을 하시오.");
                    
                  System.out.println("id 작성");
                     String idVerify = sc.next(); //문자열 형태로 아이디를 입력받음
                     
                     System.out.println("비밀번호 작성");
                     String pwVerify = sc.next(); //문자열 형태로 비번을 입력받음
                     
                     System.out.println("가입아이디:" + idVerify + " 가입비번:" + pwVerify); //입력받은 아이디 비번 출력
                     
                     if (nowSign == true) { //회원가입 상태가 참일때
                        for (int i2 = 0; i2 < newId.size(); i2++) { //idVerify와 pwVerify가 일치하는 배열 칸을 반복하며 찾음
                           if (idVerify.equals(newId.get(i2)) && pwVerify.equals(newPw.get(i2))) { //만약에 일치할때 실행
                              System.out.println("로그인 성공했습니다.");
                              nowLog = true;
                              break Loop2; //Loop2반복문을 나옴
                           }
                        }
                    }
                    else if (nowSign == false || nowLog == false){ //둘중 하나라도 아닐때 실행함
                       System.out.println("해당 id가 존재하지 않습니다. 다시 로그인 하시겠습니까? y/n");   
                      String yesOrNo = sc.next(); //다시 입력받을지 입력받음
                  
                      if (yesOrNo.equals("y")) { //입력받은 값이 y일때 실행
                         System.out.println("재 로그인");   
                      } 
                      else if (yesOrNo.equals("n")) { //입력받은 값이 n일때 실행
                         System.out.println("로그인 취소");
                         break Loop2; //loop2반복문 나감
                      }
                    }
                } 
            break;
         case 2 :
            Loop1 : 
            while (true) {
            System.out.println("회원가입을 실행합니다."); //출력
               
               Loop2 :
               while (true) { //loop2 반복문 실행 참
                   System.out.println("ID를 입력하세요"); //id입력받기 출력
                      String id = sc.next(); // id입력받기
                     
                      System.out.println("비밀번호를 입력하세요"); //비번 입력받기 출력 
                      String pw = sc.next(); //비번 입력받기
                     
                      if (pw.length() < 4) { //만약에 비번의 길이가 4보다 작다면 실행
                         System.out.println("비밀번호는 4글자 이상에 알파벳이 포함되어야 합니다."); //비번의 조건 출력
                        break Loop2; //loop2반복문을 나옴
                      }
                      for (int i1 = 0; i1 < pw.length(); i1++) { //반복문 실행(영문포함 조건)
                       char c = pw.charAt(i1); //pw의 i번째 값을 c에 초기화시켜줌
                       for (char j = 'a'; j <= 'z'; j++) { //반복문 실행(c 가 a ~ z 까지 같은지 보는 반복문)
                          if (c == j) { //(c 가 a ~ z와같으면 실행)
                             make = true; //alphabet 가 참이다(조건 만족)
                        continue; //계속진행
                        }
                       }
                      }
                     if (make == false) { //만약에 alphabet 거짓일때(조건 불만족일때)
                  System.out.println("비밀번호는 4글자 이상에 알파벳이 포함되어야 합니다.");
                  break Loop2; //다시 실행
                     }
                     for(int i7 = 0; i7 < newId.size(); i7++) {
                        if(newId.get(i7).equals(id) == true) {
                           System.out.println("이미 존재하는 아이디입니다.");
                           break Loop2;
                        }
                     }
                   newId.add(id);
                  newPw.add(pw);
                    nowSign = true; //회원가입 상태를 참으로 바꿔줌
                     break Loop1;
               }
            }
            break;
         case 3 :
            Loop5 :
            while (true) { 
                  if (nowLog == true) {
                     System.out.println("로그아웃 하시겠습니까? y/n");
                     String yesOrNo = sc.next();
                     if (yesOrNo.equals("y")) {
                        nowLog = false;
                        break;
                     } 
                     else if (yesOrNo.equals("n")) {
                        break Loop5;
                     }
                  }
                  else {
                     System.out.println("로그인중이 아닙니다. 로그인 해주십시오.");
                     break Loop5;
                  }
             }
            break;
         case 4 :
            if(nowLog == true) {
            System.out.println("회원 목록");
            for(int i5 = 0; i5 < newId.size(); i5++) {
              System.out.println(newId.get(i5)); 
            }
            }
            else {
               System.out.println("로그인 해주세요~");
            }
            break;
         case 5 :
            loop6 :
            while (true) {
                  System.out.println("프로그램을 종료 하시겠습니까? (y/n)");
                  String exit = sc.next();   
                  if (exit.equals("y")) {
                     System.out.println("로그아웃 성공. 프로그램을 종료합니다.");
                     System.exit(0);
                  } 
                  else if (exit.equals("n")) {
                     System.out.println("종료 취소");
                     break loop6;
                  }
               }
         break;
         default :
            System.out.println("제대로 된 번호를 작성해주세요."); //5<
            break;
         }
         }
      }
	}