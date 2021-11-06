package com.arelance.servlets.commands;

import com.arelance.domain.UserImd;
import com.arelance.qualifiers.ProfileQ;
import com.arelance.service.UserCrud;
import com.arelance.service.factory.Factory;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pedro
 */
@ProfileQ
public class UpdateProfile implements ActionsController {

    private static final long serialVersionUID = 1L;

    @Inject
    UserImd userImd;

    @Inject
    Factory<UserCrud> userFactory;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        userImd = (UserImd) request.getSession().getAttribute("user");

        String name = request.getParameter("name");
        String middlename = request.getParameter("profilemiddlename");
        String lastname = request.getParameter("profilelastname");
        String mail = request.getParameter("profilemail");
        String phone = request.getParameter("profilephone");

        if (!userImd.getName().equals(name)) {
            userImd.setName(name);
        }
        if (!userImd.getSurnameA().equals(middlename)) {
            userImd.setSurnameA(middlename);
        }
        if (!userImd.getSurnameB().equals(lastname) && lastname == null) {
            userImd.setSurnameB(lastname);
        }
        if (!userImd.getEmail().equals(mail)) {
            userImd.setEmail(mail);
        }
        if (userImd.getPhone() != null) {
            if (!userImd.getPhone().equals(phone)) {
                userImd.setPhone(phone);
            }

        }

        userFactory.buildCrud().updateEntity(userImd);
        return "/profile";

    }

}
