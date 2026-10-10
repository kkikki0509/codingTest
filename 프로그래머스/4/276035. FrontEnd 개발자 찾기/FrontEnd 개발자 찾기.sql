SELECT DISTINCT a.ID, a.EMAIL, a.FIRST_NAME, a.LAST_NAME
FROM DEVELOPERS AS a INNER JOIN (SELECT CODE
                                FROM SKILLCODES 
                                WHERE CATEGORY = 'Front End') AS b
ON a.SKILL_CODE & b.CODE = b.CODE
ORDER BY a.ID;