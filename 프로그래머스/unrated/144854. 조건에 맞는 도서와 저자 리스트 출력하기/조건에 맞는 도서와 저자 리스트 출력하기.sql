-- 코드를 입력하세요
SELECT BOOK_ID, AUTHOR_NAME, DATE_FORMAT(PUBLISHED_DATE, '%Y-%m-%d') AS PUBLISHED_DATE
  FROM BOOK, AUTHOR
 WHERE CATEGORY = '경제'
   AND BOOK.AUTHOR_ID = AUTHOR.AUTHOR_ID
 ORDER BY PUBLISHED_DATE