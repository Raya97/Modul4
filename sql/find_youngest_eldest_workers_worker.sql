-- Знайдемо наймолодшого працівника
WITH YoungestWorker AS (
  SELECT 'YOUNGEST' AS TYPE, NAME, BIRTHDAY
  FROM worker
  WHERE BIRTHDAY = (SELECT MIN(BIRTHDAY) FROM worker)
),
OldestWorker AS (
  SELECT 'OLDEST' AS TYPE, NAME, BIRTHDAY
  FROM worker
  WHERE BIRTHDAY = (SELECT MAX(BIRTHDAY) FROM worker)
)
SELECT * FROM YoungestWorker
UNION ALL
SELECT * FROM OldestWorker;
