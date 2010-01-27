package net.fratech.timeSheet;

public class DAOFactory {

    public static DAO getDAO(Class cl){
        return new DAO();
    }

}