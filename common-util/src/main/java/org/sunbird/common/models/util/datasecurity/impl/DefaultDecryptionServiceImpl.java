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
import org.sunbird.common.models.util.datasecurity.DecryptionService;

/** @author Manzarul */
public class DefaultDecryptionServiceImpl implements DecryptionService {

  private String sunbirdEncryption = "";

  public DefaultDecryptionServiceImpl() {
    sunbirdEncryption = System.getenv(JsonKey.SUNBIRD_ENCRYPTION);
    if (StringUtils.isBlank(sunbirdEncryption)) {
      sunbirdEncryption = PropertiesCache.getInstance().getProperty(JsonKey.SUNBIRD_ENCRYPTION);
    }
  }

  @Override
  public Map<String, Object> decryptData(Map<String, Object> data) {
    if (JsonKey.ON.equalsIgnoreCase(sunbirdEncryption)) {
      if (data == null) {
        return data;
      }
      Iterator<Entry<String, Object>> itr = data.entrySet().iterator();
      while (itr.hasNext()) {
        Entry<String, Object> entry = itr.next();
        if (!(entry.getValue() instanceof Map || entry.getValue() instanceof List)
            && null != entry.getValue()) {
          data.put(entry.getKey(), decrypt(entry.getValue() + ""));
        }
      }
    }
    return data;
  }

  @Override
  public List<Map<String, Object>> decryptData(List<Map<String, Object>> data) {
    if (JsonKey.ON.equalsIgnoreCase(sunbirdEncryption)) {
      if (data == null || data.isEmpty()) {
        return data;
      }

      for (Map<String, Object> map : data) {
        decryptData(map);
      }
    }
    return data;
  }

  @Override
  public String decryptData(String data) {
    if (JsonKey.ON.equalsIgnoreCase(sunbirdEncryption)) {
      if (StringUtils.isBlank(data)) {
        return data;
      } else {
    	  	return decrypt(data);
      }
    }
    return data;
  }

  /**
   * this method is used to decrypt password.
   *
   * @param value encrypted password.
   * @return decrypted password.
   */
  public static String decrypt(String value) {
	  byte[] bytes = value.getBytes();
	  byte[] array = Base64.decodeBase64(bytes);
	  return new String(array);
  }
}
