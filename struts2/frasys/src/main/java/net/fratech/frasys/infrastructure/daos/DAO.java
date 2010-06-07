package net.fratech.frasys.infrastructure.daos;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface DAO <PersistentObject, IDType extends Serializable>{
	
	public PersistentObject merge(PersistentObject obj);
    public PersistentObject persist(PersistentObject obj);
    public void remove(PersistentObject obj);
    public PersistentObject find(IDType id);
    public List<PersistentObject> list();
    public List<PersistentObject> listByNamedQuery(String queryName, Map<String, Object> params);
    public PersistentObject getByNamedQuery(String queryName, Map<String, Object> params);
    public void close();

}
