package com.invo.matchela.core.constants;

public class StringConstants {
    public static final String NEPALI_PATTERN = "[\\u0900-\\u097F ].+";
    public static final String ALPHABET = "^[\\w\\s]+$";
    public static final String NUMERIC = "^\\d+$";
    public static final String NUMERIC_NULL = "^(\\d+)?$";
    public static final String PHONENUMBER = "^\\d || - || + +$ + ";
    public static final String ALPHA_NUMERIC = "^[\\w\\s\\d]+$";
    public static final String NEPALI_PATTERN_NOT_REQUIRED = "[\\u0900-\\u097F ]+||^$";
    public static final String NEPALI_PATTERN_NULL = "([\\u0900-\\u097F ]+)?";
    public static final String YEAR_PATTERN = "yyyy";
    public static final String DATE_PATTERN = "yyyy-MM-dd";
    public static final String ENGLISH_PATTERN = "^[a-zA-Z ]*$";
    public static final int DEFAULT_MAX_SIZE = 50;
    public static final int DEFAULT_MAX_SIZE2 = 100;
    public static final int DEFAULT_SHORT_SIZE = 25;
    public static final int DEFAULT_DECS_SIZE = 250;
    public static final int DEFAULT_CODE_SIZE = 15;
    public static final int MINISTRY_CODE_SIZE = 3;
    public static final int DEFAULT_MIN_SIZE = 6;
    public static final int DEFAULT_MIN_PASSWORD_SIZE = 6;
    public static final int DEFAULT_NAME_SIZE = 20;
    public static final int DEFAULT_MIN_SIZE_USER = 5;
    public static final int DEFAULT_MIN_SIZE_4 = 4;
    public static final int PHONE_MAX_SIZE = 14;
    public static final int PHONE_MIN_SIZE = 10;
    public static final int WARD_MAX_SIZE = 2;
    public static final int DEFAULT_MAX_SIZE_20 = 20;
    public static final int DEFAULT_MAX_SIZE_50 = 50;
    public static final int DEFAULT_MAX_SIZE_6 = 6;
    public static final int DEFAULT_MAX_SIZE_8 = 8;
    public static final int DEFAULT_MAX_LIMIT = 254;
    public static final int GRADE_MAX_SIZE = 1;

    //DESIGNATION SHORT CODE CONSTANTS
    public static final String ASSISTANT_AUDITOR_GENERAL = "AAG";
    public static final String DEPUTY_AUDITOR_GENERAL = "DAG";
    public static final String AUDITOR_GENERAL = "AG";
    public static final String DIRECTOR = "DTR";


    //OAG UNIT LEVEL
    public static final String OFFICE_OF_AUDITOR_GENERAL = "OAG";
    public static final String DIRECTORATE = "DI";
    public static final String DIVISION = "DIV";
    public static final String DEPARTMENT = "DEP";


    //Audit Area Type Constants
    public static final String OFFICE_SPECIFIC = "officespecific";
    public static final String GENERIC_FOR_OFFICES_INSIDE_SPECIFIC_ENTITY = "genericforofficesinsidespecificentity";


    //CHECKLIST TYPE NAME
    public static final String BASIC_AUDIT_PLAN = "Basic Audit Plan";
    public static final String GENERIC_FOR_ALL = "Generic For All";
    public static final String GENERIC_FOR_OFFICE_INSIDE_SPECIFIC_ENTITY_ = "Generic For Office Inside Specific entity";
    public static final String OFFICE_SPECIFIC_ = "Office Specific";
    public static final String NPSAS = "NPSAS";
    public static final String FINANCIAL_INFORMATION = "Financial Information";
    public static final String REVIEW_OF_FINANCIAL_ACCOUNTABILITY = "Review Of Financial Accountability";
    public static final String SECTORAL_AUDIT_GUIDE = "Sectoral Audit Guide";

    public static final String TEAMLEADER = "TL";
    public static final String TEAMMEMBER = "TM";
    public static final String SUPERVIOSR_SUP = "SUPV";
    public static final String OFFICE_CHIEF = "AC";
    public static final String OFFICE_ACCOUNT_CHIEF = "AAC";
    public static final String TEAMSUPERVISOR = "SUPV";


    public static final String CHANGE_PASSWORD = "CHANGEPASSWORD";
    public static final String ENTITY = "entity";
    public static final String OFFICE = "office";

    public static final String TEST_OF_CONTROL = "Test of control";
    public static final String SUBSTANTIVE_PROCEDURE = "Substantive Procedure";

    public static final String PDF = "pdf";
    public static final String PNG = "png";
    public static final String JPG = "jpg";
    public static final String JPEG = "jpeg";

    public static final String TEAMLEADER_ = "teamleader";
    public static final String TEAMMEMBER_ = "teammember";
    public static final String SUPERVISOR_ = "supervisor";
    public static final String ALL_ = "all";

    //public static final String ASSESSMENT_OF_CONTROL="Assessment Of Control";
    //TODO master setup these groups and avoid editing of system setup data
    public static final String ASSESSMENT_OF_CONTROL_OFFICE = "Assessment Of Control[Office]";
    public static final String ASSESSMENT_OF_CONTROL_ENTITY = "Assessment Of Control[Entity]";

    public static final String SYSTEM = "system";
    public static final String EXTRA = "extra";

    public static final String PAR = "Preliminary Audit Report [PAR]";

    public static final String DOWNLOAD = "download";
    public static final String VIEW = "view";


    public static final String FA = "FA";
    public static final String PA = "PA";
    public static final String CA = "CA";


    /**
     * This constant is for OFFICE MASTER DUMP
     */

    public static final String PROVINCE_1 = "PROVINCE1";
    public static final String PROVINCE_2 = "PROVINCE2";
    public static final String PROVINCE_3 = "PROVINCE3";
    public static final String PROVINCE_4 = "PROVINCE4";
    public static final String PROVINCE_5 = "PROVINCE5";
    public static final String PROVINCE_6 = "PROVINCE6";
    public static final String PROVINCE_7 = "PROVINCE7";

    //AUDIT TASK EXECUTION
    public static final String TEST_OF_CONTROL_TE = "Test of Controls";
    public static final String SAMPLING = "Sampling";
    public static final String SUBSTANTIVE_PROCEDURE_TE = "Substantive Procedures";
    public static final String AUDITEE_RESPONSE = "Auditee Response";
    public static final String PAR_REPORT = "Par Report";

    // Audit Lifecycle
    public static final String LIFECYCLE_TP_FA = "TPFA";
    public static final String LIFECYCLE_TP_CA = "TPCA";
    public static final String LIFECYCLE_TP_PA = "TPPA";
    public static final String LIFECYCLE_AP2_FA = "OEFA";
    //common roles
    public static final String SUPER_ADMIN = "SUPER_ADMINISTRATOR";
    public static final String POLICY_DIRECTOR = "POLICYDIRECTOR";
    public static final String POLICY_IT_ADMIN = "POLICYITADMIN";


    //entity category
    public static final String ENTITY_CATEGORY_SHORT_NAME_MINISTRY = "MIS";
    public static final String ENTITY_CATEGORY_SHORT_NAME_CONSTITUTIONAL_BODY = "CB";
    public static final String ENTITY_CATEGORY_SHORT_NAME_LOCAL = "LO";
    public static final String ENTITY_CATEGORY_SHORT_NAME_AUTOMONOUS = "AB";
    public static final String ENTITY_CATEGORY_SHORT_NAME_SOE = "SOE";

    //ADMIN CONSTANTS
    public static final String ADMIN_USER_NAME = "Admin";


    //REPORTING
    public static final String ENTRY = "ENTRY";
    public static final String EXIT = "EXIT";


    /**
     * ROLE GROUP CONSTANTS
     */

    public static final String AUDITOR_GENERAL_RL = "AUDITOR_GENERAL";
    public static final String DEPUTY_AUDITOR_GENERAL_RL = "DEPUTY_AUDITOR_GENERAL";
    public static final String ASSISTANT_AUDITOR_GENERAL_RL = "ASSISTANT_AUDITOR_GENERAL";
    public static final String DIRECTOR_RL = "DIRECTOR";
    public static final String DIRECTOR_O_RL = "DIRECTOR_O";
    public static final String AUDITOR_RL = "AUDITOR";
    public static final String DEFAULT_RL = "DEFAULT";
    public static final String POLICY_DIRECTOR_RL = "POLICY_DIRECTOR";

    public static final String ENTITY_OWNER_TEAM_LEADER = "ENTITY_OWNER_TEAM_LEADER";
    public static final String ENTITY_OWNER_TEAM_MEMBER = "ENTITY_OWNER_TEAM_MEMBER";


    public static final String OFFICE_OWNER_TEAM_LEADER = "OFFICE_OWNER_TEAM_LEADER";
    public static final String OFFICE_OWNER_TEAM_MEMBER = "OFFICE_OWNER_TEAM_MEMBER";

    /**
     * These data is related to field team
     */
    public static final String ENTITY_FIELD_TEAM_LEADER = "ENTITY_FIELD_TEAM_LEADER";
    public static final String ENTITY_FIELD_TEAM_MEMBER = "ENTITY_FIELD_TEAM_MEMBER";
    public static final String ENTITY_FIELD_TEAM_SUPERVISOR = "ENTITY_FIELD_TEAM_SUPERVISOR";

    public static final String OFFICE_FIELD_TEAM_LEADER_FA = "OFFICE_FIELD_TEAM_LEADER_FA";
    public static final String OFFICE_FIELD_TEAM_MEMBER_FA = "OFFICE_FIELD_TEAM_MEMBER_FA";
    public static final String OFFICE_FIELD_TEAM_SUPERVISOR_FA = "OFFICE_FIELD_TEAM_SUPERVISOR_FA";

    public static final String OFFICE_FIELD_TEAM_LEADER_CA = "OFFICE_FIELD_TEAM_LEADER_CA";
    public static final String OFFICE_FIELD_TEAM_MEMBER_CA = "OFFICE_FIELD_TEAM_MEMBER_CA";
    public static final String OFFICE_FIELD_TEAM_SUPERVISOR_CA = "OFFICE_FIELD_TEAM_MEMBER_CA";

    public static final String OFFICE_FIELD_TEAM_LEADER_PA = "OFFICE_FIELD_TEAM_LEADER_PA";
    public static final String OFFICE_FIELD_TEAM_MEMBER_PA = "OFFICE_FIELD_TEAM_MEMBER_PA";
    public static final String OFFICE_FIELD_TEAM_SUPERVISOR_PA = "OFFICE_FIELD_TEAM_SUPERVISOR_PA";

    //Team Unit Type
    public static final String FIELD = "FIELD";
    public static final String OWNER = "OWNER";


    //AUDIT EXECUTION CONSTANTS
    public static final String AUDIT_EXECUTION = "AUDIT EXECUTION";

}
