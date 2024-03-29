package web.security.secDetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        List<User> users = userService.getUsers();
        if (users == null) {
            return null;
        }
        for (User user : users) {
            if (user.getName().equals(name)) {
                return new UserDetailesImpl(user);
            }
        }
        return null;
    }
}
