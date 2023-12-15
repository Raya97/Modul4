-- Знайдемо клієнта з найбільшою кількістю проєктів
WITH ClientProjectCount AS (
  SELECT c.NAME AS CLIENT_NAME, COUNT(p.ID) AS PROJECT_COUNT
  FROM client c
  LEFT JOIN project p ON c.ID = p.CLIENT_ID
  GROUP BY c.NAME
)
SELECT CLIENT_NAME, PROJECT_COUNT
FROM ClientProjectCount
WHERE PROJECT_COUNT = (SELECT MAX(PROJECT_COUNT) FROM ClientProjectCount);
