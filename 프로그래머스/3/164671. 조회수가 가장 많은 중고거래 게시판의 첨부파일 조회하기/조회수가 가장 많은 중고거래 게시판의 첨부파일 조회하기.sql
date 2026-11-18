SELECT CONCAT('/home/grep/src/', a.BOARD_ID, '/', CONCAT(FILE_ID, FILE_NAME, FILE_EXT)) AS FILE_ID
FROM USED_GOODS_FILE AS a INNER JOIN (SELECT BOARD_ID, VIEWS
                                      FROM USED_GOODS_BOARD
                                      ORDER BY VIEWS DESC
                                      LIMIT 1) AS b
ON a.BOARD_ID = b.BOARD_ID      
ORDER BY FILE_ID DESC