SELECT c.categoryid as CATEGORYID,
	c.categoryname as CATEGORYNAME
FROM channelscategory c
WHERE c.categoryname LIKE ‘M%’;