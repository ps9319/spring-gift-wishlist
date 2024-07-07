# spring-gift-product

## 기능 요구 사항
- 상품을 조회, 추가, 수정, 삭제할 수 있는 간단한 HTTP API를 구현한다.
- HTTP 요청과 응답은 JSON 형식으로 주고받는다.
- 현재는 별도의 데이터베이스가 없으므로 적절한 자바 컬렉션 프레임워크를 사용하여 메모리에 저장한다.

## 기능 목록
- Controller
  - get
  - add
  - update
  - delete
- Entity
  - product
- DTO
  - RequestDTO
  - ResponseDTO

- 관리자 화면 구현
  - 메인 페이지
    - getAll
  - 상품 입력 폼
    - 상품명, 상품가격, 상품url
  - 상품 선택 후 삭제
- 메모리에 저장하고 있던 모든 코드를 제거하고 H2 데이터베이스를 사용하도록 변경한다.
- 사용하는 테이블은 애플리케이션이 실행될 때 구축되어야 한다.

# spring-gift-wishlist
- step1
  - 상품 이름은 공백을 포함하여 최대 15자까지 입력할 수 있다.
  - 특수 문자 가능: ( ), [ ], +, -, &, /, _
  - 그 외 특수 문자 사용 불가
  - "카카오"가 포함된 문구는 담당 MD와 협의한 경우에만 사용할 수 있다.
- step2
- 사용자가 회원 가입, 로그인, 추후 회원별 기능을 이용할 수 있도록 구현한다.
  - 회원은 이메일과 비밀번호를 입력하여 가입한다.
  - 토큰을 받으려면 이메일과 비밀번호를 보내야 하며, 가입한 이메일과 비밀번호가 일치하면 토큰이 발급된다.
  - 토큰을 생성하는 방법에는 여러 가지가 있다. 방법 중 하나를 선택한다.
  - (선택) 회원을 조회, 추가, 수정, 삭제할 수 있는 관리자 화면을 구현한다.
