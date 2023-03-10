package com.aires.businessrules.constants;

public class DbQueries {
	public static final String CALL_PROCEDURE_DELETE_POLICY_BY_ID = "{call policydba.pdt_policy_benefit_package.cleanup_policy_benefits_by_policy_id(?)}";
	public static final String QUERY_GET_IDENTITY_TYPE_DROPDOWNLIST = "SELECT IDENTIFICATION_TYPE_DESC FROM ISISDBA.IDENTIFICATION_TYPE_CODE ORDER BY IDENTIFICATION_TYPE_DESC";
	public static final String QUERY_GET_MARITAL_STATUS_DROPDOWNLIST = "SELECT MARITAL_STATUS_DESCRIPTION FROM ISISDBA.MARITAL_STATUS_CODE";
	public static final String QUERY_GET_PRONOUNS_DROPDOWNLIST = "SELECT PRONOUN_DESCRIPTION FROM ISISDBA.pronoun_code where ACTIVE_IND='Y'";
	public static final String QUERY_GET_PHONE_TYPE_DROPDOWNLIST = "SELECT CONTACT_PF_TYPE_DESC FROM ISISDBA.CONTACT_PF_TYPE_CODE ORDER BY CONTACT_PF_TYPE_CODE";
	public static final String QUERY_GET_TRANSFEREE_EMAIL_TYPE_DROPDOWNLIST = "SELECT EMAIL_TYPE_DESC FROM ISISDBA.EMAIL_TYPE_CODE where CURRENT_IND='Y' and EMAIL_TYPE_DESC NOT LIKE 'Spouse%' order by EMAIL_TYPE_DESC";
	public static final String QUERY_GET_LOCATION_TYPE_DROPDOWNLIST = "SELECT LOCATION_TYPE_DESC FROM ISISDBA.LOCATION_TYPE_CODE where PHONE_IND='Y' order by LOCATION_TYPE_DESC";
	public static final String QUERY_GET_COUNTRY_DROPDOWNLIST = "SELECT COUNTRY_NAME FROM isisdba.country_codes order by COUNTRY_NAME";
	public static final String QUERY_GET_GENDER_DROPDOWNLIST = "SELECT GENDER_MARKER_DESCRIPTION FROM isisdba.gender_marker_code";
	public static final String QUERY_GET_RELATIONSHIP_DROPDOWNLIST = "SELECT GENDER_MARKER_DESCRIPTION FROM isisdba.family_relation_code";
	public static final String QUERY_GET_MYFILES_INFO_BY_STATUS_AND_USER = "Select * from (Select Distinct(A.ASSIGNMENT_ID)as FileID,C.COMPANY_NAME as ClientName,\r\n" + 
			"(T.last_name || ', ' || T.first_name) as TransfereeName,\r\n" + 
			"A.ORIGIN_COUNTRY_NAME as Origin,A.DEST_COUNTRY_NAME as Destination,\r\n" + 
			"A.ASSIGNMENT_STATUS_CODE as Status, AT.ASSIGNMENT_TYPE_DESC as JourneyType,\r\n" + 
			"A.BOOK_DATE as Booked \r\n" + 
			"from  ISISDBA.ASSIGNMENT A \r\n" + 
			"inner join ISISDBA.ASSIGNMENT_EMPLYEE E on A.ASSIGNMENT_ID=E.ASSIGNMENT_ID and E.END_DATE is Null\r\n" + 
			"inner join ISISDBA.CMPNY C on A.COMPANY_ID=C.COMPANY_ID\r\n" + 
			"left join ISISDBA.TRANSFEREE T on A.TRANSFEREE_ID=T.TRANSFEREE_ID\r\n" + 
			"inner join ISISDBA.ASSIGNMENT_status_code S on A.ASSIGNMENT_STATUS_CODE=S.ASSIGNMENT_STATUS_CODE\r\n" + 
			"left join ISISDBA.ASSIGNMENT_type_code AT on A.ASSIGNMENT_TYPE_CODE=AT.ASSIGNMENT_TYPE_CODE\r\n" + 
			"where E.EMP_NO=? and S.ASSIGNMENT_STATUS_DESC = ? order by transfereeName asc,FileID asc) where ROWNUM<=?\r\n" + 
			"";
	public static final String QUERY_GET_MYFILES_INFO_BY_STATUS_AND_VIP = "Select * from (Select Distinct(A.ASSIGNMENT_ID)as FileID,C.COMPANY_NAME as ClientName,\r\n" + 
			"(T.last_name || ', ' || T.first_name) as TransfereeName,\r\n" + 
			"A.ORIGIN_COUNTRY_NAME as Origin,A.DEST_COUNTRY_NAME as Destination,\r\n" + 
			"A.ASSIGNMENT_STATUS_CODE as Status, AT.ASSIGNMENT_TYPE_DESC as JourneyType,\r\n" + 
			"A.BOOK_DATE as Booked \r\n" + 
			"from  ISISDBA.ASSIGNMENT A \r\n" + 
			"inner join ISISDBA.ASSIGNMENT_EMPLYEE E on A.ASSIGNMENT_ID=E.ASSIGNMENT_ID and E.END_DATE is Null\r\n" + 
			"inner join ISISDBA.CMPNY C on A.COMPANY_ID=C.COMPANY_ID\r\n" + 
			"left join ISISDBA.TRANSFEREE T on A.TRANSFEREE_ID=T.TRANSFEREE_ID\r\n" + 
			"inner join ISISDBA.ASSIGNMENT_status_code S on A.ASSIGNMENT_STATUS_CODE=S.ASSIGNMENT_STATUS_CODE\r\n" + 
			"left join ISISDBA.ASSIGNMENT_type_code AT on A.ASSIGNMENT_TYPE_CODE=AT.ASSIGNMENT_TYPE_CODE\r\n" + 
			"where E.EMP_NO=? and S.ASSIGNMENT_STATUS_DESC = ? and A.VIP_IND='Y' order by transfereeName asc,FileID asc) where ROWNUM<=?\r\n" + 
			"";
	public static final String QUERY_GET_MYFILES_INFO_BY_STATUS_AND_EVIP = "Select * from (Select Distinct(A.ASSIGNMENT_ID)as FileID,C.COMPANY_NAME as ClientName,\r\n" + 
			"(T.last_name || ', ' || T.first_name) as TransfereeName,\r\n" + 
			"A.ORIGIN_COUNTRY_NAME as Origin,A.DEST_COUNTRY_NAME as Destination,\r\n" + 
			"A.ASSIGNMENT_STATUS_CODE as Status, AT.ASSIGNMENT_TYPE_DESC as JourneyType,\r\n" + 
			"A.BOOK_DATE as Booked \r\n" + 
			"from  ISISDBA.ASSIGNMENT A \r\n" + 
			"inner join ISISDBA.ASSIGNMENT_EMPLYEE E on A.ASSIGNMENT_ID=E.ASSIGNMENT_ID and E.END_DATE is Null\r\n" + 
			"inner join ISISDBA.CMPNY C on A.COMPANY_ID=C.COMPANY_ID\r\n" + 
			"inner join ISISDBA.TRANSFEREE T on A.TRANSFEREE_ID=T.TRANSFEREE_ID\r\n" + 
			"inner join ISISDBA.ASSIGNMENT_status_code S on A.ASSIGNMENT_STATUS_CODE=S.ASSIGNMENT_STATUS_CODE\r\n" + 
			"left join ISISDBA.ASSIGNMENT_type_code AT on A.ASSIGNMENT_TYPE_CODE=AT.ASSIGNMENT_TYPE_CODE\r\n" + 
			"where E.EMP_NO=? and S.ASSIGNMENT_STATUS_DESC = ? and A.EVIP_IND='Y'order by transfereeName asc,FileID asc) where ROWNUM<=?\r\n" + 
			"";
	public static final String QUERY_GET_MYFILES_INFO_BY_STATUS_AND_CONFIDENTIAL = "Select * from (Select Distinct(A.ASSIGNMENT_ID)as FileID,C.COMPANY_NAME as ClientName,\r\n" + 
			"(T.last_name || ', ' || T.first_name) as TransfereeName,\r\n" + 
			"A.ORIGIN_COUNTRY_NAME as Origin,A.DEST_COUNTRY_NAME as Destination,\r\n" + 
			"A.ASSIGNMENT_STATUS_CODE as Status, AT.ASSIGNMENT_TYPE_DESC as JourneyType,\r\n" + 
			"A.BOOK_DATE as Booked \r\n" + 
			"from  ISISDBA.ASSIGNMENT A \r\n" + 
			"inner join ISISDBA.ASSIGNMENT_EMPLYEE E on A.ASSIGNMENT_ID=E.ASSIGNMENT_ID and E.END_DATE is Null\r\n" + 
			"inner join ISISDBA.CMPNY C on A.COMPANY_ID=C.COMPANY_ID\r\n" + 
			"inner join ISISDBA.TRANSFEREE T on A.TRANSFEREE_ID=T.TRANSFEREE_ID\r\n" + 
			"inner join ISISDBA.ASSIGNMENT_status_code S on A.ASSIGNMENT_STATUS_CODE=S.ASSIGNMENT_STATUS_CODE\r\n" + 
			"left join ISISDBA.ASSIGNMENT_type_code AT on A.ASSIGNMENT_TYPE_CODE=AT.ASSIGNMENT_TYPE_CODE\r\n" + 
			"where E.EMP_NO=? and S.ASSIGNMENT_STATUS_DESC = ? and A.CONFIDENTIAL_IND='Y' order by transfereeName asc,FileID asc) where ROWNUM<=?\r\n" + 
			"";
	
	public static final String QUERY_GET_MYFILES_INFO_BY_STATUS_AND_SORT_ORDER = "Select Distinct(A.ASSIGNMENT_ID)as FileID,Lower(C.COMPANY_NAME) as ClientName,\r\n" + 
			"      LOWER(T.last_name || ', ' || T.first_name) as TransfereeName,\r\n" + 
			"   CASE\r\n" + 
			"    WHEN T.last_name is Not NULL THEN LOWER(T.last_name || ', ' || T.first_name)\r\n" + 
			"    ELSE T.last_name\r\n" + 
			"END as tName,\r\n" + 
			"      LOWER(A.ORIGIN_COUNTRY_NAME) as Origin,LOWER(A.DEST_COUNTRY_NAME) as Destination,\r\n" + 
			"      A.ASSIGNMENT_STATUS_CODE as Status, AT.ASSIGNMENT_TYPE_DESC as JourneyType, \r\n" + 
			"      A.BOOK_DATE as Booked\r\n" + 
			"      from  ISISDBA.ASSIGNMENT A\r\n" + 
			"      inner join ISISDBA.ASSIGNMENT_EMPLYEE E on A.ASSIGNMENT_ID=E.ASSIGNMENT_ID and E.END_DATE is null\r\n" + 
			"      inner join ISISDBA.CMPNY C on A.COMPANY_ID=C.COMPANY_ID\r\n" + 
			"      left join ISISDBA.TRANSFEREE T on A.TRANSFEREE_ID=T.TRANSFEREE_ID\r\n" + 
			"      inner join ISISDBA.ASSIGNMENT_status_code S on A.ASSIGNMENT_STATUS_CODE=S.ASSIGNMENT_STATUS_CODE \r\n" + 
			"      left join ISISDBA.ASSIGNMENT_type_code AT on A.ASSIGNMENT_TYPE_CODE=AT.ASSIGNMENT_TYPE_CODE\r\n" + 
			"      where E.EMP_NO=? and S.ASSIGNMENT_STATUS_DESC = ?";
	
	public static final String QUERY_GET_ACCOUNTING_FILES_INFO_BY_SERVICE_AND_SERVICE_STATUS="Select A.ASSIGNMENT_ID as FileID,C.COMPANY_NAME as ClientName,(T.last_name || ', ' || T.first_name) as TransfereeName\r\n" + 
			" from ISISDBA.Assignment A\r\n" + 
			"inner join ISISDBA.CMPNY C on A.COMPANY_ID=C.COMPANY_ID\r\n"+
			"inner join ISISDBA.TRANSFEREE T on A.TRANSFEREE_ID=T.Transferee_Id\r\n" + 
			"inner join ISISDBA.ASSIGNMENT_SERVICE S on A.Assignment_Id=S.ASSIGNMENT_ID\r\n" + 
			"inner join ISISDBA.ASSIGNMENT_Service_code SC on S.ASSIGNMENT_SERVICE_CODE=SC.ASSIGNMENT_SERVICE_CODE \r\n" + 
			"inner join ISISDBA.ASSIGNMENT_status_code ST on S.service_status_code=ST.ASSIGNMENT_STATUS_CODE\r\n" + 
			"where SC.ASSIGNMENT_SERVICE_DESC=? and ST.ASSIGNMENT_STATUS_DESC= ?\r\n" + 
			" order by TransfereeName asc,FileID asc";
	
	public static final String QUERY_GET_ACCOUNTING_FILES_INFO_BY_SERVICE_AND_STATUS_AND_SORT_ORDER="Select A.ASSIGNMENT_ID as FileID,Lower(C.COMPANY_NAME) as ClientName,(T.last_name || ', ' || T.first_name) as TransfereeName\r\n" + 
			",LOWER(A.ORIGIN_COUNTRY_NAME) as Origin,LOWER(A.DEST_COUNTRY_NAME) as Destination,A.ASSIGNMENT_STATUS_CODE as Status, AT.ASSIGNMENT_TYPE_DESC as JourneyType,A.BOOK_DATE as Booked from ISISDBA.Assignment A\r\n" + 
			"inner join ISISDBA.CMPNY C on A.COMPANY_ID=C.COMPANY_ID\r\n"+
			"inner join ISISDBA.TRANSFEREE T on A.TRANSFEREE_ID=T.Transferee_Id\r\n" + 
			"inner join ISISDBA.ASSIGNMENT_SERVICE S on A.Assignment_Id=S.ASSIGNMENT_ID\r\n" + 
			"inner join ISISDBA.ASSIGNMENT_Service_code SC on S.ASSIGNMENT_SERVICE_CODE=SC.ASSIGNMENT_SERVICE_CODE \r\n" + 
			"inner join ISISDBA.ASSIGNMENT_status_code ST on S.service_status_code=ST.ASSIGNMENT_STATUS_CODE\r\n" + 
			"left join ISISDBA.ASSIGNMENT_type_code AT on A.ASSIGNMENT_TYPE_CODE=AT.ASSIGNMENT_TYPE_CODE\r\n" + 
			"where SC.ASSIGNMENT_SERVICE_DESC=? and ST.ASSIGNMENT_STATUS_DESC= ?";
	
	public static final String QUERY_GET_ASSIGNMENT_FIELD_VALUES="SELECT TRANSFEREE_ID as TransfereeID FROM ISISDBA.ASSIGNMENT A where A.ASSIGNMENT_ID=?";
	public static final String QUERY_UPDATE_ASSIGNMENT_STATUS = "update isisdba.assignment set assignment_status_code = ?, policy_benefits_config_id = ? where corporation_policy_id = ? and TO_CHAR(book_date, 'DD-MM-YYYY') = ?";
	public static final String QUERY_GET_PRE_ACCEPTANCE_EXPENSE_CODE = "select EXPENSECODE as EXPENSE_CODE, DESCRIPTION from grossup.expensecodes ec, rmsdba.rms_report_code rrc where rrc.expense_code = ec.expensecode and rrc.BLUEPRINT_CATEGORY_CODE = 'PREACCEPTENCE' and ec.clientid = '999999' order by ec.expensecode";
	public static final String QUERY_GET_IMMIGRATION_EXPENSE_CODE = "select EXPENSECODE as EXPENSE_CODE, DESCRIPTION from grossup.expensecodes ec, rmsdba.rms_report_code rrc where rrc.expense_code = ec.expensecode and rrc.BLUEPRINT_CATEGORY_CODE = 'IMMIGRATION' and ec.clientid = '999999' order by ec.expensecode";
	public static final String QUERY_GET_LANG_TRAIN_EXPENSE_CODE = "select EXPENSECODE as EXPENSE_CODE, DESCRIPTION from grossup.expensecodes ec, rmsdba.rms_report_code rrc where rrc.expense_code = ec.expensecode and rrc.BLUEPRINT_CATEGORY_CODE = 'LANGUAGETRAINING' and ec.clientid = '999999' order by ec.expensecode";
	public static final String QUERY_GET_CULT_TRAIN_EXPENSE_CODE = "select EXPENSECODE as EXPENSE_CODE, DESCRIPTION from grossup.expensecodes ec, rmsdba.rms_report_code rrc where rrc.expense_code = ec.expensecode and rrc.BLUEPRINT_CATEGORY_CODE = 'CULTURALTRAINING' and ec.clientid = '999999' order by ec.expensecode";
	public static final String QUERY_GET_HOUSE_HUNTING_TRIP_EXPENSE_CODE = "select EXPENSECODE as EXPENSE_CODE, DESCRIPTION from grossup.expensecodes ec, rmsdba.rms_report_code rrc where rrc.expense_code = ec.expensecode and rrc.BLUEPRINT_CATEGORY_CODE = 'HOUSEHUNTINGTRIP' and ec.clientid = '999999' order by ec.expensecode";
	public static final String QUERY_GET_SHIPMENT_SUBSERVICEID = "select ASSIGN_SUB_SERVICE_ID from isisdba.assignment_sub_service  \r\n" + 
			"where\r\n" + 
			" assignment_service_code = 'SHIPMENT' \r\n" + 
			" order by assignment_service_code desc";
	public static final String QUERY_GET_NONSHIPMENT_SUBSERVICEID = " select ASSIGN_SUB_SERVICE_ID from isisdba.assignment_sub_service  \r\n" + 
			"where\r\n" + 
			" assignment_service_code <> 'SHIPMENT' \r\n" + 
			" order by assignment_service_code desc";
	
	public static final String QUERY_GET_CLIENT_CONTACT_ASSIGNMENT_ID_BY_FILE_STATUS="Select A.ASSIGNMENT_ID as FileID\r\n" + 
			"from ISISDBA.Assignment A\r\n" + 
			"inner join ISISDBA.ASSIGNMENT_status_code S on A.ASSIGNMENT_STATUS_CODE=S.ASSIGNMENT_STATUS_CODE\r\n"+
			"inner join ISISDBA.ASSIGNMENT_CONTACT C on A.ASSIGNMENT_ID=C.ASSIGNMENT_ID\r\n" +
			"where S.ASSIGNMENT_STATUS_DESC=?";
}
