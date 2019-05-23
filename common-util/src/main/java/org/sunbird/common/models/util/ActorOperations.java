package org.sunbird.common.models.util;

/**
 * This enum will contains different operation for a learner {addCourse, getCourse, update ,
 * getContent}
 *
 * @author Manzarul
 */
public enum ActorOperations {
  CREATE_USER("createUser"),
  UPDATE_USER("updateUser"),
  USER_AUTH("userAuth"),
  GET_USER_PROFILE("getUserProfile"),
  GET_USER_PROFILE_V2("getUserProfileV2"),
  CREATE_ORG("createOrg"),
  UPDATE_ORG("updateOrg"),
  UPDATE_ORG_STATUS("updateOrgStatus"),
  GET_ORG_DETAILS("getOrgDetails"),
  UPDATE_USER_COUNT("updateUserCount"),
  UPDATE_USER_INFO_ELASTIC("updateUserInfoToElastic"),
  GET_ROLES("getRoles"),
  APPROVE_ORGANISATION("approveOrganisation"),
  ADD_MEMBER_ORGANISATION("addMemberOrganisation"),
  REMOVE_MEMBER_ORGANISATION("removeMemberOrganisation"),
  COMPOSITE_SEARCH("compositeSearch"),
  GET_USER_DETAILS_BY_LOGINID("getUserDetailsByLoginId"),
  GET_USER_BY_KEY("getUserByKey"),
  UPDATE_ORG_INFO_ELASTIC("updateOrgInfoToElastic"),
  INSERT_ORG_INFO_ELASTIC("insertOrgInfoToElastic"),
  DOWNLOAD_ORGS("downlaodOrg"),
  BLOCK_USER("blockUser"),
  DELETE_BY_IDENTIFIER("deleteByIdentifier"),
  BULK_UPLOAD("bulkUpload"),
  PROCESS_BULK_UPLOAD("processBulkUpload"),
  ASSIGN_ROLES("assignRoles"),
  UNBLOCK_USER("unblockUser"),
  GET_BULK_OP_STATUS("getBulkOpStatus"),
  GET_BULK_UPLOAD_STATUS_DOWNLOAD_LINK("getBulkUploadStatusDownloadLink"),
  ORG_CREATION_METRICS("orgCreationMetrics"),
  ORG_CONSUMPTION_METRICS("orgConsumptionMetrics"),
  ORG_CREATION_METRICS_DATA("orgCreationMetricsData"),
  ORG_CONSUMPTION_METRICS_DATA("orgConsumptionMetricsData"),
  USER_CREATION_METRICS("userCreationMetrics"),
  USER_CONSUMPTION_METRICS("userConsumptionMetrics"),
  UPDATE_USER_ORG_ES("updateUserOrgES"),
  REMOVE_USER_ORG_ES("removeUserOrgES"),
  UPDATE_USER_ROLES_ES("updateUserRoles"),
  SYNC("sync"),
  BACKGROUND_SYNC("backgroundSync"),
  SCHEDULE_BULK_UPLOAD("scheduleBulkUpload"),
  ORG_CREATION_METRICS_REPORT("orgCreationMetricsReport"),
  ORG_CONSUMPTION_METRICS_REPORT("orgConsumptionMetricsReport"),
  EMAIL_SERVICE("emailService"),
  FILE_STORAGE_SERVICE("fileStorageService"),
  ADD_USER_BADGE_BKG("addUserBadgebackground"),
  FILE_GENERATION_AND_UPLOAD("fileGenerationAndUpload"),
  HEALTH_CHECK("healthCheck"),
  SEND_MAIL("sendMail"),
  PROCESS_DATA("processData"),
  ACTOR("actor"),
  CASSANDRA("cassandra"),
  ES("es"),
  EKSTEP("ekstep"),
  GET_ORG_TYPE_LIST("getOrgTypeList"),
  CREATE_ORG_TYPE("createOrgType"),
  UPDATE_ORG_TYPE("updateOrgType"),
  ENCRYPT_USER_DATA("encryptUserData"),
  DECRYPT_USER_DATA("decryptUserData"),
  USER_CURRENT_LOGIN("userCurrentLogin"),
  GET_MEDIA_TYPES("getMediaTypes"),
  ADD_SKILL("addSkill"),
  GET_SKILL("getSkill"),
  UPDATE_SKILL("updateSkill"),
  GET_SKILLS_LIST("getSkillsList"),
  ADD_USER_SKILL_ENDORSEMENT("addUserSkillEndorsement"),
  PROFILE_VISIBILITY("profileVisibility"),
  CREATE_TENANT_PREFERENCE("createTanentPreference"),
  UPDATE_TENANT_PREFERENCE("updateTenantPreference"),
  GET_TENANT_PREFERENCE("getTenantPreference"),
  REGISTER_CLIENT("registerClient"),
  UPDATE_CLIENT_KEY("updateClientKey"),
  GET_CLIENT_KEY("getClientKey"),
  CREATE_GEO_LOCATION("createGeoLocation"),
  GET_GEO_LOCATION("getGeoLocation"),
  UPDATE_GEO_LOCATION("updateGeoLocation"),
  DELETE_GEO_LOCATION("deleteGeoLocation"),
  GET_USER_COUNT("getUserCount"),
  UPDATE_USER_COUNT_TO_LOCATIONID("updateUserCountToLocationID"),
  SEND_NOTIFICATION("sendNotification"),
  SYNC_KEYCLOAK("syncKeycloak"),
  UPDATE_SYSTEM_SETTINGS("updateSystemSettings"),
  CREATE_DATA("createData"),
  UPDATE_DATA("updateData"),
  DELETE_DATA("deleteData"),
  READ_DATA("readData"),
  READ_ALL_DATA("readAllData"),
  SEARCH_DATA("searchData"),
  GET_METRICS("getMetrics"),
  REG_CHANNEL("channelReg"),
  UPDATE_LEARNER_STATE("updateLearnerState"),
  GET_SYSTEM_SETTING("getSystemSetting"),
  GET_ALL_SYSTEM_SETTINGS("getAllSystemSettings"),
  SET_SYSTEM_SETTING("setSystemSetting"),
  USER_TNC_ACCEPT("userTnCAccept"),
  GENERATE_OTP("generateOTP"),
  BACKGROUND_ENCRYPTION("backgroundEncryption"),
  BACKGROUND_DECRYPTION("backgroundDecryption"),
  VERIFY_OTP("verifyOTP"),
  SEND_OTP("sendOTP"),
  GET_USER_TYPES("getUserTypes"),
  CLEAR_CACHE("clearCache");

  private String value;

  /**
   * constructor
   *
   * @param value String
   */
  ActorOperations(String value) {
    this.value = value;
  }

  /**
   * returns the enum value
   *
   * @return String
   */
  public String getValue() {
    return this.value;
  }
}
