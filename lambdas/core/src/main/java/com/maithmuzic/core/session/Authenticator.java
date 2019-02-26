package com.maithmuzic.core.session;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.maithmuzic.common.db.DAO;
import com.maithmuzic.common.db.models.ActiveSession;
import com.maithmuzic.common.db.models.Session;
import com.maithmuzic.common.db.models.User;
import com.maithmuzic.core.util.PasswordUtil;
import com.maithmuzic.core.util.SecurityTokenUtil;

import java.util.*;

public class Authenticator {
    private static Authenticator instance;

    private DAO dao;

    public static Authenticator getInstance() {
        if (instance == null) {
            instance = new Authenticator();
        }

        return instance;
    }

    private Authenticator() {
        this.dao = DAO.getInstance();
    }

    public String validateUser(String username, String password) {
        return null;
    }

    public ActiveSession getSession(String securityToken) throws AuthenticationException{
        Map<String, AttributeValue> eav = new HashMap<>();
        eav.put(":token", new AttributeValue().withN(securityToken));

        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
                .withFilterExpression("SecurityToken = :token")
                .withExpressionAttributeValues(eav);

        ActiveSession session = dao.mapper.load(ActiveSession.class, securityToken);

        if (session == null) {
            throw new AuthenticationException(AuthenticationExceptionType.INVALID_SECURITY_TOKEN);
        }

        return session;
    }

    public Session createSession(LoginRequest request) throws AuthenticationException {

        try {
            User user = dao.mapper.load(User.class, request.getUsername());

            if (user == null) {
                throw new AuthenticationException(AuthenticationExceptionType.INVALID_USERNAME);
            }

            if (PasswordUtil.verify(user.getPassword(), request.getPassword())) {
                throw new AuthenticationException(AuthenticationExceptionType.INVALID_PASSWORD);
            }

            String securityToken = SecurityTokenUtil.generateSecurityToken();

            ActiveSession session = new ActiveSession();
            session.setSecurityToken(securityToken);
            session.setStartTime(new Date());
            session.setLastActivityTime(new Date());
            session.setUsername(user.getUsername());
            session.setPlatform(request.getClient().getPlatform());
            // TODO: map other parameters
            dao.mapper.save(session);

            return session;
        } catch (AuthenticationException e) {
            throw e;
        } catch (Exception e) {
            //TODO: log Exception
            throw new AuthenticationException(AuthenticationExceptionType.UNKNOWN_ERROR);
        }
    }
}
