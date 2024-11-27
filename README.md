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
|톷화 조회|GET|/api/users/{userId}| x | 단건 응답 정보 |200 : 정상 조회,  404 : 통화를 조회할 수 없음|
|통화 전체 조회|GET|/api/users| x  | 다건 응답 정보 |200 : 정상 조회|

<details>
  <summary><b>통화 생성성</b></summary>

### 1. 통화 생성

 *  기본 정보

|메서드|요청 URL|
|--|--|
|POST|/api/currencies|

  * 본문
    
    * 요청 :

      |컬럼|타입|설명|필수여부|
      |------|-----|-----|-----|
      |currencyName|String|통화 국가 이름|Y|
      |exchangeRate|BigDecimal|환율|Y|
      |symbol|String|국가 화폐 단위|Y|
    
      
    * 응답 :
   
       |컬럼|타입|설명|필수여부|
      |------|-----|-----|-----|
      |id|Long|통화 고유 식별자|Y|
      |currencyName|String|통화 국가 이름|Y|
      |exchangeRate|BigDecimal|환율|Y|
      |symbol|String|국가 화폐 단위|Y|
      |createdAt|datetime|생성일자|Y|

  * 예시
      * 요청 : POST/api/currencies

        
      ```
       {
        "currencyName" : "통화국가이름",
        "exchangeRate" : "환율",
        "symbol" : "국가화폐단위"
       }
        
      ```
    
      * 응답 : HTTP/1.1 200 OK

      ```
       {
        "id : 1
        "currencyName" : "통화국가이름",
        "exchangeRate" : "환율",
        "symbol" : "국가화폐단위"
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
      |currencyName|String|통화 국가 이름|Y|
      |exchangeRate|BigDecimal|환율|Y|
      |symbol|String|국가 화폐 단위|Y|
      |createdAt|datetime|생성일자|Y|

  * 예시
      
      * 요청 : GET/api/currencies

        
         
      * 응답 : HTTP/1.1 200 OK

      ```
       {
        "id : 1,
        "currencyName" : "통화국가이름",
        "exchangeRate" : "환율",
        "symbol" : "국가화폐단위"
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
      |currencyName|String|통화 국가 이름|Y|
      |exchangeRate|BigDecimal|환율|Y|
      |symbol|String|국가 화폐 단위|Y|
      |createdAt|datetime|생성일자|Y|

  * 예시
      
      * 요청 : GET/api/currencies

        
         
      * 응답 : HTTP/1.1 200 OK

      ```
     [
       {
        "id : 1,
        "currencyName" : "통화국가이름",
        "exchangeRate" : "환율",
        "symbol" : "국가화폐단위"
        "createdAt" : "2024-11-27 14:17:00"
       },
      {
        "id : 2,
        "currencyName" : "통화국가이름2",
        "exchangeRate" : "환율2",
        "symbol" : "국가화폐단위2"
        "createdAt" : "2024-11-27 14:20:30"
      }
      
      ```

   
</details>


## ERD 



## SQL query




