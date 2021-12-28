package pl.javorex.resourceserver.config;

import ch.qos.logback.core.net.server.Client;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;

@Configuration
class Oauth2ClientsConfig {
  private static final String SCOPE_OPENID = "openid";

  @Bean
  ClientRegistrationRepository clientRegistrationRepository() {
    return new InMemoryClientRegistrationRepository(client1(), client2());
  }

  ClientRegistration client1() {
    return ClientRegistration.withRegistrationId("client-1")
      .issuerUri(Client1.issuerUri)
      .clientId(Client1.clientId)
      .clientSecret(Client1.clientSecret)
      .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
      .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
      .redirectUri(Client1.redirectUri)
      .scope(SCOPE_OPENID)
      .clientName(Client1.clientName)
      .authorizationUri(Client1.authorizationUri)
      .tokenUri(Client1.tokenUri)
      .jwkSetUri(Client1.jwksSetUri)
      .build();
  }

  ClientRegistration client2() {
    return ClientRegistration.withRegistrationId("client-2")
      .issuerUri(Client2.issuerUri)
      .clientId(Client2.clientId)
      .clientSecret(Client2.clientSecret)
      .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
      .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
      .redirectUri(Client2.redirectUri)
      .scope(SCOPE_OPENID)
      .clientName(Client2.clientName)
      .authorizationUri(Client2.authorizationUri)
      .tokenUri(Client2.tokenUri)
      .jwkSetUri(Client2.jwksSetUri)
      .build();
  }

  // /.well-known/oauth-authorization-server
  // /.well-known/openid-configuration
  private static class Client1 {
    static String issuerUri = "http://localhost:9001";
    static String clientId = "articles-client";
    static String clientSecret = "secret";
    static String clientName = "first";
    static String redirectUri = "http://127.0.0.1:8080/login/oauth2/code/{registrationId}";
    static String authorizationUri = issuerUri + "/oauth2/authorize";
    static String tokenUri = issuerUri + "/oauth2/token";
    static String jwksSetUri = issuerUri + "/oauth2/jwks";
  }

  private static class Client2 {
    static String issuerUri = "http://localhost:9002";
    static String clientId = "articles-client";
    static String clientSecret = "secret";
    static String clientName = "second";
    static String redirectUri = "http://127.0.0.1:8080/login/oauth2/code/{registrationId}";
    static String authorizationUri = issuerUri + "/oauth2/authorize";
    static String tokenUri = issuerUri + "/oauth2/token";
    static String jwksSetUri = issuerUri + "/oauth2/jwks";
  }
}
