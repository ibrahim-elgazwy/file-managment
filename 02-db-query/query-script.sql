
SELECT t.user_id, u.username, t.training_id, t.training_date, COUNT(t.training_id) 
FROM training_details t JOIN users u 
ON (u.user_id = t.user_id)
GROUP BY u.username,t.user_id, t.training_id, t.training_date
HAVING COUNT(t.training_id) > 1
ORDER BY t.training_date DESC;