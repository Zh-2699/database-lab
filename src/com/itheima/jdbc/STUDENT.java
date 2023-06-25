package com.itheima.jdbc;

public class STUDENT {
    public String Sno;
    public String Sname;
    public String Ssex;
    public int Sage;
    public String Sdept;
    public float Sgpa;

    public String getSno() {
        return Sno;
    }

    public void setSno(String sno) {
        Sno = sno;
    }

    public String getSname() {
        return Sname;
    }

    public void setSname(String sname) {
        Sname = sname;
    }

    public String getSsex() {
        return Ssex;
    }

    public void setSsex(String ssex) {
        Ssex = ssex;
    }

    public int getSage() {
        return Sage;
    }

    public void setSage(int sage) {
        Sage = sage;
    }

    public String getSdept() {
        return Sdept;
    }

    public void setSdept(String sdept) {
        Sdept = sdept;
    }

    public float getSgpa() {
        return Sgpa;
    }

    public void setSgpa(float sgpa) {
        Sgpa = sgpa;
    }

    @Override
    public String toString() {
        return "STUDENT{" +
                "Sno='" + Sno + '\'' +
                ", Sname='" + Sname + '\'' +
                ", Ssex='" + Ssex + '\'' +
                ", Sage=" + Sage +
                ", Sdept='" + Sdept + '\'' +
                ", Sgpa=" + Sgpa +
                '}';
    }
}
