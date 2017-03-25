package com.litrum.webproject.service;

import com.litrum.webproject.dao.DAOFactory;
import com.litrum.webproject.model.CompanyDetails;
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
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        /*EndUserRegistration userInfo = daoFactory.getEndUserRegistrationDAO().findByUserName(username);
        if (null != userInfo){
            CompanyDetails endUserCompanyDetails = daoFactory.getCompanyDetailsDAO().findByEndUserId(userInfo.getId());
            if (null != endUserCompanyDetails){
                //TODO decide user has multiple roles or not.
                Collection<GrantedAuthority> authority= new ArrayList<>();
                authority.add(new SimpleGrantedAuthority("ROLE_"+endUserCompanyDetails.getEndUserRole().getRoleName()));
                return new User(userInfo.getUserName(), userInfo.getPassword(), authority);
            } else {
                logger.error("End User company details not found.");
                throw new UsernameNotFoundException("User Company details not found");
            }
        } else {
            logger.error("End User not found.");
            throw new UsernameNotFoundException("userName not found");
        }*/
        return null;
    }

    private Collection<GrantedAuthority> getAuthority(List<String> userRoles) {
        Collection<GrantedAuthority> rolesList = new ArrayList<>();
        for (String role : userRoles) {
            rolesList.add(new SimpleGrantedAuthority("ROLE_" + role));
        }
        return rolesList;
    }
}
