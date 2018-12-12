/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsfmanagedbeans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import org.imsglobal.lti.launch.LtiOauthVerifier;
import org.imsglobal.lti.launch.LtiVerificationException;
import org.imsglobal.lti.launch.LtiVerificationResult;
import org.imsglobal.lti.launch.LtiVerifier;

/**
 *
 * @author vkom9
 */
@Named(value = "verif")
@SessionScoped
public class verif implements Serializable {

    /**
     * Creates a new instance of verif
     * @param request
     * @return 
     * @throws org.imsglobal.lti.launch.LtiVerificationException
     */
    public LtiVerificationResult verify(@WebParam(name = "request") HttpServletRequest request) throws LtiVerificationException {
        LtiVerifier ltiVerifier = new LtiOauthVerifier();
        String key = request.getParameter("oauth_consumer_key");
        String secret = "secret";
        LtiVerificationResult ltiResult = ltiVerifier.verify(request, secret);
        System.out.println(ltiResult.getMessage()+' '+ltiResult.getSuccess());
        System.out.println(ltiResult.getLtiLaunchResult().getResourceLinkId());
        return ltiResult;
    }
    
}
