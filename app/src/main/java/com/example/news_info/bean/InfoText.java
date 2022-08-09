package com.example.news_info.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 测试GSON解析多层JSON
 */
public class InfoText implements Serializable {

    private String a;
    private List<B> b;
    private C c;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public C getC() {
        return c;
    }

    public void setC(C c) {
        this.c = c;
    }

    public List<B> getB() {
        return b;
    }

    public void setB(List<B> b) {
        this.b = b;
    }

    public static class C {

        private String c1;
        private String c2;

        public String getC1() {
            return c1;
        }

        public void setC1(String c1) {
            this.c1 = c1;
        }

        public String getC2() {
            return c2;
        }

        public void setC2(String c2) {
            this.c2 = c2;
        }
    }

    public static class B {

        private String b1;
        private String b2;

        public String getB1() {
            return b1;
        }

        public void setB1(String b1) {
            this.b1 = b1;
        }

        public String getB2() {
            return b2;
        }

        public void setB2(String b2) {
            this.b2 = b2;
        }
    }
}
