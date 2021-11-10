package com.aires.businessrules.constants;

public class DbQueries {
	public static final String QUERY_AIR_FARE_RATE = "select rate from isisdba.ce_international_airfare where from_country_region=? and to_country_region=? AND AIRFARE_CLASS=?";
	public static final String QUERY_CAR_RENTAL_RATE = "select rate, weekly_rate, monthly_rate from isisdba.ce_international_rental_car where country_region = ? and rental_class = ?";
	public static final String CALL_PROCEDURE_GET_COUNTRY_REGION = "{? = call COST_ESTIMATES_INTERNATIONAL.get_country_region(?,?)}";
	public static final String QUERY_GET_PORT_CODE_FROM_HISTORIC_TABLE = "select distinct(?) as port_code from isisdba.ce_intl_port_code_data where country_code = ? and state_code = ? and city = ? order by start_date desc;";
	public static final String QUERY_FETCH_COUNTRY_PORTS = "SELECT c.PORT_CODE portCode, c.CITY, c.STATE stateCode, o.COUNTRY_CODE countryCode, o.PROXY_PORT proxyPort FROM ISISDBA.CE_INTL_PORT_CODE c, ISISDBA.CE_INTL_PORT_CODE_PROXY o WHERE c.PORT_CODE = o.PORT_CODE AND c.END_DATE IS NULL AND o.END_DATE IS NULL AND UPPER(o.COUNTRY_CODE) = UPPER(?) AND UPPER(o.PORT_TYPE) = UPPER(?)";
	public static final String QUERY_FETCH_COUNTRY_PORTS_PROXY_Y = "SELECT o.PORT_CODE portCode, null stateCode, o.COUNTRY_CODE countryCode, o.PROXY_PORT proxyPort FROM ISISDBA.CE_INTL_PORT_CODE_PROXY o WHERE o.END_DATE IS NULL AND o.PROXY_PORT = 'Y' AND UPPER(o.COUNTRY_CODE) = UPPER(?) AND UPPER(o.PORT_TYPE) = UPPER(?)";
	/*public static final String CALL_PROCEDURE_GET_AIR_SHIPMENT_COST = "{? = call COST_ESTIMATES_INTL_PORT_RATES.get_intl_shipment_air_port(?,?,?,?,?,?,?,?,?,?)}";*/
	public static final String CALL_PROCEDURE_GET_AIR_SHIPMENT_COST = "{call COST_ESTIMATES_INTL_PORT_RATES.get_intl_shipment_air_port(?,?,?,?,?,?,?,?,?,?)}";
	public static final String CALL_PROCEDURE_GET_SEA_SHIPMENT_COST = "{call COST_ESTIMATES_INTL_PORT_RATES.get_intl_shipment_sea_port(?,?,?,?,?,?,?,?,?,?,?,?)}";
	public static final String CALL_PROCEDURE_GET_SURFACE_SHIPMENT_COST = "{call COST_ESTIMATES_INTERNATIONAL.get_international_ship_surf(?,?,?,?,?,?,?)}";
	public static final String CALL_PROCEDURE_GET_TEMP_STORAGE_COST = "{call COST_ESTIMATES_INTL_PORT_RATES.get_intl_temp_storage_port(?,?,?,?,?,?,?,?,?,?)}";
	public static final String CALL_PROCEDURE_GET_INTNL_PERM_STORAGE_COST = "{call COST_ESTIMATES_INTL_PORT_RATES.get_intl_perm_expat_port(?,?,?,?,?,?,?,?)}";
	public static final String QUERY_DELETE_DELEGATE_FROM_USERINFO = "delete from cpadba.user_info where username=?";
	public static final String QUERY_DELETE_DELEGATE_FROM_DELEGATECONFIG = "delete from cpadba.delegate_config dc WHERE dc.delegate_username =?";
}
