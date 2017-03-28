
package com.litrum.webproject.service;

import com.litrum.webproject.Utils.LitrumProjectConstants;
import com.litrum.webproject.dao.DAOFactory;
import com.litrum.webproject.model.AdminUserRegistration;
import com.litrum.webproject.model.EndUserRegistration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Pc on 24/03/2017.
 */

@Service("userDetailsService")
public class UserDetailsManager implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(UserDetailsManager.class);

    @Autowired
    private DAOFactory daoFactory;


    /**
     * Locates the user based on the username. In the actual implementation, the search
     * may possibly be case sensitive, or case insensitive depending on how the
     * implementation instance is configured. In this case, the <code>UserDetails</code>
     * object that comes back may have a username that is of a different case than what
     * was actually requested..
     *
     * @param username the username identifying the user whose data is required.
     * @return a fully populated user record (never <code>null</code>)
     * @throws UsernameNotFoundException if the user could not be found or the user has no
     *                                   GrantedAuthority
     */

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.debug("Username:{}", username);
        logger.info("tails Inside user deservice manager");
        EndUserRegistration endUser = daoFactory.getEndUserRegistrationDAO().findByUserName(username);
        if (null == endUser) {
            logger.info("End user not found hence checking admin user.");
            AdminUserRegistration adminUser = daoFactory.getAdminUserRegistrationDAO().findByUserName(username);
            if (null == adminUser) {
                logger.error("admin User also not found.");
                throw new UsernameNotFoundException("User not found");
            } else {
                logger.debug("Admin user found and passed to authentication");
                return new User(adminUser.getUserName(), adminUser.getPassword(), getAuthority(adminUser.getUserLoginRole()));
            }
        } else {
            logger.debug("End user found and passed to authentication");
            return new User(endUser.getUserName(), endUser.getPassword(), getAuthority(endUser.getUserLoginRole()));
        }
    }

    private Collection<GrantedAuthority> getAuthority(String userRoles) {
        logger.info("Insode getauthority method for creating granted authority for role:[{}]", userRoles);
        Collection<GrantedAuthority> rolesList = new ArrayList<>();
        rolesList.add(new SimpleGrantedAuthority(LitrumProjectConstants.ROLE_PREFIX + userRoles));
        return rolesList;
    }
}
