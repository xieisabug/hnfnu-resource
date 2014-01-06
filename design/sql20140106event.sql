
--
-- Dumping events for database 'hnfnuzyw'
--
/*!50106 SET @save_time_zone= @@TIME_ZONE */ ;
/*!50106 DROP EVENT IF EXISTS `e_user_habit` */;
DELIMITER ;;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;;
/*!50003 SET character_set_client  = utf8 */ ;;
/*!50003 SET character_set_results = utf8 */ ;;
/*!50003 SET collation_connection  = utf8_general_ci */ ;;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;;
/*!50003 SET @saved_time_zone      = @@time_zone */ ;;
/*!50003 SET time_zone             = 'SYSTEM' */ ;;
/*!50106 CREATE*/ /*!50117 DEFINER=`root`@`%`*/ /*!50106 EVENT `e_user_habit` ON SCHEDULE EVERY 1 HOUR STARTS '2013-12-02 13:55:46' ON COMPLETION PRESERVE ENABLE DO call user_habit() */ ;;
/*!50003 SET time_zone             = @saved_time_zone */ ;;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;;
/*!50003 SET character_set_client  = @saved_cs_client */ ;;
/*!50003 SET character_set_results = @saved_cs_results */ ;;
/*!50003 SET collation_connection  = @saved_col_connection */ ;;
DELIMITER ;
/*!50106 SET TIME_ZONE= @save_time_zone */ ;

--
-- Dumping routines for database 'hnfnuzyw'
--
/*!50003 DROP PROCEDURE IF EXISTS `user_habit` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`%` PROCEDURE `user_habit`()
BEGIN
  DECLARE no_more INT(1) DEFAULT 0;
  DECLARE tmp_menuId INT(11);
  DECLARE tmp_count INT(11);
  DECLARE tmp_id INT(11);
  DECLARE cur_user_count CURSOR FOR
    SELECT s_user.id userId,menuId,COUNT(0) num FROM l_user_operate,s_user 
      WHERE userId = s_user.id GROUP BY userId,menuId ;
  DECLARE CONTINUE HANDLER FOR NOT FOUND SET no_more = 1;
  
  OPEN cur_user_count;
  REPEAT 
    
    FETCH cur_user_count INTO tmp_id,tmp_menuId,tmp_count;

    IF NOT no_more
    THEN
      INSERT INTO s_user_habit(userId,menuId,times) 
        VALUES(tmp_id,tmp_menuId,tmp_count) ON DUPLICATE KEY 
          UPDATE times = times+tmp_count;
      SELECT tmp_id,tmp_menuId,tmp_count;
    END IF;

  UNTIL no_more END REPEAT;
  CLOSE cur_user_count;
  
  delete from l_user_operate WHERE 1=1;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
