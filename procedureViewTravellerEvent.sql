DELIMITER $$
CREATE or REPLACE PROCEDURE viewTravellerEvent(IN usname varchar(30))
BEGIN
SELECT *
FROM viewevent
Where usname = traveller_username
END$$
DELIMITER ;