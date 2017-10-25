package org.sunbird.common.models.util;

/**
 * This enum will contains different operation
 *  for a learner {addCourse, getCourse, update , getContent}
 * @author Manzarul
 *
 */

public enum ActorOperations {
   
    ENROLL_COURSE("CourseEnrollmentActor","enrollCourse"), GET_COURSE("LearnerStateActor","getCourse"), ADD_CONTENT("LearnerStateUpdateActor","addContent"),
    GET_CONTENT("LearnerStateActor","getContent"), CREATE_COURSE("CourseManagementActor","createCourse"), UPDATE_COURSE("CourseManagementActor","updateCourse"),
    PUBLISH_COURSE("CourseManagementActor","publishCourse"), SEARCH_COURSE("CourseManagementActor","searchCourse"), DELETE_COURSE("CourseManagementActor","deleteCourse"),
    CREATE_USER("UserManagementActor","createUser"), UPDATE_USER("UserManagementActor","updateUser"), LOGIN("UserManagementActor","login"), LOGOUT("UserManagementActor","logout"),
    CHANGE_PASSWORD("UserManagementActor","changePassword"), USER_AUTH("","userAuth"), GET_PROFILE("UserManagementActor","getUserProfile"),
    CREATE_ORG("OrganisationManagementActor","createOrg"), UPDATE_ORG("OrganisationManagementActor","updateOrg"), UPDATE_ORG_STATUS("OrganisationManagementActor","updateOrgStatus"),
    GET_ORG_DETAILS("OrganisationManagementActor","getOrgDetails"), APPROVE_ORG("OrganisationManagementActor","approveOrg"), 
    CREATE_PAGE("PageManagementActor","createPage"),UPDATE_PAGE("PageManagementActor","updatePage"), DELETE_PAGE("","deletePage"), 
    GET_PAGE_SETTINGS("PageManagementActor","getPageSettings"), GET_PAGE_SETTING("PageManagementActor","getPageSetting"), 
    GET_PAGE_DATA("PageManagementActor","getPageData"),
    CREATE_SECTION("PageManagementActor","createSection"), UPDATE_SECTION("PageManagementActor","updateSection"),
    GET_ALL_SECTION("PageManagementActor","getAllSection"), GET_SECTION("PageManagementActor","getSection"),
    GET_COURSE_BY_ID("CourseManagementActor","getCourseById"), UPDATE_USER_COUNT("BackgroundJobManager","updateUserCount"),
    SAVE_ASSESSMENT("AssessmentItemActor","saveAssessment"), GET_ASSESSMENT("AssessmentItemActor","getAssessment"),
    GET_RECOMMENDED_COURSES("CourseManagementActor","getRecommendedCourses"),
    UPDATE_USER_INFO_ELASTIC("BackgroundJobManager","updateUserInfoToElastic"),GET_ROLES("UserManagementActor","getRoles"),
    APPROVE_ORGANISATION("OrganisationManagementActor","approveOrganisation"), JOIN_USER_ORGANISATION("OrganisationManagementActor","joinUserOrganisation"),
    ADD_MEMBER_ORGANISATION("OrganisationManagementActor","addMemberOrganisation"), REMOVE_MEMBER_ORGANISATION("OrganisationManagementActor","removeMemberOrganisation"),
    APPROVE_USER_ORGANISATION("OrganisationManagementActor","approveUserOrganisation"),COMPOSITE_SEARCH("SearchHandlerActor","compositeSearch"),
    GET_USER_DETAILS_BY_LOGINID("UserManagementActor","getUserDetailsByLoginId"),UPDATE_ORG_INFO_ELASTIC("BackgroundJobManager","updateOrgInfoToElastic"),
    REJECT_USER_ORGANISATION("OrganisationManagementActor","rejectUserOrganisation"),INSERT_ORG_INFO_ELASTIC("BackgroundJobManager","insertOrgInfoToElastic"),
    DOWNLOAD_USERS("UserManagementActor","downloadUsersData"),DOWNLOAD_ORGS("OrganisationManagementActor","downlaodOrg"),BLOCK_USER("UserManagementActor","blockUser")
    ,DELETE_BY_IDENTIFIER("","deleteByIdentifier"),
    BULK_UPLOAD("BulkUploadManagementActor","bulkUpload"),PROCESS_BULK_UPLOAD("BulkUploadBackGroundJobActor","processBulkUpload"),ASSIGN_ROLES("UserManagementActor","assignRoles"), UNBLOCK_USER("UserManagementActor","unblockUser"),
    CREATE_BATCH("CourseBatchManagementActor","createBatch"),UPDATE_BATCH("CourseBatchManagementActor","updateBatch"),REMOVE_BATCH("CourseBatchManagementActor","removeBatch"),ADD_USER_TO_BATCH("CourseBatchManagementActor","addUserBatch"),
    REMOVE_USER_FROM_BATCH("CourseBatchManagementActor","removeUserFromBatch"),GET_BATCH("CourseBatchManagementActor","getBatch"),INSERT_COURSE_BATCH_ES("BackgroundJobManager","insertCourseBatchToEs"),
    UPDATE_COURSE_BATCH_ES("BackgroundJobManager","updateCourseBatchToEs"),GET_BULK_OP_STATUS("BulkUploadManagementActor","getBulkOpStatus"),
    ORG_CREATION_METRICS("OrganisationMetricsActor","orgCreationMetrics"),ORG_CONSUMPTION_METRICS("OrganisationMetricsActor","orgConsumptionMetrics"),
    ORG_CREATION_METRICS_DATA("OrganisationMetricsActor","orgCreationMetricsData"), 
    ORG_CONSUMPTION_METRICS_DATA("OrganisationMetricsActor","orgConsumptionMetricsData"),
    COURSE_PROGRESS_METRICS("CourseMetricsActor","courseProgressMetrics"), COURSE_CREATION_METRICS("CourseMetricsActor","courseConsumptionMetrics"), 
    USER_CREATION_METRICS("UserMetricsActor","userCreationMetrics"), USER_CONSUMPTION_METRICS("UserMetricsActor","userConsumptionMetrics"),
    GET_COURSE_BATCH_DETAIL("CourseBatchManagementActor","getCourseBatchDetail"),UPDATE_USER_ORG_ES("BackgroundJobManager","updateUserOrgES"),
    REMOVE_USER_ORG_ES("BackgroundJobManager","removeUserOrgES"),UPDATE_USER_ROLES_ES("BackgroundJobManager","updateUserRoles"),
    SYNC("EsSyncActor","sync"),INSERT_USR_COURSES_INFO_ELASTIC("BackgroundJobManager","insertUserCoursesInfoToElastic"),
    UPDATE_USR_COURSES_INFO_ELASTIC("BackgroundJobManager","updateUserCoursesInfoToElastic"),SCHEDULE_BULK_UPLOAD("SchedularActor","scheduleBulkUpload"),
    COURSE_PROGRESS_METRICS_REPORT("CourseMetricsActor","courseProgressMetricsReport"), COURSE_CREATION_METRICS_REPORT("CourseMetricsActor","courseConsumptionMetricsReport"),
    ORG_CREATION_METRICS_REPORT("OrganisationMetricsActor","orgCreationMetricsReport"),ORG_CONSUMPTION_METRICS_REPORT("OrganisationMetricsActor","orgConsumptionMetricsReport"),
    EMAIL_SERVICE("EmailServiceActor","emailService"),FILE_STORAGE_SERVICE("FileUploadServiceActor","fileStorageService"),GET_ALL_BADGE("BadgesActor","getAllBadge"),ADD_USER_BADGE("BadgesActor","addUserBadge"),
    ADD_USER_BADGE_BKG("BackgroundJobManager","addUserBadgebackground"),FILE_GENERATION_AND_UPLOAD("MetricsBackGroundJobActor","fileGenerationAndUpload"),HEALTH_CHECK("BadgesActor","healthCheck"),
    SEND_MAIL("MetricsBackGroundJobActor","sendMail"), PROCESS_DATA("MetricsBackGroundJobActor","processData"), ACTOR("BadgesActor","actor"),CASSANDRA("BadgesActor","cassandra"),ES("BadgesActor","es"),EKSTEP("","ekstep"),
    COURSE_PROGRESS_METRICS_DATA("CourseMetricsActor","courseProgressMetricsData"),GET_ORG_TYPE_LIST("OrganisationMetricsActor","getOrgTypeList"),CREATE_ORG_TYPE("OrganisationMetricsActor","createOrgType"),
    UPDATE_ORG_TYPE("OrganisationManagementActor","updateOrgType"), CREATE_NOTE("NotesManagementActor","createNote"), UPDATE_NOTE("NotesManagementActor","updateNote"),
    SEARCH_NOTE("NotesManagementActor","searchNote"), GET_NOTE("NotesManagementActor","getNote"), DELETE_NOTE("NotesManagementActor","deleteNote"),
    INSERT_USER_NOTES_ES("BackgroundJobManager","insertUserNotesToElastic"),ENCRYPT_USER_DATA("UserDataEncryptionDecryptionServiceActor","encryptUserData"),DECRYPT_USER_DATA("UserDataEncryptionDecryptionServiceActor","decryptUserData"), 
    UPDATE_USER_NOTES_ES("BackgroundJobManager","updateUserNotesToElastic"),USER_CURRENT_LOGIN("UserManagementActor","userCurrentLogin"), GET_MEDIA_TYPES("UserManagementActor","getMediaTypes"),
    SEARCH_AUDIT_LOG("ActorAuditLogServiceImpl","searchAuditLog"), PROCESS_AUDIT_LOG("ActorAuditLogServiceImpl","processAuditLog"),FORGOT_PASSWORD("UserManagementActor","forgotpassword"),
    ADD_SKILL("","addSkill"), GET_SKILL("","getSkill") , GET_SKILLS_LIST("","getSkillsList");

    private String key;
    private String value;

    /**
     * constructor
     * @param value String
     */
    ActorOperations(String key, String value){
        this.key = key;
        this.value = value;
    }

    /**
     * returns the Enum key
     * @return String
     */
    public String getKey(){
        return this.key;
    }
    
    /**
     * returns the enum value
     * @return String
     */
    public String getValue(){
        return this.value;
    }
}