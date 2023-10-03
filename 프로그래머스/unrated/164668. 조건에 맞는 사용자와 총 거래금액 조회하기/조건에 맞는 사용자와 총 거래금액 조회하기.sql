-- 코드를 입력하세요
SELECT USER_ID, NICKNAME, SUM(A.PRICE) AS TOTAL_SALES
  FROM USED_GOODS_BOARD AS A, USED_GOODS_USER AS B
 WHERE A.WRITER_ID = B.USER_ID
   AND A.STATUS = "DONE"
 GROUP BY B.USER_ID
 HAVING SUM(A.PRICE) >= 700000
 ORDER BY TOTAL_SALES