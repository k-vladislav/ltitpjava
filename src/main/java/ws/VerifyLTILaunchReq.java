/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import javax.jws.WebService;
import javax.jws.WebMethod;
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
@WebService(serviceName = "VerifyLTILaunchReq")
public class VerifyLTILaunchReq {

    /**
     * Verifying an LTI launch request.
     *
     * HttpServletRequest request; // java servlet request LtiVerifier
     * ltiVerifier = new LtiOauthVerifier(); String key =
     * request.getParameter("oauth_consumer_key"); String secret = // retrieve
     * corresponding secret for key from db LtiVerificationResult ltiResult =
     * ltiVerifier.verify(request, secret);
     *
     * @param request
     * @return
     */
    @WebMethod(operationName = "verify")
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
