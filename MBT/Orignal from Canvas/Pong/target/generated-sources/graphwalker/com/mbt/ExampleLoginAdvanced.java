// Generated by GraphWalker (http://www.graphwalker.org)
package com.mbt;

import org.graphwalker.java.annotation.Model;
import org.graphwalker.java.annotation.Vertex;
import org.graphwalker.java.annotation.Edge;

@Model(file = "com/mbt/ExampleLoginAdvanced.graphml")
public interface ExampleLoginAdvanced {

    @Vertex()
    void v_HomePage_Submitted();

    @Edge()
    void e_rmFile();

    @Edge()
    void e_SelectAssignment();

    @Edge()
    void e_Logout();

    @Vertex()
    void v_HomePage_Open();

    @Vertex()
    void v_AssignmentPage_Submitted();

    @Vertex()
    void v_AssignmentPage_Open();

    @Edge()
    void e_Withdraw();

    @Vertex()
    void v_LoginPage_Open();

    @Edge()
    void e_addFile();

    @Edge()
    void e_Start();

    @Edge()
    void e_Submit();

    @Vertex()
    void v_LoginPage_Submitted();

    @Edge()
    void e_Login();
}