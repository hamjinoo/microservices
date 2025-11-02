# 🚀 마이크로서비스 게시판 프로젝트

Spring Boot 기반의 마이크로서비스 학습을 위한 게시판 프로젝트입니다.

## 📋 프로젝트 개요

이 프로젝트는 모놀리식 아키텍처에서 시작하여 마이크로서비스 아키텍처로 점진적으로 전환하는 학습 프로젝트입니다.

### 현재 단계: 2단계 (기본 게시판 API 개발) ✅

- ✅ 기본 CRUD API 구현
- ✅ 예외 처리 및 응답 표준화
- ✅ 트랜잭션 관리
- ✅ 입력 검증
- 🔄 페이징 및 검색 기능 (예정)

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
│   └── ReplyController.java
├── service/            # 비즈니스 로직
│   ├── BoardService.java
│   ├── PostService.java
│   └── ReplyService.java
├── repository/         # 데이터 접근 계층
│   ├── BoardRepository.java
│   ├── PostRepository.java
│   └── ReplyRepository.java
├── model/             # 엔티티
│   ├── BaseEntity.java      # 공통 필드 (생성일, 수정일)
│   ├── Board.java
│   ├── Post.java
│   └── Reply.java
├── dto/               # 데이터 전송 객체
│   └── ApiResponse.java     # 표준 응답 구조
├── exception/         # 예외 처리
│   ├── EntityNotFoundException.java
│   └── GlobalExceptionHandler.java
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

### 댓글 API
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

자세한 테스트 가이드는 [API_테스트_가이드.md](dont_upload/API_테스트_가이드.md)를 참고하세요.

### 빠른 테스트 예시

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

## 🔑 주요 기능

### ✅ 구현 완료
- [x] 게시판 CRUD
- [x] 게시글 CRUD
- [x] 댓글 CRUD
- [x] 조회수 기능
- [x] 입력 검증 (Validation)
- [x] 예외 처리 (GlobalExceptionHandler)
- [x] 표준 응답 구조 (ApiResponse)
- [x] 트랜잭션 관리
- [x] 생성일시/수정일시 자동 관리
- [x] 순환 참조 방지

### 🔄 개발 예정
- [ ] 페이징 및 정렬
- [ ] 검색 기능
- [ ] N+1 문제 해결
- [ ] Spring Security
- [ ] JWT 인증
- [ ] 파일 업로드
- [ ] API 문서화 (Swagger)

## 📚 학습 가이드

이 프로젝트는 단계별 학습을 위해 설계되었습니다.

1. **[학습가이드.md](dont_upload/학습가이드.md)** - 전체 학습 로드맵
2. **[API_테스트_가이드.md](dont_upload/API_테스트_가이드.md)** - Postman 테스트 가이드
3. **[다음단계_개선사항.md](dont_upload/다음단계_개선사항.md)** - 다음 구현 예정 기능

### 학습 단계
```
1단계: 기초 및 프로젝트 설정 ✅
2단계: 기본 게시판 API 개발 ✅ (현재)
3단계: 게시판 기능 확장 🔄
4단계: 사용자 인증 및 권한
5단계: 마이크로서비스 전환 - 1
6단계: 마이크로서비스 전환 - 2
7단계: 이벤트 기반 아키텍처
8단계: 테스트 및 배포
9단계: 모니터링 및 성능 최적화
```

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
Board (게시판)
  ├── id: Long
  ├── name: String
  ├── posts: List<Post>
  ├── createdAt: LocalDateTime
  └── updatedAt: LocalDateTime

Post (게시글)
  ├── id: Long
  ├── title: String
  ├── content: String
  ├── viewCount: Long
  ├── board: Board (N:1)
  ├── replies: List<Reply> (1:N)
  ├── createdAt: LocalDateTime
  └── updatedAt: LocalDateTime

Reply (댓글)
  ├── id: Long
  ├── commenter: String
  ├── content: String
  ├── post: Post (N:1)
  ├── createdAt: LocalDateTime
  └── updatedAt: LocalDateTime
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

## 📝 개발 로그

### v0.2.0 (현재) - 2단계 완성
- BaseEntity 추가 (타임스탬프)
- ApiResponse 표준화
- GlobalExceptionHandler 구현
- 입력 검증 추가
- 조회수 기능 구현
- Board, Reply CRUD 완성

### v0.1.0 - 1단계 기본 구조
- 프로젝트 초기 설정
- Post 엔티티 및 CRUD 구현
- H2 데이터베이스 연동

## 🤝 기여하기

이 프로젝트는 학습 목적으로 제작되었습니다. 
개선 사항이나 버그를 발견하시면 Issue를 열어주세요!

## 📜 라이선스

이 프로젝트는 학습 목적으로 자유롭게 사용 가능합니다.

## 📧 문의

프로젝트에 대한 질문이나 도움이 필요하시면 언제든 연락주세요!

---

**Happy Coding! 🚀**

