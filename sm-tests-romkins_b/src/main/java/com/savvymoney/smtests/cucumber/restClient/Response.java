package com.savvymoney.smtests.cucumber.restClient;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum Response {
  
  //cancellation process
  MEMBER_ALREADY_CANCELLED("Cancellation failed", "Member with passed member id already cancelled", false), //
  // logout process
  SESSION_IS_NOT_AUTHENTICATED("ok", "Session is not authenticated", false), //
  // common
  OK("ok", "Processed successfully", false), //
  MEMBER_NOT_FOUND("General failure", "Member with passed member id not found", false), //
  ACCESS_DENIED("Access denied", "Access denied", false), //
  GENERAL_FAILURE("General failure", "Internal error occurred", true), //
  ;

  private String value;
  private String description;
  private boolean isError;

  Response(String value, String errorDescription, boolean isError) {
    this.value = value;
    this.description = errorDescription;
    this.isError = isError;
  }

  public String val() {
    return this.value;
  }

  public String descr() {
    return this.description;
  }

  public boolean isError() {
    return this.isError;
  }

  @SuppressWarnings("serial")
  public Map<String, Object> toMap() {
    if (isError) {
      return Collections.unmodifiableMap(new HashMap<String, Object>() {{
        put("errorCode", value);
        put("errorDescription", description);
      }});
    } else {
      return Collections.unmodifiableMap(new HashMap<String, Object>() {{
        put("status", value);
        put("statusDescription", description);
      }});
    }
  }
}
