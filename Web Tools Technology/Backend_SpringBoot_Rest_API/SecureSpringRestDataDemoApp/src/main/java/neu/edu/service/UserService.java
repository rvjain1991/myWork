package neu.edu.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import neu.edu.controller.role.RoleModel;
import neu.edu.controller.user.UserCreation;
import neu.edu.controller.user.UserModel;

import neu.edu.dao.RoleDao;
import neu.edu.dao.UserDao;

import neu.edu.entity.Role;
import neu.edu.entity.User;

@Service
public class UserService implements UserDetailsService  {

	@Autowired
	private UserDao userDao;

	@Autowired
	private RoleDao roleDao;
	
	
	@Transactional
	public UserModel createUser(UserCreation userCreation) {

		Role role = roleDao.findOne(userCreation.getRoleId());
		UserModel userProfile = null;

		if (role != null) {
			
			User user = new User();
			user.setUsername(userCreation.getUsername());
			user.setPassword(getHashedPassword(userCreation.getPassword()));
			user.setCreatedOn(new Date());
			user.setFName(userCreation.getFirstname());
			user.setLName(userCreation.getLastname());
			user.setEmailId(userCreation.getEmail());
			user.setDob(userCreation.getDob());
			user.setRole(role);
			user = userDao.save(user);
			
			userProfile = new UserModel();
			userProfile.setUserId(user.getUserId());
			userProfile.setUsername(user.getUsername());

			RoleModel roleModel = new RoleModel(role.getRoleId());
			roleModel.setRoleName(role.getRoleName());
			roleModel.setRoleDesc(role.getRoleDesc());
			userProfile.setRole(roleModel);

		} else {
			return userProfile;
		}

		return userProfile;

	}
	
	 private  String getHashedPassword(String password) {
		  	ShaPasswordEncoder encoder = new ShaPasswordEncoder(256);
		  	String hashed = encoder.encodePassword(password, null);
		  	return hashed;
	}

	@Transactional
	public List<UserModel> findAll() {

		return userDao.findAll().stream()
				.map(user -> {

					UserModel userProfile = new UserModel();
					userProfile.setUserId(user.getUserId());
					userProfile.setUsername(user.getUsername());
					
					Role role = user.getRole();
					RoleModel roleModel = new RoleModel(role.getRoleId());
					roleModel.setRoleName(role.getRoleName());
					roleModel.setRoleDesc(role.getRoleDesc());
					userProfile.setRole(roleModel);
					
					return userProfile;
		}).collect(Collectors.toList());

	}

	@Transactional
	public boolean deletedUser(Integer userId) {
		User toBeDeleted=userDao.findOne(userId);
		
		if(toBeDeleted!=null && toBeDeleted.getFundings().size()<=0 && toBeDeleted.getProjects().size()<=0
				&& toBeDeleted.getStartups().size()<=0 && toBeDeleted.getTestimonials().size()<=0){
			userDao.delete(userId);
			return true;
		}
		return false;
		
	}
	
	
	@Transactional
	public boolean updateUserRole(Integer userId,UserModel userModel) {
		User user = userDao.findOne(userId);
		Role newRole=roleDao.findByRoleName(userModel.getRole().getRoleName());
		if(newRole != null){
			user.setRole(newRole);
			userDao.save(user);
			return true;
		}else{
			return false;
		}
	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		 User user = userDao.findByUsername(username);
		 
		  if(user == null) {
	            throw new UsernameNotFoundException(String.format("The username %s doesn't exist", username));
	        }
		  
		  System.out.println(" User Role -->"+user.getRole().getRoleName());
		  List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(user.getRole().getRoleName()));
		
	    UserDetails userDetails = new org.springframework.security.core.userdetails.
                User(user.getUsername(), user.getPassword(), authorities);

		return userDetails;
	}

}
