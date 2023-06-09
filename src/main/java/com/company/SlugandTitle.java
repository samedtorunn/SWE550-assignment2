package com.company;// Generated by GraphWalker (http://www.graphwalker.org)

import org.graphwalker.java.annotation.Edge;
import org.graphwalker.java.annotation.Model;
import org.graphwalker.java.annotation.Vertex;

@Model(file = "SlugandTitle.json")
public interface SlugandTitle {

    @Vertex()
    void v_ProductPage();

    @Edge()
    void e_openHome();

    @Edge()
    void e_clickHome();

    @Edge()
    void e_clickProduct();

    @Vertex()
    void v_Start();

    @Vertex()
    void v_HomePage();
}
