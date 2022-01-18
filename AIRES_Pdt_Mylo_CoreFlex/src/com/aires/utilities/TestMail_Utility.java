package com.aires.utilities;

import com.aires.businessrules.constants.PDTConstants;

public class TestMail_Utility {

    public static void main(String[] args) throws Exception {
            // TODO Auto-generated method stub
            System.out.println("Verify Email Received");
            String host = "outlook.office365.com";
            
            //Enter Your Email ID 
            //String userName = "Email ID";
            String userName = "airesautomation@aires.com";
            
            //Enter your email outlook password
            //String pwd = "Password";
            String pwd = PDTConstants.AUTO_EMAIL_PWD;
            
            //Enter expected From complete email address
            //String expFrom = "\"Test Six-MobilityX Inc.\" <test_approvalrequest@aires.com>";  testrelonet@aires.com <testrelonet@aires.com>
            //String expFrom = "\"testrelonet@aires.com\" <testrelonet@aires.com>";
            String expFrom = "testrelonet@aires.com";
            
            //Enter expected email subject
            //String expEmailSubject = "Mobility Initiation for ReloqazNetFirst ReloqazNetLast requires your review";	//"AUTOAIRESctwa TESTAIRESctwa Mobility Policy Exception Request"; //"MobilityX Username"; //"Re: Pre prod testing test cases";
            
            //String expEmailSubject = "Mobility Policy Exception Request";	//"AUTOAIRESctwa TESTAIRESctwa Mobility Policy Exception Request"; //"MobilityX Username"; //"Re: Pre prod testing test cases";
            String expEmailSubject = "Aires Springboard Username";
           /* String startTag = "<font style=\"padding-left:5px;\" size=\"3\" face=\"Arial\" color=\"#424143\"><b>";
            String endTag = "</b></font>";
            String result = EmailUtil.searchEmailAndReturnResult(host, userName, pwd, expFrom, expEmailSubject, startTag, endTag);*/
            String result = EmailUtil.searchEmailAndReturnResult(host, userName, pwd, expFrom, expEmailSubject, PDTConstants.USER_NAME);
            
            System.out.println("in main script result=="+result);
            
            /*String startTagPass = "Your temporary password is <b>";
            String endTagPass = "</b></font>";
            
            String resultPassword = EmailUtil.searchEmailAndReturnResult(host, userName, pwd, expFrom, "Aires Springboard Password", startTagPass, endTagPass);*/
            String resultPassword = EmailUtil.searchEmailAndReturnResult(host, userName, pwd, expFrom, "Aires Springboard Password", PDTConstants.PASSWORD);
            System.out.println("in main script result=="+resultPassword);
    }
}