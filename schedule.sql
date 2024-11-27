use advanced;

CREATE TABLE users
(
    id         BIGINT          NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '유저 식별 고유 번호',
    name       VARCHAR(30)  NOT NULL COMMENT '유저 이름',
    email      VARCHAR(255) NOT NULL COMMENT '유저 이메일',
    status     ENUM ('normal', 'cancelled'),
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '생성일시',
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '수정일시',
    PRIMARY KEY (id)
);

CREATE TABLE currencies
(
    id         BIGINT          NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '통화 식별 고유 번호',
    exchange_rate  double NOT NULL COMMENT '환율',
    currency_name       VARCHAR(30)  NOT NULL COMMENT '통화 이름',
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '생성일시',
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '수정일시',
    PRIMARY KEY (id)
);

CREATE TABLE exchanges
(
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '유저_통화 식별 고유 번호',
    user_id BIGINT NOT NULL COMMENT '유저 고유 번호',
    currency_id BIGINT NOT NULL COMMENT '통화 고유 번호',
    amount_in_krw DOUBLE COMMENT '환전 전 금액 (원화 기준)',
    amount_after_exchange DOUBLE COMMENT '환전 후 금액',
    status ENUM ('normal', 'cancelled') DEFAULT 'normal' COMMENT '환전 상태',
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (currency_id) REFERENCES currencies (id)
)