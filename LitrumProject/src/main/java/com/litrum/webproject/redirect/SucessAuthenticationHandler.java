package com.litrum.webproject.redirect;

import com.litrum.webproject.Utils.LitrumProjectConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

/**
 * Created by Pc on 24/03/2017.
 */
public class SucessAuthenticationHandler implements AuthenticationSuccessHandler {

    private static final Logger logger = LoggerFactory.getLogger(SucessAuthenticationHandler.class);

    /**
     * Called when a user has been successfully authenticated.
     *
     * @param request        the request which caused the successful authentication
     * @param response       the response
     * @param authentication the <tt>Authentication</tt> object which was created during
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        logger.debug("User Authencaticated successfully");
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for (GrantedAuthority grantedAuthority : authorities) {
            if (grantedAuthority.getAuthority()
                    .equalsIgnoreCase(LitrumProjectConstants.ROLE_PREFIX.concat(LitrumProjectConstants.ROLE_SUPER_ADMIN))) {
                response.sendRedirect(request.getContextPath().concat("/adminPannelHome"));
            } else if (grantedAuthority.getAuthority().equalsIgnoreCase(LitrumProjectConstants.ROLE_PREFIX.concat(LitrumProjectConstants
                    .ROLE_END_USER))) {
                response.sendRedirect(request.getContextPath().concat("/endUserPannelHome"));
            } else if (grantedAuthority.getAuthority().equalsIgnoreCase(LitrumProjectConstants.ROLE_PREFIX.concat(LitrumProjectConstants
                    .ROLE_EDITOR))) {
                //TODO deicde where to redirect
                response.sendRedirect(request.getContextPath().concat("/endUserPannelHome"));
            } else if (grantedAuthority.getAuthority().equalsIgnoreCase(LitrumProjectConstants.ROLE_PREFIX.concat(LitrumProjectConstants
                    .ROLE_AUTHORISER))) {
                //TODO deicde where to redirect
                response.sendRedirect(request.getContextPath().concat("/endUserPannelHome"));
            } else if (grantedAuthority.getAuthority().equalsIgnoreCase(LitrumProjectConstants.ROLE_PREFIX.concat(LitrumProjectConstants
                    .ROLE_PRIORITY_EDITOR))) {
                //TODO deicde where to redirect
                response.sendRedirect(request.getContextPath().concat("/endUserPannelHome"));
            } else if (grantedAuthority.getAuthority().equalsIgnoreCase(LitrumProjectConstants.ROLE_PREFIX.concat(LitrumProjectConstants
                    .ROLE_SALES))) {
                //TODO deicde where to redirect
                response.sendRedirect(request.getContextPath().concat("/endUserPannelHome"));
            }
        }
    }
}
