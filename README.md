# 🚀 스프링부트 마이크로서비스 학습 프로젝트

> **프론트엔드 개발자에서 풀스택 개발자로!**  
> 실무에서 바로 사용할 수 있는 스프링부트 마이크로서비스를 단계별로 학습하는 프로젝트입니다.

## 📋 프로젝트 개요

이 프로젝트는 **프론트엔드 개발 경험이 있는 분들**을 위한 백엔드 학습 프로젝트입니다.

- 모놀리식 아키텍처에서 시작
- 마이크로서비스 아키텍처로 점진적 전환
- **개념 이해 중심** (70% 개념 + 30% 코드)
- 프론트엔드 경험과 연결하여 설명

### 🎯 학습 목표

1. **백엔드 API 개발**: CRUD부터 인증, 예외 처리까지
2. **마이크로서비스 아키텍처**: 서비스 분리, API Gateway, 이벤트 기반
3. **프로덕션 준비**: Docker, Kubernetes, 모니터링, 최적화
4. **풀스택 개발**: React 연동, CI/CD 파이프라인 구축

## 🛠️ 기술 스택

- **Java**: 17
- **Spring Boot**: 3.5.6
- **Spring Data JPA**: 엔티티 및 데이터 접근
- **Spring Validation**: 입력 검증
- **H2 Database**: 개발용 인메모리 데이터베이스
- **MariaDB**: 프로덕션용 데이터베이스 (설정 완료)
- **Lombok**: 보일러플레이트 코드 제거
- **Gradle**: 빌드 도구

## 📂 프로젝트 구조

```
src/main/java/com/project/board/
├── controller/          # REST API 컨트롤러
│   ├── BoardController.java
│   ├── PostController.java
│   └── ReplyController.java (Step 3에서 추가 예정)
├── service/            # 비즈니스 로직
│   ├── BoardService.java
│   ├── PostService.java
│   └── ReplyService.java (Step 3에서 추가 예정)
├── repository/         # 데이터 접근 계층
│   ├── BoardRepository.java
│   ├── PostRepository.java
│   └── ReplyRepository.java (Step 3에서 추가 예정)
├── model/             # 엔티티
│   ├── Board.java
│   ├── Post.java
│   ├── Reply.java (Step 3에서 추가 예정)
│   └── BaseEntity.java (Step 3에서 추가 예정)
├── dto/               # 데이터 전송 객체 (Step 3에서 추가 예정)
├── exception/         # 예외 처리 (Step 3에서 추가 예정)
└── BoardApplication.java    # 메인 애플리케이션
```

## 🚀 시작하기

### 1. 프로젝트 클론

```bash
git clone <repository-url>
cd board
```

### 2. 애플리케이션 실행

#### Gradle 사용

```bash
./gradlew bootRun
```

#### IDE에서 실행

`BoardApplication.java` 파일을 실행

### 3. 애플리케이션 확인

```
애플리케이션: http://localhost:8080
H2 콘솔: http://localhost:8080/h2-console
```

## 📡 API 엔드포인트

### Base URL

```
http://localhost:8080/api
```

### 게시판 API

| Method | Endpoint           | 설명             |
| ------ | ------------------ | ---------------- |
| GET    | `/api/boards`      | 게시판 목록 조회 |
| GET    | `/api/boards/{id}` | 게시판 상세 조회 |
| POST   | `/api/boards`      | 게시판 생성      |
| PUT    | `/api/boards/{id}` | 게시판 수정      |
| DELETE | `/api/boards/{id}` | 게시판 삭제      |

### 게시글 API

| Method | Endpoint          | 설명             |
| ------ | ----------------- | ---------------- |
| GET    | `/api/posts`      | 게시글 목록 조회 |
| GET    | `/api/posts/{id}` | 게시글 상세 조회 |
| POST   | `/api/posts`      | 게시글 생성      |
| PUT    | `/api/posts/{id}` | 게시글 수정      |
| DELETE | `/api/posts/{id}` | 게시글 삭제      |

### 댓글 API (Step 3에서 추가 예정)

| Method | Endpoint                                | 설명           |
| ------ | --------------------------------------- | -------------- |
| GET    | `/api/posts/{postId}/replies`           | 댓글 목록 조회 |
| GET    | `/api/posts/{postId}/replies/{replyId}` | 댓글 상세 조회 |
| POST   | `/api/posts/{postId}/replies`           | 댓글 생성      |
| PUT    | `/api/posts/{postId}/replies/{replyId}` | 댓글 수정      |
| DELETE | `/api/posts/{postId}/replies/{replyId}` | 댓글 삭제      |

## 📄 API 응답 형식

### 성공 응답

```json
{
  "success": true,
  "message": "요청이 성공적으로 처리되었습니다",
  "data": {
    "id": 1,
    "title": "게시글 제목",
    "content": "게시글 내용"
  },
  "timestamp": "2024-01-01T10:00:00"
}
```

### 에러 응답

```json
{
  "success": false,
  "message": "게시글를 찾을 수 없습니다. ID: 999",
  "data": null,
  "timestamp": "2024-01-01T10:00:00"
}
```

## 🧪 API 테스트

### 빠른 테스트 예시 (Postman 또는 curl)

#### 1. 게시판 생성

```bash
curl -X POST http://localhost:8080/api/boards \
  -H "Content-Type: application/json" \
  -d '{"name": "자유게시판"}'
```

#### 2. 게시글 생성

```bash
curl -X POST http://localhost:8080/api/posts \
  -H "Content-Type: application/json" \
  -d '{
    "title": "첫 번째 게시글",
    "content": "안녕하세요!",
    "board": {"id": 1}
  }'
```

#### 3. 게시글 조회

```bash
curl http://localhost:8080/api/posts/1
```

## 🎓 학습 특징

### 개념 중심 학습 (70% 개념 + 30% 코드)

- **"왜 필요한가?"**를 먼저 이해
- 프론트엔드 경험과 연결하여 설명
- 실무 최소 수준의 내용만 포함

### 실생활 비유로 이해하기

| 백엔드 개념     | 실생활 비유                               |
| --------------- | ----------------------------------------- |
| Controller      | 민원 창구에서 시민을 맞이하는 상담 직원   |
| Service         | 상담 내용을 바탕으로 해결책을 찾는 내부 팀 |
| Repository      | 자료 보관소에서 서류를 찾아오는 기록 담당 |
| Entity          | 서류 양식 또는 카드 한 장                 |
| DI Container    | 필요한 물품을 정리해 두는 중앙 창고       |
| JWT             | 신분증이나 출입증처럼 신원을 증명하는 표  |
| API Gateway     | 건물 정문에서 방문자를 분산시키는 안내데스크 |
| Circuit Breaker | 과부하 시 전기를 끊어 장비를 보호하는 차단기 |

### 실습 중심

- 각 단계마다 직접 코드 작성
- Postman으로 API 테스트
- 에러를 경험하고 해결하는 과정 포함

## 📚 학습 가이드

### 시작하기

**👉 [학습 로드맵 보기](docs/README_마이크로서비스_학습_로드맵.md)**

### 10단계 학습 과정

| 단계        | 문서                                                           | 주요 학습 내용        | 예상 시간 |
| ----------- | -------------------------------------------------------------- | --------------------- | --------- |
| **Step 1**  | [스프링부트 기초](docs/Step_01_스프링부트_기초.md)             | IoC/DI, 첫 API 만들기 | 1-2일     |
| **Step 2**  | [기본 게시판 API](docs/Step_02_기본_게시판_API.md)             | 계층형 아키텍처, CRUD | 3-5일     |
| **Step 3**  | [게시판 기능 확장](docs/Step_03_게시판_기능_확장.md)           | 댓글, 페이징, 검색    | 3-4일     |
| **Step 4**  | [인증 권한 관리](docs/Step_04_인증_권한_관리.md)               | Spring Security, JWT  | 5-7일     |
| **Step 5**  | [마이크로서비스 전환 1](docs/Step_05_마이크로서비스_전환_1.md) | MSA 개념, Eureka      | 5-7일     |
| **Step 6**  | [마이크로서비스 전환 2](docs/Step_06_마이크로서비스_전환_2.md) | API Gateway, Feign    | 5-7일     |
| **Step 7**  | [이벤트 기반 아키텍처](docs/Step_07_이벤트_기반_아키텍처.md)   | Kafka, 이벤트 처리    | 5-7일     |
| **Step 8**  | [테스트 및 배포](docs/Step_08_테스트_배포.md)                  | JUnit, Docker, K8s    | 5-7일     |
| **Step 9**  | [모니터링 최적화](docs/Step_09_모니터링_최적화.md)             | 로깅, 성능, 캐싱      | 5-7일     |
| **Step 10** | [최종 프로젝트](docs/Step_10_최종_프로젝트.md)                 | 프론트 연동, CI/CD    | 7-10일    |

**총 학습 기간**: 약 3개월 (주 10-15시간 기준)

## 🗄️ 데이터베이스 설정

### H2 (개발 환경) - 현재 사용 중

```properties
spring.datasource.url=jdbc:h2:mem:boarddb
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```

H2 콘솔 접속: http://localhost:8080/h2-console

- JDBC URL: `jdbc:h2:mem:boarddb`
- Username: `sa`
- Password: (비워두기)

### MariaDB (프로덕션 환경) - 설정 완료

```properties
spring.datasource.url=jdbc:mariadb://localhost:3306/boarddb
spring.datasource.username=root
spring.datasource.password=your_password
```

## 🧩 엔티티 구조

```
Board (게시판) - 현재 구현 완료
  ├── id: Long
  ├── name: String
  └── posts: List<Post>
  └── createdAt, updatedAt (Step 3에서 추가 예정)

Post (게시글) - 현재 구현 완료
  ├── id: Long
  ├── title: String
  ├── content: String
  ├── board: Board (N:1)
  └── replies: List<Reply> (Step 3에서 추가)
  └── createdAt, updatedAt (Step 3에서 추가 예정)

Reply (댓글) - Step 3에서 추가 예정
  ├── id: Long
  ├── commenter: String
  ├── content: String
  ├── post: Post (N:1)
  └── createdAt: LocalDateTime
```

## 🎯 코드 품질

### 레이어 구조

- **Controller**: API 엔드포인트, 입력 검증
- **Service**: 비즈니스 로직, 트랜잭션 관리
- **Repository**: 데이터 접근

### 트랜잭션 관리

- 읽기 전용: `@Transactional(readOnly = true)`
- 쓰기 작업: `@Transactional`

### 로깅

- SLF4J + Logback
- 각 레이어별 로그 레벨 관리

## 🐛 트러블슈팅

### 1. LazyInitializationException

**원인**: 트랜잭션 밖에서 지연 로딩 엔티티 접근

**해결**: 서비스 메서드에 `@Transactional` 추가

### 2. 순환 참조 (Circular Reference)

**원인**: Board ↔ Post, Post ↔ Reply 양방향 참조

**해결**: `@JsonIgnore` 어노테이션 추가로 해결 완료

### 3. N+1 문제

**현재 상태**: 발생 가능성 있음

**해결 예정**:

- `@BatchSize` 적용
- `@EntityGraph` 사용
- DTO 패턴 적용

## 📝 현재 진행 상황

### ✅ 완료된 기능 (Step 1-2)

- [x] 스프링부트 프로젝트 구조 이해
- [x] IoC/DI 개념 학습
- [x] 게시판(Board) CRUD API
- [x] 게시글(Post) CRUD API
- [x] JPA Entity 및 연관관계 매핑 (Board ↔ Post)
- [x] 트랜잭션 관리 (@Transactional)
- [ ] 예외 처리 및 표준 응답 (Step 3에서 추가 예정)
- [ ] 입력 검증 (Validation) (Step 4에서 추가 예정)
- [ ] 댓글(Reply) 기능 (Step 3에서 추가 예정)
- [ ] 조회수 기능 (Step 3에서 추가 예정)

### 🔄 진행 예정 (Step 3-10)

- [ ] 페이징, 검색, DTO 패턴
- [ ] Spring Security, JWT 인증
- [ ] 마이크로서비스 분리
- [ ] API Gateway, Feign Client
- [ ] Kafka 이벤트 처리
- [ ] Docker, Kubernetes 배포
- [ ] Redis 캐싱, 성능 최적화
- [ ] React 프론트엔드 연동

## 💡 학습 팁

1. **순차적 학습**: Step 1부터 순서대로 진행 (기초가 중요!)
2. **직접 코딩**: 복붙하지 말고 손으로 직접 타이핑
3. **에러 경험**: 에러가 나면 스스로 해결 시도 (구글링 + Stack Overflow)
4. **Git 커밋**: 매 단계마다 커밋하여 진행 상황 기록
   - 📝 [커밋 메시지 가이드](docs/커밋_메시지_가이드.md) 참고
5. **개념 정리**: 자신의 말로 노트 작성

## 🎯 이 학습을 마치면...

- ✅ 백엔드 API를 혼자서 개발할 수 있습니다
- ✅ 마이크로서비스 아키텍처를 설계할 수 있습니다
- ✅ 프론트엔드와 백엔드를 모두 개발하는 풀스택 개발자가 됩니다
- ✅ 실무 프로젝트에 바로 투입될 수 있습니다

## 🤝 기여하기

이 프로젝트는 학습 목적으로 제작되었습니다.
개선 사항이나 버그를 발견하시면 Issue를 열어주세요!

## 📜 라이선스

이 프로젝트는 학습 목적으로 자유롭게 사용 가능합니다.

---

**Happy Coding! 🚀**
