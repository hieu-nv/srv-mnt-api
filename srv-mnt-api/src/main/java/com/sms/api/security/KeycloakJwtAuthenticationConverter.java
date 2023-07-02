package com.sms.api.security;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;

/**
 * KeycloakJwtAuthenticationConverter.
 *
 * @author Hieu Nguyen
 */
public class KeycloakJwtAuthenticationConverter implements
    Converter<Jwt, AbstractAuthenticationToken> {

  private JwtAuthenticationConverter jwtAuthenticationConverter;
  private JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter;


  public KeycloakJwtAuthenticationConverter() {
    this.jwtAuthenticationConverter = new JwtAuthenticationConverter();
    this.jwtGrantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
  }
  @Override
  public AbstractAuthenticationToken convert(Jwt jwt) {
//    `ROLE_`
    Collection<GrantedAuthority> authorities = extractAuthorities(jwt);

    return new JwtAuthenticationToken(jwt, authorities);
  }

  private Collection<GrantedAuthority> extractAuthorities(Jwt jwt) {
    if(jwt.getClaim("realm_access") != null) {
      Map<String, Object> realmAccess = jwt.getClaim("realm_access");
      ObjectMapper mapper = new ObjectMapper();
      List<String> roles = mapper.convertValue(realmAccess.get("roles"), new TypeReference<List<String>>(){});
      List<GrantedAuthority> authorities = new ArrayList<>();

      for (String role : roles) {
        authorities.add(new SimpleGrantedAuthority(role));
//        @PreAuthorize("hasAuthority('offline_access')")
//        hasRole('offline_access') = hasAuthority('ROLE_offline_access')
      }

      return authorities;
    }
    return new ArrayList<>();
  }
}
