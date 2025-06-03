package com.example;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String hello() {
    // 環境変数を取得（設定されていない場合は"not set"を表示）
    String pushEnabled = System.getenv("PUSH_ENABLED");
    String envStatus = (pushEnabled != null) ? pushEnabled : "not set";

    return "Hello, openshift! version:1.0.49 PUSH_ENABLED:" + envStatus;
  }
}
