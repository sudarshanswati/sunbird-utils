/**
 * 
 */
package org.sunbird.common.models.util;

import java.net.URLDecoder;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Pattern;

import net.sf.junidecode.Junidecode;

/**
 * This class will remove the special character,space from the provided String.
 * 
 * @author Manzarul
 */
public class Slug {

  private static final Pattern NONLATIN = Pattern.compile("[^\\w-\\.]");
  private static final Pattern WHITESPACE = Pattern.compile("[\\s]");
  private static final Pattern DUPDASH = Pattern.compile("-+");


  public static String makeSlug(String input, boolean transliterate) {
    String origInput = input;
    // Validate the input
    if (input == null) {
      ProjectLogger.log("Provided input value is null");
      return input;
    }
    // Remove extra spaces
    input = input.trim();
    // Remove URL encoding
    input = urlDecode(input);
    // If transliterate is required
    if (transliterate) {
      // Tranlisterate & cleanup
      String transliterated = transliterate(input);
      // transliterated = removeDuplicateChars(transliterated);
      input = transliterated;
    }
    // Replace all whitespace with dashes
    input = WHITESPACE.matcher(input).replaceAll("-");
    // Remove all accent chars
    input = Normalizer.normalize(input, Form.NFD);
    // Remove all non-latin special characters
    input = NONLATIN.matcher(input).replaceAll("");
    // Remove any consecutive dashes
    input = normalizeDashes(input);
    // Validate before returning
    validateResult(input, origInput);
    // Slug is always lowercase
    return input.toLowerCase(Locale.ENGLISH);
  }

  private static void validateResult(String input, String origInput) {
    // Check if we are not left with a blank
    if (input.length() == 0) {
      ProjectLogger.log("Failed to cleanup the input " + origInput);
    }
  }

  public static String transliterate(String input) {
    return Junidecode.unidecode(input);
  }

  public static String urlDecode(String input) {
    try {
      input = URLDecoder.decode(input, "UTF-8");
    } catch (Exception ex) {
      ProjectLogger.log(ex.getMessage(), ex);
    }
    return input;
  }

  public static String removeDuplicateChars(String text) {
	  Set<Character> set = new LinkedHashSet<Character>();
    StringBuilder ret = new StringBuilder(text.length());
    if (text.length() == 0) {
      return "";
    }
    for (int i = 0; i < text.length(); i++) {
     set.add(text.charAt(i));
    }	
    Iterator<Character>  itr= set.iterator();
    while (itr.hasNext()) {
    	ret.append(itr.next());
    }
    return ret.toString();
  }

  public static String normalizeDashes(String text) {
    String clean = DUPDASH.matcher(text).replaceAll("-");
    // Special case that only dashes remain
    if (clean.equals("-") || clean.equals("--"))
      return "";
    int startIdx = (clean.startsWith("-") ? 1 : 0);
    int endIdx = (clean.endsWith("-") ? 1 : 0);
    clean = clean.substring(startIdx, (clean.length() - endIdx));
    return clean;
  }

}
