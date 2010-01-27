package net.fratech.timeSheet;

public class TimeSheet {

    public String register(String nome) throws Exception {
	return DAOFactory.getDAO(DAO.class).save(nome);
    }

}
