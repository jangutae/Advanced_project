package com.jut.user_currency.service;

import com.jut.user_currency.dto.ExchangeRequestDto;
import com.jut.user_currency.dto.ExchangeResponseDto;
import com.jut.user_currency.entity.Currency;
import com.jut.user_currency.entity.Exchange;
import com.jut.user_currency.entity.User;
import com.jut.user_currency.formatter.PriceFormatter;
import com.jut.user_currency.repository.CurrencyRepository;
import com.jut.user_currency.repository.ExchangeRepository;
import com.jut.user_currency.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
@Slf4j
public class ExchangeService {

    private static final BigDecimal MIN_RATE = new BigDecimal("0.1");  // 최소 환율 범위
    private static final BigDecimal MAX_RATE = new BigDecimal("500.00");

    private final PriceFormatter priceFormatter;
    private final CurrencyRepository currencyRepository;
    private final UserRepository userRepository;
    private final ExchangeRepository exchangeRepository;

    // 환전 요청
    public ExchangeResponseDto requestedExchange(ExchangeRequestDto requestDto) {
        // 유저를 아이디 조회
        User findUser = userRepository.findByIdOrElseThrow(requestDto.userId());
        // 통화를 아이디로 조회
        Currency findCurrency = currencyRepository.findByIdOrElseThrow(requestDto.currencyId());
        // 환전 요청 생성
        Exchange exchange = new Exchange(findUser, findCurrency, requestDto.beforeExchangeAmount(), requestDto.status());
        // 환전 요청 금액 타입 변환
        BigDecimal DoubleBigDecimal = BigDecimal.valueOf(exchange.getBeforeExchangeAmount());
        // 환율 계산
        BigDecimal afterExchangeDollar = findCurrency.getExchangeRate().multiply(DoubleBigDecimal);
        // Double 입력 값 -> 달러 형태로 변환
        String StringToDollar = priceFormatter.print(afterExchangeDollar, new Locale("en", "US"));

        if (!validationStringToDollar(StringToDollar)) {
            throw new IllegalArgumentException("요청값의 형식이 맞지 않습니다. ");
        }
        // 반환 값을 다시 타입 변환
        BigDecimal afterExchange = findCurrency.getExchangeRate().multiply(new BigDecimal(StringToDollar));
        // 소수점 둘쨋자리까지 표현
        BigDecimal exchangePrice = afterExchange.setScale(2, RoundingMode.HALF_UP);
        // 환전된 금액 업데이트
        exchange.update(exchangePrice);

        // repository 저장
        Exchange savedExchange = exchangeRepository.save(exchange);

        return ExchangeResponseDto.toDto(savedExchange);
    }

    // 환전 요청 조회
    public ExchangeResponseDto requestedExchangeById(Long exchangeId) {
        Exchange exchange = exchangeRepository.findByIdOrElseThrow(exchangeId);

        return ExchangeResponseDto.toDto(exchange);
    }

    // 환전 요청 상태 변경
    public String requestedExchangeChangeStatus(Long exchangeId) {
        Exchange exchange = exchangeRepository.findByIdOrElseThrow(exchangeId);

        if (exchange.getAfterExchangeAmount() != null) {
            exchange.setStatus(Exchange.Status.CANCELLED);
        }

        return exchange.getStatus().toString();
    }

    //
    @PostConstruct
    public void checkExchangeRates() {
        currencyRepository.findAll().forEach(currency -> {
            BigDecimal rate = currency.getExchangeRate();

            // 환율이 0이거나 음수이거나 범위를 벗어나면 로그 기록
            if (rate.compareTo(BigDecimal.ZERO) <= 0 || rate.compareTo(MIN_RATE) < 0 || rate.compareTo(MAX_RATE) > 0) {
                log.error("Invalid exchange rate detected for currency {}: {}. Rate must be between {} and {}.",
                        currency.getCurrencyName(), rate, MIN_RATE, MAX_RATE);
            } else {
                log.info("Valid exchange rate for currency {}: {}", currency.getCurrencyName(), rate);
            }
        });
    }

    public static boolean validationStringToDollar(String checkAfterExchange) {
        // 금액 형삭에 대한 정규식
        String checkString = "^\\d+(\\.\\d+)?$";

        Pattern pattern = Pattern.compile(checkString);
        Matcher matcher = pattern.matcher(checkAfterExchange);

        return matcher.matches();





    }
}
