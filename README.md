# Advanced_project

## API 명세서

## User

|기능|Method|URL|Request|Response|상태코드|
|---|---|---|---|---|---|
|유저 생성|POST|/api/users| 요청 body | 등록 정보 | 201 : 정상 등록,  400 : 잘못된 요청 구문|
|유저 조회|GET|/api/users/{userId}| x | 단건 응답 정보 |200 : 정상 조회,  404 : 유저를 조회할 수 없음|
|유저 전체 조회|GET|/api/users| x  | 다건 응답 정보 |200 : 정상 조회|
|유저 삭제|DELETE|users/{userId}| x  | 삭제 정보 |200 : 정상 실행, 404 : 유저를 조회할 수 없음|

<details>
  <summary><b>유저 생성</b></summary>

  ### 1. 유저 생성

   *  기본 정보

|메서드|요청 URL|
|--|--|
|POST|/api/users|

  * 본문
    * 요청 :

      |컬럼|타입|설명|필수여부|
      |------|-----|-----|-----|
      |email|String|고객 이메일|Y|
      |name|String|고객 이름|Y|
    
      
    * 응답 :
   
      |컬럼|타입|설명|필수여부|
      |------|-----|-----|-----|
      |id|Long|고객 고유 식별자|Y|
      |email|String|고객 이메일|Y|
      |name|String|고객 이름|Y|
      |createdAt|datetime|생성일자|Y|

  * 예시
      * 요청 : POST/api/users

        
      ```
       {
        "email" : "test@cexample",
        "name" : "이름"
       }
        
      ```
    
      * 응답 : HTTP/1.1 200 OK

      ```
      {
       "id" : 1,
       "email" : "test@cexample",
       "name" : "이름",
       "createdAt : "2024-11-27 13:50:00
      }
      ```
  
</details>
    


<details>
  <summary><b>유저 조회</b></summary>

### 2. 유저 조회

 *  기본 정보

|메서드|요청 URL|
|--|--|
|GET|/api/users/{userId}|

  * 본문
  
    * 요청 : 없음

      
    * 응답 :
   
      |컬럼|타입|설명|필수여부|
      |------|-----|-----|-----|
      |id|Long|고객 고유 식별자|Y|
      |email|String|고객 이메일|Y|
      |name|String|고객 이름|Y|
      |createdAt|datetime|생성일자|Y|

  * 예시
     
      * 요청 : GET/api/users/{userId}

    
     
      * 응답 : HTTP/1.1 200 OK

      ```
      {
       "id" : 1,
       "email" : "test@cexample",
       "name" : "이름",
       "createdAt : "2024-11-27 13:50:00
      }
      ```

   </details>


<details>
  <summary><b>유저 전체 조회</b></summary>


### 3. 유저 전체 조회

 *  기본 정보

|메서드|요청 URL|
|--|--|
|GET|/api/users|

  * 본문
  
    * 요청 : 없음

      
    * 응답 :
   
      |컬럼|타입|설명|필수여부|
      |------|-----|-----|-----|
      |id|Long|고객 고유 식별자|Y|
      |email|String|고객 이메일|Y|
      |name|String|고객 이름|Y|
      |createdAt|datetime|생성일자|Y|

  * 예시
     
      * 요청 : GET/api/users

    
     
      * 응답 : HTTP/1.1 200 OK

      ```
     [
        {
         "id" : 1,
         "email" : "test@cexample",
         "name" : "이름",
         "createdAt : "2024-11-27 13:50:00
        },
        {
         "id" : 2,
         "email" : "test2@cexample",
         "name" : "이름2",
         "createdAt : "2024-11-27 13:55:22
        }
     ]
      ```
</details>


<details>
  <summary><b>유저 삭제</b></summary>


### 4. 유저 삭제

*  기본 정보

|메서드|요청 URL|
|--|--|
|DELETE|/api/users/{userId}|

  * 본문
  
    * 요청 : 없음

      
    * 응답 :
   
      |컬럼|타입|설명|필수여부|
      |------|-----|-----|-----|
      |id|Long|고객 고유 식별자|Y|
      |email|String|고객 이메일|Y|
      |name|String|고객 이름|Y|
      |createdAt|datetime|생성일자|Y|

  * 예시
     
      * 요청 : GET/api/users

    
     
      * 응답 : HTTP/1.1 200 OK

      ```
     [
        {
         "id" : 1,
         "email" : "test@cexample",
         "name" : "이름",
         "createdAt : "2024-11-27 13:50:00
        },
        {
         "id" : 2,
         "email" : "test2@cexample",
         "name" : "이름2",
         "createdAt : "2024-11-27 13:55:22
        }
     ]
      ```
</details>




## Currency

|기능|Method|URL|Request|Response|상태코드|
|---|---|---|---|---|---|
|통화 생성|POST|/api/users| 요청 body | 등록 정보 | 201 : 정상 등록,  400 : 잘못된 요청 구문|
|통화 조회|GET|/api/users/{userId}| x | 단건 응답 정보 |200 : 정상 조회,  404 : 통화를 조회할 수 없음|
|통화 전체 조회|GET|/api/users| x  | 다건 응답 정보 |200 : 정상 조회|

<details>
  <summary><b>통화 생성</b></summary>

### 1. 통화 생성

 *  기본 정보

|메서드|요청 URL|
|--|--|
|POST|/api/currencies|

  * 본문
    
    * 요청 :

      |컬럼|타입|설명|필수여부|
      |------|-----|-----|-----|
      |currencyName|String|화폐명|Y|
      |exchangeRate|BigDecimal|환율|Y|
      |symbol|String|화폐단위|Y|
    
      
    * 응답 :
   
       |컬럼|타입|설명|필수여부|
      |------|-----|-----|-----|
      |id|Long|통화 고유 식별자|Y|
      |currencyName|String|화폐명|Y|
      |exchangeRate|BigDecimal|환율|Y|
      |symbol|String|화폐단위|Y|
      |createdAt|datetime|생성일자|Y|

  * 예시
      * 요청 : POST/api/currencies

        
      ```
       {
        "currencyName" : "화폐명",
        "exchangeRate" : "환율",
        "symbol" : "화폐단위"
       }
        
      ```
    
      * 응답 : HTTP/1.1 200 OK

      ```
       {
        "id : 1
        "currencyName" : "화폐명",
        "exchangeRate" : "환율",
        "symbol" : "화폐단위"
        "createdAt" : "2024-11-27 14:17:00"
       }
      ```
</details>


<details>
  <summary><b>통화 조회</b></summary>

### 2. 통화 조회

 *  기본 정보

|메서드|요청 URL|
|--|--|
|GET|/api/currencies/{curency_id}|

  * 본문
    
    * 요청 : 없음

      
    * 응답 :
   
      |컬럼|타입|설명|필수여부|
      |------|-----|-----|-----|
      |id|Long|통화 고유 식별자|Y|
      |currencyName|String|화폐명|Y|
      |exchangeRate|BigDecimal|환율|Y|
      |symbol|String|화폐단위|Y|
      |createdAt|datetime|생성일자|Y|

  * 예시
      
      * 요청 : GET/api/currencies

        
         
      * 응답 : HTTP/1.1 200 OK

      ```
       {
        "id" : 1,
        "currencyName" : "화폐명",
        "exchangeRate" : "환율",
        "symbol" : "화폐단위"
        "createdAt" : "2024-11-27 14:17:00"
       }
      ```

</details>

<details>
  <summary><b>통화 전체 조회</b></summary>

### 3. 통화 전체 조회

 *  기본 정보

|메서드|요청 URL|
|--|--|
|GET|/api/currencies|

  * 본문
    
    * 요청 : 없음

      
    * 응답 :
   
      |컬럼|타입|설명|필수여부|
      |------|-----|-----|-----|
      |id|Long|통화 고유 식별자|Y|
      |currencyName|String|화폐명|Y|
      |exchangeRate|BigDecimal|환율|Y|
      |symbol|String|화폐단위|Y|
      |createdAt|datetime|생성일자|Y|

  * 예시
      
      * 요청 : GET/api/currencies

        
         
      * 응답 : HTTP/1.1 200 OK

      ```
     [
       {
        "id" : 1,
        "currencyName" : "화폐명",
        "exchangeRate" : "환율",
        "symbol" : "화폐단위"
        "createdAt" : "2024-11-27 14:17:00"
       },
      {
        "id" : 2,
        "currencyName" : "화폐명2",
        "exchangeRate" : "환율2",
        "symbol" : "화폐단위"
        "createdAt" : "2024-11-27 14:17:00"
      }
    ]

</details>


## Exchange


|기능|Method|URL|Request|Response|상태코드|
|---|---|---|---|---|---|
|환전 요청 수행|POST|/api/users/{userId}/currencies/{currencyId}/exchanges| 요청 body | 등록 정보 | 201 : 정상 등록,  400 : 잘못된 요청 구문|
|환전 요청 조회|GET|/api/users/{userId}/currencies/{currencyId}/exchanges/{exchangeId}| x | 단건 응답 정보 |200 : 정상 조회,  404 : 통화를 조회할 수 없음|
|환전 요청 상태 변경|GET|/api/users/{userId}/currencies/{currencyId}/exchanges/{exchangeId}| 요청 params  | 상태 변경 정보 |200 : 정상 조회|
|환전 요청 삭제|GET|/api/users/{userId}| x  | 등록 삭제 |200 : 정상 조회|

<details>
  <summary><b>환전 요청 수행</b></summary>

  ## 1. 환전 요청 수행
    
  * 기본 정보
      
  |메서드|요청 URL|
  |--|--|
  |POST|/api/users/{userId}/currencies/{currencyId}/exchanges|

       
  * 본문 
  
    * 요청 :
   
      |컬럼|타입|설명|필수여부|
      |------|-----|-----|-----|
      |userId|Long|유저 고유식별 번호|Y|
      |currencyId|Long|통화 고유식별 번호|Y|
      |beforeExchange|Double|환전 전 금액|Y|
    
      
    * 응답 :
   
      |컬럼|타입|설명|필수여부|
      |------|-----|-----|-----|
      |id|Long|환전 고유 식별 번호|Y|
      |userId|Long|유저 고유식별 번호|Y|
      |currencyId|Long|통화 고유식별 번호|Y|
      |afterExchange|Double|환전 후 금액|Y|
      |status|enum|환전 상태Y|
      |createdAt|datetime|생성일자|Y|
      
  * 예시 :

    * 요청 : POST/api/users/{userId}/currencies/{currencyId}/exchanges
   
       ```
       {
        "beforeExchange" : 10000
       }
      ```


    * 응답 : HTTP/1.1  200 OK
   
     
       ```
       {
        "id" : 1,
        "userId" : 1,
        "currencyId" : 1,
        "afterExchange" : 13000,
        "status" : "NORMAL",
        "createdAt" : "2024-11-27 14:20:30"
       }
      ```


</details>

<details>
  <summary><b>환전 요청 조회</b></summary>
  
  ## 2. 환전 요청 조회

   * 기본 정보
      
  |메서드|요청 URL|
  |--|--|
  |GET|/users/{userId}/currencies/{currencyId}/exchanges/{exchangeId}|
       
  * 본문 : 
      
      * 요청 : 없음

      
      * 응답 : 

    |컬럼|타입|설명|필수여부|
    |------|-----|-----|-----|
    |id|Long|환전 고유 식별 번호|Y|
    |userId|Long|유저 고유식별 번호|Y|
    |currencyId|Long|통화 고유식별 번호|Y|
    |afterExchange|Double|환전 후 금액|Y|
    |status|enum|환전 상태Y|
    |createdAt|datetime|생성일자|Y|
      
      
  * 예시 :
    
    * 요청 : GET/api/users/{userId}/currencies/{currencyId}/exchanges/{exchangeId}

      
    * 응답 : HTTP/1.1  200 OK
   
        ```
         {
        "id" : 1,
        "userId" : 1,
        "currencyId" : 1,
        "afterExchange" : 13000,
        "status" : "NORMAL"
        "createdAt" : "2024-11-27 14:20:30"
         }
        ```         
     
        

</details>

<details>
  <summary><b>환전 요청 상태 변경</b></summary>

  ## 3. 환전 요청 상태 변경

   * 기본 정보
      
  |메서드|요청 URL|
  |--|--|
  |POST|/api/users/{userId}/currencies/{currencyId}/exchanges/{exchangeId}|
       
  * 본문 : 
      
      * 요청 :
    
    |컬럼|타입|설명|필수여부|
    |------|-----|-----|-----|
    |status|enum|환전상태|Y|

   
        
      * 응답 :
   
    |컬럼|타입|설명|필수여부|
    |------|-----|-----|-----|
    |id|Long|환전 고유 식별 번호|Y|
    |userId|Long|유저 고유식별 번호|Y|
    |currencyId|Long|통화 고유식별 번호|Y|
    |status|enum|환전 상태Y|
    |createdAt|datetime|생성일자|Y|
      
        
  * 예시 :
      
      
    * 요청 : POST/api/users/{userId}/currencies/{currencyId}/exchanges/{exchangeId}
   


      ```
      {
      "status" : "NORMAL",
      }
      ```
      
      
    * 응답 : HTTP/1.1  200 OK
   
       ```
         {
        "id" : 1,
        "userId" : 1,
        "currencyId" : 1,
        "afterExchange" : 13000,
        "status" : "NORMAL"
        "createdAt" : "2024-11-27 14:20:30"
         }
        ```         

</details>

<details>
  <summary><b>환전 요청 삭제</b></summary>

  ## 4. 환전 요청 삭제

   * 기본 정보
      
  |메서드|요청 URL|
  |--|--|
  |DELETE|/api/users/{userId}|
       
  * 본문 : 
     
      
      * 요청 : 없음
      
      
      * 응답 : 없음
  
  
  * 예시 :
      
      
      * 요청 : DELETE/api/user/{userId}
      
      
      * 응답 : HTTP/1.1  200 OK

</details>




## ERD 



## SQL query

### 1. 테이블 생성
```sql
--- Create users table
CREATE TABLE users
(
    id         BIGINT          NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '유저 식별 고유 번호',
    name       VARCHAR(30)  NOT NULL COMMENT '유저 이름',
    email      VARCHAR(255) NOT NULL COMMENT '유저 이메일',
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '생성일시',
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '수정일시',
    PRIMARY KEY (id)
);

--- Create currnecies table
CREATE TABLE currencies
(
    id            BIGINT      NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '통화 식별 고유 번호',
    exchange_rate double NOT NULL COMMENT '환율',
    currency_name VARCHAR(30) NOT NULL COMMENT '통화 이름',
    created_at    DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '생성일시',
    updated_at    DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '수정일시',
    PRIMARY KEY (id)
);

--- Create exchanges table
CREATE TABLE exchanges
(
    id          BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '유저_통화 식별 고유 번호',
    user_id     BIGINT NOT NULL COMMENT '유저 고유 번호',
    currency_id BIGINT NOT NULL COMMENT '통화 고유 번호',
    amount_in_krw DOUBLE COMMENT '환전 전 금액 (원화 기준)',
    amount_after_exchange DOUBLE COMMENT '환전 후 금액',
    status      ENUM ('normal', 'cancelled') DEFAULT 'normal' COMMENT '환전 상태',
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (currency_id) REFERENCES currencies (id)
);
```
### 2. 유저 생성 및 통화 생성

```sql

-- Insert users
INSERT INTO users (id, name, email, created_at)
VALUES (1, 이름, test@example.com, current_timestamp());

-- Insert currencies
INSERT INTO user (id, currency_name, exchange_rate, symbol, create_date)
VALUES (1, 통화', '환율','화폐단위', current_timestamp());

```

### 3. 유저 조회 및 통화 조회 

```sql

--- Select users with id 1
SELECT id, name, email, created_at, updated_at FROM users WHERE id = 1;

--- Select currencys id 1
SELECT id, currnecy_name, exchange_rate, created_at, updated_at FROM users WHERE id = 1;

```

### 4. 유저 및 통화 전체 조회

```sql

--- Select users
SELECT id, name, email, created_at, updated_at FROM users

--- Select currencys
SELECT id, currnecy_name, exchange_rate, created_at, updated_at FROM users

```
### 5. 유저 삭제

```sql
--- Delete users with id 1
DELETE FROM users WHERE id = 1;

```

### 5. 환전 요청

```sql
--- Insert exchanges
INSERT INTO (user_id, currency_id, amount_in_krw, status, created_at)
VALUES(1, 1, 1000, NORMAL, current_timestamp());

```
### 6. 환전 요청 조회

```sql
--- Select exchanges with id 1
SELECT user_id, currency_id, amount_in_krw, amount_after_exchange, status, created_at
FROM exchanges WHERE id = 1;

```

### 7. 환전 요청 상태 변경

```sql
--- Update exchange with id 1
UPDATE status SET = 'CONCELLED' WHERE id = 1; 

```

### 8. 환전 요청 삭제

```sql
--- Delete exchanges with user_id 1
 
DROP TABLE users WHERE user_id = 1;

```




