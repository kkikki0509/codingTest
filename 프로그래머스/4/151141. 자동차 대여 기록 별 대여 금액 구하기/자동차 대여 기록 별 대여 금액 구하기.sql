SELECT b.HISTORY_ID, 
    CASE
        WHEN b.ranges = '7일 이상' THEN FLOOR(b.DAILY_FEE * (1 - COALESCE(a.DISCOUNT_RATE, 0) / 100)  * 
                                                          b.diff)
        WHEN b.ranges = '30일 이상' THEN FLOOR(b.DAILY_FEE * (1 - COALESCE(a.DISCOUNT_RATE, 0) / 100) * 
                                                           b.diff)
        WHEN b.ranges = '90일 이상' THEN FLOOR(b.DAILY_FEE * (1 - COALESCE(a.DISCOUNT_RATE, 0) / 100) * 
                                                           b.diff)
        ELSE FLOOR(b.DAILY_FEE * b.diff)
    END AS FEE
FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN AS a RIGHT JOIN 
            (SELECT a.history_id, b.CAR_TYPE, b.DAILY_FEE, DATEDIFF(a.END_DATE, a.START_DATE) + 1 AS diff,
                    CASE
                        WHEN DATEDIFF(a.END_DATE, a.START_DATE) + 1 >= 90 THEN '90일 이상'
                        WHEN DATEDIFF(a.END_DATE, a.START_DATE) + 1 >= 30 THEN '30일 이상'
                        WHEN DATEDIFF(a.END_DATE, a.START_DATE) + 1 >= 7 THEN '7일 이상'
                    END AS ranges
                FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY AS a INNER JOIN(SELECT *
                                                                       FROM CAR_RENTAL_COMPANY_CAR 
                                                                       WHERE CAR_TYPE = '트럭') AS b
                ON a.CAR_ID = b.CAR_ID) AS b
ON a.CAR_TYPE = b.CAR_TYPE AND a.DURATION_TYPE = b.ranges
ORDER BY FEE DESC, b.HISTORY_ID DESC