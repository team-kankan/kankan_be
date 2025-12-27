# kankan_be

KanKan 백엔드(Spring Boot) API 서버입니다.  
로컬 개발 환경은 Docker Compose로 API + MySQL을 함께 실행합니다.

## Requirements
- Docker Desktop (Docker Compose 포함)

## Quick Start

### 1) Run (API + MySQL)

    docker compose up -d --build

### 2) Check
- API: http://localhost:8080
- Health Check: http://localhost:8080/health

### 3) MySQL Connection (Local)
- Host: 127.0.0.1
- Port: 3307
- Schema(Database): kankan
- User/Password: `.env` 값 사용

## Stop

    docker compose down

## Reset (DB 포함 전체 초기화)
⚠️ 아래 명령은 DB 데이터가 삭제됩니다.

    docker compose down -v
