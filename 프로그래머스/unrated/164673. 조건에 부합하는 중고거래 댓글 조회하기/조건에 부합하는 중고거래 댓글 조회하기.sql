-- 코드를 입력하세요
SELECT 
    GB.TITLE
    , GB.BOARD_ID
    , GR.REPLY_ID
    , GR.WRITER_ID
    , GR.CONTENTS
    , DATE_FORMAT(GR.CREATED_DATE, "%Y-%m-%d") AS CREATED_DATE
FROM
    USED_GOODS_BOARD AS GB
JOIN
    USED_GOODS_REPLY GR
ON 
    GB.BOARD_ID = GR.BOARD_ID
WHERE
    DATE_FORMAT(GB.CREATED_DATE, "%Y-%m-%d") > DATE('2022-09-30')
    AND DATE_FORMAT(GB.CREATED_DATE, "%Y-%m-%d") < DATE('2022-11-01')
ORDER BY
    DATE_FORMAT(GR.CREATED_DATE, "%Y-%m-%d"), GB.TITLE
    