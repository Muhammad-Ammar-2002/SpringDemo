//package com.SpringDemo.Security.Config;
//
//import com.SpringDemo.Security.Service.JwtServiceInterface;
//import com.SpringDemo.Security.Service.UserInfoService;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.RequiredArgsConstructor;
//import org.apache.catalina.core.ApplicationContext;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//
//@Component
//@RequiredArgsConstructor
//public class JwtFilter extends OncePerRequestFilter {
//
//    private final JwtServiceInterface jwtService;
//    private final UserInfoService userInfoService;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//
//        String authHeader = request.getHeader("Authorization");
//        String jwtToken = null;
//        String username = null;
//
//        if(authHeader != null && authHeader.startsWith("Bearer ")) {
//            jwtToken = authHeader.substring(7);
//            username = jwtService.extractUsername(jwtToken);
//
//        }
//
//        if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null)
//        {
//            UserDetails userDetails = userInfoService.loadUserByUsername(username);
//
//            if(jwtService.validateToken(jwtToken,userDetails)) {
//
//                UsernamePasswordAuthenticationToken authenticationToken =
//                        new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
//
//                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//            }
//        }
//
//        filterChain.doFilter(request,response);
//    }
//}
