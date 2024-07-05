package gift.auth;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Jwts.SIG;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.SecretKey;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenGenerator {
    private static final SecretKey key = SIG.HS256.key().build();
    private static final int EXPIRE_TIME = 1;

    public String createToken(String email, String role) {
        Date now = new Date();
        Date exp = new Date(now.getTime() + Duration.ofHours(EXPIRE_TIME).toMillis());

        Map<String, Object> claims = new HashMap<>();
        claims.put("email", email);
        claims.put("role", role);
//        User에 name이 필요할지도
//        claims.put("name", name);

        return Jwts.builder()
            .issuedAt(now)
            .expiration(exp)
            .claims(claims)
            .signWith(key)
            .compact();
    }
}