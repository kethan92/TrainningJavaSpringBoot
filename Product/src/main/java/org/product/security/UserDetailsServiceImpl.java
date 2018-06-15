package org.product.security;

import java.util.ArrayList;
import java.util.List;

import org.product.jpaModel.AppRole;
import org.product.jpaModel.AppUser;
import org.product.repository.RoleRepository;
import org.product.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		AppUser appUser=this.userRepository.findUserAccount(username);
		
		if(appUser==null) {
			throw new UsernameNotFoundException("Khong tin thay username");
		}
		List<AppRole> roleName=roleRepository.getRoleNamesByUserId(appUser.getUserId());
		
		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        if (roleName != null) {
            for (AppRole role : roleName) {
                // ROLE_USER, ROLE_ADMIN,..
            	String roleNameString =role.getRoleName();
                GrantedAuthority authority = new SimpleGrantedAuthority(roleNameString);
                grantList.add(authority);
            }
        }
        
        UserDetails userDetails = (UserDetails) new User(appUser.getUserName(), //
                appUser.getEncrytedPassword(), grantList);
 
        return userDetails;
	}

}
