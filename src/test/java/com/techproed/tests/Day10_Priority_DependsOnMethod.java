package com.techproed.tests;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class Day10_Priority_DependsOnMethod {

    @Test(priority = 1)
    public void login(){
        System.out.println("Bu method login methodu");
    }

    @Test(priority = 2,dependsOnMethods = "login")
    public void homePage(){
        System.out.println("Bu method homePage methodu");
    }

    @Test(priority = -4)
    public void search(){
        System.out.println("Bu method search methodu");
    }

    @Test(priority = 11, dependsOnMethods = "search")
    public void result(){
        System.out.println("Bu method result methodu");
    }











}
