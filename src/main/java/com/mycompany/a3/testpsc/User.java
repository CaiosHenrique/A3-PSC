package com.mycompany.a3.testpsc;

public final class User { 
    private String  sUser;
    private String  sPass;
    private String  sEmail;
    
    public  User()
    {   clearObject();
    }
    public  User(String sE, String sU, String sP)
    {   sUser = sU;
        sPass = sP;
        sEmail = sE;
    }   

    public String getEmail() {
        return sEmail;
    }

    public void setEmail(String sEmail) {
        this.sEmail = sEmail;
    }
    
    public  String  getUser()
    {   return  sUser;
    }
    public  void    setUser(String sU)
    {   sUser = sU;
    }
    
    public  String  getPass()
    {   return  sPass;
    }
    public  void    setPass(String sP)
    {   sPass = sP;
    }
    public  void    clearObject()
    {   sUser = "Não há usuário cadastrado";
        sPass = "Não há senha cadastrada";
        sEmail = "Não há email cadastrado";
    }
}