# SNS-Service
redis를 이용한 채팅서비스, kafka를 이용한 알림, SNS (진행중)

## 사용할 기술<br>
Docker, Spring boot<br>
(사용 예정)Redis, Kafka<br>
WebSocket

## Configuration
SPRING 버전 : 2.7.0<br>
JAVA= 11<br>
Thymeleaf<br>
<!-- MARIADB:10 <br>
REDIS:6 -->

## 📚 기술스택
<img src="https://img.shields.io/badge/Docker-536DFE?style=flat-square&logo=Java&logoColor=white"/> <img src="https://img.shields.io/badge/Gradle-02303A?style=flat-square&logo=Gradle&logoColor=white"/>
<img src="https://img.shields.io/badge/Java-536DFE?style=flat-square&logo=Java&logoColor=white"/> <img src="https://img.shields.io/badge/Gradle-02303A?style=flat-square&logo=Gradle&logoColor=white"/>
<img src="https://img.shields.io/badge/Spring Boot-6DB33F?style=flat-square&logo=Spring Boot&logoColor=white"/>
<img src="https://img.shields.io/badge/Redis-DC382D?style=flat-square&logo=Redis&logoColor=white"/>
<img src="https://img.shields.io/badge/NGINX-009639?style=flat-square&logo=NGINX&logoColor=white"/>
<img src="https://img.shields.io/badge/Swagger-85EA2D?style=flat-square&logo=Swagger&logoColor=white"/>
<br>
<img src="https://img.shields.io/badge/Amazon EC2-FF9900?style=flat-square&logo=Amazon EC2&logoColor=white"/> <img src="https://img.shields.io/badge/Amazon S3-569A31?style=flat-square&logo=Amazon S3&logoColor=white"/>
<img src="https://img.shields.io/badge/Stomp-000000?style=flat-square&logo=Stomp&logoColor=white"/>
<img src="https://img.shields.io/badge/Sock.JS-000000?style=flat-square&logo=Sock.JS&logoColor=white"/>
<img src="https://img.shields.io/badge/GitHub Actions-2088FF?style=flat-square&logo=GitHub Actions&logoColor=white"/>
<img src="https://img.shields.io/badge/Kafka-85EA2D?style=flat-square&logo=Swagger&logoColor=white"/>


## 🔧 사용 툴
<img src="https://img.shields.io/badge/GitHub-181717?style=flat-square&logo=GitHub&logoColor=white"/> <img src="https://img.shields.io/badge/Git-F05032?style=flat-square&logo=Git&logoColor=white"/>
<img src="https://img.shields.io/badge/IntelliJ IDEA-000000?style=flat-square&logo=IntelliJ IDEA&logoColor=white"/>
<img src="https://img.shields.io/badge/Sourcetree-0052CC?style=flat-square&logo=Sourcetree&logoColor=white"/>
<img src="https://img.shields.io/badge/Notion-000000?style=flat-square&logo=Notion&logoColor=white"/>
<img src="https://img.shields.io/badge/Postman-FF6C37?style=flat-square&logo=Postman&logoColor=white"/>
<img src="https://img.shields.io/badge/Slack-4A154B?style=flat-square&logo=Slack&logoColor=white"/>
<img src="https://img.shields.io/badge/MySQL-4479A1?style=flat-square&logo=MySQL&logoColor=white"/>
<img src="https://img.shields.io/badge/Figma-F24E1E?style=flat-square&logo=Figma&logoColor=white"/>

## 기술적 구현 **
1. db의 select 쿼리를 줄이기 위해 캐시 서버인 Redis에서 값을 조회한 뒤 데이터가 없다면 Repository를 조회하도록 하였습니다.
추가예정

## 🧑‍💻 기술적 의사 결정
| 기술명           | 이유                                                                                                                                                                                                                                                 |
|:--------------|:---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Spring Boot   | 자바의 웹 프레임워크로, 특정 Library의 버전 자동 설정 기능을 이용하여 쉽고 빠른 웹 개발을 위하여 선택                                                                                                                                                                                     |
|Github flow    | 개인으로 프로젝트를 진행하기에 Gitflow보다는 단순한 Github flow를 사용. preProduction으로 기능별 브랜치를 설정하고, Production을 통해서 pull/request를 사용 |
| Docker        | Redis, MariaDB같은 독립적인 컨테이너들의 다중 컨테이너 라이프 사이클을 효율적으로 관리하기 위해 사용|
| Stomp,Sock.Js | websocket의 경우 단순한 통신 구조로 인해 메세지가 어떠한 요청인지 구분하기 힘들다는 단점 <br> 따라서 메시지 전송을 효율적으로 처리하기 위해 Stomp의 pub/sub를 이용하였고, <br>Redis가 제공하는 pub/sub를 활용하여 다른 서버에 접속해 있는 클라이언트가 다른 서버의 클라이언트와 메세지를 주고받도록 구현 |
| MARIADB       | Mysql과의 호환성이 뛰어나고, 더욱 강력한 기능을 제공합니다. 또한, RDS의 가격 측면에서 훨씬 저렴해 사용|
| Redis         | 채팅 데이터를 빠르게 읽고 쓰기 위한 caching용 DB로 선택|
| Kafka         | 추가예정|
