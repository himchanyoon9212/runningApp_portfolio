# 취업을 위한 토이 프로젝트로, 간단한 집중력 타이머를 구현하였습니다.

## 사용 기술

- AAC
- MVVM
- Room
- DI(Dagger Hilt)
- Foreground Service
- Retrofit
- Coroutine
- Firebase Auth

## 구현한 기능 설명

**MVVM 패턴을 이용하여, View와 Logic을 분리하였습니다.**
 
 Activity의 ViewModel에 타이머 값을 저장하여, ViewModel에 저장된 타이머 값을 Fragment에 공유하여 사용하였습니다.

![스크린샷 2021-09-23 오전 3 33 32](https://user-images.githubusercontent.com/55573050/134401681-044d4ed4-0783-45b1-9b25-ec6542d87279.png)

![스크린샷 2021-09-23 오전 4 02 56](https://user-images.githubusercontent.com/55573050/134405690-38de0915-dc46-4d14-8f39-7a17a7f51fe5.png)
 
 **Foreground Service를 이용해서 Notification에 카운팅을 구현하였습니다. 아래와 같은 case를 모두 고려하여 제작하였습니다.**

 - 앱을 종료하여도 Notification에 타이머가 러닝
 - 앱 종료 후, Notification을 클릭하여 앱을 실행할 때, 기존의 카운팅한 값을 받아와서 동작하도록 구현
 - 타이머를 중지 시, Notifiation에 타이머 중지
 - 타이머 종료 시, Foreground Service 종료
 
![ezgif com-gif-maker](https://user-images.githubusercontent.com/55573050/134403049-8bba07ba-f5fa-4386-bbb6-a4fa2b0bfa98.gif)


 **Room을 이용하여 기록한 데이터들을 로컬DB에 저장하는 부분을 구현하였습니다.**
 
 Room을 이용해서, 기록한 시간 값을 저장하도록 구현하였습니다.
 
  ![스크린샷 2021-09-23 오전 3 48 58](https://user-images.githubusercontent.com/55573050/134403841-2e06e163-dc56-47fc-a816-b05303751428.png)
 
 Dagger Hilt를 이용하여 ViewModel에서 Room을 사용하도록 Inject하였습니다.
  
  ![스크린샷 2021-09-23 오전 3 52 15](https://user-images.githubusercontent.com/55573050/134404269-1f7359e6-9571-4128-86e7-d4b1fa709c5e.png)

 **Room에서 한개의 table로만 예제들을 발전시켜 mutiple tables를 사용하였습니다.**
 
 ![스크린샷 2021-09-23 오전 3 47 48](https://user-images.githubusercontent.com/55573050/134403699-902d6580-87ba-4cb0-af4c-144927c7a2df.png)


Coroutine을 이용하여 날씨 정보와, Github의 running관련 데이터들을 받아오도록 구현하였습니다.

 상단의 날씨 정보와 RecyclerView에 보여주는 데이터를 Weather API, Github API를 받아와서 사용하였습니다.

  ![스크린샷 2021-09-23 오전 3 58 31](https://user-images.githubusercontent.com/55573050/134405141-27fb4d77-6d94-491e-a72b-5476c7c49029.png)

![스크린샷 2021-09-23 오전 3 54 41](https://user-images.githubusercontent.com/55573050/134405159-4f498349-85b1-4d5a-a8a4-219611a118bc.png)

  
  
