create table conversions
(
    conversionId   integer      not null,
    sourceCurrency varchar(255) not null,
    targetCurrency varchar(255),
    amount         decimal      not null,
    timestamp      timestamp,
    primary key (conversionId)
);

/* Replace H2 sysdate() function(deprecated) with CURRENT_DATE() function */

INSERT INTO conversions (conversionId, sourceCurrency, targetCurrency, amount, timestamp)
VALUES (10001, 'BGN', 'EUR', 2.5, CURRENT_DATE());
INSERT INTO conversions (conversionId, sourceCurrency, targetCurrency, amount, timestamp)
VALUES (10002, 'BGN', 'EUR', 3.5, CURRENT_DATE());
INSERT INTO conversions (conversionId, sourceCurrency, targetCurrency, amount, timestamp)
VALUES (10003, 'BGN', 'EUR', 4.5, CURRENT_DATE());