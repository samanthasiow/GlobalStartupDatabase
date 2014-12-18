/* Display all people with a given role, given the startup id*/
DELIMITER $$

DROP PROCEDURE IF EXISTS ShowRolesByStartupID $$

CREATE PROCEDURE ShowRolesByStartupID(IN startupID VARCHAR(255), IN queryBy VARCHAR(255))
BEGIN
	IF EXISTS (SELECT * FROM StartupListing as SL WHERE SL.id = startupID)
		THEN 
			SELECT name as Name, role as Role, startupName as StartupName
			FROM StartupListing as S, StartupRoles as R
			WHERE R.startupID = S.id and S.id = startupID and R.role = queryBy;
	ELSE
		SELECT 'No people found for that startup.' AS  'Error Message';
	END IF;
END;
$$