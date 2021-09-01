# MovieInfo
***

## Naver에 있는 영화리스트 애플리케이션
***

## 구성 :
### Language : Kotlin
### DI : Hilt
### AAC(Clean, MVVM, DataBinding, LiveData, Room, Navigation)
### Opensource: Retrofit, Glide
### asynchronous processing : coroutines Flow
### Test : Unit Test(JUnit4)

***
## 소개 :
### 안드로이드 코틀린언어를 사용하여 네이버 영화 리스트 항목을 받아와서 사용자에게 보여주는 어플리케이션 입니다.
### 안드로이드  패턴을 공부하기 위하여 Clean Architecture 및 MVVM 패턴을 사용하였습니다.
### 또한 디자인패턴을 적용하기 쉽도록 JetPack 라이브러리를 사용하였습니다.

***
## DI(Hilt):
### di를 적용하여 클래스 간 의존성을 줄여 설계하였습니다.
### 의존성 주입 Framework를 이용하여 의존성을 주입할 객체의 생명주기 관리가 쉬워집니다.
### 주입한 의존성의 변경이 주입된 객체에게 영향을 주지 않는 설계가 가능해집니다.

***
## AAC Clean,MVVM:
<img width="1396" alt="스크린샷 2021-07-30 오후 8 11 19" src="https://user-images.githubusercontent.com/87660196/127644934-a9355801-1ec9-44b8-9d43-2521d41997d1.png">


***
## 추가 고려사항
디자인적 요소 : 메인 페이지의 상단에 있는 SAVE PAGE 버튼을 바텀네비게이션으로 형식을 변경 예정.
기능 추가 요소: 1.현재 Database에서 모든 데이터를 가져오는 Select * 문과, 데이터를 저장하는 기능만 구현되어 있으므로, 데이터 Delete 와 Search 등을 추가할 예정. <br>
             2. 한번에 많은 갯수의 영화 목록을 가져올 경우 사용자의 경험이 나빠질 수 있으며, 앱 성능에도 영향을 미치므로, Paging 기능 추가 예정.
