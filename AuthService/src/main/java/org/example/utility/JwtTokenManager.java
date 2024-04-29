package org.example.utility;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.Value;
import org.example.utility.enums.ERole;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
/*
@Service
public class JwtTokenManager {
   // @Value("${jwt.SECRET_KEY}")
  //  private String secretKey;
  //  @Value("${jwt.issuer}")
   // private String issuer;
   // @Value("${jwt.audience}")
   // private String audience;
/*
    public Optional<String> createToken(Long id, ERole role){
        String token = null;
        Date date = new Date(System.currentTimeMillis()+(1000*60*5));
        try {
            token = JWT.create()
                    .withAudience(audience)
                    .withIssuer(issuer)
                    .withIssuedAt(new Date())
                    .withExpiresAt(date)
                    .withClaim("id",id)
                    .withClaim("role",role.toString())
                    .sign(Algorithm.HMAC512(secretKey));
            return Optional.of(token);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }



}

 */
