package com.company;// Generated by GraphWalker (http://www.graphwalker.org)

import org.graphwalker.java.annotation.Edge;
import org.graphwalker.java.annotation.Model;
import org.graphwalker.java.annotation.Vertex;

@Model(file = "LoginModel.json")
public interface Login {

    @Edge()
    void e_correctInputs();

    @Edge()
    void e_falseInputs();

    @Edge()
    void e_openHome();

    @Vertex()
    void v_Start();

    @Vertex()
    void v_LoggedIn();

    @Edge()
    void e_logOut();

    @Vertex()
    void v_HomePage();
}