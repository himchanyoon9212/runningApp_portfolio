# MVVM과 DI를 공부하며, 간단한 집중력 타이머 앱을 제작하였습니다.

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

 **Foreground Service를 이용해서 Notification에 카운팅을 구현하였습니다. 아래와 같은 case를 모두 고려하여 제작하였습니다.**

 - 앱을 종료하여도 Notification에 타이머가 러닝
 - 앱 종료 후, Notification을 클릭하여 앱을 실행할 때, 기존의 카운팅한 값을 받아와서 동작하도록 구현
 - 타이머를 중지 시, Notifiation에 타이머 중지
 - 타이머 종료 시, Foreground Service 종료
 

 **Room을 이용하여 기록한 데이터들을 로컬DB에 저장하는 부분을 구현하였습니다.**
 
 Room을 이용해서, 기록한 시간 값을 저장하도록 구현하였습니다.
 
 Dagger Hilt를 이용하여 ViewModel에서 Room을 사용하도록 Inject하였습니다.
  
  

 **Coroutine을 이용하여 날씨 정보와, Github의 running관련 데이터들을 받아오도록 구현하였습니다.**

상단의 날씨 정보와 RecyclerView에 보여주는 데이터를 Weather API, Github API를 받아와서 사용하였습니다.
  
  
