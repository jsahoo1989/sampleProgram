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
	public static final String QUERY_UPDATE_ASSIGNMENT_STATUS = "update isisdba.assignment set assignment_status_code = ?, policy_benefits_config_id = ? where corporation_policy_id = ? and TO_CHAR(book_date, 'DD-MM-YYYY') = ?";
	public static final String QUERY_GET_PRE_ACCEPTANCE_EXPENSE_CODE = "select EXPENSECODE as EXPENSE_CODE, DESCRIPTION from grossup.expensecodes ec, rmsdba.rms_report_code rrc where rrc.expense_code = ec.expensecode and rrc.BLUEPRINT_CATEGORY_CODE = 'PREACCEPTENCE' and ec.clientid = '999999' order by ec.expensecode";
	public static final String QUERY_GET_IMMIGRATION_EXPENSE_CODE = "select EXPENSECODE as EXPENSE_CODE, DESCRIPTION from grossup.expensecodes ec, rmsdba.rms_report_code rrc where rrc.expense_code = ec.expensecode and rrc.BLUEPRINT_CATEGORY_CODE = 'IMMIGRATION' and ec.clientid = '999999' order by ec.expensecode";
	public static final String QUERY_GET_LANG_TRAIN_EXPENSE_CODE = "select EXPENSECODE as EXPENSE_CODE, DESCRIPTION from grossup.expensecodes ec, rmsdba.rms_report_code rrc where rrc.expense_code = ec.expensecode and rrc.BLUEPRINT_CATEGORY_CODE = 'LANGUAGETRAINING' and ec.clientid = '999999' order by ec.expensecode";
	public static final String QUERY_GET_CULT_TRAIN_EXPENSE_CODE = "select EXPENSECODE as EXPENSE_CODE, DESCRIPTION from grossup.expensecodes ec, rmsdba.rms_report_code rrc where rrc.expense_code = ec.expensecode and rrc.BLUEPRINT_CATEGORY_CODE = 'CULTURALTRAINING' and ec.clientid = '999999' order by ec.expensecode";
	public static final String QUERY_GET_HOUSE_HUNTING_TRIP_EXPENSE_CODE = "select EXPENSECODE as EXPENSE_CODE, DESCRIPTION from grossup.expensecodes ec, rmsdba.rms_report_code rrc where rrc.expense_code = ec.expensecode and rrc.BLUEPRINT_CATEGORY_CODE = 'HOUSEHUNTINGTRIP' and ec.clientid = '999999' order by ec.expensecode";
	public static final String QUERY_GET_CURRENCYCOUNTRY = "SELECT DISTINCT COUNTRY FROM ISISDBA.CURRENCY_LOCALES WHERE ISO_CODE = ?";
}
