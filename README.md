# SNS-Service
redis를 이용한 채팅서비스, kafka를 이용한 알림, SNS (진행중)

## 사용할 기술<br>
Docker, Spring boot<br>
(사용 예정)Redis, Kafka

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

## 🧑‍💻 기술적 의사 결정
| 기술명           | 이유                                                                                                                                                                                                                                                 |
|:--------------|:---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Spring Boot   | 자바의 웹 프레임워크로, 특정 Library의 버전 자동 설정 기능을 이용하여 쉽고 빠른 웹 개발을 위하여 선택                                                                                                                                                                                     |
| Docker        | 채팅 데이터를 빠르게 읽고 쓰기 위한 caching용 DB로 선택                                                                                                                                                                                                               |
| Stomp,Sock.Js | 기존의 Websocket위에서 작동하는 프로토콜로, 클라이언트와 서버의 통신에 사용할 메시징 형식이 정의되어 있고, 그에 맞춰서 데이터 송수신에 편리함이 있어 선택 <br> Spring STOMP의 내장된 Message Broker와 Publish/Subscribe 기능을 통해, 데이터를 원하는 클라이언트로 전달하는데 편리함이 있어 선택 <br> 유저의 브라우저가 Websocket 지원하지 않을 경우를 대비하여 Sock.js 선택 |
| MARIADB       | 추가예정                                                                                                                                                                                                                                               |
| Redis         | 채팅 데이터를 빠르게 읽고 쓰기 위한 caching용 DB로 선택                                                                                                                                                                                                               |
| Kafka         | 추가예정                                                                                                                                                                                                                                               |