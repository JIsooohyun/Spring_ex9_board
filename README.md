# Spring_ex9_board
 
#1. Project setting
## 1) Encoding
####  web.xml EncodingFilter 등록
## 2) API(pom.xml)
#### a.springFramework ver 4 이상
#### b. Mybatis
####   - mybatis
####   - spring-mybatis
####   - spring-jdbc
####   - ojdbc6 
#### c. fileUpload
####   - commons-fileUpload(commons-io)
#### d. JuniTest
####   - JUNIT ver 4.12 이상
####   - spring - test 
## 3) JUNIT Test 설정
#### a. src/test/java
####    - 기본패키지 내에 AbstractTest junit test case 작성
####    - 클래스 선언부에
#####        @RunWith(SpringJUnit4ClassRunner.class)
#####        @ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})  
####    - 다른 junit Test case 생성해서 상속 받아서 사용 
## 4) XML 파일 설정































