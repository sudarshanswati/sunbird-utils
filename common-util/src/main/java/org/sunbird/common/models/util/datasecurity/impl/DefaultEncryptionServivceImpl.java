/** */
package org.sunbird.common.models.util.datasecurity.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.sunbird.common.models.util.JsonKey;
import org.sunbird.common.models.util.PropertiesCache;
import org.sunbird.common.models.util.datasecurity.EncryptionService;

/**
 * Default data encryption service
 *
 * @author Manzarul
 */
public class DefaultEncryptionServivceImpl implements EncryptionService {

  private String sunbirdEncryption = "";

  public DefaultEncryptionServivceImpl() {
    sunbirdEncryption = System.getenv(JsonKey.SUNBIRD_ENCRYPTION);
    if (StringUtils.isBlank(sunbirdEncryption)) {
      sunbirdEncryption = PropertiesCache.getInstance().getProperty(JsonKey.SUNBIRD_ENCRYPTION);
    }
  }

  @Override
  public Map<String, Object> encryptData(Map<String, Object> data) throws Exception {
    if (JsonKey.ON.equalsIgnoreCase(sunbirdEncryption)) {
      if (data == null) {
        return data;
      }
      Iterator<Entry<String, Object>> itr = data.entrySet().iterator();
      while (itr.hasNext()) {
        Entry<String, Object> entry = itr.next();
        if (!(entry.getValue() instanceof Map || entry.getValue() instanceof List)
            && null != entry.getValue()) {
          data.put(entry.getKey(), encrypt(entry.getValue() + ""));
        }
      }
    }
    return data;
  }

  @Override
  public List<Map<String, Object>> encryptData(List<Map<String, Object>> data) throws Exception {
    if (JsonKey.ON.equalsIgnoreCase(sunbirdEncryption)) {
      if (data == null || data.isEmpty()) {
        return data;
      }
      for (Map<String, Object> map : data) {
        encryptData(map);
      }
    }
    return data;
  }

  @Override
  public String encryptData(String data) throws Exception {
    if (JsonKey.ON.equalsIgnoreCase(sunbirdEncryption)) {
      if (StringUtils.isBlank(data)) {
        return data;
      }
      if (null != data) {
        return encrypt(data);
      } else {
        return data;
      }
    } else {
      return data;
    }
	  
  }

  /**
   * this method is used to encrypt the password.
   *
   * @param value String password
   * @param encryption_key
   * @return encrypted password.
   */
  public static String encrypt(String value) {
	  return Base64.encodeBase64String(value.getBytes());
  }
}
