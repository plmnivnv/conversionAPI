create table conversions
(
    conversionId   integer      not null,
    sourceCurrency varchar(255) not null,
    targetCurrency varchar(255) not null,
    amount         decimal      not null,
    result         decimal      not null,
    timestamp      timestamp,
    primary key (conversionId)
);



INSERT INTO conversions (conversionId, sourceCurrency, targetCurrency, amount, result, timestamp)
VALUES (10001, 'BGN', 'EUR', 2.5, 25, CURRENT_DATE());
INSERT INTO conversions (conversionId, sourceCurrency, targetCurrency, amount, result, timestamp)
VALUES (10002, 'BGN', 'EUR', 3.5, 10, CURRENT_DATE());
INSERT INTO conversions (conversionId, sourceCurrency, targetCurrency, amount, result, timestamp)
VALUES (10003, 'BGN', 'EUR', 4.5, 51, CURRENT_DATE());