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
#### a.servlet-context.xml 

#### b.root-context.xml 
####   - mybatis
#####      1) connection - properties 파일 사용   : Dri
##### <!-- DirverManagerDataSource 등록 -->
<bean class="org.springframework.jdbc.datasource.DriverManagerDataSource" id="dataSource">
		<property name="username" value="${oracle.user}" />
		<property name="password" value="${oracle.pw}" />
		<property name="url" value="${oracle.url}" />
		<property name="driverClassName" value="${oracle.driver}" />
	</bean>
#####      2) connection, xml - 
##### 	<!-- sqlSessionFactoryBean등록 -->
	<bean class="org.mybatis.spring.SqlSessionFactoryBean" id="sqlSessionFactoryBean">
		<property name="dataSource" ref="dataSource"/>
		<property name="mapperLocations" value="classpath:/myBatis/mappers/**/*Mapper.xml"/><!-- sql따로 빼놓은 위치가 어디냐 -->
		<property name="configLocation" value="classpath:/myBatis/config/myBatisConfig.xml"/><!-- 풀패키지명을 단축어로 만들어주는 부분 -->
	</bean>
#####      3) 최종Mapping
##### <!-- sqlSession 등록 --> <!-- 자바랑 맵핑하는 부분 -->
	<bean class="org.mybatis.spring.SqlSessionTemplate" id="sqlSession">
		<constructor-arg name="sqlSessionFactory" ref="sqlSessionFactoryBean"/>
	</bean>
#### - fileUpload
####   commonsMultPartResolver
##### - properties 파일 위치 설정
#####   propertyPlaceholderConfigurer

## 5) Myvatis 설정
#### - file들의 위치
#####    src/main/resources 하위에 myBatis 디렉터리 생성
#####    configue : mybatis 설정 파일들
#####    mappers  : mybatis sql 파일들
































