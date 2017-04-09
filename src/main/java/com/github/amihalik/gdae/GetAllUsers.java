package com.github.amihalik.gdae;

import java.util.List;

import org.eclipse.egit.github.core.User;
import org.eclipse.egit.github.core.client.GitHubClient;
import org.eclipse.egit.github.core.service.OrganizationService;
import org.eclipse.egit.github.core.service.UserService;

/**
 * Examples based off of README docs at https://github.com/eclipse/egit-github/tree/master/org.eclipse.egit.github.core
 *
 */
public class GetAllUsers {

    public static void main(String[] args) throws Exception {

        // replace with "github.mycompany.com" if you are using github enterprise
        GitHubClient client = new GitHubClient("api.github.com");
        
        // https://github.com/settings/tokens under "personal access tokens"
        client.setOAuth2Token("get a token!");
        
        UserService userservice = new UserService(client);

        OrganizationService orgservice = new OrganizationService(client);

        
        List<User> members = orgservice.getPublicMembers("apache");
        
        System.out.println("Apache member count : " + members.size());
        
        for (User member : members) {
            User u = userservice.getUser(member.getLogin());
            
            System.out.println(u.getGravatarId() + " : " + u.getName() + " : " + u.getLogin() );
        }

        
        

    }
}
