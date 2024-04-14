package bansach.demo.service;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtService {
   private final  String JWT_Seret = "5367566B59703373367639792F423F4528482B4D6251655468576D5A71347437" ;

   private final long jwt_expiration = 30*60*1000 ;

   public String generateToken(String tendangnhap) {
       Map<String , Object> cliams = new HashMap<>();
       cliams.put("isAdmin", true) ;
       return  createToken(cliams , tendangnhap) ;

   }

    private String createToken(Map<String, Object> cliams, String tendangnhap) {
       return Jwts.builder()
               .setClaims(cliams)
               .setSubject(tendangnhap)
               .setIssuedAt(new Date(System.currentTimeMillis()))
               .setExpiration(new Date(System.currentTimeMillis()+jwt_expiration))
               .signWith(SignatureAlgorithm.HS256,getkey()).compact();


    }

    private Key getkey () {
       byte[] keybites = Decoders.BASE64.decode(JWT_Seret);
       return Keys.hmacShaKeyFor(keybites);

    }

    private Claims extra(String token){
       return  Jwts.parser().setSigningKey(getkey()).build().parseClaimsJws(token).getBody();

    }

    public <T> T extraclim(String token , Function<Claims,T> claimsTFunction)  {
   final  Claims claims = extra(token);
   return claimsTFunction.apply(claims);

    }

    public Date extrakiemtratg(String token) {
     return extraclim(token , Claims::getExpiration);
    }

    private String extaName(String token) {
       return  extraclim(token , Claims::getSubject);

    }

    private Boolean istoken(String token) {
       return extrakiemtratg(token).before(new Date());
    }

   public Boolean vailudattoken(String token , UserDetails userDetails) {
     final  String tendangnhap = extaName(token);
     return  (tendangnhap.equals(userDetails.getUsername()) && !istoken(token));

   }






}
