SELECT * FROM ALL_TABLES  WHERE OWNER='ISIS2304B161820' ;
SELECT * FROM ALL_CONSTRAINTS WHERE OWNER='ISIS2304B161820';
SELECT atb.table_name,atb.column_name,atb.data_type,atb.data_length, ac.search_condition,ac.search_condition_vc FROM ALL_TAB_COLUMNS atb INNER JOIN ALL_CONSTRAINTS ac ON atb.table_name= ac.table_name WHERE atb.OWNER='ISIS2304B161820' ;

SELECT table_name,column_name,data_type,data_length FROM ALL_TAB_COLUMNS  WHERE OWNER='ISIS2304B161820' ;